/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinforexperiencereport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 4.3信息化系统使用体验Entity
 * @author anti_magina
 * @version 2018-04-20
 */
public class IronfoinformationexperienceReport extends DataEntity<IronfoinformationexperienceReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String bjxty;		// 便捷性体验
	private String gnxty;		// 功能性体验
	private String ggxty;		// 观感性体验
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public IronfoinformationexperienceReport() {
		super();
	}

	public IronfoinformationexperienceReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="便捷性体验", align=2, sort=8)
	public String getBjxty() {
		return bjxty;
	}

	public void setBjxty(String bjxty) {
		this.bjxty = bjxty;
	}
	@ExcelField(title="功能性体验", align=2, sort=9)
	public String getGnxty() {
		return gnxty;
	}

	public void setGnxty(String gnxty) {
		this.gnxty = gnxty;
	}
	@ExcelField(title="观感性体验", align=2, sort=10)
	public String getGgxty() {
		return ggxty;
	}

	public void setGgxty(String ggxty) {
		this.ggxty = ggxty;
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