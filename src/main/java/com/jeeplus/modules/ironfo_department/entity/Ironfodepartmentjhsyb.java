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
public class Ironfodepartmentjhsyb extends DataEntity<Ironfodepartmentjhsyb> {
	
	private static final long serialVersionUID = 1L;
	private String jhsyk;		// 计划生育科
	private String tjremark;		// 添加
	private String dep_id;		// 主表id
	private String doc_id;
	
	
	
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public Ironfodepartmentjhsyb() {
		super();
	}

	public Ironfodepartmentjhsyb(String id){
		super(id);
	}

	@ExcelField(title="计划生育科", dictType="", align=2, sort=7)
	public String getJhsyk() {
		return jhsyk;
	}

	public void setJhsyk(String jhsyk) {
		this.jhsyk = jhsyk;
	}
	
//	@ExcelField(title="添加", align=2, sort=8)
	
	
	
//	public String getTj_remark() {
//		return tj_remark;
//	}
//
//	public void setTj_remark(String tj_remark) {
//		this.tj_remark = tj_remark;
//	}
	
	@ExcelField(title="主表id", align=2, sort=9)
	public String getDep_id() {
		return dep_id;
	}

	@ExcelField(title="添加", align=2, sort=8)
	public String getTjremark() {
		return tjremark;
	}

	public void setTjremark(String tjremark) {
		this.tjremark = tjremark;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
}