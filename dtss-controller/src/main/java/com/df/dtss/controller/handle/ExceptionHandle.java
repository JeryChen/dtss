package com.df.dtss.controller.handle;

import com.xy.cola.dto.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 〈一句话介绍功能〉<br>
 * 〈统一异常处理〉
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(IllegalArgumentException.class)
    public Response handleArgumentException(IllegalArgumentException e) {
        return Response.buildFailure("500", e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Response handleBusinessException(Throwable e) {
        return Response.buildFailure("500", e.getMessage());
    }
}
