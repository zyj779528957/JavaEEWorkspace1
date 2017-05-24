package com.entity;

import java.util.Date;

import java.util.List;

public class User {
	
	private String  uid;			//用户Id名
	private String  uname;			//用户真实姓名（T为男，F为女）
	private String  upwd;			//密码
	private String  usex;			//性别
	private Date    ubirthday;  	//生日
	private String  uidentitycode;	//身份证号
	private String  uemail;			//邮箱
	private String  umobile;		//手机
	private String  uaddress;		//地址
	private Integer ustatus;		//状态：1-普通用户(前台)，2-管理员（后台）


	/**
	 * 无参构造
	 */
	public User() {
		super();
	}

	/**
	 * 有参构造 仅作jason测试用（即仅供TestJason类使用）
	 * @param uid
	 * @param uname
	 * @param upwd
	 * @param usex
	 */
	public User(String uid, String uname, String upwd, String usex) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
	}

	/**
	 * 有参构造
	 * @param uid
	 * @param uname
	 * @param upwd
	 * @param usex
	 * @param ubirthday
	 * @param uidentitycode
	 * @param uemail
	 * @param umobile
	 * @param uaddress
	 * @param ustatus
	 */




	public User(String uid, String uname, String upwd, String usex, Date ubirthday, String uidentitycode, String uemail, String umobile, String uaddress, Integer ustatus) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
		this.ubirthday = ubirthday;
		this.uidentitycode = uidentitycode;
		this.uemail = uemail;
		this.umobile = umobile;
		this.uaddress = uaddress;
		this.ustatus = ustatus;
	}


	/**
	 * get、set方法
	 */
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public Date getUbirthday() {
		return ubirthday;
	}

	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}

	public String getUidentitycode() {
		return uidentitycode;
	}

	public void setUidentitycode(String uidentitycode) {
		this.uidentitycode = uidentitycode;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public Integer getUstatus() {
		return ustatus;
	}

	public void setUstatus(Integer ustatus) {
		this.ustatus = ustatus;
	}

	
	
}
