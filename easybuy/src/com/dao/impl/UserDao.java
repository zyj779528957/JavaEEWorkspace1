package com.dao.impl;

import com.dao.IUserDao;
import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Aeyjie on 2017-04-14.
 */
public class UserDao extends BaseDao implements IUserDao {

    /**
     * 登录
     * @param uid
     * @param upwd
     * @return
     */
    @Override
    public User ifLogin(String uid, String upwd) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = super.init(); //初始化(即得到连接)
        User u1 = null; //声明用户对象

        String sql = null;

        //uid与upwd都不为空时进行登录
        //uid不为空，upwd为空时，则进行注册前的判断（即判断此uid是否已存在）
        if (uid != null && upwd != null) {
            sql = "select * from EASYBUY_USER where EU_USER_ID=? and EU_PASSWORD=?";
        } else if (uid != null && upwd == null) {
            sql = "select * from EASYBUY_USER where EU_USER_ID=?";
        }


        try {

            ps = conn.prepareStatement(sql);

            //uid与upwd都不为空时进行登录
            //uid不为空，upwd为空时，则进行注册前的判断（即判断此uid是否已存在）
            if (uid != null && upwd != null) {
                ps.setString(1, uid);
                ps.setString(2, upwd);

            } else if (uid != null && upwd == null) {
                ps.setString(1, uid);
            }

            rs = ps.executeQuery();

            while(rs.next()){

                u1 = new User();

                u1.setUid(rs.getString("EU_USER_ID"));
                u1.setUname(rs.getString("EU_USER_NAME"));
                u1.setUpwd(rs.getString("EU_PASSWORD"));
                u1.setUstatus(rs.getInt("EU_STATUS"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(conn, ps, rs); //关闭连接
        }

        return u1;
    }

    /**
     * 注册方法
     *
     * @param u1
     * @return
     */
    @Override
    public Integer register(User u1) {
        String sql= "insert into EASYBUY_USER(EU_USER_ID, EU_USER_NAME, EU_BIRTHDAY, EU_SEX, EU_STATUS, EU_PASSWORD) values(?,?,?,?,?,?)";
        int count = super.updade(sql, u1.getUid(), u1.getUname(), u1.getUbirthday(),u1.getUsex(), u1.getUstatus(), u1.getUpwd());
        return count;
    }


}
