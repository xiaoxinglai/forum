package com.nchu.exception;

import com.nchu.enums.ResultEnum;

/**
 * Created by user12 on 2017/12/13.
 */
public class UserException extends RuntimeException {

    private Integer code;



    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }



}

