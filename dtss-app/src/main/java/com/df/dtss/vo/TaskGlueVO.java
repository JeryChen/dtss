package com.df.dtss.vo;

import lombok.Data;

/**
 * <功能介绍><br>
 * <p>
 * <任务glue记录信息>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class TaskGlueVO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 任务表主键id
     */
    private Long taskId;

    /**
     * 任务类型
     */
    private Integer taskType;

    /**
     * GLUE类型
     */
    private Integer glueType;

    /**
     * GLUE源代码
     */
    private String glueSource;

    /**
     * GLUE版本备注
     */
    private String glueVersion;

}
