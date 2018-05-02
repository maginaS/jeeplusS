/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfozyb.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 3.3住院部医疗设备配置Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfozyb extends DataEntity<Ironfozyb> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
//	private String isnull;  //是否配置
	
	
	
	
//	
//	public String getIsnull() {
//		return isnull;
//	}
//
//	public void setIsnull(String isnull) {
//		this.isnull = isnull;
//	}

	public Ironfozyb() {
		super();
	}

	public Ironfozyb(String id){
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
//	public String getZyb_sbmc() {
//		return zyb_sbmc;
//	}
//
//	public void setZyb_sbmc(String zyb_sbmc) {
//		this.zyb_sbmc = zyb_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getZyb_pp() {
//		return zyb_pp;
//	}
//
//	public void setZyb_pp(String zyb_pp) {
//		this.zyb_pp = zyb_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getZyb_xh() {
//		return zyb_xh;
//	}
//
//	public void setZyb_xh(String zyb_xh) {
//		this.zyb_xh = zyb_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getZyb_sl() {
//		return zyb_sl;
//	}
//
//	public void setZyb_sl(String zyb_sl) {
//		this.zyb_sl = zyb_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getZyb_sbjg() {
//		return zyb_sbjg;
//	}
//
//	public void setZyb_sbjg(String zyb_sbjg) {
//		this.zyb_sbjg = zyb_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getZyb_trsynf() {
//		return zyb_trsynf;
//	}
//
//	public void setZyb_trsynf(String zyb_trsynf) {
//		this.zyb_trsynf = zyb_trsynf;
//	}
	
}