package com.df.dtss.controller.handle;

import com.xy.cola.dto.Response;
import com.xy.cola.enums.ResponseCodeEnum;
import com.xy.cola.exception.BizException;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(IllegalArgumentException.class)
    public Response handleArgumentException(IllegalArgumentException e) {
        log.error("请求参数校验异常", e);
        return Response.buildFailure(ResponseCodeEnum.FAIL_PARAMS_401.getCode(),
                buildMessage(ResponseCodeEnum.FAIL_PARAMS_401, e.getMessage()));
    }

    @ExceptionHandler(BizException.class)
    public Response handleArgumentException(BizException e) {
        log.error("业务处理异常", e);
        return Response.buildFailure(ResponseCodeEnum.FAIL_BIZ_501.getCode(),
                buildMessage(ResponseCodeEnum.FAIL_BIZ_501, e.getMessage()));
    }

    @ExceptionHandler(Throwable.class)
    public Response handleBusinessException(Throwable e) {
        log.error("未知系统处理异常", e);
        return Response.buildFailure(ResponseCodeEnum.FAIL_SYS_500.getCode(), ResponseCodeEnum.FAIL_SYS_500.getDesc());
    }

    private String buildMessage(ResponseCodeEnum responseCodeEnum, String message) {
        return responseCodeEnum.getDesc().concat("：").concat(message);
    }
}
