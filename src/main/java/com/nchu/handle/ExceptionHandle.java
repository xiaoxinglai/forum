package com.nchu.handle;

import com.nchu.Utils.ResultUtil;
import com.nchu.aspect.HttpAspect;
import com.nchu.domain.Result.Result;
import com.nchu.enums.ResultEnum;
import com.nchu.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by user12 on 2017/12/13.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {


        if (e instanceof UserException) {

            return ResultUtil.error(((UserException) e).getCode(), e.getMessage());



        } else {

            logger.error("系统异常{}",e);
            return ResultUtil.error(ResultEnum.UNKOWN_ERROR.getCode(), ResultEnum.UNKOWN_ERROR.getMsg());


        }

    }
}
