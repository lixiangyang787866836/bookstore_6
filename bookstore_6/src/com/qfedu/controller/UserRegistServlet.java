package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        System.out.println(user);

        UserService userService = new UserServiceImpl();
        int i = userService.userRegist(user);
        if (i == 1){
            System.out.println("注册成功,可以登陆了");
            response.sendRedirect(servletContext.getContextPath()+"jsps/user/login.jsp");
        }else{
            response.setContentType("text/html;charset=uft-8");
            response.getWriter().append("注册失败，请重新注册");
            response.sendRedirect(servletContext.getContextPath()+"jsps/user/regist.jsp");
        }


    }
}
