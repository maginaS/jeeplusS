/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationexperience.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 4.3信息化系统使用体验Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoinformationexperience extends DataEntity<Ironfoinformationexperience> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String bjxty;		// 便捷性体验
	private String gnxty;		// 功能性体验
	private String ggxty;		// 观感性体验
	
	public Ironfoinformationexperience() {
		super();
	}

	public Ironfoinformationexperience(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getBjxty() {
		
		return bjxty;
	}

	public void setBjxty(String bjxty) {
		this.bjxty = bjxty;
	}

	public String getGnxty() {
		
		return gnxty;
	}

	public void setGnxty(String gnxty) {
		this.gnxty = gnxty;
	}

	public String getGgxty() {
		
		return ggxty;
	}

	public void setGgxty(String ggxty) {
		this.ggxty = ggxty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
//	@ExcelField(title="便捷性体验", align=2, sort=8)
//	public String getExperience_bjxty() {
//		return experience_bjxty;
//	}
//
//	public void setExperience_bjxty(String experience_bjxty) {
//		this.experience_bjxty = experience_bjxty;
//	}
//	
//	@ExcelField(title="功能性体验", align=2, sort=9)
//	public String getExperience_gnxty() {
//		return experience_gnxty;
//	}
//
//	public void setExperience_gnxty(String experience_gnxty) {
//		this.experience_gnxty = experience_gnxty;
//	}
//	
//	@ExcelField(title="观感性体验", align=2, sort=10)
//	public String getExperience_ggxty() {
//		return experience_ggxty;
//	}
//
//	public void setExperience_ggxty(String experience_ggxty) {
//		this.experience_ggxty = experience_ggxty;
//	}
	
}