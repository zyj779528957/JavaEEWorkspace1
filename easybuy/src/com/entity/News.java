package com.entity;

import java.util.Date;

public class News {
	
	Integer nid;			//新闻ID
	String  ntitle;			//新闻标题
	String  ncontent;		//新闻内容
	Date    ncreatetime;	//新闻创建时间（即录入时间：yyyy-mm-dd hh:mm:ss）

	/**
	 * 无参构造
	 */
	public News() {
		super();
	}
	
	/**
	 * 有参构造
	 * 
	 * @param nid
	 * @param ntitle
	 * @param ncontent
	 * @param ncreatetime
	 */
	public News(Integer nid, String ntitle, String ncontent, Date ncreatetime) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ncreatetime = ncreatetime;
	}

	/**
	 * get、set方法
	 *  
	 */
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNcreatetime() {
		return ncreatetime;
	}
	public void setNcreatetime(Date ncreatetime) {
		this.ncreatetime = ncreatetime;
	}
	
}
