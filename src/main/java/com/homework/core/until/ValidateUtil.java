package com.homework.core.until;

import com.homework.core.exception.BusException;
import org.apache.commons.lang3.StringUtils;

import static com.homework.common.bean.ResultCodeEnum.USERRULE;

/****
 *  @title: ValidateUtil
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 14:01
 ***/
public class ValidateUtil {
    public static void validateString(String str, String rex, RuntimeException ex) {
        //如果字段值不为空，那必须合法
        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(rex)) {
            // 字符串是否与正则表达式相匹配
            if (!str.matches(rex)) {
                //对请求报文中个字段进行合法性校验，长度和格式等
                throw ex;
            }
        }
    };

    public static void valideOperType(String operType){
        if( null == operType || "".equals(operType)){
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        String nameRegex="\\w.{5,20}$";
        String pwdRegex="\"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$\"";
        //ValidateUtil.validateString("ab1",nameRegex,new BusException(USERRULE.getMessage(),230));
        ValidateUtil.validateString("ab1*1abaaa",nameRegex,new BusException(USERRULE.getMessage(),240));
    }
}
