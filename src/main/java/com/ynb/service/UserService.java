package com.ynb.service;

import com.ynb.dao.UserDao;
import com.ynb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ynb
 * @create 2019-3-19 17:12
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(int id){
        return  userDao.getById(id);
    }
}
