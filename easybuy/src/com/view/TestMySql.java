package com.view;

import java.sql.*;

public class TestMySql {

	/**
	 * @param args
	 */
	public void selectInfoPrint(){
		//要使用的驱动名
		String driver="com.mysql.jdbc.Driver";
		//数据库连接串
		String url="jdbc:mysql://localhost:3306/test"+"?useUnicode=true&characterEncoding=GBK";
		//用户名
		String user="scott";
		//密码
		String password="tiger";

		try {
			//注册Jdbc 驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return;
		}

		Connection con = null;
		try {
			//使用驱动管理器新建连接
			con=DriverManager.getConnection(url,user,password);
			//新建 sql 语句的执行对象。
			Statement stm=con.createStatement();
			//执行查询，返回结果集
			ResultSet rs=stm.executeQuery("select * from students");
			//处理返回结果集
			while(rs.next()){
				System.out.print("工号:" + rs.getInt(1)+";  ");
				System.out.print("姓名:" + rs.getString("sname").trim()+";  \n");
			}
			//释放资源
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMySql sd=new TestMySql();
		sd.selectInfoPrint();
	}

}
