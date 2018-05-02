/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivesssglreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.11手术室Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivesssglReport extends DataEntity<IronfofivesssglReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String Ajjjsss;		// Ⅰ级洁净手术室（间）
	private String Bjjjsss;		// Ⅱ级洁净手术室（间）
	private String Cjjjsss;		// Ⅲ级洁净手术室（间）
	private String Djjjsss;		// Ⅳ级洁净手术室（间）
	private String Fjjjsss;		// 一般手术室（间）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfofivesssglReport() {
		super();
	}

	public IronfofivesssglReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
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

	@ExcelField(title="Ⅰ级洁净手术室（间）", align=2, sort=8)
	public String getAjjjsss() {
		return Ajjjsss;
	}

	public void setAjjjsss(String Ajjjsss) {
		this.Ajjjsss = Ajjjsss;
	}
	
	@ExcelField(title="Ⅱ级洁净手术室（间）", align=2, sort=9)
	public String getBjjjsss() {
		return Bjjjsss;
	}

	public void setBjjjsss(String Bjjjsss) {
		this.Bjjjsss = Bjjjsss;
	}
	
	@ExcelField(title="Ⅲ级洁净手术室（间）", align=2, sort=10)
	public String getCjjjsss() {
		return Cjjjsss;
	}

	public void setCjjjsss(String Cjjjsss) {
		this.Cjjjsss = Cjjjsss;
	}
	
	@ExcelField(title="Ⅳ级洁净手术室（间）", align=2, sort=11)
	public String getDjjjsss() {
		return Djjjsss;
	}

	public void setDjjjsss(String Djjjsss) {
		this.Djjjsss = Djjjsss;
	}
	
	@ExcelField(title="一般手术室（间）", align=2, sort=12)
	public String getFjjjsss() {
		return Fjjjsss;
	}

	public void setFjjjsss(String Fjjjsss) {
		this.Fjjjsss = Fjjjsss;
	}
	
}