package com.df.dtss.service.impl;

import com.df.dtss.command.app.AppQryExe;
import com.df.dtss.domain.dto.AppInfoQry;
import com.df.dtss.service.AppServiceI;
import com.df.dtss.vo.AppInfoVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.SingleResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class AppServiceImpl implements AppServiceI {

    @Resource
    private AppQryExe appQryExe;

    /**
     * 获取所有appName
     *
     * @return 所有appName
     */
    @Override
    public SingleResponse<List<AppInfoVO>> getAllAppNameList() {
        return appQryExe.loadAll();
    }

    /**
     * 分页查询应用信息
     *
     * @param appInfoQry  查询参数
     * @param pagingParam 分页信息
     * @return 应用信息
     */
    @Override
    public PageResponse<List<AppInfoVO>> pageList(AppInfoQry appInfoQry, PagingParam pagingParam) {
        return appQryExe.page(appInfoQry, pagingParam);
    }
}
