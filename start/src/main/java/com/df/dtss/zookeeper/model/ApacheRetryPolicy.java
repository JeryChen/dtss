package com.df.dtss.zookeeper.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <功能介绍><br>
 * <p>
 * <ApacheRetryPolicy>
 *
 * @author xy on 2020/8/14.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ConfigurationProperties(prefix = "apache.retry.policy")
@Data
public class ApacheRetryPolicy {

    /**
     * 重连策略，初始化间隔时间
     */
    private Integer baseSleepTime;

    /**
     * 重连次数
     */
    private Integer maxRetries;

    /**
     * 重连最长时间
     */
    private Integer maxSleep;
}
