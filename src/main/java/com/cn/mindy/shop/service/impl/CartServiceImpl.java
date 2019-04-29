package com.cn.mindy.shop.service.impl;

import com.cn.mindy.shop.pojo.vo.Cart;
import com.cn.mindy.shop.service.CartService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CartServiceImpl implements CartService {


            /**
             * 获取购物车数据
             * @param cart
             * @return
             */
            @Override
            public Cart getCart(Cart cart) {

                if(null == cart){

                    cart = new Cart();
                }

                return cart;
            }

            @Override
            public int add(Cart cart) throws Exception {
                return 0;
            }

            @Override
            public int delete(Long id) throws Exception {
                return 0;
            }

            @Override
            public int update(Cart cart) throws Exception {
                return 0;
            }

            @Override
            public List<Cart> queyAll() throws Exception {
                return null;
            }





}
