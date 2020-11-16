package com.hnu.common.exception;

import com.hnu.common.exception.error.DefaultError;
import com.hnu.common.exception.error.ErrorInfo;
import com.hnu.common.respone.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：yuan
 * @Description:description
 * @Date:Created in 14:57 2017/11/16
 * @Modified By:
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BaseBusinessException.class)
    public ErrorInfo<String> businessException(HttpServletRequest request,
                                               BaseBusinessException e){
        LOGGER.error("GlobalExceptionHandler BaseBusinessException info :");
        e.printStackTrace();
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setStatus(BaseResponse.Status.FAILED);
        r.setErrorCode(e.getError().getErrorCode());
        r.setErrorMessage(e.getError().getErrorMessage());
        r.setExtMessage(e.getExtMessage());
        return r;
    }

    @ExceptionHandler(value = BusinessException.class)
    public ErrorInfo<String> businessException1(HttpServletRequest request,
                                               BusinessException e){
        LOGGER.error("GlobalExceptionHandler BusinessException info :");
        e.printStackTrace();
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setStatus(BaseResponse.Status.FAILED);
        r.setErrorCode(e.getErrorCode());
        r.setErrorMessage(e.getErrorMessage());
        r.setExtMessage(e.getExtMessage());
        return r;
    }

    @ExceptionHandler(value = Exception.class)
    public ErrorInfo<String> exception(HttpServletRequest request,
                                               Exception e){
        LOGGER.error("GlobalExceptionHandler Exception info :");
        e.printStackTrace();
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setStatus(BaseResponse.Status.FAILED);
        r.setErrorCode(DefaultError.SYSTEM_INTERNAL_ERROR.getErrorCode());
        r.setErrorMessage(e.getMessage());
        r.setExtMessage(null);
        return r;
    }
}
