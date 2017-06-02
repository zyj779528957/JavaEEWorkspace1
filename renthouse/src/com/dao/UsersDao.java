package com.dao;

import com.domain.Users;
import com.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by Aeyjie on 2017-05-29.
 */
public class UsersDao {


    /**
     * 登录
     * @param u
     * @return
     */
    public Users ifLogin(Users u) {

        //得到sesseion
        Session session = HibernateUtils.getSession();
        //final Session session = Main.getSession();
        //开启事务
        Transaction tr = session.beginTransaction();

        //查询用户
      /*  Query query = session.createQuery("from Users where name="+u.getName()+"and password="+u.getPassword());
        List<Users> list = query.list();*/

        Users users = session.get(Users.class, 60L);
        System.out.println(users);


        //提交事务
        tr.commit();
        //关闭资源
//        session.close();

        return users;
    }
}
