package com.olzumzum.weblab4.server.model.DAO;


import com.olzumzum.weblab4.server.model.HibernateUtil;
import com.olzumzum.weblab4.server.model.entities.User;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Класс осуществляет работу с таблицей пользователей
 * все возможные манипуляции с этой таблице описаны здесь
 */
public class UserTable  {

    /** по умолчанию, все создаваемые пользователи - не администраторы,
     * задаем id роли "user"
     */
    private final int ROLE_ID = 2;
    private final String SQL_SEARCH_USER_EMAIL ="SELECT * from Users where email_user = ?";

    private String userRole;

    /**
     * Поиск пользователя по таблице
     * @param user
     * @return
     */

    public boolean searchUserInTable(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(userRoot);
        session.createQuery(userCriteriaQuery).getResultList();
        return true;
    }

    /**
     * Зарегистрировать нового пользователя
     * внесение новой записи в таблицу Users
     * @param user
     */
//    public void insetUserRecord(User user) {
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        String email = user.getEmailUser();
//        String password = user.getPasswordUser();
//
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into Users(email_user, password_user, role_id) " +
//                    "value ('"+ email + "', '" + password + "', '" + ROLE_ID + "');");
//
//            connection.close();
//            db.closeConnection();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** возвращает роль пользователя */
//    public String getUserRole(){
//        return userRole;
//    }
//
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
