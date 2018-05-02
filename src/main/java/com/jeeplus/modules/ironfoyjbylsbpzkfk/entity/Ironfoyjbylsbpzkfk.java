/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzkfk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 康复科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzkfk extends DataEntity<Ironfoyjbylsbpzkfk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzkfk() {
		super();
	}

	public Ironfoyjbylsbpzkfk(String id){
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
//	public String getKfk_sbmc() {
//		return kfk_sbmc;
//	}
//
//	public void setKfk_sbmc(String kfk_sbmc) {
//		this.kfk_sbmc = kfk_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getKfk_pp() {
//		return kfk_pp;
//	}
//
//	public void setKfk_pp(String kfk_pp) {
//		this.kfk_pp = kfk_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getKfk_xh() {
//		return kfk_xh;
//	}
//
//	public void setKfk_xh(String kfk_xh) {
//		this.kfk_xh = kfk_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getKfk_sl() {
//		return kfk_sl;
//	}
//
//	public void setKfk_sl(String kfk_sl) {
//		this.kfk_sl = kfk_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getKfk_sbjg() {
//		return kfk_sbjg;
//	}
//
//	public void setKfk_sbjg(String kfk_sbjg) {
//		this.kfk_sbjg = kfk_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getKfk_trsynf() {
//		return kfk_trsynf;
//	}
//
//	public void setKfk_trsynf(String kfk_trsynf) {
//		this.kfk_trsynf = kfk_trsynf;
//	}
	
}