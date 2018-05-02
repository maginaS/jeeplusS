/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 放射科、超声科、心电图科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzfskcskxdtk extends DataEntity<Ironfoyjbylsbpzfskcskxdtk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzfskcskxdtk() {
		super();
	}

	public Ironfoyjbylsbpzfskcskxdtk(String id){
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
//	public String getFskcskxdtk_sbmc() {
//		return fskcskxdtk_sbmc;
//	}
//
//	public void setFskcskxdtk_sbmc(String fskcskxdtk_sbmc) {
//		this.fskcskxdtk_sbmc = fskcskxdtk_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getFskcskxdtk_pp() {
//		return fskcskxdtk_pp;
//	}
//
//	public void setFskcskxdtk_pp(String fskcskxdtk_pp) {
//		this.fskcskxdtk_pp = fskcskxdtk_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getFskcskxdtk_xh() {
//		return fskcskxdtk_xh;
//	}
//
//	public void setFskcskxdtk_xh(String fskcskxdtk_xh) {
//		this.fskcskxdtk_xh = fskcskxdtk_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getFskcskxdtk_sl() {
//		return fskcskxdtk_sl;
//	}
//
//	public void setFskcskxdtk_sl(String fskcskxdtk_sl) {
//		this.fskcskxdtk_sl = fskcskxdtk_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getFskcskxdtk_sbjg() {
//		return fskcskxdtk_sbjg;
//	}
//
//	public void setFskcskxdtk_sbjg(String fskcskxdtk_sbjg) {
//		this.fskcskxdtk_sbjg = fskcskxdtk_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getFskcskxdtk_trsynf() {
//		return fskcskxdtk_trsynf;
//	}
//
//	public void setFskcskxdtk_trsynf(String fskcskxdtk_trsynf) {
//		this.fskcskxdtk_trsynf = fskcskxdtk_trsynf;
//	}
	
}