package com.df.dtss.controller;

import com.df.dtss.service.AppServiceI;
import com.df.dtss.vo.AppInfoVO;
import com.xy.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController("/admin/app")
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
}
