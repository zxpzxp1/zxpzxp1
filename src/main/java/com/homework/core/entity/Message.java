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
    @ApiModelProperty("用户编号")
    private String userId;
    @ApiModelProperty("信息")
    private String msg;
    @ApiModelProperty("子信息")
    private String childMsg;

}