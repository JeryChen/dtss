package com.df.dtss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.df.dtss", "com.xy.cola" })
@MapperScan("com.df.dtss.gatewayimpl.database")
public class DtssApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtssApplication.class, args);
    }

}
