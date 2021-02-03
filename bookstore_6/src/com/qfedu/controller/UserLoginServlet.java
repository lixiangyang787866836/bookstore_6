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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserService userService = new UserServiceImpl();
        boolean b = userService.login(user);
        if (b){
            System.out.println("登陆成功");
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect(servletContext.getContextPath()+"/jsps/main.jsp");
        }else{
           // System.out.println("登陆失败");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().append("登陆失败");
            response.sendRedirect(servletContext.getContextPath()+"jsps/login.jsp");
        }
    }
}
