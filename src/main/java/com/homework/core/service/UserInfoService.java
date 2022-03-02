package com.homework.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.core.entity.UserInfo;
import com.homework.core.vo.LoginVo;

import java.util.Map;

/****
 *  @title: UserInfoService
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 9:33
 ***/
public interface UserInfoService extends IService<UserInfo> {
    String login(LoginVo loginVo);
}
