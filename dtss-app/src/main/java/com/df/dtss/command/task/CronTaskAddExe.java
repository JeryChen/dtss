package com.df.dtss.command.task;

import com.df.dtss.convert.CronTaskConvert;
import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.util.MD5CryptUtils;
import com.df.dtss.gatewayimpl.database.CronTaskInfoMapper;
import com.df.dtss.gatewayimpl.database.model.CronTaskInfo;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.enums.ResponseCodeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务新增执行器>
 *
 * @author xy on 2021/3/31.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class CronTaskAddExe {

    @Resource
    private CronTaskInfoMapper cronTaskInfoMapper;

    /**
     * 创建周期任务
     *
     * @param cronTaskAddCmd 添加周期任务指令
     * @return 处理结果，返回周期任务主键id
     */
    public SingleResponse<Long> add(CronTaskAddCmd cronTaskAddCmd) {
        SingleResponse<Long> response = null;
        CronTaskInfo cronTaskInfo = CronTaskConvert.INSTANCE.map(cronTaskAddCmd.getCronTask());
        cronTaskInfo.setCreator(cronTaskAddCmd.getOperator());
        cronTaskInfo.setEditor(cronTaskAddCmd.getOperator());
        cronTaskInfo.setTaskCode(MD5CryptUtils.md5(cronTaskInfo.getTaskName() + cronTaskInfo.getAppId()));
        int insert = cronTaskInfoMapper.insert(cronTaskInfo);
        if (insert > 0) {
            response = SingleResponse.of(cronTaskInfo.getId());
        } else {
            response = SingleResponse.buildFailure(ResponseCodeEnum.FAIL_BIZ_501.getCode(), "创建周期任务失败");
        }
        return response;
    }
}
