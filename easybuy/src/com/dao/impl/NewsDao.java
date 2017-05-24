package com.dao.impl;

import com.dao.INewsDao;
import com.entity.News;
import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aeyjie on 2017-04-20.
 */
public class NewsDao extends BaseDao implements INewsDao {

    /**
     * 得到所有新闻对象集合
     *
     * @return
     */
    @Override
    public List<News> getAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = super.init(); //初始化(即得到连接)

        News n1 = null; //声明用户对象
        ArrayList<News> list = new ArrayList<News>();


        String sql = "select * from EASYBUY_NEWS";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){

                n1 = new News();

                n1.setNid(rs.getInt("EN_ID"));
                n1.setNtitle(rs.getString("EN_TITLE"));
                n1.setNcontent(rs.getString("EN_CONTENT"));
                n1.setNcreatetime(rs.getDate("EN_CREATE_TIME"));

                list.add(n1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(conn, ps, rs); //关闭连接
        }

        return list;
    }



}
