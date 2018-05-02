/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojhsybylsbpz.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 3.5计划生育部医疗设备配置Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfojhsybylsbpz extends DataEntity<Ironfojhsybylsbpz> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元
	private String trsynf;		// 投入使用年份
	
	public Ironfojhsybylsbpz() {
		super();
	}

	public Ironfojhsybylsbpz(String id){
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
//	public String getJhsybylsbpz_sbmc() {
//		return jhsybylsbpz_sbmc;
//	}
//
//	public void setJhsybylsbpz_sbmc(String jhsybylsbpz_sbmc) {
//		this.jhsybylsbpz_sbmc = jhsybylsbpz_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getJhsybylsbpz_pp() {
//		return jhsybylsbpz_pp;
//	}
//
//	public void setJhsybylsbpz_pp(String jhsybylsbpz_pp) {
//		this.jhsybylsbpz_pp = jhsybylsbpz_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getJhsybylsbpz_xh() {
//		return jhsybylsbpz_xh;
//	}
//
//	public void setJhsybylsbpz_xh(String jhsybylsbpz_xh) {
//		this.jhsybylsbpz_xh = jhsybylsbpz_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getJhsybylsbpz_sl() {
//		return jhsybylsbpz_sl;
//	}
//
//	public void setJhsybylsbpz_sl(String jhsybylsbpz_sl) {
//		this.jhsybylsbpz_sl = jhsybylsbpz_sl;
//	}
//	
//	@ExcelField(title="设备价格（元", align=2, sort=12)
//	public String getJhsybylsbpz_sbjg() {
//		return jhsybylsbpz_sbjg;
//	}
//
//	public void setJhsybylsbpz_sbjg(String jhsybylsbpz_sbjg) {
//		this.jhsybylsbpz_sbjg = jhsybylsbpz_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getJhsybylsbpz_trsynf() {
//		return jhsybylsbpz_trsynf;
//	}
//
//	public void setJhsybylsbpz_trsynf(String jhsybylsbpz_trsynf) {
//		this.jhsybylsbpz_trsynf = jhsybylsbpz_trsynf;
//	}
	
}