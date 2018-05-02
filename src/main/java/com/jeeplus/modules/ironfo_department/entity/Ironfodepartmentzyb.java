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
public class Ironfodepartmentzyb extends DataEntity<Ironfodepartmentzyb> {
	
	private static final long serialVersionUID = 1L;
	private String ptbq;		// 普通病区
	private String kfbq;		// 康复病区
	private String lzghk;		// 临终关怀科
	private String tjremarks;		// 添加
	private String dep_id;		// 主表id
	private String doc_id;
	
	
	
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ironfodepartmentzyb() {
		super();
	}

	public Ironfodepartmentzyb(String id){
		super(id);
	}

	@ExcelField(title="普通病区", dictType="", align=2, sort=7)
	public String getPtbq() {
		return ptbq;
	}

	public void setPtbq(String ptbq) {
		this.ptbq = ptbq;
	}
	
	@ExcelField(title="康复病区", dictType="", align=2, sort=8)
	public String getKfbq() {
		return kfbq;
	}

	public void setKfbq(String kfbq) {
		this.kfbq = kfbq;
	}
	
	@ExcelField(title="临终关怀科", dictType="", align=2, sort=9)
	public String getLzghk() {
		return lzghk;
	}

	public void setLzghk(String lzghk) {
		this.lzghk = lzghk;
	}
	
	
	
	
//	public String getTj_remarks() {
//		return tj_remarks;
//	}
//
//	public void setTj_remarks(String tj_remarks) {
//		this.tj_remarks = tj_remarks;
//	}
	
	@ExcelField(title="主表id", align=2, sort=11)
	public String getDep_id() {
		return dep_id;
	}

	@ExcelField(title="添加", align=2, sort=10)
	public String getTjremarks() {
		return tjremarks;
	}

	public void setTjremarks(String tjremarks) {
		this.tjremarks = tjremarks;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
}