package com.ynb.dao;

import com.ynb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author ynb
 * @create 2019-3-19 17:10
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id =#{id}")
    public User getById(@Param("id") int id);
}
