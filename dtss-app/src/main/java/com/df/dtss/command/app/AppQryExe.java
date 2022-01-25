package com.df.dtss.command.app;

import com.df.dtss.convert.AppConvert;
import com.df.dtss.convert.AppViewConvert;
import com.df.dtss.domain.dto.AppInfoQry;
import com.df.dtss.domain.query.AppInfoQuery;
import com.df.dtss.gatewayimpl.database.AppInfoMapper;
import com.df.dtss.gatewayimpl.database.model.AppInfo;
import com.df.dtss.vo.AppInfoVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.util.StreamUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <app查询执行器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class AppQryExe {

    @Resource
    private AppInfoMapper appInfoMapper;

    /**
     * 查询所有appName
     *
     * @return 所有appName
     */
    public SingleResponse<List<AppInfoVO>> loadAll() {
        List<AppInfo> allAppList = appInfoMapper.getAllApps();
        return SingleResponse.of(StreamUtil.map(allAppList, AppViewConvert.INSTANCE::map));
    }

    /**
     * 分页查询应用信息
     *
     * @param appInfoQry  查询参数
     * @param pagingParam 分页信息
     *
     * @return 应用信息
     */
    public PageResponse<List<AppInfoVO>> page(AppInfoQry appInfoQry, PagingParam pagingParam) {
        PageResponse<List<AppInfoVO>> response = PageResponse.of(null, pagingParam);
        AppInfoQuery appInfoQuery = AppConvert.INSTANCE.map(appInfoQry);
        appInfoQuery.setPagingParam(pagingParam);
        Integer totalNum = appInfoMapper.countByCondition(appInfoQuery);
        if (Objects.nonNull(totalNum) && totalNum > 0) {
            List<AppInfo> appInfoList = appInfoMapper.selectByCondition(appInfoQuery);
            pagingParam.setTotalNum(totalNum);
            response.setData(StreamUtil.map(appInfoList, AppViewConvert.INSTANCE::map));
        }
        return response;
    }

    /**
     * 根据主键id查询app应用信息
     *
     * @param appId app主键id
     *
     * @return 处理结果
     */
    public SingleResponse<AppInfoVO> loadById(Long appId) {
        AppInfo appInfo = appInfoMapper.selectByPrimaryKey(appId);
        return SingleResponse.of(AppViewConvert.INSTANCE.map(appInfo));
    }

}
