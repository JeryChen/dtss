package com.df.dtss.controller;

import com.df.dtss.domain.dto.UserLoginCmd;
import com.df.dtss.service.UserLoginServiceI;
import com.xy.cola.dto.Response;
import com.xy.cola.extension.BizScenario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_SYS;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_USE_CASE;
import static com.df.dtss.domain.constants.BizSceneConstants.USER_LOGIN_SCENARIO;

/**
 * <功能介绍><br>
 * <p>
 * <登录>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/admin/user")
public class LoginController {

    @Resource
    private UserLoginServiceI userLoginServiceI;

    /**
     * 登录验证
     *
     * @param userLoginCmd 登录指令
     *
     * @return 处理结果
     */
    @GetMapping("/login")
    public Response login(UserLoginCmd userLoginCmd) {
        if (Objects.nonNull(userLoginCmd)) {
            userLoginCmd.setBizScenario(BizScenario.valueOf(ADMIN_SYS, ADMIN_USE_CASE, USER_LOGIN_SCENARIO));
        }
        return userLoginServiceI.login(userLoginCmd);
    }
}
