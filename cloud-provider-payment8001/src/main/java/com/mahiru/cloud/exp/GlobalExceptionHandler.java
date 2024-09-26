package com.mahiru.cloud.exp;

import com.mahiru.cloud.resp.ResultData;
import com.mahiru.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className GlobalExceptionHandler
 * @description 全局异常处理
 * @author mahiru
 * @date 2024/09/26 14:00
 * @version v1.0.0
**/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @author mahiru
     * @date 2024/9/26 14:04
     * @methodName exception
     * @description 全局500异常处理
     * @param e Exception
     * @return com.mahiru.cloud.resp.ResultData<java.lang.String>
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        System.out.println("##### come in GlobalExceptionHandler #####");
        log.error("全局异常信息： {}",e.getMessage(), e);

        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
