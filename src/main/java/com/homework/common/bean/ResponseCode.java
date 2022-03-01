/**
 * (C) Copyright Company 2018. All rights reserved.
 * 文件名：ResponseCode
 * 版 本：1.0
 * 内容简述：常用的请求响应代码和提示
 * 创建日期：2018.09.12-13:00:13
 * 创建人：陈玉麟
 * 修改记录：
 * 日期  版本  修改人  修改内容
 */
package com.homework.common.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {

    OK(200, "操作成功"),
    SIGN_IN_OK(200, "登录成功"),
    LOGOUT_OK(200, "注销登录成功"),

    FAIL(-1, "操作失败"),
    LOGOUT_FAIL(-2, "注销登录失败"),
    SIGN_IN_FAIL(-3, "登录失败"),
    SIGN_IN_INPUT_FAIL(-4, "账号或密码错误"),

    NO_LOGIN(401, "未登录或登录已失效"),
    CUS_FAIL(-11, "操作失败,"),
    NO_ROLE(-99, "权限不足"),
    CONNECTION_FAIL(-100, "连接失败"),

    USER_EXISTS(-66, "用户已存在");

    /**
     * 响应代码
     */
    public Integer code;
    /**
     * 提示信息
     */
    public String msg;

    /**
     * 初始化常用的响应消息模型
     *
     * @return 响应消息模型列表
     */
    public static List<ResponseMessage> getArrayMessage() {
        ArrayList<ResponseMessage> responseMessages = new ArrayList<>();
        for (ResponseCode statusEnum : ResponseCode.values()) {
            responseMessages.add(new ResponseMessageBuilder()
                    .code(statusEnum.code)
                    .message(statusEnum.msg)
                    .build());
        }
        return responseMessages;
    }
}
