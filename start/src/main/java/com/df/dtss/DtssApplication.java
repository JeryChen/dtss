package com.df.dtss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <功能介绍><br>
 * <p>
 * <启动类>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SpringBootApplication(scanBasePackages = {"com.df.dtss", "com.xy.cola"})
@MapperScan("com.df.dtss.gatewayimpl.database")
public class DtssApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtssApplication.class, args);
    }

}
