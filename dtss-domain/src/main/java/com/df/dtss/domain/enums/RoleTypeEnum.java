package com.df.dtss.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <角色类型枚举>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
@Getter
public enum RoleTypeEnum {

    /**
     * 角色：0-普通用户、1-管理员
     */
    GENERAL(0, "普通用户"),

    ADMIN(1, "管理员");

    private final Integer code;

    private final String desc;

    public static boolean isExist(Integer code) {
        if (Objects.isNull(code)) {
            return false;
        }
        for (RoleTypeEnum roleTypeEnum : RoleTypeEnum.values()) {
            if (Objects.equals(roleTypeEnum.getCode(), code)) {
                return true;
            }
        }
        return false;
    }

}
