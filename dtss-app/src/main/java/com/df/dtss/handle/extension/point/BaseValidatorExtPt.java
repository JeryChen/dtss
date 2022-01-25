package com.df.dtss.handle.extension.point;

import com.xy.cola.dto.Command;
import com.xy.cola.extension.ExtensionPointI;

/**
 * <功能介绍><br>
 * <p>
 * <base validator extension point>
 *
 * @author xy on 2022/1/25.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface BaseValidatorExtPt<T extends Command> extends ExtensionPointI {

    /**
     * cmd validate
     *
     * @param cmd cmd
     */
    void validate(T cmd);
}
