package com.homework.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/****
 *  @title: loginVo
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 9:27
 ***/

@Data
@ApiModel(description="登录对象")
public class LoginVo {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String password;

}
