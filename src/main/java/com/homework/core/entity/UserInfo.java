package com.homework.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.homework.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:23
 **/

@Data
@TableName("t_user_info")
public class UserInfo extends BaseEntity {
    @ApiModelProperty("账号")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("状态")
    private Integer status;
}