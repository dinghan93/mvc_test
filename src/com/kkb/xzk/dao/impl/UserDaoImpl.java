package com.kkb.xzk.dao.impl;

import com.kkb.xzk.bean.User;
import com.kkb.xzk.dao.UserDao;
import com.kkb.xzk.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 15:21
 * @Modified By:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() {
        Connection connection = DruidUtil.getConnection();
        List<User> users = new ArrayList<User>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("select * from user");
            rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUserid(rs.getInt("userid"));
                u.setUsername(rs.getString("username"));
                u.setUserpass(rs.getString("userpass"));
                users.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtil.close(connection, ps, rs);
        }
        return users;
    }

    @Override
    public User getUser(Integer userId) {
        Connection connection = DruidUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = new User();
        user.setUserid(userId);
        try {
            ps = connection.prepareStatement("select username, userpass from user where userid=?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
                String userName = rs.getString("username");
                String userPass = rs.getString("userpass");
                user.setUsername(userName);
                user.setUserpass(userPass);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return user;
        } finally {
            DruidUtil.close(connection, ps, rs);
        }
        return user;
    }

    @Override
    public boolean userNameExisted(String userName) {
        Connection connection = DruidUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("select * from user where username=?");
            ps.setString(1, userName);
            rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally {
            DruidUtil.close(connection, ps, rs);
        }
        return false;
    }
}
