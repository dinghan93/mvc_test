package com.kkb.xzk.servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-26 14:31
 * @Modified By:
 */
@WebServlet(urlPatterns = "/upload")
public class uploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 1. 创建文件上传对象
            SmartUpload smartUpload = new SmartUpload();

            // 2.初始化文件上传对象
            PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, false, 8192, true);
            smartUpload.initialize(pageContext);

            // 2.1 设置字符集
            smartUpload.setCharset("utf-8");

            // 3. 上传文件
            smartUpload.upload();

            // 4. 获得文件信息
            File file = smartUpload.getFiles().getFile(0);
            String fileName = file.getFileName();
            String contentType = file.getContentType();
            System.out.println("fileName:" + fileName + ", contentType:" + contentType);

            // 5. 指定上传路径
            String path = "/uploadfile/"+fileName;

            // 6. 保存上传的文件
            file.saveAs(path, File.SAVEAS_VIRTUAL);

            // 7.跳转到成功页面
            Request request = smartUpload.getRequest();
            String userName = request.getParameter("username");
            String userPass = request.getParameter("userpass");
            req.setAttribute("username",userName);
            req.setAttribute("userpass",userPass);
            req.setAttribute("filename", fileName);
            req.getRequestDispatcher("showimg.jsp").forward(req, resp);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }
}
