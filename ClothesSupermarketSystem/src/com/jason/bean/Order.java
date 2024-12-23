package com.jason.bean;

import com.jason.utils.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-19 02:42
 **/
public class Order implements Serializable {

    private List<OrderItem> orderItems = new ArrayList<>();
    private String createDate;
    private float sum; // 总金额
    private OrderStatusType status = OrderStatusType.UNPAID;// 状态
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private int userId;

    public Order() {
    }

    public Order(List<OrderItem> orderItems, String createDate, float sum, OrderStatusType status, int orderId, int userId) {
        this.orderItems = orderItems;
        this.createDate = createDate;
        this.sum = sum;
        this.status = status;
        this.orderId = orderId;
        this.userId = userId;
    }

    public Order(List<OrderItem> orderItems, String createDate, float sum, OrderStatusType status, int userId) {
        this.orderItems = orderItems;
        this.createDate = createDate;
        this.sum = sum;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                ", createDate='" + createDate + '\'' +
                ", sum=" + sum +
                ", status=" + status +
                ", orderId=" + orderId +
                ", userId=" + userId +
                '}';
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
