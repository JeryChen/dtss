package com.df.dtss.gatewayimpl.database.model;

import lombok.Data;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈用户账户信息〉<p>
 *
 * @author
 * @date 2020-10-26
 */
@Data
public class UserAccount implements Serializable {

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
     * 账号
     *
     * @最大长度   50
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   idx_username_is_deleted
     */
    private String username;

    /**
     * 密码
     *
     * @最大长度   50
     * @允许为空   NO
     * @是否索引   NO
     */
    private String password;

    /**
     * 角色：0-普通用户、1-管理员
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer role;

    /**
     * 权限：执行器ID列表，多个逗号分割
     *
     * @最大长度   255
     * @允许为空   YES
     * @是否索引   NO
     */
    private String permission;

    /**
     * 是否已删除，1.是，0.否
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer isDeleted;

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