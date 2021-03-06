/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 外科、妇（产）科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzwkfck extends DataEntity<Ironfoyjbylsbpzwkfck> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzwkfck() {
		super();
	}

	public Ironfoyjbylsbpzwkfck(String id){
		super(id);
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getSbjg() {
		return sbjg;
	}

	public void setSbjg(String sbjg) {
		this.sbjg = sbjg;
	}

	public String getTrsynf() {
		return trsynf;
	}

	public void setTrsynf(String trsynf) {
		this.trsynf = trsynf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

//	@ExcelField(title="主表id", align=2, sort=7)
//	public String getWkfck_doc_id() {
//		return wkfck_doc_id;
//	}
//
//	public void setWkfck_doc_id(String wkfck_doc_id) {
//		this.wkfck_doc_id = wkfck_doc_id;
//	}
//	
//	@ExcelField(title="设备名称", align=2, sort=8)
//	public String getWkfck_sbmc() {
//		return wkfck_sbmc;
//	}
//
//	public void setWkfck_sbmc(String wkfck_sbmc) {
//		this.wkfck_sbmc = wkfck_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getWkfck_pp() {
//		return wkfck_pp;
//	}
//
//	public void setWkfck_pp(String wkfck_pp) {
//		this.wkfck_pp = wkfck_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getWkfck_xh() {
//		return wkfck_xh;
//	}
//
//	public void setWkfck_xh(String wkfck_xh) {
//		this.wkfck_xh = wkfck_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getWkfck_sl() {
//		return wkfck_sl;
//	}
//
//	public void setWkfck_sl(String wkfck_sl) {
//		this.wkfck_sl = wkfck_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getWkfck_sbjg() {
//		return wkfck_sbjg;
//	}
//
//	public void setWkfck_sbjg(String wkfck_sbjg) {
//		this.wkfck_sbjg = wkfck_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getWkfck_trsynf() {
//		return wkfck_trsynf;
//	}
//
//	public void setWkfck_trsynf(String wkfck_trsynf) {
//		this.wkfck_trsynf = wkfck_trsynf;
//	}
//	
}