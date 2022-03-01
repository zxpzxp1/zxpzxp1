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
public class Message {
    private int id;
    @ApiModelProperty("父编号")
    private String parent;
    @ApiModelProperty("信息")
    private String msg;

}