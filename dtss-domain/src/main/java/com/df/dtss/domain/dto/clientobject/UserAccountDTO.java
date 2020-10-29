package com.df.dtss.domain.dto.clientobject;

import com.xy.cola.dto.ClientObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <用户账户信息>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAccountDTO extends ClientObject {

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色：0-普通用户、1-管理员
     */
    private Integer role;

    /**
     * 权限：执行器ID列表，多个逗号分割
     */
    private String permission;
}
