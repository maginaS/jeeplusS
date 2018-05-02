/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofamilies.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.5病种Entity
 * @author mikesun
 * @version 2018-03-19
 */
public class Ironfofamilies extends DataEntity<Ironfofamilies> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String dep;		// 科室
	private List<Ironfo_jbbz> ironfo_jbbzList = Lists.newArrayList();		// 子表列表
	private List<Ironfotjbz> ironfotjbzList = Lists.newArrayList();		// 子表列表
	
	public Ironfofamilies() {
		super();
	}

	public Ironfofamilies(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="科室", align=2, sort=8)
	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}
	
	public List<Ironfo_jbbz> getIronfo_jbbzList() {
		return ironfo_jbbzList;
	}

	public void setIronfo_jbbzList(List<Ironfo_jbbz> ironfo_jbbzList) {
		this.ironfo_jbbzList = ironfo_jbbzList;
	}
	public List<Ironfotjbz> getIronfotjbzList() {
		return ironfotjbzList;
	}

	public void setIronfotjbzList(List<Ironfotjbz> ironfotjbzList) {
		this.ironfotjbzList = ironfotjbzList;
	}
}