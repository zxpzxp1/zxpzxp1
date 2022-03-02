package com.homework.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.homework.core.entity.Message;
import com.homework.core.mapper.MessageMapper;
import com.homework.core.service.MessageService;
import com.homework.core.vo.ChildVo;
import com.homework.core.vo.MessageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        String childMsg=vo.getChildMsg();
        Message message=new Message();
        message.setUserId(userId);
        message.setMsg(msg);
        message.setChildMsg(childMsg);
        if (id==0){
            this.baseMapper.insert(message);
        }
    }

    @Override
    public void saveChild(String id, String userId, String msg) {
        List<Map<String,Object>> chidMsgList= Lists.newArrayList();
        Message message = this.baseMapper.selectById(id);
        HashMap<String,Object> map= new HashMap<>();
        ChildVo vo=new ChildVo();
        vo.setUserId(userId);
        vo.setMsg(msg);
        map.put(id,vo);
        if (StringUtils.isEmpty(message.getChildMsg())){
            chidMsgList.add(map);
        }else{
            String childMsg = message.getChildMsg();
            JSONObject jsonObject = JSONArray.parseObject(childMsg);

        }
        String strChild = chidMsgList.toString();
        message.setChildMsg(strChild);
        this.baseMapper.updateById(message);
    }

    @Override
    public void update(MessageVo vo) {
        String msg = vo.getMsg();
        String userId = vo.getUserId();
        int id = vo.getId();
        String childMsg=vo.getChildMsg();
        Message message=new Message();
        message.setId((long)id);
        message.setUserId(userId);
        message.setMsg(msg);
        message.setMsg(childMsg);
        this.saveOrUpdate(message);
    }


}
