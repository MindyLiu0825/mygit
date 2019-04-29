package com.cn.mindy.shop.service;

import com.cn.mindy.shop.pojo.User;

public interface UserService extends IService<User> {

    /**
     * 判断用户名是否已存在
     * @param usernmae
     */
    public boolean queryByUsername(String usernmae) throws Exception;

    /**
     * 判断登录信息
     * @param usernmae
     */
    public boolean queryLogin(String usernmae,String password) throws Exception;

    /**
     * 根据code查询用户
     * @param code
     * @return
     */
    public  User queryByCode(String code) throws Exception;


    /**
     * 根据uid修改user数据
     * @param uid
     * @return
     */
    public  boolean updateByUid(Integer uid) throws Exception;


        /**
         * 根据用户名查询用户信息
         * @param username
         * @return
         */
        public  User queryUserByUsername(String username) throws Exception;
}
