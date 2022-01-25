package com.df.dtss.service.impl;

import com.df.dtss.command.app.AppAddExe;
import com.df.dtss.command.app.AppQryExe;
import com.df.dtss.domain.dto.AppInfoAddCmd;
import com.df.dtss.domain.dto.AppInfoQry;
import com.df.dtss.handle.extension.point.BaseValidatorExtPt;
import com.df.dtss.service.AppServiceI;
import com.df.dtss.vo.AppInfoVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.Response;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.extension.ExtensionExecutor;
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

    @Resource
    private AppAddExe appAddExe;

    @Resource
    private ExtensionExecutor extensionExecutor;

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
     *
     * @return 应用信息
     */
    @Override
    public PageResponse<List<AppInfoVO>> pageList(AppInfoQry appInfoQry, PagingParam pagingParam) {
        return appQryExe.page(appInfoQry, pagingParam);
    }

    /**
     * 获取app信息
     *
     * @param id 主键id
     *
     * @return app信息
     */
    @Override
    public SingleResponse<AppInfoVO> getById(Long id) {
        return appQryExe.loadById(id);
    }

    /**
     * 添加app信息
     *
     * @param appInfoAddCmd app信息添加指令
     *
     * @return 响应结果
     */
    @Override
    public Response add(AppInfoAddCmd appInfoAddCmd) {
        extensionExecutor.executeVoid(BaseValidatorExtPt.class, appInfoAddCmd.getBizScenario(),
                appInfoAddValidator -> appInfoAddValidator.validate(appInfoAddCmd));

        return appAddExe.createAppInfo(appInfoAddCmd);
    }
}
