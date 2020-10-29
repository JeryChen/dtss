package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <运行模式枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum RunTypeEnum {

    /**
     * 1: 'GLUE模式',
     * 2: 'BEAN模式',
     */
    GLUE(1, "GLUE模式"),
    BEAN(2, "BEAN模式");

    private final Integer code;

    private final String desc;
}
