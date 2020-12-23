package com.df.dtss.handle.extension.point;

import com.xy.cola.dto.Command;
import com.xy.cola.exception.util.ArgumentAssert;
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
public interface CronTaskValidatorExtPt<T extends Command> extends ExtensionPointI {

    /**
     * 周期任务参数验证处理
     *
     * @param cmd 周期任务操作参数指令
     */
    default void validate(T cmd) {
        ArgumentAssert.notNull(cmd, "周期任务操作参数指令对象不能为空");
        ArgumentAssert.notNull(cmd.getBizScenario(), "业务场景来源不能为空");
    }
}
