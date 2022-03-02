package com.homework.core.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:23
 **/

@Data
public class UserInfo {
    private long id;
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("邮箱")
    private String email;
}