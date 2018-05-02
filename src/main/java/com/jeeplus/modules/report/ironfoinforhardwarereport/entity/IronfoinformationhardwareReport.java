/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinforhardwarereport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 4.5信息化系统配套硬件Entity
 * @author anti_magina
 * @version 2018-04-20
 */
public class IronfoinformationhardwareReport extends DataEntity<IronfoinformationhardwareReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String xxxtjf;		// 信息系统机房
	private String xtjfmj;		// 信息系统机房面积（m2）
	private String fwq;		// 服务器（台）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfoinformationhardwareReport() {
		super();
	}

	public IronfoinformationhardwareReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="信息系统机房", dictType="", align=2, sort=8)
	public String getXxxtjf() {
		return xxxtjf;
	}

	public void setXxxtjf(String xxxtjf) {
		this.xxxtjf = xxxtjf;
	}
	@ExcelField(title="信息系统机房面积（m2）", align=2, sort=9)
	public String getXtjfmj() {
		return xtjfmj;
	}

	public void setXtjfmj(String xtjfmj) {
		this.xtjfmj = xtjfmj;
	}
	@ExcelField(title="服务器（台）", align=2, sort=10)
	public String getFwq() {
		return fwq;
	}

	public void setFwq(String fwq) {
		this.fwq = fwq;
	}

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
	
}