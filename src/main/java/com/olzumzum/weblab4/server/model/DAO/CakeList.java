package com.olzumzum.weblab4.server.model.DAO;

import com.olzumzum.weblab4.server.model.HibernateUtil;
import com.olzumzum.weblab4.server.model.entities.Cake;
import com.olzumzum.weblab4.server.model.entities.ItemProduct;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Work with the cake table
 */
public class CakeList {
    /**
     * get all table items
     *
     * @return List
     */
    public List getAllCakes() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        /** получить список всех тортов */
        Query query = session.createQuery("from Cake");
        List list = query.getResultList();

        /** список для данных каждого торта */
        List<ItemProduct> mItemProductList = new ArrayList<>();

        session.getTransaction().commit();
        /** получить данные о тортах */
        mItemProductList = getItemProductList(list, mItemProductList);

        return mItemProductList;
    }

    private List<ItemProduct> getItemProductList(List list, List<ItemProduct> mItemProductList) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        List l;

        for (int i = 0; i < list.size(); i++) {
            int id = ((Cake) list.get(i)).getItemProductId();

            Query query1 = session.createQuery("from ItemProduct I where I.mIdProduct = :paramId");
            query1.setParameter("paramId", id);
            mItemProductList.add((ItemProduct) query1.getResultList().get(0));
        }

        session.getTransaction().commit();
        return mItemProductList;
    }

    /**
     * get a list by assortment criterion
     *
     * @param criterion
     * @return List
     */
    public List getCakesAssortmentCriterion(String criterion) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Query q = session.createQuery("select AC.assortment_cake_id from AssortmentCake AC where AC.assortment_cake_name = :paramCrit");
        q.setParameter("paramCrit", criterion);
        int assortId = (int) q.getResultList().get(0);

        Query q2 = session.createQuery("from Cake C where C.itemProductId = :paramProdId");
        q2.setParameter("paramProdId", assortId);
        List list = q2.getResultList();

        List mItemProductList = new ArrayList<>();
        session.getTransaction().commit();

        mItemProductList = getItemProductList(list, mItemProductList);


           return mItemProductList;
    }

    /**
     * return list of cakes by search
     *
     * @param searchCriterion
     * @return List
     */
    public List getCakesListSearch(String searchCriterion) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        /** получить список всех тортов */
        Query query = session.createQuery("from Cake ");

        /** список для данных каждого торта */
        List list = query.getResultList();

        /** список для данных каждого торта */
        List<ItemProduct> mItemProductList = new ArrayList<>();

        Query q = session.createQuery("from ItemProduct I where I.mProductName = :searchCrit");
        q.setParameter("searchCrit", searchCriterion);
        List l = q.getResultList();

        for (int i = 0; i < l.size(); i++) {
            mItemProductList.add((ItemProduct) l.get(0));
        }
        session.getTransaction().commit();
        /** получить данные о тортах */
        // mItemProductList = getItemProductList(list, mItemProductList);

        return mItemProductList;
    }
