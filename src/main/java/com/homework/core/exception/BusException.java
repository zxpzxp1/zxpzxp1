package com.homework.core.exception;

import com.homework.common.bean.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/****
 *  @title: BusException
 *  @projectName Bulletinboard
 **    @author zxp
 *     @date 2022/3/2 10:26
 ***/
@Data
@ApiModel(value = "自定义全局异常类")
public class BusException extends RuntimeException {
    @ApiModelProperty(value = "异常状态码")
    private Integer code;

    public BusException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public BusException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "BusException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
