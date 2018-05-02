/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofamilies.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.5病种Entity
 * @author mikesun
 * @version 2018-03-19
 */
public class Ironfo_jbbz extends DataEntity<Ironfo_jbbz> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 基本病种名称
	private String fam_id;		// 主表id
	
	public Ironfo_jbbz() {
		super();
	}

	public Ironfo_jbbz(String id){
		super(id);
	}

	@ExcelField(title="基本病种名称", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="主表id", align=2, sort=8)
	public String getFam_id() {
		return fam_id;
	}

	public void setFam_id(String fam_id) {
		this.fam_id = fam_id;
	}
	
}