package com.nchu.enums;

/**
 * Created by user12 on 2018/2/3.
 */
public enum ParamEnum {
    PARAM_IS_NULL(10,"参数为空"),
    NO_IS_REPEAT(11,"学号重复"),
    ;
    private Integer code;
    private String msg;

    ParamEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;

    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
