package com.df.dtss.service;

import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.vo.CronTaskVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;

import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务处理>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CronTaskServiceI {

    /**
     * 分页查询周期任务信息列表
     *
     * @param cronTaskQry 查询参数指令
     * @param pagingParam 分页参数信息
     * @return 分页周期任务信息
     */
    PageResponse<List<CronTaskVO>> pageList(CronTaskQry cronTaskQry, PagingParam pagingParam);
}
