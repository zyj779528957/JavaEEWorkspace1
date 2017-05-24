package com.entity;

public class OrderDetail {
	
	Integer odid;			//订单详情ID
	Integer oid;			//订单ID
	Integer opid;			//订单商品ID
	Integer odquantity;		//订单详情数量
	Double  odcost;			//订单详情：小计金额（单价*数量）

	
	/**
	 * 无参构造
	 */
	public OrderDetail() {
		super();
	}
	
	/**
	 * 有参构造
	 * 
	 * @param odid
	 * @param oid
	 * @param opid
	 * @param odquantity
	 * @param odcost
	 */
	public OrderDetail(Integer odid, Integer oid, Integer opid, Integer odquantity, Double odcost) {
		super();
		this.odid = odid;
		this.oid = oid;
		this.opid = opid;
		this.odquantity = odquantity;
		this.odcost = odcost;
	}

	/**
	 * get、set方法
	 * 
	 */
	public Integer getOdid() {
		return odid;
	}
	public void setOdid(Integer odid) {
		this.odid = odid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getOpid() {
		return opid;
	}
	public void setOpid(Integer opid) {
		this.opid = opid;
	}
	public Integer getOdquantity() {
		return odquantity;
	}
	public void setOdquantity(Integer odquantity) {
		this.odquantity = odquantity;
	}
	public Double getOdcost() {
		return odcost;
	}
	public void setOdcost(Double odcost) {
		this.odcost = odcost;
	}

}
