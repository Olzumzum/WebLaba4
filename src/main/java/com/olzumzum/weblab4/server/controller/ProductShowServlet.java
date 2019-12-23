package com.olzumzum.weblab4.server.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.olzumzum.weblab4.server.model.DAO.CakeList;
import com.olzumzum.weblab4.server.model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Download product lists and add data to the session.
 * obtaining user rights information
 */

@WebServlet("/ProductShowServlet")
public class ProductShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Мы здесь драсте");
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        List<ItemProduct> mCakeList = null;

        /**listing and loading product lists */
        CakeList cakeTable = new CakeList();

        HttpSession session = req.getSession();
        String searchCriterion = req.getParameter("searchCriterion");
        String assortCriterion = req.getParameter("assort");


        if ( (assortCriterion != null) && (assortCriterion.equals("all")) ) {
            /** get list all products */
            mCakeList = cakeTable.getAllCakes();
            req.setAttribute("listCake", mCakeList);
        } else {
//            /** search by two criteria */
//           /* if ((assortCriterion != null) && (searchCriterion != null)) {
//                cakeTable.getCakesListSearchAndAssortment(searchCriterion, assortCriterion);
//                req.setAttribute("listCake", mCakeList);
//            }
//            */

            /** search by one criteria */
            if (searchCriterion == null)
            /** get list by assortment criterion */
                mCakeList = cakeTable.getCakesAssortmentCriterion(assortCriterion);

            if (assortCriterion == null) {
                mCakeList = cakeTable.getCakesListSearch(searchCriterion);

            }
        }

        /** превращаем полученный список в объект JSON */
        ObjectMapper objectMapper = new ObjectMapper();
        String listCake = objectMapper.writeValueAsString(mCakeList);

        req.setAttribute("listCake", mCakeList);

        /** записываем данные о списке в ответ от сервера,
         * чтобы получить изменения в ajax
         */
        resp.setHeader("Cache-Control", "no-cache");
        resp.getWriter().write(listCake);
//        resp.getWriter().write("Ответочка");

       // session.setAttribute("roleRule", roleCheck(session));


    }


    /**
     * Сheck user rights
     *
     * @param session
     * @return
     */
//    private boolean roleCheck(HttpSession session) {
//        String userRole = String.valueOf(session.getAttribute("userRole"));
//
//        if (!userRole.equals("null")) {
//            UserRoleList userRoleList = new UserRoleList();
//            String role = userRoleList.roleCheck(userRole);
//            System.out.println("Наша роль " + role);
//            return role.equals("admin");
//        }
//        return false;
//    }
}
