package com.hnu.common.exception;

import com.hnu.common.exception.error.HnuError;
import com.hnu.common.respone.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 通用异常处理类
 * @author: YUANHX
 * @create: 11:01 上午
 **/
@ControllerAdvice
public class GlobalExceptionHandler{

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result handlerException(BusinessException e){
        LOGGER.error("GlobalExceptionHandler.BusinessException: ", e);
        if(e instanceof BusinessException){
            Result result = new Result();
            BusinessException exception = (BusinessException) e;
            result.setCode(exception.getErrorCode());
            result.setMessage(exception.getErrorMessage());
            return result;
        }else{
            Result result = new Result();
            result.setCode(HnuError.BUSINESS_ERROR.getErrorCode());
            result.setMessage(HnuError.BUSINESS_ERROR.getErrorMessage());
            return result;
        }

    }
}
