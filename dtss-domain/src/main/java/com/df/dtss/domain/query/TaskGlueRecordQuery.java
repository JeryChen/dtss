package com.df.dtss.domain.query;

import com.xy.cola.dto.PagingQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈glue记录信息 查询参数〉<p>
 *
 * @author xy
 * @date 2020-10-26
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class TaskGlueRecordQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务表主键id
     */
    private Long taskId;

    /**
     * 任务类型
     */
    private Integer taskType;

    /**
     * GLUE类型
     */
    private Integer glueType;

    /**
     * GLUE源代码
     */
    private String glueSource;

    /**
     * GLUE版本备注
     */
    private String glueVersion;

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