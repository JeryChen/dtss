package com.df.dtss.handle.extension;

import com.df.dtss.domain.dto.AppInfoAddCmd;
import com.df.dtss.domain.enums.RegistryTypeEnum;
import com.df.dtss.handle.extension.point.BaseValidatorExtPt;
import com.xy.cola.exception.util.ArgumentAssert;
import com.xy.cola.extension.Extension;

import static com.df.dtss.domain.constants.BizSceneConstants.ADD_APP_INFO_SCENARIO;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_SYS;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_USE_CASE;

/**
 * <功能介绍><br>
 * <p>
 * <添加app信息校验处理>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Extension(bizId = ADMIN_SYS, useCase = ADMIN_USE_CASE, scenario = ADD_APP_INFO_SCENARIO)
public class AppInfoAddValidatorHandle implements BaseValidatorExtPt<AppInfoAddCmd> {

    @Override
    public void validate(AppInfoAddCmd cmd) {
        ArgumentAssert.notNull(cmd, "新增app信息参数对象不能为空");
        ArgumentAssert.notNull(cmd.getAppInfo(), "新增app信息参数对象不能为空");
        ArgumentAssert.hasText(cmd.getAppInfo().getAppName(), "[应用名]不能为空");
        ArgumentAssert.hasText(cmd.getAppInfo().getAppDesc(), "[应用描述]不能为空");
        ArgumentAssert.notNull(cmd.getAppInfo().getRegistryType(), "[应用地址注册类型]不能为空");
        if (RegistryTypeEnum.MANUAL.equalsCurr(cmd.getAppInfo().getRegistryType())) {
            ArgumentAssert.hasText(cmd.getAppInfo().getAddress(), "[注册地址]不能为空");
        }
    }
}
