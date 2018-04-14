package com.hx.edu.modules.user.repository;

import com.hx.edu.modules.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 *
 * Created by DT人 on 2018/4/10 22:24.
 */
@Mapper
public interface UserRepository /*extends JpaRepository<User, Integer>*/ {
    User findByUsername(String username);

    void getCountByUserName(Map map);
}
