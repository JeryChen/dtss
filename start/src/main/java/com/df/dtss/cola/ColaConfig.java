package com.df.dtss.cola;

import com.xy.cola.boot.SpringBootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <功能介绍><br>
 * <p>
 * <Configuration for COLA framework>
 *
 * @author xy on 2020/8/14.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
@ComponentScan(value = {"com.xy.cola","com.df.dtss"})
public class ColaConfig {

    @Bean(initMethod = "init")
    public SpringBootstrap bootstrap() {
        return new SpringBootstrap();
    }
}
