package com.entity;

import java.util.Date;

public class Order {
	
	Integer oid;			//订单ID
	String  ouid;			//用户ID名
	String  ouname;			//用户真实姓名
	String  ouaddress;		//用户收货地址
	Date    ocreatetime; 	//下单时间
	double  ocost;			//总金额
	Integer ostatus;		//状态：1-待审核，2-通过审核
	Integer otype;			//支付类型：1-现金支付，2-其他
	
	/**
	 * 无参构造
	 */
	public Order() {
		super();
	}
	/**
	 * 有参构造
	 * 
	 * @param oid
	 * @param ouid
	 * @param ouname
	 * @param ouaddress
	 * @param ocreatetime
	 * @param ocost
	 * @param ostatus
	 * @param otype
	 */
	public Order(Integer oid, String ouid, String ouname, String ouaddress, Date ocreatetime, double ocost,
			Integer ostatus, Integer otype) {
		super();
		this.oid = oid;
		this.ouid = ouid;
		this.ouname = ouname;
		this.ouaddress = ouaddress;
		this.ocreatetime = ocreatetime;
		this.ocost = ocost;
		this.ostatus = ostatus;
		this.otype = otype;
	}
	
	/**
	 * get、set方法
	 * 
	 */
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getOuid() {
		return ouid;
	}
	public void setOuid(String ouid) {
		this.ouid = ouid;
	}
	public String getOuname() {
		return ouname;
	}
	public void setOuname(String ouname) {
		this.ouname = ouname;
	}
	public String getOuaddress() {
		return ouaddress;
	}
	public void setOuaddress(String ouaddress) {
		this.ouaddress = ouaddress;
	}
	public Date getOcreatetime() {
		return ocreatetime;
	}
	public void setOcreatetime(Date ocreatetime) {
		this.ocreatetime = ocreatetime;
	}
	public double getOcost() {
		return ocost;
	}
	public void setOcost(double ocost) {
		this.ocost = ocost;
	}
	public Integer getOstatus() {
		return ostatus;
	}
	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}
	public Integer getOtype() {
		return otype;
	}
	public void setOtype(Integer otype) {
		this.otype = otype;
	}
	
}
