package com.homework.core.controller;

import com.homework.common.bean.Result;

import com.homework.core.entity.UserInfo;
import com.homework.core.helper.JwtHelper;
import com.homework.core.service.MessageService;
import com.homework.core.service.UserInfoService;
import com.homework.core.until.AuthContextHolder;
import com.homework.core.vo.LoginVo;
import com.homework.core.vo.RegisterVo;
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
    private MessageService messageService;
    @Autowired
    private UserInfoService userInfoService;
    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo, HttpServletRequest request){
        String token = userInfoService.login(loginVo);
        request.setAttribute("token",token);
        return Result.ok(token);
    }

    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public Result register(@RequestBody RegisterVo registerVo, HttpServletRequest request){
         userInfoService.register(registerVo);
        return Result.ok("success");
    }
    //获取用户id信息接口
    @ApiOperation(value = "获取用户信息")
    @GetMapping("auth/getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);
        UserInfo userInfo = userInfoService.getById(userId);
        return Result.ok(userInfo);
    }
}