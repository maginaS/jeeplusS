/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoqtkspz.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 3.6其他科室医疗设备配置Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoqtkspz extends DataEntity<Ironfoqtkspz> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	
	
	public Ironfoqtkspz() {
		super();
	}

	public Ironfoqtkspz(String id){
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
//	public String getQtkspz_sbmc() {
//		return qtkspz_sbmc;
//	}
//
//	public void setQtkspz_sbmc(String qtkspz_sbmc) {
//		this.qtkspz_sbmc = qtkspz_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getQtkspz_pp() {
//		return qtkspz_pp;
//	}
//
//	public void setQtkspz_pp(String qtkspz_pp) {
//		this.qtkspz_pp = qtkspz_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getQtkspz_xh() {
//		return qtkspz_xh;
//	}
//
//	public void setQtkspz_xh(String qtkspz_xh) {
//		this.qtkspz_xh = qtkspz_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getQtkspz_sl() {
//		return qtkspz_sl;
//	}
//
//	public void setQtkspz_sl(String qtkspz_sl) {
//		this.qtkspz_sl = qtkspz_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getQtkspz_sbjg() {
//		return qtkspz_sbjg;
//	}
//
//	public void setQtkspz_sbjg(String qtkspz_sbjg) {
//		this.qtkspz_sbjg = qtkspz_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getQtkspz_trsynf() {
//		return qtkspz_trsynf;
//	}
//
//	public void setQtkspz_trsynf(String qtkspz_trsynf) {
//		this.qtkspz_trsynf = qtkspz_trsynf;
//	}
	
}