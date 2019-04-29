package com.cn.mindy.shop.service;

import java.util.List;

public interface IService<T> {

    /**
     * 新增操作
     * @param t
     * @return
     */
     public int add(T t)throws Exception;

    /**
     * 删除操作
     * @param id
     * @return
     */
    public int delete(Long id)throws Exception;

    /**
     * 修改操作
     * @param t
     * @return
     */
    public int update(T t)throws Exception;

    /**
     * 查询所有操作
     * @return
     */
    public List<T> queyAll()throws Exception;



}
