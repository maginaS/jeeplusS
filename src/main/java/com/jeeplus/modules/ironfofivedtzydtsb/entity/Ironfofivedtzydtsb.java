/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedtzydtsb.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 电梯设备Entity
 * @author mikesun
 * @version 2018-04-17
 */
public class Ironfofivedtzydtsb extends DataEntity<Ironfofivedtzydtsb> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String czdt;		// 垂直电梯
	private String zdft;		// 自动扶梯
	private String bcdt;		// 病床电梯
	
	public Ironfofivedtzydtsb() {
		super();
	}

	public Ironfofivedtzydtsb(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="垂直电梯", dictType="", align=2, sort=8)
	public String getCzdt() {
		
		return czdt;
	}

	public void setCzdt(String czdt) {
		this.czdt = czdt;
	}
	
	@ExcelField(title="自动扶梯", dictType="", align=2, sort=9)
	public String getZdft() {
		
		return zdft;
	}

	public void setZdft(String zdft) {
		this.zdft = zdft;
	}
	
	@ExcelField(title="病床电梯", dictType="", align=2, sort=10)
	public String getBcdt() {
		
		return bcdt;
	}

	public void setBcdt(String bcdt) {
		this.bcdt = bcdt;
	}
	
}