package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <功能介绍><br>
 * <p>
 * <任务类型枚举>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum TaskTypeEnum {

    /**
     * 任务类型
     */
    CRON_TASK(1, "周期任务"),
    TIME_TASK(2, "定点任务");

    private final Integer code;

    private final String desc;
}
