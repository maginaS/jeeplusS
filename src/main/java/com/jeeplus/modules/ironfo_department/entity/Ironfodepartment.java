/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.4科室设置Entity
 * @author mikesun
 * @version 2018-03-16
 */
public class Ironfodepartment extends DataEntity<Ironfodepartment> {
	
	private static final long serialVersionUID = 1L;
	private String zndy;		// 职能单元
	private String doc_id;		// 主表id
	private List<Ironfodepartmentggwsb> ironfodepartmentggwsbList = Lists.newArrayList();		// 子表列表
	private List<Ironfodepartmentjhsyb> ironfodepartmentjhsybList = Lists.newArrayList();		// 子表列表
	private List<Ironfodepartmentremark> ironfodepartmentremarkList = Lists.newArrayList();		// 子表列表
	private List<Ironfodepartmentyjb> ironfodepartmentyjbList = Lists.newArrayList();		// 子表列表
	private List<Ironfodepartmentznglb> ironfodepartmentznglbList = Lists.newArrayList();		// 子表列表
	private List<Ironfodepartmentzyb> ironfodepartmentzybList = Lists.newArrayList();		// 子表列表
	
	public Ironfodepartment() {
		super();
	}

	public Ironfodepartment(String id){
		super(id);
	}

	@ExcelField(title="职能单元", align=2, sort=7)
	public String getZndy() {
		return zndy;
	}

	public void setZndy(String zndy) {
		this.zndy = zndy;
	}
	
	@ExcelField(title="主表id", align=2, sort=8)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	public List<Ironfodepartmentggwsb> getIronfodepartmentggwsbList() {
		return ironfodepartmentggwsbList;
	}

	public void setIronfodepartmentggwsbList(List<Ironfodepartmentggwsb> ironfodepartmentggwsbList) {
		this.ironfodepartmentggwsbList = ironfodepartmentggwsbList;
	}
	public List<Ironfodepartmentjhsyb> getIronfodepartmentjhsybList() {
		return ironfodepartmentjhsybList;
	}

	public void setIronfodepartmentjhsybList(List<Ironfodepartmentjhsyb> ironfodepartmentjhsybList) {
		this.ironfodepartmentjhsybList = ironfodepartmentjhsybList;
	}
	public List<Ironfodepartmentremark> getIronfodepartmentremarkList() {
		return ironfodepartmentremarkList;
	}

	public void setIronfodepartmentremarkList(List<Ironfodepartmentremark> ironfodepartmentremarkList) {
		this.ironfodepartmentremarkList = ironfodepartmentremarkList;
	}
	public List<Ironfodepartmentyjb> getIronfodepartmentyjbList() {
		return ironfodepartmentyjbList;
	}

	public void setIronfodepartmentyjbList(List<Ironfodepartmentyjb> ironfodepartmentyjbList) {
		this.ironfodepartmentyjbList = ironfodepartmentyjbList;
	}
	public List<Ironfodepartmentznglb> getIronfodepartmentznglbList() {
		return ironfodepartmentznglbList;
	}

	public void setIronfodepartmentznglbList(List<Ironfodepartmentznglb> ironfodepartmentznglbList) {
		this.ironfodepartmentznglbList = ironfodepartmentznglbList;
	}
	public List<Ironfodepartmentzyb> getIronfodepartmentzybList() {
		return ironfodepartmentzybList;
	}

	public void setIronfodepartmentzybList(List<Ironfodepartmentzyb> ironfodepartmentzybList) {
		this.ironfodepartmentzybList = ironfodepartmentzybList;
	}
}