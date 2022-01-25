package com.df.dtss.service;

import com.df.dtss.domain.dto.UserLoginCmd;
import com.xy.cola.dto.Response;

/**
 * <功能介绍><br>
 * <p>
 * <用户登录相关操作>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserLoginServiceI {

    /**
     * 登录检查
     *
     * @param userLoginCmd 登录指令
     *
     * @return 处理结果
     */
    Response login(UserLoginCmd userLoginCmd);
}
