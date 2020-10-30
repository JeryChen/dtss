package com.df.dtss.service;

import com.df.dtss.domain.dto.TaskGlueAddCmd;
import com.xy.cola.dto.Response;

/**
 * <功能介绍><br>
 * <p>
 * <任务glue相关业务处理>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface TaskGlueServiceI {

    /**
     * 新建任务glue信息
     *
     * @param taskGlueAddCmd 添加任务glue脚本信息指令
     * @return 处理结果
     */
    Response create(TaskGlueAddCmd taskGlueAddCmd);
}
