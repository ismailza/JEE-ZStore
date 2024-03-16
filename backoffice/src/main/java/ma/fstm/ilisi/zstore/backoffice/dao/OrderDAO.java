package ma.fstm.ilisi.zstore.backoffice.dao;

import ma.fstm.ilisi.zstore.backoffice.bo.Client;
import ma.fstm.ilisi.zstore.backoffice.bo.Order;
import ma.fstm.ilisi.zstore.backoffice.bo.OrderItem;
import ma.fstm.ilisi.zstore.backoffice.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class OrderDAO implements DAOInterface<Order> {
    @Override
    public Collection<Order> retrieve() {
        // TODO implement here
        return null;
    }

    @Override
    public boolean create(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            for (OrderItem orderItem : order.getOrderItems()) {
                orderItem.setOrder(order);
                session.saveOrUpdate(orderItem);
            }
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        // TODO implement here
        return false;
    }

    @Override
    public boolean delete(Order order) {
        // TODO implement here
        return false;
    }

    public Order findById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            Order order = session.find(Order.class, id);
            transaction.commit();
            session.close();
            return order;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public Collection<Order> findByClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Order> orders = session.createQuery("FROM Order WHERE client = :client", Order.class)
                    .setParameter("client", client)
                    .getResultList();
            transaction.commit();
            session.close();
            return orders;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
