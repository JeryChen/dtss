package com.df.dtss.service.impl;

import com.df.dtss.command.user.UserAccountQryExe;
import com.df.dtss.domain.dto.UserLoginCmd;
import com.df.dtss.domain.dto.clientobject.UserAccountDTO;
import com.df.dtss.handle.extension.point.BaseValidatorExtPt;
import com.df.dtss.service.UserLoginServiceI;
import com.xy.cola.dto.Response;
import com.xy.cola.extension.ExtensionExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UserLoginServiceImpl implements UserLoginServiceI {

    @Resource
    private UserAccountQryExe userAccountQryExe;

    @Resource
    private ExtensionExecutor extensionExecutor;

    /**
     * 登录检查
     *
     * @param userLoginCmd 登录指令
     *
     * @return 处理结果
     */
    @Override
    public Response login(UserLoginCmd userLoginCmd) {
        Response response;
        extensionExecutor.executeVoid(BaseValidatorExtPt.class, userLoginCmd.getBizScenario(),
                userLoginValidator -> userLoginValidator.validate(userLoginCmd));

        UserAccountDTO userAccountDTO = userAccountQryExe.getByUserName(userLoginCmd.getUsername());

        if (Objects.isNull(userAccountDTO)) {
            response = Response.buildFailure()
        }

        return response;
    }
}
