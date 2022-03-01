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
public class User {
    private int id;
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("角色：0-普通用户、1-管理员")
    private String role;
    @ApiModelProperty("权限：执行器ID列表，多个逗号分割")
    private String permission;
}