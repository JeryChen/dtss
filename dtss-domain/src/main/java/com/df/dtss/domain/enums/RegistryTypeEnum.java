package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <注册方式枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum RegistryTypeEnum {

    /**
     * 注册方式
     */
    AUTO(1, "自动注册"),
    MANUAL(2, "手动录入");

    private final Integer code;

    private final String desc;

    public static boolean isExist(Integer code) {
        if (Objects.isNull(code)) {
            return false;
        }
        for (RegistryTypeEnum registryTypeEnum : RegistryTypeEnum.values()) {
            if (Objects.equals(registryTypeEnum.getCode(), code)) {
                return true;
            }
        }
        return false;
    }

    public boolean equalsCurr(Integer code) {
        return this.code.equals(code);
    }
}
