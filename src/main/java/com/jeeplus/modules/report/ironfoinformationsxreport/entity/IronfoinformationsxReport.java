/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationsxreport.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 4.2信息化系统功能实现Entity
 * @author anti_magina
 * @version 2018-04-24
 */
public class IronfoinformationsxReport extends DataEntity<IronfoinformationsxReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String xxhxtgndy;		// 信息化系统功能单元
	private List<IronfoinformationsxjbggwsfwReport> ironfoinformationsxjbggwsfwList = Lists.newArrayList();		// 子表列表
	private List<IronfoinformationsxjbylfwReport> ironfoinformationsxjbylfwList = Lists.newArrayList();		// 子表列表
	private List<IronfoinformationsxjgjkReport> ironfoinformationsxjgjkList = Lists.newArrayList();		// 子表列表
	private List<IronfoinformationsxjgyyglReport> ironfoinformationsxjgyyglList = Lists.newArrayList();		// 子表列表
	private List<IronfoinformationsxjkdaglReport> ironfoinformationsxjkdaglList = Lists.newArrayList();		// 子表列表
	private List<IronfoinformationsxjkxxfwReport> ironfoinformationsxjkxxfwList = Lists.newArrayList();		// 子表列表
	
	//add by anti_magina
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

	public IronfoinformationsxReport() {
		super();
	}

	public IronfoinformationsxReport(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="信息化系统功能单元", align=2, sort=8)
	public String getXxhxtgndy() {
		return xxhxtgndy;
	}

	public void setXxhxtgndy(String xxhxtgndy) {
		this.xxhxtgndy = xxhxtgndy;
	}
	
	public List<IronfoinformationsxjbggwsfwReport> getIronfoinformationsxjbggwsfwList() {
		return ironfoinformationsxjbggwsfwList;
	}

	public void setIronfoinformationsxjbggwsfwList(List<IronfoinformationsxjbggwsfwReport> ironfoinformationsxjbggwsfwList) {
		this.ironfoinformationsxjbggwsfwList = ironfoinformationsxjbggwsfwList;
	}
	public List<IronfoinformationsxjbylfwReport> getIronfoinformationsxjbylfwList() {
		return ironfoinformationsxjbylfwList;
	}

	public void setIronfoinformationsxjbylfwList(List<IronfoinformationsxjbylfwReport> ironfoinformationsxjbylfwList) {
		this.ironfoinformationsxjbylfwList = ironfoinformationsxjbylfwList;
	}
	public List<IronfoinformationsxjgjkReport> getIronfoinformationsxjgjkList() {
		return ironfoinformationsxjgjkList;
	}

	public void setIronfoinformationsxjgjkList(List<IronfoinformationsxjgjkReport> ironfoinformationsxjgjkList) {
		this.ironfoinformationsxjgjkList = ironfoinformationsxjgjkList;
	}
	public List<IronfoinformationsxjgyyglReport> getIronfoinformationsxjgyyglList() {
		return ironfoinformationsxjgyyglList;
	}

	public void setIronfoinformationsxjgyyglList(List<IronfoinformationsxjgyyglReport> ironfoinformationsxjgyyglList) {
		this.ironfoinformationsxjgyyglList = ironfoinformationsxjgyyglList;
	}
	public List<IronfoinformationsxjkdaglReport> getIronfoinformationsxjkdaglList() {
		return ironfoinformationsxjkdaglList;
	}

	public void setIronfoinformationsxjkdaglList(List<IronfoinformationsxjkdaglReport> ironfoinformationsxjkdaglList) {
		this.ironfoinformationsxjkdaglList = ironfoinformationsxjkdaglList;
	}
	public List<IronfoinformationsxjkxxfwReport> getIronfoinformationsxjkxxfwList() {
		return ironfoinformationsxjkxxfwList;
	}

	public void setIronfoinformationsxjkxxfwList(List<IronfoinformationsxjkxxfwReport> ironfoinformationsxjkxxfwList) {
		this.ironfoinformationsxjkxxfwList = ironfoinformationsxjkxxfwList;
	}
}