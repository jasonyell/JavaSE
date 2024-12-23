package com.jason.service.impl;

import com.jason.bean.Order;
import com.jason.service.OrderService;
import com.jason.utils.BusinessException;
import com.jason.utils.OrderIO;

import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-30 00:08
 **/
public class OrderServiceImpl implements OrderService {

    private OrderIO orderIO = new OrderIO();

    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findId(int orderId) throws BusinessException {
        return orderIO.findByOrderId(orderId);
    }
}
