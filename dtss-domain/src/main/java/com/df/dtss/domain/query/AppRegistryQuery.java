package com.df.dtss.domain.query;

import com.xy.cola.common.PagingQuery;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈AppRegistry 查询参数〉<p>
 *
 * @author xy
 * @date 2020-10-26
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class AppRegistryQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String registryGroup;

    /**
     * 
     */
    private String registryKey;

    /**
     * 
     */
    private String registryValue;

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