package com.df.dtss.api;

import com.df.dtss.dto.clientobject.JobCO;
import com.xy.cola.dto.SingleResponse;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈定时任务服务相关接口〉
 *
 * @author xingyi on 2020/8/4.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface JobServiceApi {

    /**
     * 获取任务信息
     *
     * @param jobId 任务id
     * @return 响应结果
     */
    SingleResponse<JobCO> getJobById(Long jobId);

}
