package com.cn.mindy.shop.mapper;

import com.cn.mindy.shop.pojo.Orderitem;
import com.cn.mindy.shop.pojo.OrderitemExample;
import com.cn.mindy.shop.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderitemMapper extends IService<Orderitem> {

    int countByExample(OrderitemExample example);

    int deleteByExample(OrderitemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    List<Orderitem> selectByExample(OrderitemExample example);

    Orderitem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);

    /**
     * 自定义方法
     * 新增订单子项,返回主键
     */
    Integer addOrderItem(Orderitem orderitem);


}