package com.cn.mindy.shop.controller;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.vo.Cart;
import com.cn.mindy.shop.pojo.vo.CartItem;
import com.cn.mindy.shop.service.CartService;
import com.cn.mindy.shop.service.ProductService;
import com.cn.mindy.shop.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

        @Autowired
        public ProductService productService;

        @Autowired
        public CartService cartService;


        @RequestMapping("/cartInit")
        public String cartInit(@RequestParam(defaultValue = "0") Integer quantity, @RequestParam(defaultValue = "0") Long pid, HttpServletRequest request,Model model){

            System.out.println("........cartInit.....quantity = " + quantity +",pid = " + pid);

            CartItem cartItem = new CartItem();

            //根据pid查询Product对象
            //productService = new ProductServiceImpl();

            Product product = null;

            try {
                if(null != pid){

                    product = productService.queryProductByPid(pid);

                    //设置购物项的商品信息
                    cartItem.setProduct(product);

                    //设置购物项的购买数量
                    cartItem.setNum(Integer.valueOf(quantity));

                    //设置购物小计
                    cartItem.setSubTotal((float) (Integer.valueOf(quantity) * product.getShopPrice()));

                    //从Session中获取cart属性
                    Cart cart = (Cart) request.getSession().getAttribute("cart");
                    //判断session中是存在购物车,有则返回无则创建
                    cart = cartService.getCart(cart);

                    //添加到购物车方法
                    cart.addProductToCart(cartItem);

                    //添加到session中
                    request.getSession().setAttribute("cart", cart);

                }else{

                     model.addAttribute("message", Common.NO_PRODUCT_INFO);

                    return "common/message";

                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            return "cart/CartList";

        }


}
