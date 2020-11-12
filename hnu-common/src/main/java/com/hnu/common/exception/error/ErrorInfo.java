package com.hnu.common.exception.error;


import com.hnu.common.respone.BaseResponse;

/**
 * @Author： yuan
 * @Description: description
 * @Date: Created in 14:54 2017/11/16
 * @Modified By:
 */
public class ErrorInfo<T> {

    public BaseResponse.Status status;

    private String errorCode;

    private String errorMessage;

    private String extMessage;

    public BaseResponse.Status getStatus() {
        return status;
    }

    public void setStatus(BaseResponse.Status status) {
        this.status = status;
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
        return extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }
}
