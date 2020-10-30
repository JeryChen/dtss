package com.df.dtss.service.impl;

import com.df.dtss.command.glue.TaskGlueAddExe;
import com.df.dtss.domain.dto.TaskGlueAddCmd;
import com.df.dtss.service.TaskGlueServiceI;
import com.xy.cola.dto.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class TaskGlueServiceImpl implements TaskGlueServiceI {

    @Resource
    private TaskGlueAddExe taskGlueAddExe;

    /**
     * 新建任务glue信息
     *
     * @param taskGlueAddCmd 添加任务glue脚本信息指令
     * @return 处理结果
     */
    @Override
    public Response create(TaskGlueAddCmd taskGlueAddCmd) {
        return taskGlueAddExe.execute(taskGlueAddCmd);
    }
}
