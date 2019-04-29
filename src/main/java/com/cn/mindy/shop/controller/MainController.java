package com.cn.mindy.shop.controller;


import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.service.CategoryService;
import com.cn.mindy.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    /**
     * 首页初始化操作
     * @return
     */
     @RequestMapping("/mainInit")
     public  String init(HttpServletRequest request,Model model)  {

         try {
             //获取一级目录和二级目录并且放入session中
             List<Category> categoryList = categoryService.queyAll();
             request.getSession().setAttribute("categories",categoryList);

             //获取热门商品
             List<Product> hots = productService.queryHot();
             model.addAttribute("hots",hots);

             //获取最新商品
             List<Product> news =productService.queryNew();
             model.addAttribute("news",news);

         } catch (Exception e) {
             e.printStackTrace();
         }

         return "main/main";

     }


}
