package com.df.dtss.convert;

import com.df.dtss.domain.dto.AppInfoQry;
import com.df.dtss.domain.query.AppInfoQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <功能介绍><br>
 * <p>
 * <应用相关DTO转换器>
 *
 * @author xy on 2020/10/29.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Mapper
public abstract class AppConvert {

    /**
     * The constant INSTANCE.
     */
    public static final AppConvert INSTANCE = Mappers.getMapper(AppConvert.class);

    /**
     * Map app info query.
     *
     * @param appInfoQry the app info qry
     * @return the app info query
     */
    @Mapping(target = "id", source = "appId")
    public abstract AppInfoQuery map(AppInfoQry appInfoQry);
}
