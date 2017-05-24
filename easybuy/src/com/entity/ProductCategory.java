package com.entity;

import java.util.ArrayList;

public class ProductCategory {
	
	Integer pcid;			//类别ID
	String  pcname;			//类别名称
	Integer pcparentid;		//父类别ID

	private ArrayList<ProductCategory> clist = new ArrayList<ProductCategory>();
	
	
	/**
	 * 无参构造
	 */
	public ProductCategory() {
		super();
	}
	
	/**
	 * 有参构造
	 * 
	 * @param pcid
	 * @param pcname
	 * @param pcparentid
	 */
	public ProductCategory(Integer pcid, String pcname, Integer pcparentid) {
		super();
		this.pcid = pcid;
		this.pcname = pcname;
		this.pcparentid = pcparentid;
	}

	/**
	 * get、set方法
	 * 
	 */
	public Integer getPcid() {
		return pcid;
	}
	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public Integer getPcparentid() {
		return pcparentid;
	}
	public void setPcparentid(Integer pcparentid) {
		this.pcparentid = pcparentid;
	}
	
}
