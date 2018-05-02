/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiventzydjcnreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 冬季采暖Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofiventzydjcnReport extends DataEntity<IronfofiventzydjcnReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String zykt;		// 中央空调
	private String ftkt;		// 分体空调
	private String glcn;		// 锅炉采暖
	private String dzq;		// 电暖气
	private String szrl;		// 市政热力
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public IronfofiventzydjcnReport() {
		super();
	}

	public IronfofiventzydjcnReport(String id){
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

	@ExcelField(title="中央空调", dictType="", align=2, sort=8)
	public String getZykt() {
		return zykt;
	}

	public void setZykt(String zykt) {
		this.zykt = zykt;
	}
	
	@ExcelField(title="分体空调", dictType="", align=2, sort=9)
	public String getFtkt() {
		return ftkt;
	}

	public void setFtkt(String ftkt) {
		this.ftkt = ftkt;
	}
	
	@ExcelField(title="锅炉采暖", dictType="", align=2, sort=10)
	public String getGlcn() {
		return glcn;
	}

	public void setGlcn(String glcn) {
		this.glcn = glcn;
	}
	
	@ExcelField(title="电暖气", dictType="", align=2, sort=11)
	public String getDzq() {
		return dzq;
	}

	public void setDzq(String dzq) {
		this.dzq = dzq;
	}
	
	@ExcelField(title="市政热力", dictType="", align=2, sort=12)
	public String getSzrl() {
		return szrl;
	}

	public void setSzrl(String szrl) {
		this.szrl = szrl;
	}
	
}