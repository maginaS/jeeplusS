/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 中医科Entity
 * @author anti_magina
 * @version 2018-04-20
 */
public class IronfoyjbylsbpzzykReport extends DataEntity<IronfoyjbylsbpzzykReport> {
	
	private static final long serialVersionUID = 1L;
	private String docId;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String rusynf;		// 投入使用年份
	
	@ExcelField(title="用户", align=2, sort=7)
	private String duserName;
	
	public String getDuserName() {
		duserName = duser.getName();
		return duserName;
	}

	public void setDuserName(String duserName) {
		this.duserName = duserName;
	}

	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfoyjbylsbpzzykReport() {
		super();
	}

	public IronfoyjbylsbpzzykReport(String id){
		super(id);
	}
	@ExcelField(title="投入使用年份", align=2, sort=13)
	public String getRusynf() {
		return rusynf;
	}

	public void setRusynf(String rusynf) {
		this.rusynf = rusynf;
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

	@ExcelField(title="设备名称", align=2, sort=8)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	//@ExcelField(title="主表id", align=2, sort=7)
	
//	public String getDoc_id() {
//		return doc_id;
//	}
//
//	public void setDoc_id(String doc_id) {
//		this.doc_id = doc_id;
//	}
	
	@ExcelField(title="品牌", align=2, sort=9)
	public String getPp() {
		return pp;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}
	@ExcelField(title="型号", align=2, sort=10)
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
	@ExcelField(title="数量（台/个）", align=2, sort=11)
	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}
	@ExcelField(title="设备价格（元）", align=2, sort=12)
	public String getSbjg() {
		return sbjg;
	}

	public void setSbjg(String sbjg) {
		this.sbjg = sbjg;
	}
	
}