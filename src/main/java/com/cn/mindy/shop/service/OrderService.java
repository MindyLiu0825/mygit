package com.cn.mindy.shop.service;

import com.cn.mindy.shop.pojo.Orders;

public interface OrderService  extends IService<Orders>{

    Orders findByOid(Integer oid) throws Exception;

    /**
     * 新增订单操纵
     * @param orders
     * @return
     */
    Integer addOrders(Orders orders) throws Exception;


    public Orders findByOrderNo(String orderno) throws Exception;
}
