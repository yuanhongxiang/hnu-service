package com.hnu.springboot.example.control;

import com.hnu.common.exception.BusinessException;
import com.hnu.common.respone.Result;
import com.hnu.common.respone.ResultUtil;
import com.hnu.springboot.example.exception.HnuError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: YUANHX
 * @create: 12:58 下午
 **/
@RestController
@RequestMapping("/hnuexample")
public class HnuCommonTest {

    @RequestMapping("/add")
    public Result add(){
        return ResultUtil.success();
    }

    @RequestMapping("/add1")
    public Result add1(){
        return ResultUtil.error(HnuError.BUSINESS_ERROR);
    }

    @RequestMapping("/add2")
    public Result add2(){
        throw new BusinessException(HnuError.BUSINESS_ERROR);
    }

//    @RequestMapping("/add0")
//    public Result add0(){
//        try{
//            throw new BusinessException(HnuError.BUSINESS_ERROR);
//        }catch (Exception e){
//            throw new BusinessException(HnuError.SYSTEM_ERROR);
//        }
//        Result chenggadd2 = ResultUtil.success("chenggadd2");
//        return chenggadd2;
//    }

    @RequestMapping("/add3")
    public Result add3(){
        return ResultUtil.success("chenggong");
    }

    @RequestMapping("/add4")
    public Result add4(){
        Result result1 = new Result();
        result1.setData("abcd");
        return result1;
    }

    @RequestMapping("/add5")
    public Result add5(){
        Result result1 = new Result();
        result1.setData("abcd");
        return ResultUtil.success(result1);
    }
}
