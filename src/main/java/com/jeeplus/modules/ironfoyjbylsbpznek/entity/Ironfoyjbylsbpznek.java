/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpznek.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 内（儿）科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpznek extends DataEntity<Ironfoyjbylsbpznek> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpznek() {
		super();
	}

	public Ironfoyjbylsbpznek(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
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
	
	
	
	
	
//	@ExcelField(title="设备名称", align=2, sort=8)
//	public String getNek_sbmc() {
//		return nek_sbmc;
//	}
//
//	public void setNek_sbmc(String nek_sbmc) {
//		this.nek_sbmc = nek_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getNek_pp() {
//		return nek_pp;
//	}
//
//	public void setNek_pp(String nek_pp) {
//		this.nek_pp = nek_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getNek_xh() {
//		return nek_xh;
//	}
//
//	public void setNek_xh(String nek_xh) {
//		this.nek_xh = nek_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getNek_sl() {
//		return nek_sl;
//	}
//
//	public void setNek_sl(String nek_sl) {
//		this.nek_sl = nek_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getNek_sbjg() {
//		return nek_sbjg;
//	}
//
//	public void setNek_sbjg(String nek_sbjg) {
//		this.nek_sbjg = nek_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getNek_trsynf() {
//		return nek_trsynf;
//	}
//
//	public void setNek_trsynf(String nek_trsynf) {
//		this.nek_trsynf = nek_trsynf;
//	}
	
}