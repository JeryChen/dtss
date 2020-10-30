package com.df.dtss.domain.dto;

import com.df.dtss.domain.dto.clientobject.AppInfoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <添加app信息指令>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppInfoAddCmd extends CommonCommand {

    /**
     * app应用信息
     */
    private AppInfoDTO appInfo;
}
