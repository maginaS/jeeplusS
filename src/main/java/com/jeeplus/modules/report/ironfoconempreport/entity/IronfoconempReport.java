/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoconempreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.7.1职工构成Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfoconempReport extends DataEntity<IronfoconempReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String date;		// 时间
	private String zzzgs;		// 在岗职工数（人）
	private String wsjsry;		// 卫生技术人员（人）
	private String qtjsry;		// 其他技术人员（人）
	private String glry;		// 管理人员（人）
	private String gqjnry;		// 工勤技能人员（人）
	
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
	
	public IronfoconempReport() {
		super();
	}

	public IronfoconempReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="时间", align=2, sort=8)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@ExcelField(title="在岗职工数（人）", align=2, sort=9)
	public String getZzzgs() {
		return zzzgs;
	}

	public void setZzzgs(String zzzgs) {
		this.zzzgs = zzzgs;
	}
	
	@ExcelField(title="卫生技术人员（人）", align=2, sort=10)
	public String getWsjsry() {
		return wsjsry;
	}

	public void setWsjsry(String wsjsry) {
		this.wsjsry = wsjsry;
	}
	
	@ExcelField(title="其他技术人员（人）", align=2, sort=11)
	public String getQtjsry() {
		return qtjsry;
	}

	public void setQtjsry(String qtjsry) {
		this.qtjsry = qtjsry;
	}
	
	@ExcelField(title="管理人员（人）", align=2, sort=12)
	public String getGlry() {
		return glry;
	}

	public void setGlry(String glry) {
		this.glry = glry;
	}
	
	@ExcelField(title="工勤技能人员（人）", align=2, sort=13)
	public String getGqjnry() {
		return gqjnry;
	}

	public void setGqjnry(String gqjnry) {
		this.gqjnry = gqjnry;
	}
	
}