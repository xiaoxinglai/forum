package com.nchu.Utils;

import com.nchu.domain.Result.Result;
import com.nchu.enums.ResultEnum;

import java.util.List;

/**
 * Created by user12 on 2017/12/13.
 */
public class ResultUtil{


    //成功
    public static<T> Result success(List<T> data){
        Result  result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());//成功为0
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return  result;

    }

    //成功 查询成功但是没有数据
    public static Result success(){

        return  success(null);

    }




    //失败
    public  static  Result error(Integer code,String msg){

        Result  result=new Result();
        result.setCode(code);//失败的代码  有多种情况 比如1 网络不好 2 服务器故障等等
        result.setMsg("msg");
        return  result;
    }
}
