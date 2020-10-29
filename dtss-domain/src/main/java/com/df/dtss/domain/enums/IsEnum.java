package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <通用是否枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum IsEnum {

    /**
     * 通用是否
     */
    YES(1, "是"),

    NO(0, "否");

    private final Integer code;

    private final String desc;
}
