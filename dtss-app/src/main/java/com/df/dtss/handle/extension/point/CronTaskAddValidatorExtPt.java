package com.df.dtss.handle.extension.point;

import com.df.dtss.domain.dto.CronTaskAddCmd;
import com.xy.cola.extension.ExtensionPointI;

/**
 * <功能介绍><br>
 * <p>
 * <周期任务创建验证器扩展点>
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CronTaskAddValidatorExtPt extends ExtensionPointI {

    /**
     * 创建周期任务参数验证处理
     *
     * @param cronTaskAddCmd 新建周期任务参数指令
     */
    void validate(CronTaskAddCmd cronTaskAddCmd);
}
