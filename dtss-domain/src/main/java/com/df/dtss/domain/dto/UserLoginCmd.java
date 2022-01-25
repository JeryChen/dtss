package com.df.dtss.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <登录指令>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginCmd extends CommonCommand {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
