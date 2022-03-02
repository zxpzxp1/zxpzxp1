package com.homework.core.controller;

import com.homework.common.bean.Result;

import com.homework.core.service.UserInfoService;
import com.homework.core.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @className: UserController
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:23
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户信息接口")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo, HttpServletRequest request){
        Map<String, Object> info = userInfoService.login(loginVo);
        return Result.ok(info);
    }
}