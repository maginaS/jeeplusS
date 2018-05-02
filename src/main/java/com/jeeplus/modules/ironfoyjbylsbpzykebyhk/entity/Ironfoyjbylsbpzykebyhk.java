/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzykebyhk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 眼科、耳鼻咽喉科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzykebyhk extends DataEntity<Ironfoyjbylsbpzykebyhk> {
	
	private static final long serialVersionUID = 1L;
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	private String doc_id;		// 主表id
	
	public Ironfoyjbylsbpzykebyhk() {
		super();
	}

	public Ironfoyjbylsbpzykebyhk(String id){
		super(id);
	}
	
	
	

//	@ExcelField(title="设备名称", align=2, sort=7)
//	public String getYkebyhk_sbmc() {
//		return ykebyhk_sbmc;
//	}
//
//	public void setYkebyhk_sbmc(String ykebyhk_sbmc) {
//		this.ykebyhk_sbmc = ykebyhk_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=8)
//	public String getYkebyhk_pp() {
//		return ykebyhk_pp;
//	}
//
//	public void setYkebyhk_pp(String ykebyhk_pp) {
//		this.ykebyhk_pp = ykebyhk_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=9)
//	public String getYkebyhk_xh() {
//		return ykebyhk_xh;
//	}
//
//	public void setYkebyhk_xh(String ykebyhk_xh) {
//		this.ykebyhk_xh = ykebyhk_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=10)
//	public String getYkebyhk_sl() {
//		return ykebyhk_sl;
//	}
//
//	public void setYkebyhk_sl(String ykebyhk_sl) {
//		this.ykebyhk_sl = ykebyhk_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=11)
//	public String getYkebyhk_sbjg() {
//		return ykebyhk_sbjg;
//	}
//
//	public void setYkebyhk_sbjg(String ykebyhk_sbjg) {
//		this.ykebyhk_sbjg = ykebyhk_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=12)
//	public String getYkebyhk_trsynf() {
//		return ykebyhk_trsynf;
//	}
//
//	public void setYkebyhk_trsynf(String ykebyhk_trsynf) {
//		this.ykebyhk_trsynf = ykebyhk_trsynf;
//	}
	
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

	@ExcelField(title="主表id", align=2, sort=13)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}