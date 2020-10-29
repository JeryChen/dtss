package com.df.dtss.gatewayimpl.database.model;

import lombok.Data;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈周期任务信息〉<p>
 *
 * @author
 * @date 2020-10-26
 */
@Data
public class CronTaskInfo implements Serializable {

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
     * 任务编码
     *
     * @最大长度   32
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_task_code_is_deleted
     */
    private String taskCode;

    /**
     * 任务名称
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   YES
     */
    private String taskName;

    /**
     * appId，应用表主键id
     *
     * @允许为空   NO
     * @是否索引   YES
     */
    private Long appId;

    /**
     * 所属应用名
     *
     * @最大长度   32
     * @允许为空   NO
     * @是否索引   NO
     */
    private String appName;

    /**
     * 运行模式
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer runType;

    /**
     * 任务周期，cron表达式
     *
     * @最大长度   64
     * @允许为空   NO
     * @是否索引   NO
     */
    private String cron;

    /**
     * 任务状态
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer taskStatus;

    /**
     * 路由策略
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer routeStrategy;

    /**
     * 任务实现的beanName
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String jobHandler;

    /**
     * 阻塞策略
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer blockStrategy;

    /**
     * 子任务ids
     *
     * @最大长度   255
     * @允许为空   YES
     * @是否索引   NO
     */
    private String subTaskIds;

    /**
     * 任务执行超时时间，单位秒
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer taskTimeOut;

    /**
     * 失败重试次数
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer retryTimes;

    /**
     * 报警邮箱地址
     *
     * @最大长度   255
     * @允许为空   YES
     * @是否索引   NO
     */
    private String mail;

    /**
     * 任务参数
     *
     * @最大长度   1024
     * @允许为空   YES
     * @是否索引   NO
     */
    private String taskParam;

    /**
     * 负责人
     *
     * @最大长度   32
     * @允许为空   NO
     * @是否索引   NO
     */
    private String owner;

    /**
     * GLUE源代码表主键id
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long glueSourceId;

    /**
     * 上次调度执行时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long lastExecuteTime;

    /**
     * 下次调度执行时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long nextExecuteTime;

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