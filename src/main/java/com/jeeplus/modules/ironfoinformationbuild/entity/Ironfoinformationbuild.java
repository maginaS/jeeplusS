/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationbuild.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.1信息化系统建设情况Entity
 * @author mikesun
 * @version 2018-03-22
 */
public class Ironfoinformationbuild extends DataEntity<Ironfoinformationbuild> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String rjmc;		// 软件名称
	private String csmc;		// 厂商名称
	private String rjzj;		// 软件造价（元）
	private String trsysj;		// 投入使用时间
	private String xtbsfs;		// 系统部署方式
	private String xtgnsx;		// 系统功能实现
	
	public Ironfoinformationbuild() {
		super();
	}

	public Ironfoinformationbuild(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getRjmc() {
		return rjmc;
	}

	public void setRjmc(String rjmc) {
		this.rjmc = rjmc;
	}

	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}

	public String getRjzj() {
		return rjzj;
	}

	public void setRjzj(String rjzj) {
		this.rjzj = rjzj;
	}

	public String getTrsysj() {
		return trsysj;
	}

	public void setTrsysj(String trsysj) {
		this.trsysj = trsysj;
	}

	public String getXtbsfs() {
		return xtbsfs;
	}

	public void setXtbsfs(String xtbsfs) {
		this.xtbsfs = xtbsfs;
	}

	public String getXtgnsx() {
		return xtgnsx;
	}

	public void setXtgnsx(String xtgnsx) {
		this.xtgnsx = xtgnsx;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
//	@ExcelField(title="软件名称", align=2, sort=8)
//	public String getBuild_rjmc() {
//		return build_rjmc;
//	}
//
//	public void setBuild_rjmc(String build_rjmc) {
//		this.build_rjmc = build_rjmc;
//	}
//	
//	@ExcelField(title="厂商名称", align=2, sort=9)
//	public String getBuild_csmc() {
//		return build_csmc;
//	}
//
//	public void setBuild_csmc(String build_csmc) {
//		this.build_csmc = build_csmc;
//	}
//	
//	@ExcelField(title="软件造价（元）", align=2, sort=10)
//	public String getBuild_rjzj() {
//		return build_rjzj;
//	}
//
//	public void setBuild_rjzj(String build_rjzj) {
//		this.build_rjzj = build_rjzj;
//	}
//	
//	@ExcelField(title="投入使用时间", align=2, sort=11)
//	public String getBuild_trsysj() {
//		return build_trsysj;
//	}
//
//	public void setBuild_trsysj(String build_trsysj) {
//		this.build_trsysj = build_trsysj;
//	}
//	
//	@ExcelField(title="系统部署方式", align=2, sort=12)
//	public String getBuild_xtbsfs() {
//		return build_xtbsfs;
//	}
//
//	public void setBuild_xtbsfs(String build_xtbsfs) {
//		this.build_xtbsfs = build_xtbsfs;
//	}
//	
//	@ExcelField(title="系统功能实现", align=2, sort=13)
//	public String getBuild_xtgnsx() {
//		return build_xtgnsx;
//	}
//
//	public void setBuild_xtgnsx(String build_xtgnsx) {
//		this.build_xtgnsx = build_xtgnsx;
//	}
	
}