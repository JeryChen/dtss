package com.df.dtss.domain.dto;

import com.df.dtss.domain.dto.clientobject.TaskGlueDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <添加任务glue脚本信息指令>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskGlueAddCmd extends CommonCommand {

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
     * 任务Glue信息
     */
    private TaskGlueDTO taskGlue;
}
