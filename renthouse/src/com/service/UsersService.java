package com.service;

import com.dao.UsersDao;
import com.domain.Users;


/**
 * Created by Aeyjie on 2017-05-29.
 */
public class UsersService {

    UsersDao dao = new UsersDao();

    /**
     * 登录
     * @param u
     * @return
     */
    public Users ifLogin(Users u) {
        return  dao.ifLogin(u);
    }
}
