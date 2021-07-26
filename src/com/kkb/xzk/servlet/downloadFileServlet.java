package com.kkb.xzk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-26 17:20
 * @Modified By:
 */
@WebServlet(urlPatterns = "/downloadimg")
public class downloadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filename = req.getParameter("filename");
        String filepath = "/uploadfile/" + filename;
        //设置文件类型并添加头信息
        resp.setContentType("application/octet-stream");
        resp.addHeader("Content-Disposition", "attachment;filename="+filename);

        req.getRequestDispatcher(filepath).forward(req, resp);
        resp.flushBuffer();
    }
}
