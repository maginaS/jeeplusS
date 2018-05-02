/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationhardware.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.5信息化系统配套硬件Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoinformationhardware extends DataEntity<Ironfoinformationhardware> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String xxxtjf;		// 信息系统机房
	private String xtjfmj;		// 信息系统机房面积（m2）
	private String fwq;		// 服务器（台）
	
	public Ironfoinformationhardware() {
		super();
	}

	public Ironfoinformationhardware(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getXxxtjf() {
		
		return xxxtjf;
	}

	public void setXxxtjf(String xxxtjf) {
		this.xxxtjf = xxxtjf;
	}

	public String getXtjfmj() {
		return xtjfmj;
	}

	public void setXtjfmj(String xtjfmj) {
		this.xtjfmj = xtjfmj;
	}

	public String getFwq() {
		return fwq;
	}

	public void setFwq(String fwq) {
		this.fwq = fwq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
//	@ExcelField(title="信息系统机房", dictType="", align=2, sort=8)
//	public String getHardware_xxxtjf() {
//		return hardware_xxxtjf;
//	}
//
//	public void setHardware_xxxtjf(String hardware_xxxtjf) {
//		this.hardware_xxxtjf = hardware_xxxtjf;
//	}
//	
//	@ExcelField(title="信息系统机房面积（m2）", align=2, sort=9)
//	public String getHardware_xtjfmj() {
//		return hardware_xtjfmj;
//	}
//
//	public void setHardware_xtjfmj(String hardware_xtjfmj) {
//		this.hardware_xtjfmj = hardware_xtjfmj;
//	}
//	
//	@ExcelField(title="服务器（台）", align=2, sort=10)
//	public String getHardware_fwq() {
//		return hardware_fwq;
//	}
//
//	public void setHardware_fwq(String hardware_fwq) {
//		this.hardware_fwq = hardware_fwq;
//	}
	
}