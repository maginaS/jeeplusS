/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszygssyreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 给水水源Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivegpszygssyReport extends DataEntity<IronfofivegpszygssyReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String szgw;		// 市政管网
	private String sjzq;		// 水井自取
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public IronfofivegpszygssyReport() {
		super();
	}

	public IronfofivegpszygssyReport(String id){
		super(id);
	}

	////@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
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

	@ExcelField(title="市政管网", dictType="", align=2, sort=8)
	public String getSzgw() {
		return szgw;
	}

	public void setSzgw(String szgw) {
		this.szgw = szgw;
	}
	
	@ExcelField(title="水井自取", dictType="", align=2, sort=9)
	public String getSjzq() {
		return sjzq;
	}

	public void setSjzq(String sjzq) {
		this.sjzq = sjzq;
	}
	
}