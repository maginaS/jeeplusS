/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzzyk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.sys.entity.User;

/**
 * 中医科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzzyk extends DataEntity<Ironfoyjbylsbpzzyk> {
	
	private static final long serialVersionUID = 1L;
	private String docId;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String rusynf;		// 投入使用年份
	
	@ExcelField(title="用户", align=2, sort=6)
	private String duserName;
	
	private User duser;
	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}

	public String getDuserName() {
		duserName = duser.getName();
		return duserName;
	}

	public void setDuserName(String duserName) {
		this.duserName = duserName;
	}
	public Ironfoyjbylsbpzzyk() {
		super();
	}

	public Ironfoyjbylsbpzzyk(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
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
	@ExcelField(title="投入使用年份", align=2, sort=7)
	public String getRusynf() {
		return rusynf;
	}

	public void setRusynf(String rusynf) {
		this.rusynf = rusynf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
//	@ExcelField(title="设备名称", align=2, sort=8)
//	public String getZyk_sbmc() {
//		return zyk_sbmc;
//	}
//
//	public void setZyk_sbmc(String zyk_sbmc) {
//		this.zyk_sbmc = zyk_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getZyk_pp() {
//		return zyk_pp;
//	}
//
//	public void setZyk_pp(String zyk_pp) {
//		this.zyk_pp = zyk_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getZyk_xh() {
//		return zyk_xh;
//	}
//
//	public void setZyk_xh(String zyk_xh) {
//		this.zyk_xh = zyk_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getZyk_sl() {
//		return zyk_sl;
//	}
//
//	public void setZyk_sl(String zyk_sl) {
//		this.zyk_sl = zyk_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getZyk_sbjg() {
//		return zyk_sbjg;
//	}
//
//	public void setZyk_sbjg(String zyk_sbjg) {
//		this.zyk_sbjg = zyk_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getZyk_rusynf() {
//		return zyk_rusynf;
//	}
//
//	public void setZyk_rusynf(String zyk_rusynf) {
//		this.zyk_rusynf = zyk_rusynf;
//	}
	
}