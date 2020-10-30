package com.df.dtss.domain.event;

import com.df.dtss.domain.dto.clientobject.TaskGlueDTO;
import com.xy.cola.event.DomainEventI;
import lombok.Data;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务创建完成事件>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class TaskCreatedEvent implements DomainEventI {

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 任务类型
     *
     * @see com.df.dtss.domain.enums.TaskTypeEnum
     */
    private Integer taskType;

    /**
     * 任务glue信息
     */
    private TaskGlueDTO taskGlue;

    /**
     * 操作人
     */
    private String operator;
}
