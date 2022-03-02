package com.homework.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.core.entity.Message;
import com.homework.core.vo.MessageVo;

import java.util.List;

/****
 *  @title: MessageService
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 15:20
 ***/
public interface MessageService extends IService<Message> {
    public void save(MessageVo vo);

    public void saveChild(int id,String userId,String Msg);

    public void update(MessageVo vo);

    IPage<Message> selectPage(long current, long limit);
}
