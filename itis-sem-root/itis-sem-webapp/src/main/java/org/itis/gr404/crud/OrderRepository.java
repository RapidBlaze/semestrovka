package org.itis.gr404.crud;


import org.itis.gr404.entity.Order;

import java.util.List;

public interface OrderRepository {

    void createOrder(Order order);

    Order getOrder(Integer id);

    List<Order> getOrders();

    void updateOrder(Order order);

    void deleteOrder(Integer id);
}
