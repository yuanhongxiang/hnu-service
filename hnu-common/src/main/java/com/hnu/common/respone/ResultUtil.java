package com.hnu.common.respone;

import com.hnu.common.exception.error.IError;

/**
 * @description: 通用返回结果工具类
 * @author: YUANHX
 * @create: 10:54 上午
 **/
public class ResultUtil {

    /**
     * 执行成功
     * @param obj
     * @return
     */
    public static Result success(Object obj){
        Result result = new Result();
        result.setCode("000000");
        result.setMessage("SUCCESS");
        result.setData(obj);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    /**
     * 异常返回结果
     * @param code
     * @param message
     * @return
     */
    public static Result error(String code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result error(IError error){
        Result result = new Result();
        result.setCode(error.getErrorCode());
        result.setMessage(error.getErrorMessage());
        return result;
    }
}
