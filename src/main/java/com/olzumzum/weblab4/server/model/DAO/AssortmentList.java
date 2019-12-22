package com.olzumzum.weblab4.server.model.DAO;

import com.olzumzum.weblab4.server.model.HibernateUtil;
import com.olzumzum.weblab4.server.model.entities.ItemAssortment;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Загрузка ассортимента выбранной категории продукции их БД
 */
public class AssortmentList {

    /**
     * Переменная для получения имени таблицы ассортимента
     * таких таблиц несколько в зависимости от вида продукции
     */
    private String mNameTable = null;

    /**
     * инициализация списка
     */
    private List<ItemAssortment> mListAssortment = new ArrayList<>();


    public AssortmentList(String nameTable) {
        mNameTable = nameTable;
    }

    /**
     * Заполнить список ассортимента из базы данных
     */
    private void lsitFilling() {
        /** Подключаемся к базе данных */
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Query query = session.createQuery("from ItemAssortment");
        mListAssortment = query.getResultList();

        session.getTransaction().commit();
    }

    /**
     * если список еще не заполнен, вызвать функцию listFilling
     * иначе вернуть уже существующий заполненный список
     *
     * @return List<ItemAssortment>
     */
    public List getList() {
        if (mListAssortment.isEmpty())
            lsitFilling();

        return mListAssortment;

    }


}
