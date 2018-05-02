/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivesssgl.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5.4手术室Entity
 * @author mikesun
 * @version 2018-04-08
 */
public class Ironfofivesssgl extends DataEntity<Ironfofivesssgl> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String Ajjjsss;		// Ⅰ级洁净手术室（间）
	private String Bjjjsss;		// Ⅱ级洁净手术室（间）
	private String Cjjjsss;		// Ⅲ级洁净手术室（间）
	private String Djjjsss;		// Ⅳ级洁净手术室（间）
	private String Fjjjsss;		// 一般手术室（间）
	
	public Ironfofivesssgl() {
		super();
	}

	public Ironfofivesssgl(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="Ⅰ级洁净手术室（间）", align=2, sort=8)
	public String getAjjjsss() {
		return Ajjjsss;
	}

	public void setAjjjsss(String Ajjjsss) {
		this.Ajjjsss = Ajjjsss;
	}
	
	@ExcelField(title="Ⅱ级洁净手术室（间）", align=2, sort=9)
	public String getBjjjsss() {
		return Bjjjsss;
	}

	public void setBjjjsss(String Bjjjsss) {
		this.Bjjjsss = Bjjjsss;
	}
	
	@ExcelField(title="Ⅲ级洁净手术室（间）", align=2, sort=10)
	public String getCjjjsss() {
		return Cjjjsss;
	}

	public void setCjjjsss(String Cjjjsss) {
		this.Cjjjsss = Cjjjsss;
	}
	
	@ExcelField(title="Ⅳ级洁净手术室（间）", align=2, sort=11)
	public String getDjjjsss() {
		return Djjjsss;
	}

	public void setDjjjsss(String Djjjsss) {
		this.Djjjsss = Djjjsss;
	}
	
	@ExcelField(title="一般手术室（间）", align=2, sort=12)
	public String getFjjjsss() {
		return Fjjjsss;
	}

	public void setFjjjsss(String Fjjjsss) {
		this.Fjjjsss = Fjjjsss;
	}
	
}