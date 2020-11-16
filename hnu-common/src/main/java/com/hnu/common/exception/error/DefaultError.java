package com.hnu.common.exception.error;

/**
 * 定义默认异常错误
 */
public enum DefaultError implements IError {
    //内部错误
    SYSTEM_INTERNAL_ERROR("000000", "System Internal Error"),
    /** token认证失败 **/
    TOKEN_AUTH_FAILED("000001", "Token Auth Failed")
    ;

    String errorCode;
    String errorMessage;

    private DefaultError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private DefaultError(String errorCode, String errorMessage, String extErrorMsg) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return "SYS." + this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

}
