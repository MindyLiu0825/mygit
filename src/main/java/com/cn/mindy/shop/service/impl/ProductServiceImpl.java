package com.cn.mindy.shop.service.impl;

import com.cn.mindy.shop.mapper.ProductMapper;
import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.ProductExample;
import com.cn.mindy.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public int add(Product product) throws Exception {
        return 0;
    }

    @Override
    public int delete(Long id) throws Exception {
        return 0;
    }

    @Override
    public int update(Product product) throws Exception {
       return 0;
    }

    /**
     * 查询所有商品信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> queyAll() throws Exception {

        ProductExample productExample = new ProductExample();

        return productMapper.selectByExample(productExample);
    }

    /**
     * 查询热门商品
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> queryHot() throws Exception {

        return productMapper.queryhot();
    }


    /**
     * 获取最新商品
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> queryNew() throws Exception {
        return productMapper.queryNew();
    }


    /**
     * 根据id查询指定商品信息
     * @return
     * @throws Exception
     */
    @Override
    public Product queryProductByPid(Long pid) throws Exception {

        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
         //添加查询条件
        criteria.andPidEqualTo(pid);
        List<Product> products =  productMapper.selectByExample(productExample);

        return (null != products && products.size()>0)?products.get(0):null;
    }


    /**
     * 根据cid查询商品集合
     * @return
     */
    @Override
    public List<Product> queyProductByCid(Long cid) throws Exception {

        return productMapper.queryProductByCid(cid);
    }


}
