package com.service;

import com.entity.User;

/**
 * Created by Aeyjie on 2017-04-14.
 */
public interface IUserService {

    /**
     * 登录方法
     * @param uid
     * @param upwd
     * @return
     */
    public User ifLogin(String uid, String upwd);

    /**
     * 注册方法
     * @param u1
     * @return
     */
    public  Integer register(User u1);

}
