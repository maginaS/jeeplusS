/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzyjk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 *  药剂科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfo_yjbylsbpz_yjk extends DataEntity<Ironfo_yjbylsbpz_yjk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	//add by anti_magina 
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	private String duserName;
	
	
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
	@ExcelField(title="用户", align=2, sort=6)
	public String getDuserName() {
		duserName = duser.getName();
		return duserName;
	}

	public void setDuserName(String duserName) {
		this.duserName = duserName;
	}

	public Ironfo_yjbylsbpz_yjk() {
		super();
	}

	public Ironfo_yjbylsbpz_yjk(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	//@ExcelField(title="设备名称", align=2, sort=8)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	@ExcelField(title="品牌", align=2, sort=9)
	public String getPp() {
		return pp;
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

	public String getTrsynf() {
		return trsynf;
	}
	@ExcelField(title="投入使用年份", align=2, sort=13)
	public void setTrsynf(String trsynf) {
		this.trsynf = trsynf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}