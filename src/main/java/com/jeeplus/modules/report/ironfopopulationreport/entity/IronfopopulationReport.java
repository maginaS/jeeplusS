/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopopulationreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.1.1建筑总体概况Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfopopulationReport extends DataEntity<IronfopopulationReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String zjzmj;		// 总建筑面积（m2）
	private String dxjzmj;		// 地下建筑面积（m2）
	private String dtjzsl;		// 单体建筑数量（栋）
	private String jzgd;		// 建筑高度24m以上的单体建筑数量（m）
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

	public IronfopopulationReport() {
		super();
	}

	public IronfopopulationReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="总建筑面积（m2）", align=2, sort=8)
	public String getZjzmj() {
		return zjzmj;
	}

	public void setZjzmj(String zjzmj) {
		this.zjzmj = zjzmj;
	}
	@ExcelField(title="地下建筑面积（m2）", align=2, sort=9)
	public String getDxjzmj() {
		return dxjzmj;
	}

	public void setDxjzmj(String dxjzmj) {
		this.dxjzmj = dxjzmj;
	}
	@ExcelField(title="单体建筑数量（栋）", align=2, sort=10)
	public String getDtjzsl() {
		return dtjzsl;
	}

	public void setDtjzsl(String dtjzsl) {
		this.dtjzsl = dtjzsl;
	}
	@ExcelField(title="建筑高度24m以上的单体建筑数量（m）", align=2, sort=11)
	public String getJzgd() {
		return jzgd;
	}

	public void setJzgd(String jzgd) {
		this.jzgd = jzgd;
	}

}