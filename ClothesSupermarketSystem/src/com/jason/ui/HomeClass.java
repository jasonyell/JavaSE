package com.jason.ui;

import com.jason.bean.Clothes;
import com.jason.bean.Order;
import com.jason.bean.OrderItem;
import com.jason.service.ClothesService;
import com.jason.service.OrderService;
import com.jason.service.impl.ClothesServiceImpl;
import com.jason.service.impl.OrderServiceImpl;
import com.jason.utils.BusinessException;
import com.jason.utils.ConsoleTable;
import com.jason.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-22 01:08
 **/
public class HomeClass extends BaseClass {

    private OrderService orderService;
    private ClothesService clothesService;


    public HomeClass(){
        orderService = (OrderService) beanFactory.getBean("orderService");
        clothesService = (ClothesService) beanFactory.getBean("clothesService");
    }


    public void show(){
        showProducts();
        print("welcome:_"+currUser.getUsername());
        menu();
    }

    private void menu() {
        boolean flag = true;

        while(flag){
            print(getString("home.function"));
            print(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":       // 查询全部订单
                    findOrderList();
                    flag=false;
                    break;
                case "2":       // 查找订单
                    findOrderById();
                    flag=false;
                    break;
                case "3":       // 购买
                    try {
                        buyProducts();
                        flag=false;

                    } catch (BusinessException e) {
                        print(e.getMessage());
                    }
                    break;
                case "4":       // 显示商品
                    show();
                    break;
                case "0":       // 退出
                    print(getString("info.exit"));
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    print(getString("input.error"));
                    break;

            }
        }
    }

    // 查询订单列表
    private void findOrderList() {
        List<Order> list = orderService.list();
        for(Order o : list){
            showOrder(o);
        }
        menu();
    }

    private void showOrder(Order o) {
        println(getString("product.order.oid") + o.getOrderId());
        println("\t"+getString("product.order.createDate")+o.getCreateDate());
        print("\t"+getString("product.order.sum")+o.getSum());
        ConsoleTable t = new ConsoleTable(9,true);
        t.appendRow();
        t.appendColum("itemId")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("price")
                .appendColum("description")
                .appendColum("shoppingNum")
                .appendColum("sum");

        for(OrderItem item : o.getOrderItems()){
            t.appendRow();
            t.appendColum(item.getItemId())
                    .appendColum(item.getClothes().getBrand())
                    .appendColum(item.getClothes().getStyle())
                    .appendColum(item.getClothes().getColor())
                    .appendColum(item.getClothes().getSize())
                    .appendColum(item.getClothes().getPrice())
                    .appendColum(item.getClothes().getDescription())
                    .appendColum(item.getShoppingNum())
                    .appendColum(item.getSum());
        }
        print(t.toString());
    }

    private void findOrderById() {
        print(getString("product.order.input.oid"));
        String oid = input.nextLine();
        Order order = orderService.findId(Integer.parseInt(oid));
        if(order!=null){
            showOrder(order);
        }else{
            print(getString("product.order.error"));
        }
        menu();
    }


    /**
     * 购买商品
     */
    private void showProducts() {
        List<Clothes> list = clothesService.list();

        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");

        for (Clothes c : list){
            t.appendRow();
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrice())
                    .appendColum(c.getDescription());
        }
        print(t.toString());
    }

    private void buyProducts() throws BusinessException {
        // 生产订单
        boolean flag = true;
        int count = 1;
        float sumPrice = 0.0f; // 订单总金额
        Order order = new Order(); // 生成的订单

        while (flag) {
            print(getString("product.input.id"));
            String id = input.nextLine();
            print(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(id);


            // 用户输入数量是否超过库存
            int num = Integer.parseInt(shoppingNum);
            if(num > clothes.getNum()){
                throw new BusinessException("product.num.error");
            }

            // 一条订单明细
            clothes.setNum(clothes.getNum()-num); // 减去库存
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);
            // 订单总价
            sumPrice += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItems().add(orderItem);

            print(getString("product.buy.continue"));
            String isBuy = input.nextLine();
            switch (isBuy){
                case "1" :
                    flag=true;
                    break;

                case "2" :
                    flag=false;
                    break;

                default:
                    flag=false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sumPrice);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProduct(order);
        clothesService.update();
        show();

    }
}
