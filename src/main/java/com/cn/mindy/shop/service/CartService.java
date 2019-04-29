package com.cn.mindy.shop.service;

import com.cn.mindy.shop.pojo.vo.Cart;

public interface CartService extends IService<Cart>{

    public Cart getCart(Cart cart);

}
