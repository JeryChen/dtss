package com.df.dtss.handle.extension;

import com.df.dtss.command.task.CronTaskQryExe;
import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.dto.clientobject.CronTaskDTO;
import com.df.dtss.domain.dto.clientobject.TaskGlueDTO;
import com.df.dtss.domain.enums.BlockStrategyEnum;
import com.df.dtss.domain.enums.GlueTypeEnum;
import com.df.dtss.domain.enums.RouteStrategyEnum;
import com.df.dtss.domain.enums.RunTypeEnum;
import com.df.dtss.domain.util.CronExpression;
import com.df.dtss.handle.extension.point.CronTaskValidatorExtPt;
import com.df.dtss.vo.CronTaskVO;
import com.google.common.collect.Sets;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.exception.util.ArgumentAssert;
import com.xy.cola.extension.Extension;
import com.xy.cola.util.StreamUtil;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.df.dtss.domain.constants.BizSceneConstants.ADD_CRON_TASK_SCENARIO;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_SYS;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_USE_CASE;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务创建验证处理器>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Extension(bizId = ADMIN_SYS, useCase = ADMIN_USE_CASE, scenario = ADD_CRON_TASK_SCENARIO)
public class CronTaskAddValidatorHandle implements CronTaskValidatorExtPt<CronTaskAddCmd> {

    @Resource
    private CronTaskQryExe cronTaskQryExe;

    /**
     * 周期任务参数验证处理
     *
     * @param cmd 周期任务操作参数指令
     */
    @Override
    public void validate(CronTaskAddCmd cmd) {
        ArgumentAssert.notNull(cmd, "周期任务操作参数指令对象不能为空");
        ArgumentAssert.notNull(cmd.getBizScenario(), "业务场景来源不能为空");
        CronTaskDTO cronTask = cmd.getCronTask();
        ArgumentAssert.notNull(cronTask, "周期任务参数信息不能为空");
        ArgumentAssert.hasText(cronTask.getTaskName(), "[任务名称]不能为空");
        ArgumentAssert.hasText(cronTask.getCron(), "[执行周期]不能为空");
        ArgumentAssert.isTrue(CronExpression.isValidExpression(cronTask.getCron()), "cron表达式格式不正确");
        ArgumentAssert.hasText(cronTask.getJobHandler(), "[处理器类]不能为空");
        ArgumentAssert.notNull(cronTask.getAppId(), "[所属应用]不能为空");
        ArgumentAssert.notNull(cronTask.getBlockStrategy(), "[阻塞策略]不能为空");
        ArgumentAssert.hasText(cronTask.getOwner(), "[负责人]不能为空");
        ArgumentAssert.notNull(cronTask.getRetryTimes(), "[重试次数]不能为空");
        ArgumentAssert.notNull(cronTask.getRouteStrategy(), "[路由策略]不能为空");
        ArgumentAssert.notNull(cronTask.getTaskTimeOut(), "[任务超时]不能为空");
        ArgumentAssert.notNull(cronTask.getRunType(), "[运行模式]不能为空");
        ArgumentAssert.isTrue(BlockStrategyEnum.isExist(cronTask.getBlockStrategy()), "非法[阻塞策略]类型");
        ArgumentAssert.isTrue(RouteStrategyEnum.isExist(cronTask.getRouteStrategy()), "非法[路由策略]类型");
        ArgumentAssert.isTrue(RunTypeEnum.isExist(cronTask.getRunType()), "非法[运行模式]类型");
        if (RunTypeEnum.isGlue(cronTask.getRunType())) {
            TaskGlueDTO taskGlue = cmd.getTaskGlue();
            ArgumentAssert.notNull(taskGlue, "glue对象参数信息不能为空");
            ArgumentAssert.hasText(taskGlue.getGlueSource(), "[glue源码]不能为空");
            ArgumentAssert.notNull(taskGlue.getGlueType(), "[glue编码类型]不能为空]");
            ArgumentAssert.isTrue(GlueTypeEnum.isJava(taskGlue.getGlueType()), "非法[glue编码类型]类型");
            ArgumentAssert.hasText(taskGlue.getGlueVersion(), "[glue版本]不能为空");
        }
        if (StringUtils.isNotBlank(cronTask.getSubTaskIds())) {
            List<Long> taskIds = Arrays.stream(cronTask.getSubTaskIds().split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            SingleResponse<List<CronTaskVO>> response = cronTaskQryExe.loadByIds(taskIds);
            ArgumentAssert.notEmpty(response.getData(), "子任务ID：" + cronTask.getSubTaskIds() + "非法");
            List<Long> taskIdList = StreamUtil.map(response.getData(), CronTaskVO::getId);
            Sets.SetView<Long> difference = Sets.difference(Sets.newHashSet(taskIdList), Sets.newHashSet(taskIds));
            ArgumentAssert.isTrue(difference.isEmpty(), "子任务ID：" + StringUtils.join(difference.immutableCopy(), ",") + "非法");
        }
    }
}
