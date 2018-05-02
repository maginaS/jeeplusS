/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivemjzyfreport.entity;

import java.util.List;

import com.google.common.collect.Lists;
import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.2门急诊用房Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivemjzyfReport extends DataEntity<IronfofivemjzyfReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private List<IronfofivemjzyfkjlxReport> ironfofivemjzyfkjlxList = Lists.newArrayList();		// 子表列表
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}

	public IronfoDocTitle getIronfoDocTitle() {
		return ironfoDocTitle;
	}

	public void setIronfoDocTitle(IronfoDocTitle ironfoDocTitle) {
		this.ironfoDocTitle = ironfoDocTitle;
	}

	public IronfofivemjzyfReport() {
		super();
	}

	public IronfofivemjzyfReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=8)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}
	
	public List<IronfofivemjzyfkjlxReport> getIronfofivemjzyfkjlxList() {
		return ironfofivemjzyfkjlxList;
	}

	public void setIronfofivemjzyfkjlxList(List<IronfofivemjzyfkjlxReport> ironfofivemjzyfkjlxList) {
		this.ironfofivemjzyfkjlxList = ironfofivemjzyfkjlxList;
	}
}