/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulationf.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5.1.2建筑分布概况Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfopopulationf extends DataEntity<Ironfopopulationf> {
	
	private static final long serialVersionUID = 1L;
	private String jzmc;		// 建筑名称
	private String jzgn;		// 建筑功能
	private String dscs;		// 地上层数
	private String dxcs;		// 地下层数
	private String trsysj;		// 投入使用时间
	private String docid;		// 主表id
	
	
	
	public Ironfopopulationf() {
		super();
	}

	public Ironfopopulationf(String id){
		super(id);
	}
	
	
	

//	@ExcelField(title="建筑名称", align=2, sort=7)
//	public String getPopulationf_jzmc() {
//		return populationf_jzmc;
//	}
//
//	public void setPopulationf_jzmc(String populationf_jzmc) {
//		this.populationf_jzmc = populationf_jzmc;
//	}
//	
//	@ExcelField(title="建筑功能", align=2, sort=8)
//	public String getPopulationf_jzgn() {
//		return populationf_jzgn;
//	}
//
//	public void setPopulationf_jzgn(String populationf_jzgn) {
//		this.populationf_jzgn = populationf_jzgn;
//	}
//	
//	@ExcelField(title="地上层数", align=2, sort=9)
//	public String getPopulationf_dscs() {
//		return populationf_dscs;
//	}
//
//	public void setPopulationf_dscs(String populationf_dscs) {
//		this.populationf_dscs = populationf_dscs;
//	}
//	
//	@ExcelField(title="地下层数", align=2, sort=10)
//	public String getPopulationf_dxcs() {
//		return populationf_dxcs;
//	}
//
//	public void setPopulationf_dxcs(String populationf_dxcs) {
//		this.populationf_dxcs = populationf_dxcs;
//	}
//	
//	@ExcelField(title="投入使用时间", align=2, sort=11)
//	public String getPopulationf_trsysj() {
//		return populationf_trsysj;
//	}
//
//	public void setPopulationf_trsysj(String populationf_trsysj) {
//		this.populationf_trsysj = populationf_trsysj;
//	}
	
	@ExcelField(title="建筑名称", align=2, sort=7)
	public String getJzmc() {
		return jzmc;
	}

	public void setJzmc(String jzmc) {
		this.jzmc = jzmc;
	}

	@ExcelField(title="建筑功能", align=2, sort=8)
	public String getJzgn() {
		return jzgn;
	}

	public void setJzgn(String jzgn) {
		this.jzgn = jzgn;
	}

	@ExcelField(title="地上层数", align=2, sort=9)
	public String getDscs() {
		return dscs;
	}

	public void setDscs(String dscs) {
		this.dscs = dscs;
	}

	@ExcelField(title="地下层数", align=2, sort=10)
	public String getDxcs() {
		return dxcs;
	}

	public void setDxcs(String dxcs) {
		this.dxcs = dxcs;
	}

	@ExcelField(title="投入使用时间", align=2, sort=11)
	public String getTrsysj() {
		return trsysj;
	}

	public void setTrsysj(String trsysj) {
		this.trsysj = trsysj;
	}

	@ExcelField(title="主表id", align=2, sort=12)
	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	
	
//	public String getDoc_id() {
//		return doc_id;
//	}
//
//	public void setDoc_id(String doc_id) {
//		this.doc_id = doc_id;
//	}
	
}