package com.cn.mindy.shop.service.impl;

import com.cn.mindy.shop.mapper.OrderitemMapper;
import com.cn.mindy.shop.mapper.OrdersMapper;
import com.cn.mindy.shop.pojo.Orderitem;
import com.cn.mindy.shop.pojo.Orders;
import com.cn.mindy.shop.pojo.OrdersExample;
import com.cn.mindy.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Service
@Scope("prototype")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderitemMapper orderitemMapper;


    @Override
    public int add(Orders orders) throws Exception {


        return ordersMapper.insert(orders);
    }

    @Override
    public int delete(Long id) throws Exception {
        return 0;
    }

    @Override
    public int update(Orders orders) throws Exception {

        return ordersMapper.updateByPrimaryKey(orders);
    }

    @Override
    public List queyAll() throws Exception {
        return null;
    }

    /**
     * 根据oid获取订单信息
     * @param oid
     * @return
     */
    @Override
    public Orders findByOid(Integer oid) {

        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andOidEqualTo(oid);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);

        return (null!= orders && orders.size()>0)?orders.get(0) : null;
    }



    /**
     * 新增订单操纵
     * @param orders
     * @return
     */
    @Override
    public Integer addOrders(Orders orders)throws Exception{

        //新增主表 orders 产生oid
        Integer count =  ordersMapper.addOrders(orders);
        Integer oid = 0;
        if(count > 0){

            oid = orders.getOid();
            if(oid > 0){

                //新增子表  orderitem
                Set<Orderitem> orderitemSet = orders.getOrderItems();

                if(null != orderitemSet){
                     Iterator<Orderitem> orderitemIterator =  orderitemSet.iterator();

                     while(orderitemIterator.hasNext()){
                            Orderitem orderitem = orderitemIterator.next();
                            orderitem.setOid(oid);

                            int orderiem_id =  orderitemMapper.addOrderItem(orderitem);
                            if(orderiem_id > 0 ){

                            }else{
                                count = -1;
                                break;
                            }
                     }

                }

            }else{
                count = -1;
            }
        }

            return count;
    }


    /**
     * 根据OrderNo查询指定订单
     * @param orderNo
     * @return
     */
    @Override
    public Orders findByOrderNo(String orderNo) {
        return ordersMapper.findByOrderNo(orderNo);
    }

}
