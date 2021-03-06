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

import java.util.*;


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
        message.setIsDeleted(0);
        message.setCreateTime(new Date());
        if (id==0){
            this.baseMapper.insert(message);
        }
    }

    @Override
    public void saveChild(int id, String userId, String msg) {
        Message message = this.getById(id);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userid",userId);
        jsonObject.put("msg",msg);


        List<JSONObject> jsonObjects=Lists.newArrayList();
        if (StringUtils.isEmpty(message.getChildMsg())){
            jsonObjects.add(jsonObject);
        }else{
            String childMsg = message.getChildMsg();
            jsonObjects = JSONArray.parseArray(childMsg).toJavaList(JSONObject.class);
            jsonObjects.add(jsonObject);

        }
        String strChild = jsonObjects.toString();
        message.setChildMsg(strChild);
        message.setUpdateTime(new Date());
        this.updateById(message);

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
        message.setUpdateTime(new Date());
        this.saveOrUpdate(message);
    }


}
