package com.cn.mindy.shop.mapper;

import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据code查询用户
     */
    User queryByCode(String code);
    /**
     * 根据uid修改user数据
     */
    boolean updateByUid(Integer uid);
}