/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzxdgys.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 消毒供应室Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoyjbylsbpzxdgys extends DataEntity<Ironfoyjbylsbpzxdgys> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoyjbylsbpzxdgys() {
		super();
	}

	public Ironfoyjbylsbpzxdgys(String id){
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
//	public String getXdgys_sbmc() {
//		return xdgys_sbmc;
//	}
//
//	public void setXdgys_sbmc(String xdgys_sbmc) {
//		this.xdgys_sbmc = xdgys_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getXdgys_pp() {
//		return xdgys_pp;
//	}
//
//	public void setXdgys_pp(String xdgys_pp) {
//		this.xdgys_pp = xdgys_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getXdgys_xh() {
//		return xdgys_xh;
//	}
//
//	public void setXdgys_xh(String xdgys_xh) {
//		this.xdgys_xh = xdgys_xh;
//	}
//	
//	@ExcelField(title="数量（台/个", align=2, sort=11)
//	public String getXdgys_sl() {
//		return xdgys_sl;
//	}
//
//	public void setXdgys_sl(String xdgys_sl) {
//		this.xdgys_sl = xdgys_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getXdgys_sbjg() {
//		return xdgys_sbjg;
//	}
//
//	public void setXdgys_sbjg(String xdgys_sbjg) {
//		this.xdgys_sbjg = xdgys_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getXdgys_trsynf() {
//		return xdgys_trsynf;
//	}
//
//	public void setXdgys_trsynf(String xdgys_trsynf) {
//		this.xdgys_trsynf = xdgys_trsynf;
//	}
	
}