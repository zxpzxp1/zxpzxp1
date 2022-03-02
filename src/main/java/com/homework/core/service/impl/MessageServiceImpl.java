package com.homework.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.core.entity.Message;
import com.homework.core.mapper.MessageMapper;
import com.homework.core.service.MessageService;
import com.homework.core.vo.MessageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/****
 *  @title: MessageServiceImpl
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 15:23
 ***/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper,Message> implements MessageService {
    @Override
    public void save(MessageVo vo) {
        String msg = vo.getMsg();
        String userId = vo.getUserId();
        int id = vo.getId();
        Message message=new Message();
        message.setUserId(userId);
        message.setMsg(msg);
        if (StringUtils.isEmpty(id)){
            this.baseMapper.insert(message);
        }

    }

    @Override
    public void update(MessageVo vo) {
        String msg = vo.getMsg();
        String userId = vo.getUserId();
        int id = vo.getId();
        String childMsg=vo.getChildMsg();
        Message message=new Message();
        message.setId(id);
        message.setUserId(userId);
        message.setMsg(msg);
        message.setMsg(childMsg);
        this.saveOrUpdate(message);
    }

    public void saveChild(MessageVo vo) {
        int id = vo.getId();
        String userId = vo.getUserId();
        Message message=new Message();
        message.setUserId(userId);
    //    message.setId(msg);
        this.baseMapper.insert(message);
    }
}
