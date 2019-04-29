package com.cn.mindy.shop.service;

import com.cn.mindy.shop.pojo.Orderitem;
import com.cn.mindy.shop.service.IService;

public interface OrderitemService extends IService<Orderitem> {

    /**
     * 自定义方法
     * 新增订单子项,返回主键
     */
    Integer addOrderItem(Orderitem orderitem) throws Exception;
}
