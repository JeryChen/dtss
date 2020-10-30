package com.df.dtss.service;

import com.df.dtss.domain.dto.AppInfoQry;
import com.df.dtss.vo.AppInfoVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.SingleResponse;

import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <app业务处理>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AppServiceI {

    /**
     * 获取所有appName
     *
     * @return 所有appName
     */
    SingleResponse<List<AppInfoVO>> getAllAppNameList();

    /**
     * 分页查询应用信息
     *
     * @param appInfoQry  查询参数
     * @param pagingParam 分页信息
     * @return 应用信息
     */
    PageResponse<List<AppInfoVO>> pageList(AppInfoQry appInfoQry, PagingParam pagingParam);
}
