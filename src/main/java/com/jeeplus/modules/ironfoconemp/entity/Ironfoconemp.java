/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoconemp.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.7.1职工构成Entity
 * @author mikesun
 * @version 2018-03-21
 */
public class Ironfoconemp extends DataEntity<Ironfoconemp> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String date;		// 时间
	private String zzzgs;		// 在岗职工数（人）
	private String wsjsry;		// 卫生技术人员（人）
	private String qtjsry;		// 其他技术人员（人）
	private String glry;		// 管理人员（人）
	private String gqjnry;		// 工勤技能人员（人）


	private String doc_id1;		// 主表id
	private String date1;		// 时间
	private String zzzgs1;		// 在岗职工数（人）
	private String wsjsry1;		// 卫生技术人员（人）
	private String qtjsry1;		// 其他技术人员（人）
	private String glry1;		// 管理人员（人）
	private String gqjnry1;		// 工勤技能人员（人）
	
	
	private String doc_id2;		// 主表id
	private String date2;		// 时间
	private String zzzgs2;		// 在岗职工数（人）
	private String wsjsry2;		// 卫生技术人员（人）
	private String qtjsry2;		// 其他技术人员（人）
	private String glry2;		// 管理人员（人）
	private String gqjnry2;		// 工勤技能人员（人）
	
	
	
	
	
	
	public String getDoc_id1() {
		return doc_id1;
	}

	public void setDoc_id1(String doc_id1) {
		this.doc_id1 = doc_id1;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getZzzgs1() {
		return zzzgs1;
	}

	public void setZzzgs1(String zzzgs1) {
		this.zzzgs1 = zzzgs1;
	}

	public String getWsjsry1() {
		return wsjsry1;
	}

	public void setWsjsry1(String wsjsry1) {
		this.wsjsry1 = wsjsry1;
	}

	public String getQtjsry1() {
		return qtjsry1;
	}

	public void setQtjsry1(String qtjsry1) {
		this.qtjsry1 = qtjsry1;
	}

	public String getGlry1() {
		return glry1;
	}

	public void setGlry1(String glry1) {
		this.glry1 = glry1;
	}

	public String getGqjnry1() {
		return gqjnry1;
	}

	public void setGqjnry1(String gqjnry1) {
		this.gqjnry1 = gqjnry1;
	}

	public String getDoc_id2() {
		return doc_id2;
	}

	public void setDoc_id2(String doc_id2) {
		this.doc_id2 = doc_id2;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getZzzgs2() {
		return zzzgs2;
	}

	public void setZzzgs2(String zzzgs2) {
		this.zzzgs2 = zzzgs2;
	}

	public String getWsjsry2() {
		return wsjsry2;
	}

	public void setWsjsry2(String wsjsry2) {
		this.wsjsry2 = wsjsry2;
	}

	public String getQtjsry2() {
		return qtjsry2;
	}

	public void setQtjsry2(String qtjsry2) {
		this.qtjsry2 = qtjsry2;
	}

	public String getGlry2() {
		return glry2;
	}

	public void setGlry2(String glry2) {
		this.glry2 = glry2;
	}

	public String getGqjnry2() {
		return gqjnry2;
	}

	public void setGqjnry2(String gqjnry2) {
		this.gqjnry2 = gqjnry2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ironfoconemp() {
		super();
	}

	public Ironfoconemp(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="时间", align=2, sort=8)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@ExcelField(title="在岗职工数（人）", align=2, sort=9)
	public String getZzzgs() {
		return zzzgs;
	}

	public void setZzzgs(String zzzgs) {
		this.zzzgs = zzzgs;
	}
	
	@ExcelField(title="卫生技术人员（人）", align=2, sort=10)
	public String getWsjsry() {
		return wsjsry;
	}

	public void setWsjsry(String wsjsry) {
		this.wsjsry = wsjsry;
	}
	
	@ExcelField(title="其他技术人员（人）", align=2, sort=11)
	public String getQtjsry() {
		return qtjsry;
	}

	public void setQtjsry(String qtjsry) {
		this.qtjsry = qtjsry;
	}
	
	@ExcelField(title="管理人员（人）", align=2, sort=12)
	public String getGlry() {
		return glry;
	}

	public void setGlry(String glry) {
		this.glry = glry;
	}
	
	@ExcelField(title="工勤技能人员（人）", align=2, sort=13)
	public String getGqjnry() {
		return gqjnry;
	}

	public void setGqjnry(String gqjnry) {
		this.gqjnry = gqjnry;
	}
	
}