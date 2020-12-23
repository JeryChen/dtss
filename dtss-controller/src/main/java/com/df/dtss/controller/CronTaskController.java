package com.df.dtss.controller;

import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.df.dtss.domain.dto.CronTaskQry;
import com.df.dtss.domain.dto.CronTaskUpdateCmd;
import com.df.dtss.handle.cache.UserHolder;
import com.df.dtss.service.CronTaskServiceI;
import com.df.dtss.vo.CronTaskVO;
import com.xy.cola.dto.PageResponse;
import com.xy.cola.dto.PagingParam;
import com.xy.cola.dto.Response;
import com.xy.cola.extension.BizScenario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import static com.df.dtss.domain.constants.BizSceneConstants.ADD_CRON_TASK_SCENARIO;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_SYS;
import static com.df.dtss.domain.constants.BizSceneConstants.ADMIN_USE_CASE;
import static com.df.dtss.domain.constants.BizSceneConstants.UPDATE_CRON_TASK_SCENARIO;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务控制器>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/admin/cron-task")
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

    /**
     * 新建周期任务
     *
     * @param cronTaskAddCmd 添加周期任务指令
     * @return 新建周期任务处理结果
     */
    @PostMapping("/add")
    public Response add(CronTaskAddCmd cronTaskAddCmd) {
        if (Objects.nonNull(cronTaskAddCmd)) {
            cronTaskAddCmd.setBizScenario(BizScenario.valueOf(ADMIN_SYS, ADMIN_USE_CASE, ADD_CRON_TASK_SCENARIO));
            cronTaskAddCmd.setOperator(UserHolder.get().getUsername());
        }
        return cronTaskServiceI.create(cronTaskAddCmd);
    }

    /**
     * 执行周期任务
     *
     * @param taskId 任务id
     * @return 执行周期任务处理结果
     */
    @PostMapping("execute")
    public Response execute(Long taskId) {
        return null;
    }

    /**
     * 更新周期任务
     *
     * @param cronTaskUpdateCmd 更新周期任务指令
     * @return 更新周期任务处理结果
     */
    @PostMapping("update")
    public Response update(CronTaskUpdateCmd cronTaskUpdateCmd) {
        if (Objects.nonNull(cronTaskUpdateCmd)) {
            cronTaskUpdateCmd.setBizScenario(BizScenario.valueOf(ADMIN_SYS, ADMIN_USE_CASE, UPDATE_CRON_TASK_SCENARIO));
            cronTaskUpdateCmd.setOperator(UserHolder.get().getUsername());
        }
        return cronTaskServiceI.update(cronTaskUpdateCmd);
    }
}
