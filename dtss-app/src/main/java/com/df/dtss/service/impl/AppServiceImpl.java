package com.df.dtss.service.impl;

import com.df.dtss.command.app.AppQryExe;
import com.df.dtss.service.AppServiceI;
import com.df.dtss.vo.AppInfoVO;
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
        return appQryExe.execute();
    }
}
