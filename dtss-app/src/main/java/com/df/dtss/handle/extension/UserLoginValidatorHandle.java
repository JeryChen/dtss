package com.df.dtss.handle.extension;

import com.df.dtss.domain.dto.UserLoginCmd;
import com.df.dtss.handle.extension.point.BaseValidatorExtPt;
import com.xy.cola.exception.util.ArgumentAssert;
import com.xy.cola.extension.Extension;

import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_SYS;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_USE_CASE;
import static com.df.dtss.domain.constants.BizSceneConstants.USER_LOGIN_SCENARIO;

/**
 * <功能介绍><br>
 * <p>
 * <用户登录校验>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Extension(bizId = ADMIN_SYS, useCase = ADMIN_USE_CASE, scenario = USER_LOGIN_SCENARIO)
public class UserLoginValidatorHandle implements BaseValidatorExtPt<UserLoginCmd> {

    @Override
    public void validate(UserLoginCmd cmd) {
        ArgumentAssert.notNull(cmd, "用户登录信息指令不能为空");
        ArgumentAssert.hasText(cmd.getUsername(), "[用户名]不能为空");
        ArgumentAssert.hasText(cmd.getPassword(), "[登录密码]不能为空");
    }
}
