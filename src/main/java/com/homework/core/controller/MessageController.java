package com.homework.core.controller;

import com.homework.common.bean.Result;
import com.homework.core.entity.UserInfo;
import com.homework.core.service.MessageService;
import com.homework.core.until.AuthContextHolder;
import com.homework.core.vo.MessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private MessageService messageService;

    @PostMapping("/list")
    @ApiOperation("显示留言信息")
    public Result list(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);

        return Result.ok();
    }
    @PostMapping("/add")
    @ApiOperation("添加留言信息")
    public Result add(@RequestBody MessageVo vo, HttpServletRequest request) {
      //  Long userId = AuthContextHolder.getUserId(request);
      //  vo.setUserId(Long.toString(userId));
        messageService.save(vo);
        return Result.ok();
    }
    @PostMapping("/addChild")
    @ApiOperation("添加子留言信息")
    public Result addChild(String id, String userId, String msg){
        messageService.saveChild(id,userId,msg);
        return Result.ok();
    }
}