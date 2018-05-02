/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszywwclreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 污物处理Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivegpszywwclReport extends DataEntity<IronfofivegpszywwclReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String fsl;		// 焚烧炉
	private String fwgs;		// 废物公司
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

	public IronfofivegpszywwclReport() {
		super();
	}

	public IronfofivegpszywwclReport(String id){
		super(id);
	}

	////@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="焚烧炉", dictType="", align=2, sort=8)
	public String getFsl() {
		return fsl;
	}

	public void setFsl(String fsl) {
		this.fsl = fsl;
	}
	
	@ExcelField(title="废物公司", dictType="", align=2, sort=9)
	public String getFwgs() {
		return fwgs;
	}

	public void setFwgs(String fwgs) {
		this.fwgs = fwgs;
	}
	
}