package com.homework.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.homework.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:23
 **/

@Data
@TableName("t_message")
public class Message  extends BaseEntity {
    @ApiModelProperty("用户编号")
    private String userId;
    @ApiModelProperty("信息")
    private String msg;
    @ApiModelProperty("子信息")
    private String childMsg;

}