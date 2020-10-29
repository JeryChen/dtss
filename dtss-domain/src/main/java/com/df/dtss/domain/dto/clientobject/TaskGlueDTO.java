package com.df.dtss.domain.dto.clientobject;

import com.xy.cola.dto.ClientObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <任务glue记录信息>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskGlueDTO extends ClientObject {

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
