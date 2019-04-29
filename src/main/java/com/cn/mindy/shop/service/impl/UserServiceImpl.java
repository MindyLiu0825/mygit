package com.cn.mindy.shop.service.impl;

import com.cn.mindy.shop.mapper.UserMapper;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.pojo.UserExample;
import com.cn.mindy.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    /**
     * 判断用户名是否已存在
     * @param usernmae
     */
    @Override
    public boolean queryByUsername(String usernmae){

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(usernmae);
        List<User>  users  =  userMapper.selectByExample(userExample);
        boolean result = true;
        if(null != users && users.size() > 0) {
            //用户名已存在
            result = false;
        }
        return  result;

    }


    /**
     * 判断登录信息
     * @param usernmae
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public boolean queryLogin(String usernmae, String password) throws Exception {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(usernmae);
        criteria.andPasswordEqualTo(password);
        List<User>  users  =  userMapper.selectByExample(userExample);
        boolean result = true;

        if(null == users || users.size() <= 0) {
            //该账号不存在
            result = false;
        }
        return result;
    }

    /**
     * 根据code查询用户
     */
    @Override
    public User queryByCode(String code) throws Exception{

        return userMapper.queryByCode(code);
    }

    /**
     * 根据uid修改user数据
     */
    @Override
    public boolean updateByUid(Integer uid) throws Exception {
        return userMapper.updateByUid(uid);
    }



    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User queryUserByUsername(String username) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);

        return  (null!= users && users.size()>0)?users.get(0):null;
    }


    /**
     * 新增操作
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int add(User user) throws Exception {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Long id) throws Exception {
        return 0;
    }

    @Override
    public int update(User user) throws Exception {
        return 0;
    }

    @Override
    public List<User> queyAll() throws Exception {
        return null;
    }
}
