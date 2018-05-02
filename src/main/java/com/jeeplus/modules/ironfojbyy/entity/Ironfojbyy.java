/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbyy.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.6基本用药Entity
 * @author mikesun
 * @version 2018-03-21
 */
public class Ironfojbyy extends DataEntity<Ironfojbyy> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String jbyypzs;		// 基本用药品种数（种）
	
	public Ironfojbyy() {
		super();
	}

	public Ironfojbyy(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="基本用药品种数（种）", align=2, sort=8)
	public String getJbyypzs() {
		return jbyypzs;
	}

	public void setJbyypzs(String jbyypzs) {
		this.jbyypzs = jbyypzs;
	}
	
}