package com.homework.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.common.bean.ResultCodeEnum;
import com.homework.core.entity.UserInfo;
import com.homework.core.exception.BusException;
import com.homework.core.helper.JwtHelper;
import com.homework.core.mapper.UserInfoMapper;
import com.homework.core.service.UserInfoService;
import com.homework.core.until.MD5;
import com.homework.core.vo.LoginVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/****
 *  @title: UserInfoServiceImpl
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 9:53
 ***/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

    @Override
    public String login(LoginVo loginVo) {
        String username = loginVo.getUsername();
        String email = loginVo.getEmail();
        String password = loginVo.getCode();
        if(StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(email)) {
            throw new BusException(ResultCodeEnum.PARAM_ERROR);
        }
        UserInfo userInfo = baseMapper.selectOne(new QueryWrapper<UserInfo>().eq("email", email));
        if(null == userInfo) {
            throw new BusException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }
        //校验密码
        String passwd=MD5.encrypt(password);
        if(!passwd.equals(userInfo.getPassword())) {
            throw new BusException(ResultCodeEnum.FAIL);
        }
        //使用JWT生成token字符串
        String token = JwtHelper.createToken(userInfo.getId(), userInfo.getUsername());
        return token;

    }
}
