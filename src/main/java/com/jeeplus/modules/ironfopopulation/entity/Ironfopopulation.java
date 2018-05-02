/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulation.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5.1.1建筑总体概况Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfopopulation extends DataEntity<Ironfopopulation> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String zjzmj;		// 总建筑面积（m2）
	private String dxjzmj;		// 地下建筑面积（m2）
	private String dtjzsl;		// 单体建筑数量（栋）
	private String jzgd;		// 建筑高度24m以上的单体建筑数量（m）
	
	public Ironfopopulation() {
		super();
	}

	public Ironfopopulation(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getZjzmj() {
		return zjzmj;
	}

	public void setZjzmj(String zjzmj) {
		this.zjzmj = zjzmj;
	}

	public String getDxjzmj() {
		return dxjzmj;
	}

	public void setDxjzmj(String dxjzmj) {
		this.dxjzmj = dxjzmj;
	}

	public String getDtjzsl() {
		return dtjzsl;
	}

	public void setDtjzsl(String dtjzsl) {
		this.dtjzsl = dtjzsl;
	}

	public String getJzgd() {
		return jzgd;
	}

	public void setJzgd(String jzgd) {
		this.jzgd = jzgd;
	}

	
	
	
//	@ExcelField(title="总建筑面积（m2）", align=2, sort=8)
//	public String getPopulation_zjzmj() {
//		return population_zjzmj;
//	}
//
//	public void setPopulation_zjzmj(String population_zjzmj) {
//		this.population_zjzmj = population_zjzmj;
//	}
//	
//	@ExcelField(title="地下建筑面积（m2）", align=2, sort=9)
//	public String getPopulation_dxjzmj() {
//		return population_dxjzmj;
//	}
//
//	public void setPopulation_dxjzmj(String population_dxjzmj) {
//		this.population_dxjzmj = population_dxjzmj;
//	}
//	
//	@ExcelField(title="单体建筑数量（栋）", align=2, sort=10)
//	public String getPopulation_dtjzsl() {
//		return population_dtjzsl;
//	}
//
//	public void setPopulation_dtjzsl(String population_dtjzsl) {
//		this.population_dtjzsl = population_dtjzsl;
//	}
//	
//	@ExcelField(title="建筑高度24m以上的单体建筑数量（m）", align=2, sort=11)
//	public String getPopulation_jzgd() {
//		return population_jzgd;
//	}
//
//	public void setPopulation_jzgd(String population_jzgd) {
//		this.population_jzgd = population_jzgd;
//	}
//	
}