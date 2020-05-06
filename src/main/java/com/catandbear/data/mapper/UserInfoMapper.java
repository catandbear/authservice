package com.catandbear.data.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.catandbear.data.entity.LoginEntity;
import com.catandbear.data.entity.UserInfoDB;

@Mapper
@Repository
public interface UserInfoMapper {

    UserInfoDB selectUserByName(LoginEntity user);
    int addUser(UserInfoDB user);
    int updateUser(LoginEntity user);
    int deleteUser(int id);
}
