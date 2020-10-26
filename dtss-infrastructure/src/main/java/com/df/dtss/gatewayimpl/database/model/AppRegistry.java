package com.df.dtss.gatewayimpl.database.model;

import lombok.Data;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈AppRegistry〉<p>
 *
 * @author
 * @date 2020-10-26
 */
@Data
public class AppRegistry implements Serializable {

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
     *
     *
     * @最大长度   50
     * @允许为空   NO
     * @是否索引   YES
     */
    private String registryGroup;

    /**
     *
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String registryKey;

    /**
     *
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String registryValue;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
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