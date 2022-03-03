package com.homework.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homework.core.entity.Message;
import com.homework.core.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;


/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:24
 **/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}