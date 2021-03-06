package com.df.dtss.convert;

import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.domain.dto.clientobject.CronTaskDTO;
import com.df.dtss.domain.query.CronTaskInfoQuery;
import com.df.dtss.gatewayimpl.database.model.CronTaskInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务相关DTO转换器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Mapper
public abstract class CronTaskConvert {

    /**
     * The constant INSTANCE.
     */
    public static final CronTaskConvert INSTANCE = Mappers.getMapper(CronTaskConvert.class);

    /**
     * Map cron task info query.
     *
     * @param cronTaskQry the cron task qry
     * @return the cron task info query
     */
    public abstract CronTaskInfoQuery map(CronTaskQry cronTaskQry);


    /**
     * Map cron task info.
     *
     * @param cronTaskDTO the cron task dto
     * @return the cron task info
     */
    public abstract CronTaskInfo map(CronTaskDTO cronTaskDTO);
}
