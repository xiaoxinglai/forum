package com.nchu.mapper;

import com.nchu.domain.DO.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by user12 on 2018/1/21.
 */
@Mapper
public interface UserMapper {
    User selectUserById(Long id);

    List<User> selectAll();

    void insert(User user);

    Long update(User user);

    Long delete(Long id);
}
