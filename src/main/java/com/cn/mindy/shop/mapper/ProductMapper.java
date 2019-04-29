package com.cn.mindy.shop.mapper;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Long pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Long pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询热门商品
     * @return
     */
    List<Product> queryhot();
    /**
     * 查询热最新商品
     * @return
     */
    List<Product> queryNew();

    /**
     * 根据cid查询商品集合
     * @param cid
     * @return
     */
    List<Product> queryProductByCid(Long cid);


}