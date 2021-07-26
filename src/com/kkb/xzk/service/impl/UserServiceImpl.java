package com.kkb.xzk.service.impl;

import com.kkb.xzk.bean.User;
import com.kkb.xzk.dao.UserDao;
import com.kkb.xzk.dao.impl.UserDaoImpl;
import com.kkb.xzk.service.UserService;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 16:33
 * @Modified By:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }

    @Override
    public boolean isDuplicateUserName(String userName) {
        return userDao.userNameExisted(userName);
    }
}
