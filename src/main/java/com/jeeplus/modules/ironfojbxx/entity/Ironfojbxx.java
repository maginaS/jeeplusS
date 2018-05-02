/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbxx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 基本信息Entity
 * @author mikesun
 * @version 2018-04-17
 */
public class Ironfojbxx extends DataEntity<Ironfojbxx> {
	
	private static final long serialVersionUID = 1L;
	private String aemp;		// 填写人
	private String atel;		// 填写人电话
	private String adate;		// 填表时间
	private String aappr;		// 院长
	private String aapprtel;		// 院长电话
	private String aappremail;		// 院长邮箱
	private String bhos;		// 机构名称
	private String bhosaddr;		// 机构地址
	private String bcen;		// 是否为中心卫生院
	private String docId; //主表id
	
	public Ironfojbxx() {
		super();
	}

	public Ironfojbxx(String id){
		super(id);
	}

	@ExcelField(title="填写人", align=2, sort=7)
	public String getaemp() {
		return aemp;
	}

	public void setaemp(String aemp) {
		this.aemp = aemp;
	}
	
	@ExcelField(title="填写人电话", align=2, sort=8)
	public String getatel() {
		return atel;
	}

	public void setatel(String atel) {
		this.atel = atel;
	}
	
	@ExcelField(title="填表时间", align=2, sort=9)
	public String getadate() {
		return adate;
	}

	public void setadate(String adate) {
		this.adate = adate;
	}
	
	@ExcelField(title="院长", align=2, sort=10)
	public String getaappr() {
		return aappr;
	}

	public void setaappr(String aappr) {
		this.aappr = aappr;
	}
	
	@ExcelField(title="院长电话", align=2, sort=11)
	public String getaapprtel() {
		return aapprtel;
	}

	public void setaapprtel(String aapprtel) {
		this.aapprtel = aapprtel;
	}
	
	@ExcelField(title="院长邮箱", align=2, sort=12)
	public String getaappremail() {
		return aappremail;
	}

	public void setaappremail(String aappremail) {
		this.aappremail = aappremail;
	}
	
	@ExcelField(title="机构名称", align=2, sort=13)
	public String getbhos() {
		return bhos;
	}

	public void setbhos(String bhos) {
		this.bhos = bhos;
	}
	
	@ExcelField(title="机构地址", align=2, sort=14)
	public String getbhosaddr() {
		return bhosaddr;
	}

	public void setbhosaddr(String bhosaddr) {
		this.bhosaddr = bhosaddr;
	}
	
	@ExcelField(title="是否为中心卫生院", align=2, sort=15)
	public String getbcen() {
		return bcen;
	}

	public void setbcen(String bcen) {
		this.bcen = bcen;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
	
}