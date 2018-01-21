package com.nchu.service.imp;

import com.nchu.dao.UserRepository;
import com.nchu.domain.DO.User;
import com.nchu.exception.UserException;
import com.nchu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user12 on 2017/12/13.
 */
@Service
public class userServiceImp implements userService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getUserOne(Long uNo) {
        return userRepository.findByUNo(uNo);
    }

    @Override
    public User sign(User user) throws  UserException{


        return userRepository.save(user);
    }


}
