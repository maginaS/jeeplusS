/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoggwsylsbpz.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 3.4公共卫生部医疗设备配置Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoggwsylsbpz extends DataEntity<Ironfoggwsylsbpz> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String sbmc;		// 设备名称
	private String pp;		// 品牌
	private String xh;		// 型号
	private String sl;		// 数量（台/个）
	private String sbjg;		// 设备价格（元）
	private String trsynf;		// 投入使用年份
	
	public Ironfoggwsylsbpz() {
		super();
	}

	public Ironfoggwsylsbpz(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="设备名称", align=2, sort=8)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	@ExcelField(title="品牌", align=2, sort=9)
	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}
	@ExcelField(title="型号", align=2, sort=10)
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
	@ExcelField(title="数量（台/个）", align=2, sort=11)
	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}
	@ExcelField(title="设备价格（元）", align=2, sort=12)
	public String getSbjg() {
		return sbjg;
	}

	public void setSbjg(String sbjg) {
		this.sbjg = sbjg;
	}
	@ExcelField(title="投入使用年份", align=2, sort=13)
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
//	public String getGgwsylsbpz_sbmc() {
//		return ggwsylsbpz_sbmc;
//	}
//
//	public void setGgwsylsbpz_sbmc(String ggwsylsbpz_sbmc) {
//		this.ggwsylsbpz_sbmc = ggwsylsbpz_sbmc;
//	}
//	
//	@ExcelField(title="品牌", align=2, sort=9)
//	public String getGgwsylsbpz_pp() {
//		return ggwsylsbpz_pp;
//	}
//
//	public void setGgwsylsbpz_pp(String ggwsylsbpz_pp) {
//		this.ggwsylsbpz_pp = ggwsylsbpz_pp;
//	}
//	
//	@ExcelField(title="型号", align=2, sort=10)
//	public String getGgwsylsbpz_xh() {
//		return ggwsylsbpz_xh;
//	}
//
//	public void setGgwsylsbpz_xh(String ggwsylsbpz_xh) {
//		this.ggwsylsbpz_xh = ggwsylsbpz_xh;
//	}
//	
//	@ExcelField(title="数量（台/个）", align=2, sort=11)
//	public String getGgwsylsbpz_sl() {
//		return ggwsylsbpz_sl;
//	}
//
//	public void setGgwsylsbpz_sl(String ggwsylsbpz_sl) {
//		this.ggwsylsbpz_sl = ggwsylsbpz_sl;
//	}
//	
//	@ExcelField(title="设备价格（元）", align=2, sort=12)
//	public String getGgwsylsbpz_sbjg() {
//		return ggwsylsbpz_sbjg;
//	}
//
//	public void setGgwsylsbpz_sbjg(String ggwsylsbpz_sbjg) {
//		this.ggwsylsbpz_sbjg = ggwsylsbpz_sbjg;
//	}
//	
//	@ExcelField(title="投入使用年份", align=2, sort=13)
//	public String getGgwsylsbpz_trsynf() {
//		return ggwsylsbpz_trsynf;
//	}
//
//	public void setGgwsylsbpz_trsynf(String ggwsylsbpz_trsynf) {
//		this.ggwsylsbpz_trsynf = ggwsylsbpz_trsynf;
//	}
//	
}