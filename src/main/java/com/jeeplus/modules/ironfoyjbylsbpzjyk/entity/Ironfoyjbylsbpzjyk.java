/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzjyk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 检验科Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzjyk extends DataEntity<Ironfoyjbylsbpzjyk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzjyk() {
		super();
	}

	public Ironfoyjbylsbpzjyk(String id){
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
	
	
	
	
	
//	@ExcelField(title="设备名称", align=2, sort=8)
//	public String getJyk_sbmc() {
//		return jyk_sbmc;
//	}
//
//	public void setJyk_sbmc(String jyk_sbmc) {
//		this.jyk_sbmc = jyk_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getJyk_pp() {
//		return jyk_pp;
//	}
//
//	public void setJyk_pp(String jyk_pp) {
//		this.jyk_pp = jyk_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getJyk_xh() {
//		return jyk_xh;
//	}
//
//	public void setJyk_xh(String jyk_xh) {
//		this.jyk_xh = jyk_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getJyk_sl() {
//		return jyk_sl;
//	}
//
//	public void setJyk_sl(String jyk_sl) {
//		this.jyk_sl = jyk_sl;
//	}
//	
//	@ExcelField(title="设备价格（元", align=2, sort=12)
//	public String getJyk_sbjg() {
//		return jyk_sbjg;
//	}
//
//	public void setJyk_sbjg(String jyk_sbjg) {
//		this.jyk_sbjg = jyk_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getJyk_trsynf() {
//		return jyk_trsynf;
//	}
//
//	public void setJyk_trsynf(String jyk_trsynf) {
//		this.jyk_trsynf = jyk_trsynf;
//	}
	
}