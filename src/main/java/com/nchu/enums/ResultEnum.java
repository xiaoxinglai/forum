package com.nchu.enums;

/**
 * Created by user12 on 2017/12/13.
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    SNO_NULL_ERROR(1,"学号不能未空"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
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
