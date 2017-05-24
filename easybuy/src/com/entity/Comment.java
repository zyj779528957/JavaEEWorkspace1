package com.entity;

import java.util.Date;

public class Comment {
	
	Integer cid;			//留言ID
	String  ccontent;		//留言内容
	Date    ccreatetime;	//发表时间
	String  creply;			//回复内容
	Date    creplytime;		//回复时间
	String  cnickname;		//用户昵称（用户ID名）
	
	/**
	 * 无参构造
	 */
	Comment() {
		super();
	}
	
	/**
	 * 有参构造
	 * 
	 * @param cid
	 * @param ccontent
	 * @param ccreatetime
	 * @param creply
	 * @param creplytime
	 * @param cnickname
	 */
	public Comment(Integer cid, String ccontent, Date ccreatetime, String creply, Date creplytime, String cnickname) {
		super();
		this.cid = cid;
		this.ccontent = ccontent;
		this.ccreatetime = ccreatetime;
		this.creply = creply;
		this.creplytime = creplytime;
		this.cnickname = cnickname;
	}


	/**
	 * get、set方法
	 * 
	 */
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getCcreatetime() {
		return ccreatetime;
	}
	public void setCcreatetime(Date ccreatetime) {
		this.ccreatetime = ccreatetime;
	}
	public String getCreply() {
		return creply;
	}
	public void setCreply(String creply) {
		this.creply = creply;
	}
	public Date getCreplytime() {
		return creplytime;
	}
	public void setCreplytime(Date creplytime) {
		this.creplytime = creplytime;
	}
	public String getCnickname() {
		return cnickname;
	}
	public void setCnickname(String cnickname) {
		this.cnickname = cnickname;
	}

}
