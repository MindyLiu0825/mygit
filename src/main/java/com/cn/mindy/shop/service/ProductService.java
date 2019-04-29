package com.cn.mindy.shop.service;

import com.cn.mindy.shop.pojo.Product;

import java.util.List;

public interface ProductService extends IService<Product> {

    /**
     * 查询热门商品
     * @return
     * @throws Exception
     */
    public List<Product> queryHot() throws Exception;


    /**
     * 查询最新商品
     * @return
     * @throws Exception
     */
    public List<Product> queryNew() throws Exception;

    /**
     * 根据id查询指定商品信息
     * @return
     * @throws Exception
     */
    public Product queryProductByPid(Long pid)throws  Exception;


    /**
     * 根据cid查询商品集合
     * @return
     */
    public List<Product> queyProductByCid(Long cid)throws Exception;


}
