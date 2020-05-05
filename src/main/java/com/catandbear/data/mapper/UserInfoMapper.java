package com.catandbear.data.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.catandbear.data.UserInfo;
import com.catandbear.data.UserInfoDB;

@Mapper
@Repository
public interface UserInfoMapper {

    UserInfoDB selectUserByName(UserInfo user);
    int addUser(UserInfo user);
    int updateUser(UserInfo user);
    int deleteUser(int id);
}
