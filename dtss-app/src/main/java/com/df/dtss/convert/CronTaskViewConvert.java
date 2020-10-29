package com.df.dtss.convert;

import com.df.dtss.gatewayimpl.database.model.CronTaskInfo;
import com.df.dtss.vo.CronTaskVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务view展示转换器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Mapper
public abstract class CronTaskViewConvert {

    /**
     * The constant INSTANCE.
     */
    public static final CronTaskViewConvert INSTANCE = Mappers.getMapper(CronTaskViewConvert.class);

    /**
     * Map cron task vo.
     *
     * @param cronTaskInfo the cron task info
     * @return the cron task vo
     */
    public abstract CronTaskVO map(CronTaskInfo cronTaskInfo);
}
