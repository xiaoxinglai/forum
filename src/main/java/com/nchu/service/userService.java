package com.nchu.service;

import com.nchu.domain.DO.User;

import java.util.List;

/**
 * Created by user12 on 2017/12/13.
 */


public interface userService {


    public List<User> getUserOne(Long uNo);//根据uNo查找指定用户

    public User sign(User user) throws Exception;//用户注册
}
