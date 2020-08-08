package com.df.dtss.service.facadeimpl;

import com.df.dtss.api.JobServiceApi;
import com.df.dtss.dto.clientobject.JobCO;
import com.xy.cola.dto.SingleResponse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈〉
 *
 * @author xingyi on 2020/8/4.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@DubboService
public class JobServiceApiImpl implements JobServiceApi {


    /**
     * 获取任务信息
     *
     * @param jobId 任务id
     * @return 响应结果
     */
    @Override
    public SingleResponse<JobCO> getJobById(Long jobId) {
        return null;
    }
}
