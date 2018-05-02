/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveqtzygylxreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 供应类型Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofiveqtzygylxReport extends DataEntity<IronfofiveqtzygylxReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String zygy;		// 中央供应
	private String qpzq;		// 气瓶自取
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public IronfofiveqtzygylxReport() {
		super();
	}

	public IronfofiveqtzygylxReport(String id){
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

	@ExcelField(title="中央供应", dictType="", align=2, sort=8)
	public String getZygy() {
		return zygy;
	}

	public void setZygy(String zygy) {
		this.zygy = zygy;
	}
	
	@ExcelField(title="气瓶自取", dictType="", align=2, sort=9)
	public String getQpzq() {
		return qpzq;
	}

	public void setQpzq(String qpzq) {
		this.qpzq = qpzq;
	}
	
}