package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <Glue类型枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum GlueType {

    /**
     * Glue类型
     * 目前只支持java一种
     */
    JAVA(1, "java");

    private final Integer code;

    private final String desc;
}
