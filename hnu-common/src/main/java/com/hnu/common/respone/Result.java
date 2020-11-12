package com.hnu.common.respone;

import lombok.Data;

/**
 * @description: 定义返回结果
 * @author: YUANHX
 * @create: 10:50 上午
 **/
@Data
public class Result<T> {
    /** 错误码 **/
    private String code;

    /** 错误信息 **/
    private String message;

    /** 返回结果 **/
    private Object data;


}
