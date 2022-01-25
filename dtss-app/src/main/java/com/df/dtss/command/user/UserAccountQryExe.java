package com.df.dtss.command.user;

import com.df.dtss.convert.UserAccountConvert;
import com.df.dtss.domain.dto.clientobject.UserAccountDTO;
import com.df.dtss.domain.query.UserAccountQuery;
import com.df.dtss.gatewayimpl.database.UserAccountMapper;
import com.df.dtss.gatewayimpl.database.model.UserAccount;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <用户信息>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class UserAccountQryExe {

    @Resource
    private UserAccountMapper userAccountMapper;

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     *
     * @return 用户信息
     */
    public UserAccountDTO getByUserName(String username) {
        List<UserAccount> userAccountList = userAccountMapper.selectByCondition(UserAccountQuery.builder()
                                                                                                .username(username)
                                                                                                .build());
        if (CollectionUtils.isNotEmpty(userAccountList)) {
            return UserAccountConvert.INS.map(userAccountList.get(0));
        }
        return null;
    }
}
