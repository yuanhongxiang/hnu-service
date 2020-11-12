package com.hnu.common.exception;

import com.hnu.common.exception.error.DefaultError;
import com.hnu.common.exception.error.IError;

/**
 * @Author： yuan
 * @Description: 封装业务异常类
 * @Date: Created in 14:53 2017/11/16
 * @Modified By:
 */
public class BaseBusinessException extends RuntimeException{
    private static final long serialVersionUID = -1;
    private IError error;
    private String extMessage;

    public BaseBusinessException() {
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
    }

    public BaseBusinessException(String message) {
        super(message);
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.extMessage = message;
    }

    public BaseBusinessException(String message, Throwable cause) {
        super(message, cause);
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.extMessage = message;
    }

    public BaseBusinessException(Throwable cause) {
        super(cause);
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        if(cause instanceof BaseBusinessException){
            BaseBusinessException exception = (BaseBusinessException) cause;
            this.error = exception.getError();
            this.extMessage = exception.getMessage();
            this.extMessage = exception.getExtMessage();

        }
    }

    public BaseBusinessException(IError error) {
        super();
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.error = error;
    }

    public BaseBusinessException(IError error, String message) {
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.extMessage = message;
        this.error = error;
    }

    public BaseBusinessException( Throwable cause, IError error, String message) {
        super(message, cause);
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.extMessage = message;
        this.error = error;
    }

    public BaseBusinessException(IError error, Throwable cause) {
        super(cause);
        this.error = DefaultError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.error = error;
    }

    public IError getError() {
        return this.error;
    }

    public String getExtMessage() {
        return this.extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }

    @Override
    public String toString() {
        return super.toString() + ",ErrorCode : " + this.error.getErrorCode() + ", ErrorMessage : " + this.error.getErrorMessage() + ", ExtMessage : " + this.extMessage;
    }
}
