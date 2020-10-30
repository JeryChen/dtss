package com.df.dtss.handle.event;

import com.alibaba.fastjson.JSONObject;
import com.df.dtss.domain.dto.TaskGlueAddCmd;
import com.df.dtss.domain.event.TaskCreatedEvent;
import com.df.dtss.service.TaskGlueServiceI;
import com.xy.cola.dto.Response;
import com.xy.cola.event.EventHandler;
import com.xy.cola.event.EventHandlerI;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务创建完成，新建glue信息时间处理器>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EventHandler
@Slf4j
public class CronTaskCreatedForGlueAddEventHandle implements EventHandlerI<Response, TaskCreatedEvent> {

    @Resource
    private TaskGlueServiceI taskGlueServiceI;

    @Override
    public Response execute(TaskCreatedEvent event) {
        log.info("【周期任务创建完成事件 - 创建任务GLUE】- 开始处理创建任务GLUE事件，事件信息：{}", JSONObject.toJSONString(event));
        TaskGlueAddCmd taskGlueAddCmd = new TaskGlueAddCmd();
        taskGlueAddCmd.setTaskId(event.getTaskId());
        taskGlueAddCmd.setTaskType(event.getTaskType());
        taskGlueAddCmd.setTaskGlue(event.getTaskGlue());
        taskGlueAddCmd.setOperator(event.getOperator());
        return taskGlueServiceI.create(taskGlueAddCmd);
    }
}
