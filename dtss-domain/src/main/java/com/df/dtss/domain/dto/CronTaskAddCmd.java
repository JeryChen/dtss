package com.df.dtss.domain.dto;

import com.df.dtss.domain.dto.clientobject.CronTaskDTO;
import com.df.dtss.domain.dto.clientobject.TaskGlueDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <添加周期任务指令>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CronTaskAddCmd extends CommonCommand {

    /**
     * 周期任务
     */
    private CronTaskDTO cronTaskDTO;

    /**
     * 任务Glue信息
     */
    private TaskGlueDTO taskGlueDTO;

}
