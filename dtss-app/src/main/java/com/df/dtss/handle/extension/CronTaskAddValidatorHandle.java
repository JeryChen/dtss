package com.df.dtss.handle.extension;

import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.dto.clientobject.CronTaskDTO;
import com.df.dtss.domain.dto.clientobject.TaskGlueDTO;
import com.df.dtss.domain.enums.BlockStrategyEnum;
import com.df.dtss.domain.enums.GlueTypeEnum;
import com.df.dtss.domain.enums.RouteStrategyEnum;
import com.df.dtss.domain.enums.RunTypeEnum;
import com.df.dtss.handle.extension.point.CronTaskAddValidatorExtPt;
import com.xy.cola.exception.util.ArgumentAssert;
import com.xy.cola.extension.Extension;

import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_SYS;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务创建验证处理器>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Extension(bizId = ADMIN_SYS)
public class CronTaskAddValidatorHandle implements CronTaskAddValidatorExtPt {

    /**
     * 创建周期任务参数验证处理
     *
     * @param cronTaskAddCmd 新建周期任务参数指令
     */
    @Override
    public void validate(CronTaskAddCmd cronTaskAddCmd) {
        ArgumentAssert.notNull(cronTaskAddCmd, "创建周期任务参数对象不能为空");
        CronTaskDTO cronTask = cronTaskAddCmd.getCronTask();
        ArgumentAssert.notNull(cronTask, "周期任务参数信息不能为空");
        ArgumentAssert.hasText(cronTask.getTaskName(), "[任务名称]不能为空");
        ArgumentAssert.hasText(cronTask.getCron(), "[执行周期]不能为空");
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
            TaskGlueDTO taskGlue = cronTaskAddCmd.getTaskGlue();
            ArgumentAssert.notNull(taskGlue, "glue对象参数信息不能为空");
            ArgumentAssert.hasText(taskGlue.getGlueSource(), "[glue源码]不能为空");
            ArgumentAssert.notNull(taskGlue.getGlueType(), "[glue编码类型]不能为空]");
            ArgumentAssert.isTrue(GlueTypeEnum.isJava(taskGlue.getGlueType()), "非法[glue编码类型]类型");
            ArgumentAssert.hasText(taskGlue.getGlueVersion(), "[glue版本]不能为空");
        }

    }
}
