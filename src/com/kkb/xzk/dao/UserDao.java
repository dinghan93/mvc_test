package com.kkb.xzk.dao;

import com.kkb.xzk.bean.User;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 15:08
 * @Modified By:
 */
public interface UserDao {
    //得到所有用户数据
    List<User> getAll();
    User getUser(Integer userId);
    boolean userNameExisted(String userName);
}
