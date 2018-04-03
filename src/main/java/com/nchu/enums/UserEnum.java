package com.nchu.enums;

/**
 * Created by user12 on 2018/2/11.
 */
public enum UserEnum {
    STUDENT(1, "学生"),
    TECHER(2, "老师"),
    ADMIN(3, "系统管理员"),;
    private Integer code;
    private String msg;

    UserEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }



    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
