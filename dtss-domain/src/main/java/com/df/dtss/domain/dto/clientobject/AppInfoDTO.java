package com.df.dtss.domain.dto.clientobject;

import com.xy.cola.dto.ClientObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <应用信息>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppInfoDTO extends ClientObject {

    /**
     * 任务所属appName
     */
    private String appName;

    /**
     * 应用描述
     */
    private String appDesc;

    /**
     * 应用地址注册类型
     */
    private Integer registryType;

    /**
     * 执行器地址列表，多地址逗号分隔
     */
    private String address;

}
