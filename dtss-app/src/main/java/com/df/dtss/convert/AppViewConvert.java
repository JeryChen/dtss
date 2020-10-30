package com.df.dtss.convert;

import com.df.dtss.gatewayimpl.database.model.AppInfo;
import com.df.dtss.vo.AppInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <功能介绍><br>
 * <p>
 * <app应用view展示转换器>
 *
 * @author xy on 2020/10/29.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Mapper
public abstract class AppViewConvert {

    /**
     * The constant INSTANCE.
     */
    public static final AppViewConvert INSTANCE = Mappers.getMapper(AppViewConvert.class);

    /**
     * Map app info vo.
     *
     * @param appInfo the app info
     * @return the app info vo
     */
    public abstract AppInfoVO map(AppInfo appInfo);
}
