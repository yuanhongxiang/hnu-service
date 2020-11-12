package com.hnu.common.exception.error;

/**
 * @description: 通用异常错误
 * @author: YUANHX
 * @create: 11:47 上午
 **/
public interface IError {

    String getNamespace();

    String getErrorCode();

    String getErrorMessage();
}
