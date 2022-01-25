package com.df.dtss.command.app;

import com.df.dtss.convert.AppConvert;
import com.df.dtss.domain.dto.AppInfoAddCmd;
import com.df.dtss.gatewayimpl.database.AppInfoMapper;
import com.df.dtss.gatewayimpl.database.model.AppInfo;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.enums.ResponseCodeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <功能介绍><br>
 * <p>
 * <app信息写操作>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class AppAddExe {

    @Resource
    private AppInfoMapper appInfoMapper;

    /**
     * 新增应用信息
     *
     * @param appInfoAddCmd 新增参数信息
     *
     * @return 处理结果
     */
    public SingleResponse<Long> createAppInfo(AppInfoAddCmd appInfoAddCmd) {
        SingleResponse<Long> response = null;
        AppInfo appInfo = AppConvert.INSTANCE.map(appInfoAddCmd.getAppInfo());
        appInfo.setCreator(appInfoAddCmd.getOperator());
        appInfo.setEditor(appInfoAddCmd.getOperator());
        int insert = appInfoMapper.insert(appInfo);
        if (insert > 0) {
            response = SingleResponse.of(appInfo.getId());
        } else {
            response = SingleResponse.buildFailure(ResponseCodeEnum.FAIL_BIZ_501.getCode(), "创建应用信息失败");
        }
        return response;
    }
}
