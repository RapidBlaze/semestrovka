package dao;


import entity.Order;

import java.util.List;

public interface OrderRepository {

    void createOrder(Order order);

    Order getOrder(Integer id);

    List<Order> getOrders();

    void updateOrder(Order order);

    void deleteOrder(Integer id);
}
