package com.df.dtss.command.task;

import com.df.dtss.convert.CronTaskViewConvert;
import com.df.dtss.convert.CronTaskConvert;
import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.domain.enums.IsEnum;
import com.df.dtss.domain.query.CronTaskInfoQuery;
import com.df.dtss.domain.util.MD5CryptUtils;
import com.df.dtss.gatewayimpl.database.CronTaskInfoMapper;
import com.df.dtss.gatewayimpl.database.model.CronTaskInfo;
import com.df.dtss.vo.CronTaskVO;
import com.google.common.collect.Lists;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.SingleResponse;
import com.xy.cola.enums.ResponseCodeEnum;
import com.xy.cola.util.StreamUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务查询执行器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class CronTaskQryExe {

    @Resource
    private CronTaskInfoMapper cronTaskInfoMapper;

    /**
     * 分页查询周期任务信息
     *
     * @param cronTaskQry 查询参数指令
     * @param pagingParam 分页参数信息
     * @return 分页周期任务信息
     */
    public PageResponse<List<CronTaskVO>> execute(CronTaskQry cronTaskQry, PagingParam pagingParam) {
        PageResponse<List<CronTaskVO>> response = PageResponse.of(null, pagingParam);
        CronTaskInfoQuery cronTaskInfoQuery = CronTaskConvert.INSTANCE.map(cronTaskQry);
        cronTaskInfoQuery.setPagingParam(pagingParam);
        Integer totalNum = cronTaskInfoMapper.countByCondition(cronTaskInfoQuery);
        if (Objects.nonNull(totalNum) && totalNum > 0) {
            List<CronTaskVO> cronTaskVOList = Lists.newArrayList();
            List<CronTaskInfo> cronTaskInfoList = cronTaskInfoMapper.selectByCondition(cronTaskInfoQuery);
            cronTaskInfoList.forEach(cronTaskInfo -> {
                CronTaskVO cronTaskVO = CronTaskViewConvert.INSTANCE.map(cronTaskInfo);
                if (StringUtils.isNotBlank(cronTaskInfo.getSubTaskIds())) {
                    List<Long> subTaskIds = StreamUtil.map(cronTaskInfo.getSubTaskIds().split(","), Long::parseLong);
                    List<CronTaskInfo> subCronTaskList = cronTaskInfoMapper.selectByIds(subTaskIds);
                    cronTaskVO.setSubCronTaskList(StreamUtil.map(subCronTaskList, CronTaskViewConvert.INSTANCE::map));
                }
                cronTaskVOList.add(cronTaskVO);
            });
            pagingParam.setTotalNum(totalNum);
            response.setData(cronTaskVOList);
        }
        return response;
    }

    /**
     * 创建周期任务
     *
     * @param cronTaskAddCmd 添加周期任务指令
     * @return 处理结果，返回周期任务主键id
     */
    public SingleResponse<Long> execute(CronTaskAddCmd cronTaskAddCmd) {
        SingleResponse<Long> response = null;
        CronTaskInfo cronTaskInfo = CronTaskConvert.INSTANCE.map(cronTaskAddCmd.getCronTask());
        cronTaskInfo.setCreator(cronTaskAddCmd.getOperator());
        cronTaskInfo.setEditor(cronTaskAddCmd.getOperator());
        cronTaskInfo.setTaskCode(MD5CryptUtils.md5(cronTaskInfo.getTaskName() + cronTaskInfo.getAppId()));
        cronTaskInfo.setIsDeleted(IsEnum.NO.getCode());
        Date currDate = new Date();
        cronTaskInfo.setCreateTime(currDate);
        cronTaskInfo.setEditTime(currDate);
        int insert = cronTaskInfoMapper.insert(cronTaskInfo);
        if (insert > 0) {
            response = SingleResponse.buildSuccess();
            response.setData(cronTaskInfo.getId());
        } else {
            response = (SingleResponse<Long>) SingleResponse.buildFailure(ResponseCodeEnum.FAIL_BIZ_501);
        }
        return response;
    }
}
