package com.df.dtss.zookeeper;

import com.df.dtss.zookeeper.model.ApacheRetryPolicy;
import com.df.dtss.zookeeper.model.ApacheZooKeeperProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * <功能介绍><br>
 * <p>
 * <zookeeper client config init>
 *
 * @author xy on 2020/8/14.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
@EnableConfigurationProperties(value = {ApacheZooKeeperProperties.class, ApacheRetryPolicy.class})
@Slf4j
public class ZookeeperConfig {

    @Resource
    private ApacheZooKeeperProperties apacheZooKeeperProperties;

    @Resource
    private ApacheRetryPolicy apacheRetryPolicy;

    @Bean
    public CuratorFramework getCuratorFramework() {
        log.info("zooKeeper client init...");
        //当zk连接时失败的重连策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(apacheRetryPolicy.getBaseSleepTime(), apacheRetryPolicy.getMaxRetries());
        //获得实例对象，拿到ZK client
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(apacheZooKeeperProperties.getConnectUrl())
                .sessionTimeoutMs(apacheZooKeeperProperties.getSessionTimeout())
                .connectionTimeoutMs(apacheZooKeeperProperties.getConnectionTimeout())
                .retryPolicy(retryPolicy)
                .namespace("workspace")
                .build();
        client.start();
        log.info("zooKeeper client start...");
        return client;
    }
}
