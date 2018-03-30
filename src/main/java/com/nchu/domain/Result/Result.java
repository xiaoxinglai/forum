package com.nchu.domain.Result;

import java.util.List;

/**
 * http请求返回的最外层对象
 * Created by user12 on 2017/12/13.
 */
public class Result<T> {



    private Integer code;

    private String msg;

    private List<T> data;

    private Boolean isSuccess;

    public Result() {
    }

    public static Result Create(List data){
        Result result=new Result();
        result.setSuccess(Boolean.TRUE);
        result.setData(data);
        return result;
    }


    public static Result Create(Integer code,String msg){
        Result result=new Result();
        result.setSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}