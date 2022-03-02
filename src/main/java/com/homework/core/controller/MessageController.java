package com.homework.core.controller;

import com.homework.common.bean.Result;
import com.homework.core.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: MessageController
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 21:37
 **/
@RestController
@RequestMapping("/api/message")
@Api(tags = "信息接口")
public class MessageController {
    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Result add(@RequestBody UserInfo user) {
        return Result.ok();
    }
}