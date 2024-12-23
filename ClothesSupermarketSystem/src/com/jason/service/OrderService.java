package com.jason.service;

import com.jason.bean.Order;
import com.jason.utils.BusinessException;

import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-30 00:06
 **/
public interface OrderService {
    void buyProduct(Order o) throws BusinessException;
    List<Order> list() throws BusinessException;
    Order findId(int orderId) throws BusinessException;
}
