package com.entity;

public class Product {
	
	Integer pid;			//商品ID
	String  pname;			//商品名称
	String  pprice;			//价格
	String  pdescription;	//商品描述
	String  pstock;			//库存
	Integer pcid;			//类别ID
	Integer pchildid; 		//二级分类ID（即子ID）
	String  pfilename;		//上传文件路径
	Integer psingleamount = 0;  //当前单种所浏览商品所加入购物车的数量

	
	
	/**
	 * 无参构造
	 */
	public Product() {
		super();
	}
	
	/**
	 * 有参构造
	 * 
	 * @param pid
	 * @param pname
	 * @param pdescription
	 * @param pprice
	 * @param pstock
	 * @param pcid
	 * @param pchildid
	 * @param pfilename
	 */
	public Product(Integer pid, String pname, String pdescription, String pprice, String pstock, Integer pcid,
			Integer pchildid, String pfilename) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.pprice = pprice;
		this.pstock = pstock;
		this.pcid = pcid;
		this.pchildid = pchildid;
		this.pfilename = pfilename;
	}

	/**
	 * get、set方法
	 * 
	 */
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPstock() {
		return pstock;
	}
	public void setPstock(String pstock) {
		this.pstock = pstock;
	}
	public Integer getPcid() {
		return pcid;
	}
	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}
	public Integer getPchildid() {
		return pchildid;
	}
	public void setPchildid(Integer pchildid) {
		this.pchildid = pchildid;
	}
	public String getPfilename() {
		return pfilename;
	}
	public void setPfilename(String pfilename) {
		this.pfilename = pfilename;
	}

	public Integer getPsingleamount() {
		return psingleamount;
	}
	public void setPsingleamount(Integer psingleamount) {
		this.psingleamount = psingleamount;
	}
}
