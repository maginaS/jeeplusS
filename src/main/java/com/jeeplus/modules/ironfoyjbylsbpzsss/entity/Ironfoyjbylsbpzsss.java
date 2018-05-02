/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzsss.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 手术室Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzsss extends DataEntity<Ironfoyjbylsbpzsss> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzsss() {
		super();
	}

	public Ironfoyjbylsbpzsss(String id){
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
	
	
	

//	@ExcelField(title="主表", align=2, sort=7)
//	public String getDoc_id() {
//		return doc_id;
//	}
//
//	public void setDoc_id(String doc_id) {
//		this.doc_id = doc_id;
//	}
//	
//	@ExcelField(title="设备名称", align=2, sort=8)
//	public String getSss_sbmc() {
//		return sss_sbmc;
//	}
//
//	public void setSss_sbmc(String sss_sbmc) {
//		this.sss_sbmc = sss_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getSss_pp() {
//		return sss_pp;
//	}
//
//	public void setSss_pp(String sss_pp) {
//		this.sss_pp = sss_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getSss_xh() {
//		return sss_xh;
//	}
//
//	public void setSss_xh(String sss_xh) {
//		this.sss_xh = sss_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getSss_sl() {
//		return sss_sl;
//	}
//
//	public void setSss_sl(String sss_sl) {
//		this.sss_sl = sss_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getSss_sbjg() {
//		return sss_sbjg;
//	}
//
//	public void setSss_sbjg(String sss_sbjg) {
//		this.sss_sbjg = sss_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getSss_trsynf() {
//		return sss_trsynf;
//	}
//
//	public void setSss_trsynf(String sss_trsynf) {
//		this.sss_trsynf = sss_trsynf;
//	}
	
}