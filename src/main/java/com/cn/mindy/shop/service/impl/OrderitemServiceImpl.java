package com.cn.mindy.shop.service.impl;

import com.cn.mindy.shop.mapper.OrderitemMapper;
import com.cn.mindy.shop.pojo.Orderitem;
import com.cn.mindy.shop.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope()
public class OrderitemServiceImpl implements OrderitemService {

    @Autowired
    private OrderitemMapper orderitemMapper;

    @Override
    public int add(Orderitem orderitem) throws Exception {
        return 0;
    }

    @Override
    public int delete(Long id) throws Exception {
        return 0;
    }

    @Override
    public int update(Orderitem orderitem) throws Exception {
        return 0;
    }

    @Override
    public List<Orderitem> queyAll() throws Exception {
        return null;
    }


    /**
     * 自定义方法
     * 新增订单子项,返回主键
     */
    @Override
    public Integer addOrderItem(Orderitem orderitem) throws Exception{

        int count = orderitemMapper.add(orderitem);
        if(count > 0 ){

             return orderitem.getItemid();
        }
        return null;
    }
}
