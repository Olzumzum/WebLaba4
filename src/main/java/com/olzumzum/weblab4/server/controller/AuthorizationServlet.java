package com.olzumzum.weblab4.server.controller;

import com.olzumzum.weblab4.server.model.DAO.UserTable;
import com.olzumzum.weblab4.server.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *User authorization procedure
 */
@WebServlet("/AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** getting user data from a form */
        String emailForm = req.getParameter("email");
        String passwordForm = req.getParameter("password");

        /** user creation with received fields */
        User user = new User();
        user.setEmailUser(emailForm);
        user.setPasswordUser(passwordForm);

        /** user search in the database */
        UserTable userTable = new UserTable();
        if (userTable.searchUserInTable(user)) {
            System.out.println("Пользователь успешно авторизован");
            HttpSession session = req.getSession();

            /** filling in user session data */
            session.setAttribute("email", emailForm);
            session.setAttribute("password", passwordForm);

            /**getting user role information and session filling */
            String userRole = userTable.getUserRole();
            session.setAttribute("userRole",userRole);

            /** redirect to authorized user page */
            req.getRequestDispatcher("/Authorization.jsp").forward(req, resp);
        }
        else {
            /** redirect to login page */
            req.getRequestDispatcher("/authorization.html").forward(req, resp);
        }


    }
}
