package com.homework.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.core.entity.Message;
import com.homework.core.vo.MessageVo;

/****
 *  @title: MessageService
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 15:20
 ***/
public interface MessageService extends IService<Message> {
    public void save(MessageVo vo);

    public void update(MessageVo vo);
}
