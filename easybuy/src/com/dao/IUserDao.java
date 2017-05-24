package com.dao;

import com.entity.User;

/**
 * 数据层用户接口
 * @author Aeyjie
 *
 */
public interface IUserDao {

	/**
	 * 登录方法
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public User ifLogin(String uname, String upwd);


	/**
	 * 注册方法
	 * @param user
	 * @return
	 */
	public  Integer register(User u1);

	
}
