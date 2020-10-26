CREATE TABLE `dtss`.`dtss_cron_task_info`
(
    `id`                bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `task_code`         varchar(32)  NOT NULL COMMENT '任务编码',
    `task_name`         varchar(255) NOT NULL COMMENT '任务名称',
    `app_id`            bigint(20)   NOT NULL COMMENT 'appId，应用表主键id',
    `app_name`          varchar(32)  NOT NULL COMMENT '所属应用名',
    `run_type`          int(4)       NOT NULL COMMENT '运行模式',
    `cron`              varchar(64)  NOT NULL COMMENT '任务周期，cron表达式',
    `task_status`       tinyint(4)   NOT NULL COMMENT '任务状态',
    `route_strategy`    int(4)       NOT NULL COMMENT '路由策略',
    `job_handler`       varchar(255) NOT NULL COMMENT '任务实现的beanName',
    `block_strategy`    int(4)       NOT NULL COMMENT '阻塞策略',
    `sub_task_ids`      varchar(255)          DEFAULT NULL COMMENT '子任务ids',
    `task_time_out`     int(11)      NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
    `retry_times`       int(11)      NOT NULL DEFAULT '0' COMMENT '失败重试次数',
    `mail`              varchar(255)          DEFAULT NULL COMMENT '报警邮箱地址',
    `task_param`        varchar(1024)         DEFAULT NULL COMMENT '任务参数',
    `owner`             varchar(32)  NOT NULL COMMENT '负责人',
    `glue_source_id`    bigint(20)            DEFAULT NULL COMMENT 'GLUE源代码表主键id',
    `last_execute_time` bigint(20)   NOT NULL DEFAULT '0' COMMENT '上次调度执行时间',
    `next_execute_time` bigint(20)   NOT NULL DEFAULT '0' COMMENT '下次调度执行时间',
    `is_deleted`        tinyint(4)   NOT NULL COMMENT '是否已删除，1.是，0.否',
    `creator`           varchar(32)  NOT NULL COMMENT '创建人',
    `editor`            varchar(32)           DEFAULT NULL COMMENT '修改人',
    `create_time`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_task_code_is_deleted` (`task_code`, `is_deleted`),
    KEY `idx_task_name` (`task_name`),
    KEY `idx_app_id` (`app_id`),
    KEY `idx_create_time` (`create_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='任务信息';

CREATE TABLE `dtss`.`dtss_task_glue_record`
(
    `id`           bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `task_id`      bigint(20)   NOT NULL COMMENT '任务表主键id',
    `task_type`    int(4)       NOT NULL COMMENT '任务类型',
    `glue_type`    int(4)       NOT NULL COMMENT 'GLUE类型',
    `glue_source`  mediumtext            DEFAULT NULL COMMENT 'GLUE源代码',
    `glue_version` varchar(128) NOT NULL COMMENT 'GLUE版本备注',
    `is_deleted`   tinyint(4)   NOT NULL COMMENT '是否已删除，1.是，0.否',
    `creator`      varchar(32)  NOT NULL COMMENT '创建人',
    `editor`       varchar(32)           DEFAULT NULL COMMENT '修改人',
    `create_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_glue_version_is_deleted` (`glue_version`, `is_deleted`),
    KEY `idx_task_id_task_type` (`task_id`, `task_type`),
    KEY `idx_create_time` (`create_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='glue记录信息';

CREATE TABLE `dtss`.`dtss_app_registry`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `registry_group` varchar(50)  NOT NULL,
    `registry_key`   varchar(255) NOT NULL,
    `registry_value` varchar(255) NOT NULL,
    `create_time`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `i_g_k_v` (`registry_group`, `registry_key`, `registry_value`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='应用注册信息';

CREATE TABLE `dtss`.`dtss_app_info`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `app_name`      varchar(64)  NOT NULL COMMENT '任务所属appName',
    `app_desc`      varchar(128) NOT NULL COMMENT '应用描述',
    `registry_type` int(4)       NOT NULL COMMENT '应用地址注册类型',
    `address`       varchar(512)          DEFAULT NULL COMMENT '执行器地址列表，多地址逗号分隔',
    `is_deleted`    tinyint(4)   NOT NULL COMMENT '是否已删除，1.是，0.否',
    `creator`       varchar(32)  NOT NULL COMMENT '创建人',
    `editor`        varchar(32)           DEFAULT NULL COMMENT '修改人',
    `create_time`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_app_name_is_deleted` (`app_name`, `is_deleted`),
    KEY `idx_app_desc` (`app_desc`),
    KEY `idx_create_time` (`create_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='任务所属应用信息';

CREATE TABLE `dtss`.`dtss_user_account`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username`    varchar(50) NOT NULL COMMENT '账号',
    `password`    varchar(50) NOT NULL COMMENT '密码',
    `role`        tinyint(4)  NOT NULL COMMENT '角色：0-普通用户、1-管理员',
    `permission`  varchar(255)         DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
    `is_deleted`  tinyint(4)  NOT NULL COMMENT '是否已删除，1.是，0.否',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username_is_deleted` (`username`, `is_deleted`),
    KEY `idx_create_time` (`create_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户账户信息';