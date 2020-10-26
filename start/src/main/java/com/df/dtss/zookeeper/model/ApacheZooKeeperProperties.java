package com.df.dtss.zookeeper.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <功能介绍><br>
 * <p>
 * <ZooKeeper Properties>
 *
 * @author xy on 2020/8/14.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ConfigurationProperties(prefix = "apache.zookeeper")
@Data
public class ApacheZooKeeperProperties {

    /**
     * 连接地址
     */
    private String connectUrl;

    /**
     * 会话超时时间
     */
    private Integer sessionTimeout;

    /**
     * 连接创建超时时间
     */
    private Integer connectionTimeout;

    /**
     * 访问控制 验证策略
     */
    private String scheme;

    /**
     * 权限Id
     */
    private String authId;
}
