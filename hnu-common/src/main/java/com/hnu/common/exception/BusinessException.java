package com.hnu.common.exception;

/**
 * @Author： yuan
 * @Description: 封装业务异常类
 * @Date: Created in 14:53 2017/11/16
 * @Modified By:
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -1;

    private String errorCode;
    private String errorMessage;
    private String extMessage;

    public BusinessException(){
        this.errorCode = "SYS.0000";
        this.errorMessage = "System Internal Error";
        this.extMessage = null;
    }

    public BusinessException(String message){
        super(message);
        this.errorCode = "SYS.0000";
        this.errorMessage = message;
        this.extMessage = message;
    }

    public BusinessException(String errorCode, String message){
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public BusinessException(String errorCode, String message, String extMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
        this.extMessage = extMessage;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "SYS.0000";
        this.errorMessage = message;
        this.extMessage = message;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.errorCode = "SYS.0000";
        this.errorMessage = "System Internal Error";
        this.extMessage = null;
        if(cause instanceof BusinessException){
            BusinessException exception = (BusinessException) cause;
            this.errorCode = exception.getErrorCode();
            this.extMessage = exception.getMessage();
            this.extMessage = exception.getExtMessage();
        }
    }

    public BusinessException(String errorCode, String errorMessage, Throwable cause) {
        super(errorMessage,cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.extMessage =null;
    }

    public BusinessException(String errorCode, String errorMessage, String extMessage, Throwable cause) {
        super(errorMessage,cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.extMessage = extMessage;
    }





    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getExtMessage() {
        return this.extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }

    @Override
    public String toString() {
        return super.toString() + ",ErrorCode : " + this.getErrorCode() + ", ErrorMessage : " + this.getErrorMessage() + ", ExtMessage : " + this.extMessage;
    }

}
