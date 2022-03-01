/**
 * (C) Copyright Company 2018. All rights reserved.
 * 文件名：ResponseResult
 * 版 本：1.0
 * 内容简述：请求响应模型
 * 创建日期：2018.09.12-13:00:13
 * 创建人：陈玉麟
 * 修改记录：
 * 日期  版本  修改人  修改内容
 */
package com.homework.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "请求结果响应体")
public class ResponseResult<T> implements Serializable {
    /**
     * 响应状态回执码
     */
    @ApiModelProperty(value = "响应状态回执码")
    private Integer respnum;
    /**
     * 数据体
     */
    @ApiModelProperty(value = "数据体")
    private T data;
    /**
     * 响应回执消息
     */
    @ApiModelProperty(value = "响应回执消息")
    private String respmsg;
    /**
     * 响应时间戳
     */
    @ApiModelProperty(value = "响应时间戳")
    private final long timestamps = System.currentTimeMillis();

    /**
     * 构造请求响应模型
     *
     * @param statusEnum 状态码
     * @param <T>        模型
     * @return 请求响应模型
     */
    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum) {
        return e(statusEnum, null);
    }

    /**
     * 构造请求响应模型
     *
     * @param statusEnum 状态码
     * @param data       需要返回的数据
     * @param <T>        模型
     * @return 请求响应模型
     */
    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum, T data) {
        ResponseResult<T> res = new ResponseResult<>();
        res.setRespnum(statusEnum.code);
        if (statusEnum.code == ResponseCode.CUS_FAIL.code && data != null) {
            res.setRespmsg(statusEnum.msg + data.toString());
        } else {
            res.setRespmsg(statusEnum.msg);
        }
        res.setData(data);
        return res;
    }

    /**
     * 构造请求响应模型
     *
     * @param respmsg    语句
     * @param <T>        模型
     * @return 请求响应模型
     */
    public synchronized static <T> ResponseResult<T> e(String respmsg) {
        ResponseResult<T> res = new ResponseResult<>();
        res.setRespnum(ResponseCode.FAIL.code);
        res.setRespmsg(respmsg);
        return res;
    }

    /**
     * 构造成功的请求响应模型
     *
     * @param <T> 模型
     * @return 成功的请求响应模型
     */
    public synchronized static <T> ResponseResult<T> ok() {
        return e(ResponseCode.OK, null);
    }

    /**
     * 构造成功的请求响应模型
     *
     * @param <T> 模型
     * @return 成功的请求响应模型
     */
    public synchronized static <T> ResponseResult<T> ok(T data) {
        return e(ResponseCode.OK, data);
    }

    /**
     * 构造失败的请求响应模型
     *
     * @param <T> 模型
     * @return 失败的请求响应模型
     */
    public synchronized static <T> ResponseResult<T> error() {
        return e(ResponseCode.FAIL, null);
    }

    public boolean isOk(){
        return ResponseCode.OK.code.equals(this.respnum);
    }

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 8992436576262574064L;
}
