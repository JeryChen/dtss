package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <路由策略枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum RouteStrategyEnum {

    /**
     * 路由策略
     */
    FIRST(1, "第一个"),
    LAST(2, "最后一个"),
    ROUND(3, "轮询"),
    RANDOM(4, "随机"),
    HASH(5, "一致性HASH"),
    LFU(6, "最不经常使用"),
    LRU(7, "最近最久未使用"),
    FAIL_OVER(8, "故障转移"),
    BUSY_OVER(9, "忙碌转移"),
    SHARDING_BROADCAST(10, "分片广播");

    private final Integer code;

    private final String desc;

}
