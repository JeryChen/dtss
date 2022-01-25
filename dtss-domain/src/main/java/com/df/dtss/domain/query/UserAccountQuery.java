package com.df.dtss.domain.query;

import com.xy.cola.dto.PagingQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈用户账户信息 查询参数〉<p>
 *
 * @author xy
 * @date 2020-10-26
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccountQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色：0-普通用户、1-管理员
     */
    private Integer role;

    /**
     * 权限：执行器ID列表，多个逗号分割
     */
    private String permission;

    /**
     * 是否已删除，1.是，0.否
     */
    private Integer isDeleted;

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