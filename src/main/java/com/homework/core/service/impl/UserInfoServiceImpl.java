package com.homework.core.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.common.bean.ResultCodeEnum;
import com.homework.core.AuthStatusEnum;
import com.homework.core.entity.UserInfo;
import com.homework.core.exception.BusException;
import com.homework.core.helper.JwtHelper;
import com.homework.core.mapper.UserInfoMapper;
import com.homework.core.service.UserInfoService;
import com.homework.core.until.MD5;
import com.homework.core.until.ValidateUtil;
import com.homework.core.vo.LoginVo;
import com.homework.core.vo.RegisterVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.homework.common.bean.ResultCodeEnum.USERRULE;

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
        String password = loginVo.getPassword();
        String passwd=MD5.encrypt(password);
        if(
                StringUtils.isEmpty(password)
                ) {
            throw new BusException(ResultCodeEnum.PARAM_ERROR);
        }
        UserInfo userInfo=null;
        if (!StringUtils.isEmpty(email))
        {
            userInfo = baseMapper.selectOne(new QueryWrapper<UserInfo>().eq("email", email));
            if(null == userInfo) {
            throw new BusException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
            }
            //校验密码
            if(!passwd.equals(userInfo.getPassword())) {
                throw new BusException(ResultCodeEnum.FAIL);
            }
        }
        if (!StringUtils.isEmpty(username))
        {
            userInfo = baseMapper.selectOne(new QueryWrapper<UserInfo>().eq("name", username));
            if(null == userInfo) {
                throw new BusException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
            }
            //校验密码
            if(!passwd.equals(userInfo.getPassword())) {
                throw new BusException(ResultCodeEnum.FAIL);
            }
        }
        //使用JWT生成token字符串
        String token = JwtHelper.createToken(userInfo.getId(), userInfo.getName());
        return token;



    }

    @Override
    public void register(RegisterVo registerVo) throws BusException{
        String username = registerVo.getUsername();
        String password = registerVo.getPassword();
        String email =registerVo.getEmail();
        //校验参数
        if(StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(password))
                {
            throw new BusException("error",20001);
        }
        //查询数据库中是否存在相同的邮箱
        Integer count = baseMapper.selectCount(new QueryWrapper<UserInfo>().eq("email", email));
        if(count.intValue() > 0) {
            throw new BusException("error",300);
        }
        //查询数据库中是否存在相同的名字
        Integer countName = baseMapper.selectCount(new QueryWrapper<UserInfo>().eq("name", username));
        if(count.intValue() > 0) {
            throw new BusException("error",301);
        }
        boolean isEmail = Validator.isEmail(email);
        if(!isEmail){
            throw new BusException("邮箱验证失败",302);
        }
        String nameRegex="\\w.{5,20}$";
        String pwdRegex="\"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$\"";
  //      ValidateUtil.validateString(username,nameRegex,new BusException(USERRULE.getMessage(),230));
    //    ValidateUtil.validateString(password,pwdRegex,new BusException(USERRULE.getMessage(),240));
        //添加注册信息到数据库
        UserInfo userInfo = new UserInfo();
        userInfo.setName(registerVo.getUsername());
        userInfo.setEmail(registerVo.getEmail());
        userInfo.setPassword(MD5.encrypt(password));
        userInfo.setStatus(1);
        userInfo.setIsDeleted(0);
        this.save(userInfo);
    }


    //编号变成对应值封装
    private UserInfo packageUserInfo(UserInfo userInfo) {
        //处理认证状态编码
        userInfo.getParam().put("authStatusString",AuthStatusEnum.getStatusNameByStatus(userInfo.getStatus()));
        //处理用户状态 0  1
        String statusString = userInfo.getStatus().intValue()==0 ?"锁定" : "正常";
        userInfo.getParam().put("statusString",statusString);
        return userInfo;
    }
}
