/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.4科室设置Entity
 * @author mikesun
 * @version 2018-03-16
 */
public class Ironfodepartmentznglb extends DataEntity<Ironfodepartmentznglb> {
	
	private static final long serialVersionUID = 1L;
	private String yzbgs;		// 院长办公室
	private String djbgs;		// 党建办公室
	private String ywk;		// 医务科
	private String hlk;		// 护理科
	private String cwk;		// 财务科
	private String daglk;		// 档案管理科
	private String xxzx;		// 信息中心
	private String ygk;		// 院感科
	private String ybjsk;		// 医保结算科
	private String hqglk;		// 后勤管理科
	private String tjremarks;		// 添加
	private String dep_id;		// 主表id
	private String doc_id;
	
	
	
	
	
	
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public Ironfodepartmentznglb() {
		super();
	}

	public Ironfodepartmentznglb(String id){
		super(id);
	}

	@ExcelField(title="院长办公室", dictType="", align=2, sort=7)
	public String getYzbgs() {
		return yzbgs;
	}

	public void setYzbgs(String yzbgs) {
		this.yzbgs = yzbgs;
	}
	
	@ExcelField(title="党建办公室", dictType="", align=2, sort=8)
	public String getDjbgs() {
		return djbgs;
	}

	public void setDjbgs(String djbgs) {
		this.djbgs = djbgs;
	}
	
	@ExcelField(title="医务科", dictType="", align=2, sort=9)
	public String getYwk() {
		return ywk;
	}

	public void setYwk(String ywk) {
		this.ywk = ywk;
	}
	
	@ExcelField(title="护理科", dictType="", align=2, sort=10)
	public String getHlk() {
		return hlk;
	}

	public void setHlk(String hlk) {
		this.hlk = hlk;
	}
	
	@ExcelField(title="财务科", dictType="", align=2, sort=11)
	public String getCwk() {
		return cwk;
	}

	public void setCwk(String cwk) {
		this.cwk = cwk;
	}
	
	@ExcelField(title="档案管理科", dictType="", align=2, sort=12)
	public String getDaglk() {
		return daglk;
	}

	public void setDaglk(String daglk) {
		this.daglk = daglk;
	}
	
	@ExcelField(title="信息中心", dictType="", align=2, sort=13)
	public String getXxzx() {
		return xxzx;
	}

	public void setXxzx(String xxzx) {
		this.xxzx = xxzx;
	}
	
	@ExcelField(title="院感科", dictType="", align=2, sort=14)
	public String getYgk() {
		return ygk;
	}

	public void setYgk(String ygk) {
		this.ygk = ygk;
	}
	
	@ExcelField(title="医保结算科", dictType="", align=2, sort=15)
	public String getYbjsk() {
		return ybjsk;
	}

	public void setYbjsk(String ybjsk) {
		this.ybjsk = ybjsk;
	}
	
	@ExcelField(title="后勤管理科", dictType="", align=2, sort=16)
	public String getHqglk() {
		return hqglk;
	}

	public void setHqglk(String hqglk) {
		this.hqglk = hqglk;
	}
	
	
	
	
//	@ExcelField(title="添加", dictType="", align=2, sort=17)
//	public String getTj_remarks() {
//		return tj_remarks;
//	}
//
//	public void setTj_remarks(String tj_remarks) {
//		this.tj_remarks = tj_remarks;
//	}
	
	
	@ExcelField(title="添加", dictType="", align=2, sort=17)
	public String getTjremarks() {
		return tjremarks;
	}

	public void setTjremarks(String tjremarks) {
		this.tjremarks = tjremarks;
	}

	@ExcelField(title="主表id", dictType="", align=2, sort=18)
	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
}