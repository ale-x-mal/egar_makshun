package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.Order;

import java.util.List;

public interface OrderDao {

    Order getOne(Long orderId);

    List<Order> findAllOrders();

    List<Order> findAllUserOrders(Long userId);

}
