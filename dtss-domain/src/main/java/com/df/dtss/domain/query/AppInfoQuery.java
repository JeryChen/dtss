package com.df.dtss.domain.query;

import com.xy.cola.common.PagingQuery;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈任务所属应用信息 查询参数〉<p>
 *
 * @author xy
 * @date 2020-10-26
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class AppInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 是否已删除，1.是，0.否
     */
    private Integer isDeleted;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String editor;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;

    /**
     * 修改时间 开始
     */
    private Date editTimeFrom;

    /**
     * 修改时间 结束
     */
    private Date editTimeTo;

}