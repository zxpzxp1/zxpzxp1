package com.homework.core.exception;

import com.homework.common.bean.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/****
 *  @title: GlobalExceptionHandler
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 10:28
 ***/

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(BusException.class)
    @ResponseBody
    public Result error(BusException e) {
        e.printStackTrace();
        return Result.fail();
    }
}
