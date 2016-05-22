package dao;

import entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional
    public Order getOrder(Integer id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Order> getOrders() {
        List<Order> orders = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class).list();
        return orders;
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Integer id) {
        Order order = getOrder(id);
        sessionFactory.getCurrentSession().delete(order);
    }
}
