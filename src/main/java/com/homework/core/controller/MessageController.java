package com.homework.core.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.homework.common.bean.Result;
import com.homework.core.entity.Message;
import com.homework.core.entity.UserInfo;
import com.homework.core.service.MessageService;
import com.homework.core.until.AuthContextHolder;
import com.homework.core.vo.MessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @PostMapping("/list/{current}/{limit}")
    @ApiOperation("显示留言信息")
    public Result list(HttpServletRequest request,
                       @ApiParam(name = "current", value = "当前页码", required = true) @PathVariable long current,
                       @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable long limit) {
        Long userId = AuthContextHolder.getUserId(request);
        IPage<Message> list = messageService.selectPage(current,limit);
        List<Message> records = list.getRecords();
        for (int i = 0; i <records.size() ; i++) {
            int id = records.get(i).getId();


        }

        return Result.ok(list);
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
    public Result addChild(int id, String userId, String msg){
        messageService.saveChild(id,userId,msg);
        return Result.ok();
    }
}