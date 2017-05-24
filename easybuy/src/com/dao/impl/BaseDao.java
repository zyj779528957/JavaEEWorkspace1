package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {

    protected Connection conn = null;


    /**
     * 新增、修改、删除
     * @param sql SQL语句
     * @param params 参数
     * @return 返回影响条数
     */
    protected int updade(String sql, Object... params) {
        return JdbcUtil.update(sql, params);
    }

    /**
     * 初始化Jdbc(即得到连接)
     */
    protected Connection init() {
        return JdbcUtil.getConn();
    }

    /**
     * 关闭 conn、ps
     * @param conn
     * @param ps
     */
    protected void close(Connection conn, PreparedStatement ps) {
        JdbcUtil.close(conn, ps);
    }

    /**
     *  关闭 conn、ps、rs
     * @param conn
     * @param ps
     * @param rs
     */
    protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        JdbcUtil.close(conn, ps, rs);
    }



}
