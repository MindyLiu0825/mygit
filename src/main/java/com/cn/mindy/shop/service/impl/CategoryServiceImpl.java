package com.cn.mindy.shop.service.impl;

import com.cn.mindy.shop.mapper.CategoryMapper;
import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public int add(Category category)throws Exception {
        return 0;
    }

    @Override
    public int delete(Long id)throws Exception {
        return 0;
    }

    @Override
    public int update(Category category)throws Exception {
        return 0;
    }

    @Override
    public List<Category> queyAll()throws Exception {

        return categoryMapper.queyAll();
    }
}
