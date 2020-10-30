package com.df.dtss.controller;

import com.df.dtss.domain.dto.AppInfoQry;
import com.df.dtss.service.AppServiceI;
import com.df.dtss.vo.AppInfoVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <app控制器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/admin/app")
public class AppController {

    @Resource
    private AppServiceI appServiceI;

    /**
     * 获取所有应用信息
     *
     * @return 应用相关信息
     */
    @GetMapping("/allAppNames")
    public SingleResponse<List<AppInfoVO>> getAllAppNameList() {
        return appServiceI.getAllAppNameList();
    }

    /**
     * 分页查询应用信息
     *
     * @param appInfoQry  查询参数
     * @param pagingParam 分页信息
     * @return 应用信息
     */
    @GetMapping("/pageList")
    public PageResponse<List<AppInfoVO>> pageList(AppInfoQry appInfoQry, PagingParam pagingParam) {
        return appServiceI.pageList(appInfoQry, pagingParam);
    }
}
