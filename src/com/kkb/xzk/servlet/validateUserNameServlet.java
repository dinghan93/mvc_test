package com.kkb.xzk.servlet;

import com.kkb.xzk.service.UserService;
import com.kkb.xzk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-26 0:50
 * @Modified By:
 */
@WebServlet(urlPatterns = "/validateUserName")
public class validateUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("username");
        UserService userService = new UserServiceImpl();
        boolean f = userService.isDuplicateUserName(userName);
        PrintWriter pw = resp.getWriter();
        if(f){
            pw.println("用户名已存在！");
        }else{
            pw.println("用户名合法！");
        }
    }
}
