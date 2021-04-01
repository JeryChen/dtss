package com.df.dtss.service.impl;

import com.df.dtss.command.app.AppQryExe;
import com.df.dtss.command.task.CronTaskAddExe;
import com.df.dtss.command.task.CronTaskQryExe;
import com.df.dtss.common.event.DomainEventPublisher;
import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.domain.dto.CronTaskUpdateCmd;
import com.df.dtss.domain.enums.TaskTypeEnum;
import com.df.dtss.domain.event.TaskCreatedEvent;
import com.df.dtss.handle.extension.point.CronTaskValidatorExtPt;
import com.df.dtss.service.CronTaskServiceI;
import com.df.dtss.vo.AppInfoVO;
import com.df.dtss.vo.CronTaskVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.Response;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.exception.util.BusinessAssert;
import com.xy.cola.extension.ExtensionExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CronTaskServiceImpl implements CronTaskServiceI {

    @Resource
    private DomainEventPublisher domainEventPublisher;

    @Resource
    private ExtensionExecutor extensionExecutor;

    @Resource
    private CronTaskQryExe cronTaskQryExe;

    @Resource
    private CronTaskAddExe cronTaskAddExe;

    @Resource
    private AppQryExe appQryExe;

    /**
     * 分页查询周期任务信息列表
     *
     * @param cronTaskQry 查询参数指令
     * @param pagingParam 分页参数信息
     *
     * @return 分页周期任务信息
     */
    @Override
    public PageResponse<List<CronTaskVO>> pageList(CronTaskQry cronTaskQry, PagingParam pagingParam) {
        return cronTaskQryExe.page(cronTaskQry, pagingParam);
    }

    /**
     * 新建周期任务
     *
     * @param cronTaskAddCmd 添加周期任务指令
     *
     * @return 处理结果
     */
    @Override
    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
    public Response create(CronTaskAddCmd cronTaskAddCmd) {
        //1.执行扩展点
        extensionExecutor.executeVoid(CronTaskValidatorExtPt.class, cronTaskAddCmd.getBizScenario(),
                cronTaskValidatorExtPt -> cronTaskValidatorExtPt.validate(cronTaskAddCmd));

        //2.新建任务
        Long cronTaskId = addCronTask(cronTaskAddCmd);

        //3.创建事件
        publish(cronTaskId, cronTaskAddCmd);
        return Response.buildSuccess();
    }

    /**
     * 更新周期任务
     *
     * @param cronTaskUpdateCmd 更新周期任务指令
     *
     * @return 处理结果
     */
    @Override
    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
    public Response update(CronTaskUpdateCmd cronTaskUpdateCmd) {
        //1.执行扩展点
        extensionExecutor.executeVoid(CronTaskValidatorExtPt.class, cronTaskUpdateCmd.getBizScenario(),
                cronTaskValidatorExtPt -> cronTaskValidatorExtPt.validate(cronTaskUpdateCmd));

        //2.更新任务
        SingleResponse<AppInfoVO> appInfoResp = appQryExe.loadById(cronTaskUpdateCmd.getCronTask().getAppId());
        BusinessAssert.isNull(appInfoResp.getData(), "所属应用不存在");

        SingleResponse<CronTaskVO> result = cronTaskQryExe.loadById(cronTaskUpdateCmd.getTaskId());
        BusinessAssert.isNull(result.getData(), "对应任务信息不存在");



        //3.更新事件
        return null;
    }

    /**
     * 新建任务
     *
     * @param cronTaskAddCmd 添加周期任务指令
     *
     * @return 任务主键id
     */
    private Long addCronTask(CronTaskAddCmd cronTaskAddCmd) {
        SingleResponse<AppInfoVO> appInfoResp = appQryExe.loadById(cronTaskAddCmd.getCronTask().getAppId());
        BusinessAssert.isNull(appInfoResp.getData(), "所属应用不存在");
        cronTaskAddCmd.getCronTask().setAppName(appInfoResp.getData().getAppName());
        SingleResponse<Long> createCronTaskResp = cronTaskAddExe.add(cronTaskAddCmd);
        BusinessAssert.isTrue(createCronTaskResp.isSuccess(), "创建周期任务失败");
        return createCronTaskResp.getData();
    }

    /**
     * 发布新建任务事件
     *
     * @param cronTaskId     任务id
     * @param cronTaskAddCmd 添加周期任务指令
     */
    private void publish(Long cronTaskId, CronTaskAddCmd cronTaskAddCmd) {
        TaskCreatedEvent taskCreatedEvent = new TaskCreatedEvent();
        taskCreatedEvent.setTaskId(cronTaskId);
        taskCreatedEvent.setTaskType(TaskTypeEnum.CRON_TASK.getCode());
        taskCreatedEvent.setTaskGlue(cronTaskAddCmd.getTaskGlue());
        taskCreatedEvent.setOperator(cronTaskAddCmd.getOperator());
        Response publishResp = domainEventPublisher.publish(taskCreatedEvent);
        BusinessAssert.isTrue(publishResp.isSuccess(), "创建任务glue失败");
    }

}
