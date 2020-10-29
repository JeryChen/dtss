package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <触发类型枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum TriggerTypeEnum {

    /**
     * 触发类型
     */
    CRON("cron触发"),
    MANUAL("手动触发"),
    PARENT("父任务触发"),
    API("API触发"),
    RETRY("失败重试触发");

    private final String theme;
}
