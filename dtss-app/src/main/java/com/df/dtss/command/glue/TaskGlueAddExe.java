package com.df.dtss.command.glue;

import com.df.dtss.domain.dto.TaskGlueAddCmd;
import com.df.dtss.domain.enums.IsEnum;
import com.df.dtss.gatewayimpl.database.TaskGlueRecordMapper;
import com.df.dtss.gatewayimpl.database.model.TaskGlueRecord;
import com.xy.cola.dto.Response;
import com.xy.cola.enums.ResponseCodeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <功能介绍><br>
 * <p>
 * <任务glue创建执行器>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class TaskGlueAddExe {

    @Resource
    private TaskGlueRecordMapper taskGlueRecordMapper;

    /**
     * 执行创建任务glue处理
     *
     * @param taskGlueAddCmd 添加任务glue脚本信息指令
     *
     * @return 处理结果
     */
    public Response execute(TaskGlueAddCmd taskGlueAddCmd) {
        TaskGlueRecord taskGlueRecord = build(taskGlueAddCmd);
        int insert = taskGlueRecordMapper.insert(taskGlueRecord);
        if (insert > 0) {
            return Response.buildSuccess();
        }
        return Response.buildFailure(ResponseCodeEnum.FAIL_BIZ_501);
    }

    /**
     * 构建glue信息
     *
     * @param taskGlueAddCmd 添加任务glue脚本信息指令
     *
     * @return glue信息
     */
    private TaskGlueRecord build(TaskGlueAddCmd taskGlueAddCmd) {
        Date currDate = new Date();
        return TaskGlueRecord.builder()
                             .taskId(taskGlueAddCmd.getTaskId())
                             .taskType(taskGlueAddCmd.getTaskType())
                             .glueType(taskGlueAddCmd.getTaskGlue().getGlueType())
                             .glueSource(taskGlueAddCmd.getTaskGlue().getGlueSource())
                             .glueVersion(taskGlueAddCmd.getTaskGlue().getGlueVersion())
                             .isDeleted(IsEnum.NO.getCode())
                             .creator(taskGlueAddCmd.getOperator())
                             .editor(taskGlueAddCmd.getOperator())
                             .createTime(currDate)
                             .editTime(currDate)
                             .build();
    }
}
