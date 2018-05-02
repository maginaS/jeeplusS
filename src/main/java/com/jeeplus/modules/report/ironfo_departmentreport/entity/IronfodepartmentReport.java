/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_departmentreport.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.4科室设置Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfodepartmentReport extends DataEntity<IronfodepartmentReport> {
	
	private static final long serialVersionUID = 1L;
	private String zndy;		// 职能单元
	private String doc_id;		// 主表id
	private List<IronfodepartmentggwsbReport> ironfodepartmentggwsbList = Lists.newArrayList();		// 子表列表
	private List<IronfodepartmentjhsybReport> ironfodepartmentjhsybList = Lists.newArrayList();		// 子表列表
	private List<IronfodepartmentremarkReport> ironfodepartmentremarkList = Lists.newArrayList();		// 子表列表
	private List<IronfodepartmentyjbReport> ironfodepartmentyjbList = Lists.newArrayList();		// 子表列表
	private List<IronfodepartmentznglbReport> ironfodepartmentznglbList = Lists.newArrayList();		// 子表列表
	private List<IronfodepartmentzybReport> ironfodepartmentzybList = Lists.newArrayList();		// 子表列表
	
	private IronfoDocTitle  title;
	private User duser;
	
	
	public IronfoDocTitle getTitle() {
		return title;
	}

	public void setTitle(IronfoDocTitle title) {
		this.title = title;
	}

	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}
	public IronfodepartmentReport() {
		super();
	}

	public IronfodepartmentReport(String id){
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
	
	public List<IronfodepartmentggwsbReport> getIronfodepartmentggwsbList() {
		return ironfodepartmentggwsbList;
	}

	public void setIronfodepartmentggwsbList(List<IronfodepartmentggwsbReport> ironfodepartmentggwsbList) {
		this.ironfodepartmentggwsbList = ironfodepartmentggwsbList;
	}
	public List<IronfodepartmentjhsybReport> getIronfodepartmentjhsybList() {
		return ironfodepartmentjhsybList;
	}

	public void setIronfodepartmentjhsybList(List<IronfodepartmentjhsybReport> ironfodepartmentjhsybList) {
		this.ironfodepartmentjhsybList = ironfodepartmentjhsybList;
	}
	public List<IronfodepartmentremarkReport> getIronfodepartmentremarkList() {
		return ironfodepartmentremarkList;
	}

	public void setIronfodepartmentremarkList(List<IronfodepartmentremarkReport> ironfodepartmentremarkList) {
		this.ironfodepartmentremarkList = ironfodepartmentremarkList;
	}
	public List<IronfodepartmentyjbReport> getIronfodepartmentyjbList() {
		return ironfodepartmentyjbList;
	}

	public void setIronfodepartmentyjbList(List<IronfodepartmentyjbReport> ironfodepartmentyjbList) {
		this.ironfodepartmentyjbList = ironfodepartmentyjbList;
	}
	public List<IronfodepartmentznglbReport> getIronfodepartmentznglbList() {
		return ironfodepartmentznglbList;
	}

	public void setIronfodepartmentznglbList(List<IronfodepartmentznglbReport> ironfodepartmentznglbList) {
		this.ironfodepartmentznglbList = ironfodepartmentznglbList;
	}
	public List<IronfodepartmentzybReport> getIronfodepartmentzybList() {
		return ironfodepartmentzybList;
	}

	public void setIronfodepartmentzybList(List<IronfodepartmentzybReport> ironfodepartmentzybList) {
		this.ironfodepartmentzybList = ironfodepartmentzybList;
	}
}