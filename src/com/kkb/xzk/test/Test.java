package com.kkb.xzk.test;

import com.kkb.xzk.bean.User;
import com.kkb.xzk.dao.impl.UserDaoImpl;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 15:33
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        List<User> users = new UserDaoImpl().getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
