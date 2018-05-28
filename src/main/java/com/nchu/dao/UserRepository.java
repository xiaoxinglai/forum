package com.nchu.dao;

import com.nchu.domain.DO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user12 on 2017/12/11.
 */
public interface UserRepository  extends JpaRepository<User,Long>{

    List<User> findByUNo(Long uNo);
    List<User> findByTag(Integer tag);


}
