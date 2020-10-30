package com.df.dtss.gatewayimpl.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈glue记录信息〉<p>
 *
 * @author
 * @date 2020-10-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskGlueRecord implements Serializable {

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
     * 任务表主键id
     *
     * @允许为空   NO
     * @是否索引   YES
     */
    private Long taskId;

    /**
     * 任务类型
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer taskType;

    /**
     * GLUE类型
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer glueType;

    /**
     * GLUE源代码
     *
     * @最大长度   16777215
     * @允许为空   YES
     * @是否索引   NO
     */
    private String glueSource;

    /**
     * GLUE版本备注
     *
     * @最大长度   128
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_glue_version_is_deleted
     */
    private String glueVersion;

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