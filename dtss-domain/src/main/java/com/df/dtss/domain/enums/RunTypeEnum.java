package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

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

    public static boolean isExist(Integer code) {
        if (Objects.isNull(code)) {
            return false;
        }
        for (RunTypeEnum runTypeEnum : RunTypeEnum.values()) {
            if (Objects.equals(runTypeEnum.getCode(), code)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGlue(Integer code) {
        return Objects.equals(RunTypeEnum.GLUE.getCode(), code);
    }
}
