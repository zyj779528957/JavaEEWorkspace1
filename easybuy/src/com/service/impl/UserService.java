package com.service.impl;

import com.dao.IUserDao;
import com.dao.impl.UserDao;
import com.entity.User;
import com.service.IUserService;

/**
 * Created by Aeyjie on 2017-04-14.
 */
public class UserService implements IUserService {

    private IUserDao dao = new UserDao(); //多态

    /**
     * 登录方法
     * @param uid
     * @param upwd
     * @return
     */
    @Override
    public User ifLogin(String uid, String upwd) {
        return dao.ifLogin(uid, upwd);
    }

    /**
     * 注册方法
     *
     * @param u1@return
     */
    @Override
    public Integer register(User u1) {

        int count = 0;

        //如果数据库中不存在uid,才允许注册
        if(dao.ifLogin(u1.getUid(), null) == null){
            count = dao.register(u1);
        }

        return count;
    }


}
