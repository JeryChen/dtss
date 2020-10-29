package com.df.dtss.vo;

import lombok.Data;

import java.util.Date;

/**
 * <功能介绍><br>
 * <p>
 * <app注册信息>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class AppInfoVO {

    /**
     * 主键id
     */
    private Long id;

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

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

}
