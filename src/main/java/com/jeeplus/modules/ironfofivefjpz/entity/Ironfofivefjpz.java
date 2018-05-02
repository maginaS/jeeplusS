/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivefjpz.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5.2房间配置Entity
 * @author mikesun
 * @version 2018-03-23
 */
public class Ironfofivefjpz extends DataEntity<Ironfofivefjpz> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String fjpz_gndy;		// 功能单元
	private String fjpz_gndyjzmj;		// 功能单元建筑面积（m2）
	private String fjpz_remark;		// 添加
	private List<Ironfofivefjlx> ironfofivefjlxList = Lists.newArrayList();		// 子表列表
	
	public Ironfofivefjpz() {
		super();
	}

	public Ironfofivefjpz(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="功能单元", align=2, sort=8)
	public String getFjpz_gndy() {
		return fjpz_gndy;
	}

	public void setFjpz_gndy(String fjpz_gndy) {
		this.fjpz_gndy = fjpz_gndy;
	}
	
	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=9)
	public String getFjpz_gndyjzmj() {
		return fjpz_gndyjzmj;
	}

	public void setFjpz_gndyjzmj(String fjpz_gndyjzmj) {
		this.fjpz_gndyjzmj = fjpz_gndyjzmj;
	}
	
	@ExcelField(title="添加", align=2, sort=10)
	public String getFjpz_remark() {
		return fjpz_remark;
	}

	public void setFjpz_remark(String fjpz_remark) {
		this.fjpz_remark = fjpz_remark;
	}
	
	public List<Ironfofivefjlx> getIronfofivefjlxList() {
		return ironfofivefjlxList;
	}

	public void setIronfofivefjlxList(List<Ironfofivefjlx> ironfofivefjlxList) {
		this.ironfofivefjlxList = ironfofivefjlxList;
	}
	
	
	
	
}