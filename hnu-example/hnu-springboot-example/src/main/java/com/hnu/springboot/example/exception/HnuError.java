package com.hnu.springboot.example.exception;

import com.hnu.common.exception.error.IError;

/**
 * @description:
 * @author: YUANHX
 * @create: 1:27 下午
 **/
public enum HnuError implements IError {

    SYSTEM_ERROR("400101", "系统错误"),
    REQUEST_PARSE_PACKET_ERROR("400102","服务器处理数据失败"),
    BUSINESS_ERROR("400103", "业务处理错误");


    private String code;
    private String message;
    private String nameSpace = "HNU-EXAMPLE.";

    HnuError(String code, String message){
        this.code = nameSpace + code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "HnuError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", nameSpace='" + nameSpace + '\'' +
                '}';
    }

    public String getNamespace() {
        return this.nameSpace;
    }

    public String getErrorCode() {
        return this.code;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
