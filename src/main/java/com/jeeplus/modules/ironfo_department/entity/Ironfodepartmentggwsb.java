/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.4科室设置Entity
 * @author mikesun
 * @version 2018-03-16
 */
public class Ironfodepartmentggwsb extends DataEntity<Ironfodepartmentggwsb> {
	
	private static final long serialVersionUID = 1L;
	private String yfbjk;		// 预防保健科
	private String fnbjk;		// 妇女保健科
	private String etbjk;		// 儿童保健科
	private String tjzx;		// 体检中心
	private String tjremark;		// 添加
	private String dep_id;		// 主表id
	private String doc_id;
	
	
	
	
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public Ironfodepartmentggwsb() {
		super();
	}

	public Ironfodepartmentggwsb(String id){
		super(id);
	}

	@ExcelField(title="预防保健科", dictType="", align=2, sort=7)
	public String getYfbjk() {
		return yfbjk;
	}

	public void setYfbjk(String yfbjk) {
		this.yfbjk = yfbjk;
	}
	
	@ExcelField(title="妇女保健科", dictType="", align=2, sort=8)
	public String getFnbjk() {
		return fnbjk;
	}

	public void setFnbjk(String fnbjk) {
		this.fnbjk = fnbjk;
	}
	
	@ExcelField(title="儿童保健科", dictType="", align=2, sort=9)
	public String getEtbjk() {
		return etbjk;
	}

	public void setEtbjk(String etbjk) {
		this.etbjk = etbjk;
	}
	
	@ExcelField(title="体检中心", dictType="", align=2, sort=10)
	public String getTjzx() {
		return tjzx;
	}

	public void setTjzx(String tjzx) {
		this.tjzx = tjzx;
	}
	
	
//	public String getTj_remark() {
//		return tj_remark;
//	}
//
//	public void setTj_remark(String tj_remark) {
//		this.tj_remark = tj_remark;
//	}
	
	@ExcelField(title="添加", align=2, sort=11)
	public String getTjremark() {
		return tjremark;
	}

	public void setTjremark(String tjremark) {
		this.tjremark = tjremark;
	}

	@ExcelField(title="主表id", align=2, sort=12)
	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
}