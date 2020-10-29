package com.df.dtss.domain.dto;

import com.xy.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <功能介绍><br>
 * <p>
 * <整个应用通用的Command>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonCommand extends Command {

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String editor;
}
