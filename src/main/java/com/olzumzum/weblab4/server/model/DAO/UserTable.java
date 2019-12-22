package com.olzumzum.weblab4.server.model.DAO;


import com.olzumzum.weblab4.server.model.HibernateUtil;
import com.olzumzum.weblab4.server.model.entities.User;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Класс осуществляет работу с таблицей пользователей
 * все возможные манипуляции с этой таблице описаны здесь
 */
public class UserTable {

    /**
     * по умолчанию, все создаваемые пользователи - не администраторы,
     * задаем id роли "user"
     */
    private final int ROLE_ID = 2;
    private final String SQL_SEARCH_USER_EMAIL = "SELECT * from Users where email_user = ?";

    private String userRole;

    /**
     * Поиск пользователя по таблице
     *
     * @param user
     * @return
     */

    public boolean searchUserInTable(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Query query = session.createQuery("from User U where U.emailUser = :paramEmail and U.passwordUser = :paramPassword");
        query.setParameter("paramEmail", user.getEmailUser());
        query.setParameter("paramPassword", user.getPasswordUser());
        List userList = query.getResultList();

        session.getTransaction().commit();

        if (userList != null && userList.size() > 0) {
            int idUserRole = ((User) userList.get(0)).getRole();
            if (idUserRole == 1)
                userRole = "admin";
            else userRole = "user";
            return true;
        }
        return false;
    }

    /**
     * Зарегистрировать нового пользователя
     * внесение новой записи в таблицу Users
     *
     * @param user
     */
    public void insetUserRecord(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
    }

    /**
     * возвращает роль пользователя
     */
    public String getUserRole() {
        return userRole;
    }

//    public boolean getUserEmail(String userRole){
//        DbConnection dbConnection = new DbConnection();
//        Connection connection = dbConnection.connect();
//
//        PreparedStatement statement;
//        ResultSet resultSet;
//
//        try{
//            statement = connection.prepareStatement(SQL_SEARCH_USER_EMAIL);
//            statement.setString(1, userRole);
//
//            resultSet = statement.executeQuery();
//
//            while (resultSet.next())
//                return false;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }
}
