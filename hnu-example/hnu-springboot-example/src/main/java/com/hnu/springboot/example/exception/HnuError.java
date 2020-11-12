package com.hnu.springboot.example.exception;

import com.hnu.common.exception.error.IError;

/**
 * @description:
 * @author: YUANHX
 * @create: 1:27 下午
 **/
public enum HnuError implements IError {

    //保存失败
    SAVE_ERROR("0001", "SAVE Error"),

    ;

    String errorCode;
    String errorMessage;

    private static final String NS = "springboot-example";

    HnuError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    @Override
    public String getErrorCode() {
        return NS + "." + errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
