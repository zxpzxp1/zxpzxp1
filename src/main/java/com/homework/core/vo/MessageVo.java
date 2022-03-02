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
@ApiModel(description="信息对象")
public class MessageVo {
    private int id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "信息")
    private String msg;


    @ApiModelProperty(value = "子信息")
    //[{"msg":"{userid:1,msg:content}","userid":"1"}, {"msg":"{userid:1,msg:content2}","userid":"1"}, {"msg":"{userid:1,msg:content23}","userid":"1"}, {"msg":"{userid:1,msg:content234}","userid":"1"}, {"msg":"{userid:11,msg:content234}","userid":"1"}]
    private String childMsg;//json {userId,msg}



}
