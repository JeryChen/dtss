package com.df.dtss.domain.dto.clientobject;

import com.xy.cola.dto.ClientObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务CO>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CronTaskDTO extends ClientObject {

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * appId，应用表主键id
     */
    private Long appId;

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

}
