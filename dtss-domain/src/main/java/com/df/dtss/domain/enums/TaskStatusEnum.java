package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <任务状态枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum TaskStatusEnum {

    /**
     * cron-task任务状态：
     * 1: '启用', 0: '暂停',
     * <p>
     * time-task任务状态：
     * 1: '待执行', 0: '已暂停', 2: '已执行'
     */
    USING(1, "启用"),
    DEACTIVATE(0, "停用"),
    EXECUTED(2, "已执行");

    private final Integer code;

    private final String desc;

    public static boolean isExist(Integer code) {
        if (Objects.isNull(code)) {
            return false;
        }
        for (TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()) {
            if (Objects.equals(taskStatusEnum.getCode(), code)) {
                return true;
            }
        }
        return false;
    }

}
