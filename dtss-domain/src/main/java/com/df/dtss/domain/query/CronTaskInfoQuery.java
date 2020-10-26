package com.df.dtss.domain.query;

import com.xy.cola.common.PagingQuery;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈周期任务信息 查询参数〉<p>
 *
 * @author xy
 * @date 2020-10-26
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class CronTaskInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务编码
     */
    private String taskCode;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * appId，应用表主键id
     */
    private Long appId;

    /**
     * 所属应用名
     */
    private String appName;

    /**
     * 运行模式
     */
    private Integer runType;

    /**
     * 任务周期，cron表达式
     */
    private String cron;

    /**
     * 任务状态
     */
    private Integer taskStatus;

    /**
     * 路由策略
     */
    private Integer routeStrategy;

    /**
     * 任务实现的beanName
     */
    private String jobHandler;

    /**
     * 阻塞策略
     */
    private Integer blockStrategy;

    /**
     * 子任务ids
     */
    private String subTaskIds;

    /**
     * 任务执行超时时间，单位秒
     */
    private Integer taskTimeOut;

    /**
     * 失败重试次数
     */
    private Integer retryTimes;

    /**
     * 报警邮箱地址
     */
    private String mail;

    /**
     * 任务参数
     */
    private String taskParam;

    /**
     * 负责人
     */
    private String owner;

    /**
     * GLUE源代码表主键id
     */
    private Long glueSourceId;

    /**
     * 上次调度执行时间
     */
    private Long lastExecuteTime;

    /**
     * 下次调度执行时间
     */
    private Long nextExecuteTime;

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