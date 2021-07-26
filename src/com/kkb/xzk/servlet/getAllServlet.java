package com.kkb.xzk.servlet;

import com.kkb.xzk.bean.User;
import com.kkb.xzk.service.UserService;
import com.kkb.xzk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 16:34
 * @Modified By:
 */
@WebServlet(urlPatterns="/getAll")
public class getAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 取得参数
        //2. 数据处理
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAll();
        req.setAttribute("users", users); //通过request保存值
        //3.返回页面（通过转发的形式）
        req.getRequestDispatcher("/show.jsp").forward(req, resp);
    }
}
