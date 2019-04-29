package com.cn.mindy.shop.controller;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.service.ProductService;
import com.cn.mindy.shop.utils.Common;
import com.cn.mindy.shop.utils.ResultPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 商品模块操作
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *根据pid查询指定商品详情
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Long pid,Model model){
        try {

            Product product = productService.queryProductByPid(pid);
            model.addAttribute("product",product);

        } catch (Exception e) {
            e.printStackTrace();
        }
            return "product/product";
    }



    /**
     * 根据二级目录id商品分页显示
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping("/categorylist")
    public String categorylist(Long cid, @RequestParam(defaultValue ="1") Integer starPage, Model model,HttpSession session){

        /**
         * 使用mybatis分页插件
         * 参数1  请求的第几页
         * 参数2 每页的记录数
         */
        PageHelper.startPage(starPage,Common.PAGENUM);
        try {
              //根据cid查询所有的商品信息
            List<Product> products = productService.queyProductByCid(cid);
            PageInfo pageInfo = new PageInfo(products);
            model.addAttribute("pageInfo",pageInfo);
            session.setAttribute("cid",cid);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "product/productList";
    }





}
