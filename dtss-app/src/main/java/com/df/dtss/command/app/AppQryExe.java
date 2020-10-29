package com.df.dtss.command.app;

import com.df.dtss.gatewayimpl.database.AppInfoMapper;
import com.xy.cola.dto.SingleResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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
    public SingleResponse<List<String>> execute() {
        return SingleResponse.of(appInfoMapper.getAllApps());
    }
}
