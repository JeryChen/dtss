package com.df.dtss.dto;

import com.xy.cola.dto.Command;
import lombok.Data;

/**
 * 整个应用通用的Command
 *
 * @author Frank Zhang
 * @date 2019-02-28 7:18 PM
 */
@Data
public class CommonCommand extends Command {

    private String operator;

    private boolean needsOperator;
}
