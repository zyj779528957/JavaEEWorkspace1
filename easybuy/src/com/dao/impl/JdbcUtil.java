package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 数据层公用抽象父类（数据层实现类中所提取出的公用父类）
 * @author zyj
 */
public abstract class JdbcUtil {
	
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String USER = "easybuy";
	private static String PWD = "123456";
	
	static {
		try {
			//加载驱动(即注册驱动)
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @return 返回连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭 conn、ps、rs
	 * @param conn 连接对象
	 * @param ps 预编译可执行对象
	 * @param rs 结果集
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 conn、ps
	 * @param conn 连接对象
	 * @param ps 预编译可执行对象
	 */
	public static void close(Connection conn, PreparedStatement ps){
		close(conn, ps, null);
	}
	
	/**
	 * 新增、修改、删除
	 * @param sql SQL语句
	 * @param params 参数
	 * @return 返回影响条数
	 */
	public static int update(String sql, Object...params)  {
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			//获取连接对象
			conn = getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject((i+1), params[i]);
			}
			//执行
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps);
		}
		return count;
	}



	
}
