package com.nchu.service;

import com.nchu.domain.DO.Account;
import com.nchu.domain.DO.User;
import com.nchu.result.BizResult;

/**
 * Created by user12 on 2018/2/3.
 */
public interface IUserService {

    /**
     * 用户注册方法
     * @param user
     * @return
     */
    BizResult<Boolean> doSign(User user);

    /**
     * 用户登陆的方法
     */
    BizResult<User> doLogin(Account account);
}
