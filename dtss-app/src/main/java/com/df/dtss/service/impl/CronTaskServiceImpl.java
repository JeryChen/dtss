package com.df.dtss.service.impl;

import com.df.dtss.command.app.AppQryExe;
import com.df.dtss.command.task.CronTaskQryExe;
import com.df.dtss.common.event.DomainEventPublisher;
import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.domain.enums.TaskTypeEnum;
import com.df.dtss.domain.event.TaskCreatedEvent;
import com.df.dtss.handle.extension.point.CronTaskAddValidatorExtPt;
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
    private AppQryExe appQryExe;

    /**
     * 分页查询周期任务信息列表
     *
     * @param cronTaskQry 查询参数指令
     * @param pagingParam 分页参数信息
     * @return 分页周期任务信息
     */
    @Override
    public PageResponse<List<CronTaskVO>> pageList(CronTaskQry cronTaskQry, PagingParam pagingParam) {
        return cronTaskQryExe.execute(cronTaskQry, pagingParam);
    }

    /**
     * 新建周期任务
     *
     * @param cronTaskAddCmd 添加周期任务指令
     * @return 处理结果
     */
    @Override
    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
    public Response create(CronTaskAddCmd cronTaskAddCmd) {
        extensionExecutor.executeVoid(CronTaskAddValidatorExtPt.class, cronTaskAddCmd.getBizScenario(),
                cronTaskAddValidatorExtPt -> cronTaskAddValidatorExtPt.validate(cronTaskAddCmd));
        SingleResponse<AppInfoVO> appInfoResp = appQryExe.execute(cronTaskAddCmd.getCronTask().getAppId());
        BusinessAssert.isNull(appInfoResp.getData(), "所属应用不存在");
        cronTaskAddCmd.getCronTask().setAppName(appInfoResp.getData().getAppName());
        SingleResponse<Long> createCronTaskResp = cronTaskQryExe.create(cronTaskAddCmd);
        BusinessAssert.isTrue(createCronTaskResp.isSuccess(), "创建周期任务失败");
        TaskCreatedEvent taskCreatedEvent = new TaskCreatedEvent();
        taskCreatedEvent.setTaskId(createCronTaskResp.getData());
        taskCreatedEvent.setTaskType(TaskTypeEnum.CRON_TASK.getCode());
        taskCreatedEvent.setTaskGlue(cronTaskAddCmd.getTaskGlue());
        taskCreatedEvent.setOperator(cronTaskAddCmd.getOperator());
        Response publishResp = domainEventPublisher.publish(taskCreatedEvent);
        BusinessAssert.isTrue(publishResp.isSuccess(), "创建任务glue失败");
        return Response.buildSuccess();
    }
}
