package com.cn.mindy.shop.mapper;

import com.cn.mindy.shop.pojo.Categorysecond;
import com.cn.mindy.shop.pojo.CategorysecondExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategorysecondMapper {
    int countByExample(CategorysecondExample example);

    int deleteByExample(CategorysecondExample example);

    int deleteByPrimaryKey(Integer csid);

    int insert(Categorysecond record);

    int insertSelective(Categorysecond record);

    List<Categorysecond> selectByExample(CategorysecondExample example);

    Categorysecond selectByPrimaryKey(Integer csid);

    int updateByExampleSelective(@Param("record") Categorysecond record, @Param("example") CategorysecondExample example);

    int updateByExample(@Param("record") Categorysecond record, @Param("example") CategorysecondExample example);

    int updateByPrimaryKeySelective(Categorysecond record);

    int updateByPrimaryKey(Categorysecond record);
}