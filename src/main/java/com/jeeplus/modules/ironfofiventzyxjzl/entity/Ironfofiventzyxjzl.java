/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzyxjzl.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 夏季制冷Entity
 * @author mikesun
 * @version 2018-04-17
 */
public class Ironfofiventzyxjzl extends DataEntity<Ironfofiventzyxjzl> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String zykt;		// 中央空调
	private String ftkt;		// 分体空调
	
	public Ironfofiventzyxjzl() {
		super();
	}

	public Ironfofiventzyxjzl(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="中央空调", dictType="", align=2, sort=8)
	public String getZykt() {
		
		return zykt;
	}

	public void setZykt(String zykt) {
		this.zykt = zykt;
	}
	
	@ExcelField(title="分体空调", dictType="", align=2, sort=9)
	public String getFtkt() {
		
		return ftkt;
	}

	public void setFtkt(String ftkt) {
		this.ftkt = ftkt;
	}
	
}