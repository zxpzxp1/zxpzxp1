package com.homework.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/****
 *  @title: 注册vo
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 9:27
 ***/

@Data
@ApiModel(description="注册对象")
public class RegisterVo {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String password;



}
