package com.kkb.xzk.servlet;

import com.kkb.xzk.bean.User;
import com.kkb.xzk.service.UserService;
import com.kkb.xzk.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

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
 * @Date Created in 2021-07-26 0:26
 * @Modified By:
 */
@WebServlet(urlPatterns = "/getInfo")
public class getUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Integer userId = Integer.parseInt(req.getParameter("userid"));
        UserService userService = new UserServiceImpl();
        User user = userService.getUser(userId);
        JSONObject jsonObject = JSONObject.fromObject(user);
        PrintWriter pw = resp.getWriter();
        pw.print(jsonObject);
    }
}
