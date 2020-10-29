package com.df.dtss.service.impl;

import com.df.dtss.command.task.CronTaskQryExe;
import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.service.CronTaskServiceI;
import com.df.dtss.vo.CronTaskVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CronTaskServiceImpl implements CronTaskServiceI {

    @Resource
    private CronTaskQryExe cronTaskQryExe;

    /**
     * 分页查询周期任务信息列表
     *
     * @param cronTaskQry 查询参数指令
     * @param pagingParam 分页参数信息
     * @return 分页周期任务信息
     */
    @Override
    public PageResponse<List<CronTaskVO>> pageList(CronTaskQry cronTaskQry, PagingParam pagingParam) {
        return cronTaskQryExe.execute(cronTaskQry, pagingParam);
    }
}
