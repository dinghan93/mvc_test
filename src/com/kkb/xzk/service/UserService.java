package com.kkb.xzk.service;

import com.kkb.xzk.bean.User;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 16:32
 * @Modified By:
 */
public interface UserService {
    List<User> getAll();
    User getUser(Integer userId);
    boolean isDuplicateUserName(String userName);
}
