/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationmaintain.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.4系统维护人员Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoinformationmaintain extends DataEntity<Ironfoinformationmaintain> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String ryzc;		// 人员职称
	private String whcd;		// 文化程度
	private String sxzy;		// 所学专业
	private String xggznx;		// 现岗工作年限
	private String rypz;		// 人员配置
	
	
	
	
	public Ironfoinformationmaintain() {
		super();
	}

	public Ironfoinformationmaintain(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="人员职称", align=2, sort=8)
	public String getRyzc() {
		return ryzc;
	}

	public void setRyzc(String ryzc) {
		this.ryzc = ryzc;
	}
	@ExcelField(title="文化程度", align=2, sort=9)
	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getSxzy() {
		return sxzy;
	}

	public void setSxzy(String sxzy) {
		this.sxzy = sxzy;
	}

	public String getXggznx() {
		return xggznx;
	}

	public void setXggznx(String xggznx) {
		this.xggznx = xggznx;
	}

	public String getRypz() {
		return rypz;
	}

	public void setRypz(String rypz) {
		this.rypz = rypz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
//	@ExcelField(title="人员职称", align=2, sort=8)
//	public String getMaintain_ryzc() {
//		return maintain_ryzc;
//	}
//
//	public void setMaintain_ryzc(String maintain_ryzc) {
//		this.maintain_ryzc = maintain_ryzc;
//	}
//	
//	@ExcelField(title="文化程度", align=2, sort=9)
//	public String getMaintain_whcd() {
//		return maintain_whcd;
//	}
//
//	public void setMaintain_whcd(String maintain_whcd) {
//		this.maintain_whcd = maintain_whcd;
//	}
//	
//	@ExcelField(title="所学专业", align=2, sort=10)
//	public String getMaintain_sxzy() {
//		return maintain_sxzy;
//	}
//
//	public void setMaintain_sxzy(String maintain_sxzy) {
//		this.maintain_sxzy = maintain_sxzy;
//	}
//	
//	@ExcelField(title="现岗工作年限", align=2, sort=11)
//	public String getMaintain_xggznx() {
//		return maintain_xggznx;
//	}
//
//	public void setMaintain_xggznx(String maintain_xggznx) {
//		this.maintain_xggznx = maintain_xggznx;
//	}
//	
//	@ExcelField(title="人员配置", align=2, sort=12)
//	public String getMaintain_rypz() {
//		return maintain_rypz;
//	}
//
//	public void setMaintain_rypz(String maintain_rypz) {
//		this.maintain_rypz = maintain_rypz;
//	}
	
}