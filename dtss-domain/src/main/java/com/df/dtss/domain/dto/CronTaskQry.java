package com.df.dtss.domain.dto;

import com.xy.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务查询请求指令>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CronTaskQry extends Command {

    /**
     * 任务编码
     */
    private String taskCode;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 所属应用名
     */
    private String appName;

}
