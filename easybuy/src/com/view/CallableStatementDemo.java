package com.view;

import java.sql.*;

public class CallableStatementDemo {

	/**
	 * @param args
	 */
	public void callable(){

		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test"+"?useUnicode=true&characterEncoding=GBK";
		String user="scott";
		String password="tiger";
		Connection con = null;
		CallableStatement st = null;

		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			//得到CallableStatement 对象 （注意是 con.prepareCall 方法）
			st = con.prepareCall("{call empcount(?,?,?,?)}");
			//设定参数（注意要和存储过程定义的顺序一致）
			st.setInt(1, 7369);
			st.setString(2, "SMITH");
			//注册出参（出参必须注册）
			st.registerOutParameter(3, Types.INTEGER);
			st.registerOutParameter(4, Types.VARCHAR);

			//执行存储过程
			st.execute();
			//得到返回的参数 （和 ？ 定义的顺序一样，从1开始的）
			System.out.println(st.getInt(3) + " " + st.getString(4));

			st.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				if(st != null){
					st.close();
				}

				if(con != null){
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		CallableStatementDemo cs = new CallableStatementDemo();
		cs.callable();
	}

}
