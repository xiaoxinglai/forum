package com.nchu.service.imp;

import com.nchu.domain.DO.Account;
import com.nchu.domain.DO.User;
import com.nchu.enums.ParamEnum;
import com.nchu.enums.ResultEnum;
import com.nchu.mapper.UserMapper;
import com.nchu.result.BizResult;
import com.nchu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * Created by user12 on 2018/2/3.
 */
@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public BizResult<Boolean> doSign(User user) {
        if (Objects.isNull(user)) {
            return BizResult.Create(ParamEnum.PARAM_IS_NULL.getCode(), ParamEnum.PARAM_IS_NULL.getMsg());
        }
        user.setSignDate(new Date());

        User result = userMapper.selectByNo(user.getuNo());


        if (Objects.isNull(result)) {
            int i = userMapper.insert(user);
            if (i > 0) {
                return BizResult.Create();
            }else {
                return  BizResult.Create(ResultEnum.SQL_EXCEPTION.getCode(),ResultEnum.SQL_EXCEPTION.getMsg());
            }

        } else {
            return BizResult.Create(ParamEnum.NO_IS_REPEAT.getCode(),ParamEnum.NO_IS_REPEAT.getMsg());
        }

    }

    @Override
    public BizResult<User> doLogin(Account account) {

        User result = userMapper.selectByNo(account.getuNo());
        if (Objects.isNull(result)) {
        return BizResult.Create(ParamEnum.NO_USER.getCode(), ParamEnum.NO_USER.getMsg());
        }

        if (result.getPassword().equals(account.getPassword())){

            return  BizResult.Create(result);
        }else {
            return BizResult.Create(ParamEnum.PASS_ERR.getCode(), ParamEnum.PASS_ERR.getMsg());
        }

    }
}