//
//    /**
//     * get a list by search criteria and assortment
//     *
//     * @param searchCriterion
//     * @param assortmentCriterion
//     * @return
//     */
//    public List getCakesListSearchAndAssortment(String searchCriterion, String assortmentCriterion) {
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        PreparedStatement statement;
//        ResultSet result = null;
//        List itemCakeList = null;
//        try {
//
//            statement = connection.prepareStatement(SQL_REQUEST_SEARCH_AND_ASSORTMENT);
//            statement.setString(1, searchCriterion);
//            statement.setString(2, assortmentCriterion);
//            result = statement.executeQuery();
//
//            itemCakeList = getTable(result);
//
//            connection.close();
//            db.closeConnection();
//
//        } catch (SQLException e) {
//            System.out.println("Ошибка запроса");
//            e.printStackTrace();
//        }
//
//        return itemCakeList;
//    }
//
//    /**
//     * insert a new record in db
//     *
//     * @param itemProduct
//     */
//    public void insertProductIntoList(ItemProduct itemProduct, String assortmentName) {
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        PreparedStatement statement;
//        ResultSet result = null;
//        try {
//            /** fill the columns with occupied */
//            statement = connection.prepareStatement(SQL_REQUEST_INSERT, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, itemProduct.getmProductName());
//            statement.setString(2, itemProduct.getmProductDescription());
//            statement.setInt(3, itemProduct.getmWeight());
//            statement.setInt(4, itemProduct.getmPrice());
//
//            /** fullfill the request */
//            statement.execute();
//
//            /** get id of added record */
//            result = statement.getGeneratedKeys();
//            int idRecord = 0;
//            if (result.next()) {
//                idRecord = result.getInt(1);
//                System.out.println("Значение id = " + idRecord);
//            }
//
//            int idAssortment = gettingListAssortmentCriterion(assortmentName);
//            statement = connection.prepareStatement(SQL_REQUEST_INSERT_CAKE);
//            statement.setInt(1, idAssortment);
//            statement.setInt(2, idRecord);
//
//            statement.execute();
//
//            connection.close();
//            db.closeConnection();
//
//        } catch (SQLException e) {
//            System.out.println("Ошибка запроса");
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * вернуть id записи по названию ассортимента
//     */
//    public int gettingListAssortmentCriterion(String criterion) {
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        PreparedStatement statement;
//        ResultSet resultSet;
//        int idAssortment = 0;
//        try {
//            statement = connection.prepareStatement(SQL_REQUEST_GET_ID_ASSORTMENT);
//            statement.setString(1, criterion);
//            resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                idAssortment = resultSet.getInt(1);
//                System.out.println("Id ассортимента " + idAssortment);
//            }
//
//            connection.close();
//            db.closeConnection();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return idAssortment;
//    }
//
//    /** вернуть запись по id */
//    public ItemProduct getItemProductById(int idProduct){
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        PreparedStatement statement;
//        ResultSet resultSet;
//        try{
//            statement = connection.prepareStatement(SQL_REQUEST_RETURN_RECORD_BY_ID);
//            statement.setInt(1, idProduct);
//            resultSet = statement.executeQuery();
//
//            ItemProduct itemProduct = new ItemProduct();
//            if(resultSet.next()){
//                itemProduct.setmIdProduct(resultSet.getInt("item_product_id"));
//                itemProduct.setmProductName(resultSet.getString("product_name"));
//                itemProduct.setmProductDescription(resultSet.getString("product_description"));
//                itemProduct.setmWeight(resultSet.getInt("weight"));
//                itemProduct.setmPrice(resultSet.getInt("price"));
//            }
//
//            connection.close();
//            db.closeConnection();
//
//            return itemProduct;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    /**сохранить изменения в элементе по id */
//    public boolean saveChangsItem(int idProduct, ItemProduct itemProduct){
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        PreparedStatement statement;
//        ResultSet resultSet;
//        try{
//            statement = connection.prepareStatement(SQL_REQUEST_SAVE_CHANGES);
//            statement.setString(1, itemProduct.getmProductName());
//            statement.setString(2, itemProduct.getmProductDescription());
//            statement.setInt(3, itemProduct.getmWeight());
//            statement.setInt(4, itemProduct.getmPrice());
//            statement.setInt(5, idProduct);
//
//            statement.execute();
//
//            connection.close();
//            db.closeConnection();
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Не удалось изменить запись");
//            return false;
//        }
//    }
//
//    /**удаление записи */
//    public boolean deleteRecord(int idProduct){
//        DbConnection db = new DbConnection();
//        Connection connection = db.connect();
//
//        PreparedStatement statement;
//        ResultSet resultSet;
//        try{
//            statement = connection.prepareStatement(SQL_REQUEST_DELETE_CAKE);
//            statement.setInt(1, idProduct);
//            statement.execute();
//
//            statement = connection.prepareStatement(SQL_REQUEST_DELETE_ITEM_PRODUCT);
//            statement.setInt(1, idProduct);
//            statement.execute();
//
//            connection.close();
//            db.closeConnection();
//
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Удаление не завершено успешно");
//            return false;
//        }
//    }

}
