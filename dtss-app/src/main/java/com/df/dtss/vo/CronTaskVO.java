package com.df.dtss.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务数据信息>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class CronTaskVO {

    /**
     * 主键id
     */
    private Long id;

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
     * 修改时间
     */
    private Date editTime;

    /**
     * 子任务
     */
    private List<CronTaskVO> subCronTaskList;
}
