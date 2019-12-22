package com.olzumzum.weblab4.server.controller;


import com.olzumzum.weblab4.server.model.entities.User;
import com.olzumzum.weblab4.server.model.repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Сервлет регистрации сработал");
        /** getting user data from a form */
        String emailForm = req.getParameter("email");
        String passwordForm = req.getParameter("password");

        /** user creation with received fields */
        User user = new User();
        user.setEmailUser(emailForm);
        user.setPasswordUser(passwordForm);
        user.setRole(2);
        UsersRepository.insert(user);

        req.getRequestDispatcher("/authorization.html").forward(req, resp);
    }
}
