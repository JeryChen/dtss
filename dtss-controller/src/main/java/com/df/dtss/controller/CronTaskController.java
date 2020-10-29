package com.df.dtss.controller;

import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.service.CronTaskServiceI;
import com.df.dtss.vo.CronTaskVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务控制器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController("/admin/cron-task")
public class CronTaskController {

    @Resource
    private CronTaskServiceI cronTaskServiceI;

    /**
     * 分页查询周期任务信息
     *
     * @param cronTaskQry 周期任务查询请求指令
     * @param pagingParam 分页参数
     * @return 周期任务信息
     */
    @GetMapping("/pageList")
    public PageResponse<List<CronTaskVO>> pageList(CronTaskQry cronTaskQry, PagingParam pagingParam) {
        return cronTaskServiceI.pageList(cronTaskQry, pagingParam);
    }
}
