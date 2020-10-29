package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <阻塞策略枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum BlockStrategyEnum {

    /**
     * 祖册策略
     */
    SERIAL_EXECUTION(1, "单机串行"),
    DISCARD_LATER(2, "丢弃后续调度"),
    COVER_EARLY(3, "覆盖之前调度");

    private final Integer code;

    private final String desc;

}
