package com.df.dtss.gatewayimpl.database.model;

import lombok.Data;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈任务所属应用信息〉<p>
 *
 * @author
 * @date 2020-10-26
 */
@Data
public class AppInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Long id;

    /**
     * 任务所属appName
     *
     * @最大长度   64
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_app_name_is_deleted
     */
    private String appName;

    /**
     * 应用描述
     *
     * @最大长度   128
     * @允许为空   NO
     * @是否索引   YES
     */
    private String appDesc;

    /**
     * 应用地址注册类型
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer registryType;

    /**
     * 执行器地址列表，多地址逗号分隔
     *
     * @最大长度   512
     * @允许为空   YES
     * @是否索引   NO
     */
    private String address;

    /**
     * 是否已删除，1.是，0.否
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer isDeleted;

    /**
     * 创建人
     *
     * @最大长度   32
     * @允许为空   NO
     * @是否索引   NO
     */
    private String creator;

    /**
     * 修改人
     *
     * @最大长度   32
     * @允许为空   YES
     * @是否索引   NO
     */
    private String editor;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   YES
     */
    private Date createTime;

    /**
     * 修改时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date editTime;


}