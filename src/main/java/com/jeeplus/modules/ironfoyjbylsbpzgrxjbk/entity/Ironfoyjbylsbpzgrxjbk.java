/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 感染性疾病科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzgrxjbk extends DataEntity<Ironfoyjbylsbpzgrxjbk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzgrxjbk() {
		super();
	}

	public Ironfoyjbylsbpzgrxjbk(String id){
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
//	public String getGrxjbk_sbmc() {
//		return grxjbk_sbmc;
//	}
//
//	public void setGrxjbk_sbmc(String grxjbk_sbmc) {
//		this.grxjbk_sbmc = grxjbk_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getGrxjbk_pp() {
//		return grxjbk_pp;
//	}
//
//	public void setGrxjbk_pp(String grxjbk_pp) {
//		this.grxjbk_pp = grxjbk_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getGrxjbk_xh() {
//		return grxjbk_xh;
//	}
//
//	public void setGrxjbk_xh(String grxjbk_xh) {
//		this.grxjbk_xh = grxjbk_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getGrxjbk_sl() {
//		return grxjbk_sl;
//	}
//
//	public void setGrxjbk_sl(String grxjbk_sl) {
//		this.grxjbk_sl = grxjbk_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getGrxjbk_sbjg() {
//		return grxjbk_sbjg;
//	}
//
//	public void setGrxjbk_sbjg(String grxjbk_sbjg) {
//		this.grxjbk_sbjg = grxjbk_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getGrxjbk_trsynf() {
//		return grxjbk_trsynf;
//	}
//
//	public void setGrxjbk_trsynf(String grxjbk_trsynf) {
//		this.grxjbk_trsynf = grxjbk_trsynf;
//	}
	
}