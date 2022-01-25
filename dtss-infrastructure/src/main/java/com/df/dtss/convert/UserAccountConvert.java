package com.df.dtss.convert;

import com.df.dtss.domain.dto.clientobject.UserAccountDTO;
import com.df.dtss.gatewayimpl.database.model.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Mapper
public abstract class UserAccountConvert {

    /**
     * The constant INS.
     */
    public static final UserAccountConvert INS = Mappers.getMapper(UserAccountConvert.class);

    /**
     * Map user account dto.
     *
     * @param userAccount the user account
     *
     * @return the user account dto
     */
    public abstract UserAccountDTO map(UserAccount userAccount);
}
