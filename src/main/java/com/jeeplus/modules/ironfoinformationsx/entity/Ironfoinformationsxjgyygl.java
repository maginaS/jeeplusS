/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.2信息化系统功能实现Entity
 * @author mikesun
 * @version 2018-04-08
 */
public class Ironfoinformationsxjgyygl extends DataEntity<Ironfoinformationsxjgyygl> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String se_id;		// 4.2信息化系统功能实现id
	private String jbywglfw;		// 基本药物管理服务
	private String yfglfw;		// 药房管理服务
	private String ykglfw;		// 药库管理服务
	private String wzglfw;		// 物资管理服务
	private String sbglfw;		// 设备管理服务
	private String cwglfw;		// 财务管理服务
	private String grxxkhfw;		// 个人绩效考核服务
	private String jgxykhfw;		// 机构绩效考核服务
	private String tjfxyzhcxfw;		// 统计分析与综合查询服务
	private String ygglfw;		// 院感管理服务
	private String ylfwglfw;		// 医疗废物管理服务
	private String xdgyglfw;		// 消毒供应管理服务
	
	public Ironfoinformationsxjgyygl() {
		super();
	}

	public Ironfoinformationsxjgyygl(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="4.2信息化系统功能实现id", align=2, sort=8)
	public String getSe_id() {
		return se_id;
	}

	public void setSe_id(String se_id) {
		this.se_id = se_id;
	}
	
	@ExcelField(title="基本药物管理服务", dictType="", align=2, sort=9)
	public String getJbywglfw() {
		return jbywglfw;
	}

	public void setJbywglfw(String jbywglfw) {
		this.jbywglfw = jbywglfw;
	}
	
	@ExcelField(title="药房管理服务", dictType="", align=2, sort=10)
	public String getYfglfw() {
		return yfglfw;
	}

	public void setYfglfw(String yfglfw) {
		this.yfglfw = yfglfw;
	}
	
	@ExcelField(title="药库管理服务", dictType="", align=2, sort=11)
	public String getYkglfw() {
		return ykglfw;
	}

	public void setYkglfw(String ykglfw) {
		this.ykglfw = ykglfw;
	}
	
	@ExcelField(title="物资管理服务", dictType="", align=2, sort=12)
	public String getWzglfw() {
		return wzglfw;
	}

	public void setWzglfw(String wzglfw) {
		this.wzglfw = wzglfw;
	}
	
	@ExcelField(title="设备管理服务", dictType="", align=2, sort=13)
	public String getSbglfw() {
		return sbglfw;
	}

	public void setSbglfw(String sbglfw) {
		this.sbglfw = sbglfw;
	}
	
	@ExcelField(title="财务管理服务", dictType="", align=2, sort=14)
	public String getCwglfw() {
		return cwglfw;
	}

	public void setCwglfw(String cwglfw) {
		this.cwglfw = cwglfw;
	}
	
	@ExcelField(title="个人绩效考核服务", dictType="", align=2, sort=15)
	public String getGrxxkhfw() {
		return grxxkhfw;
	}

	public void setGrxxkhfw(String grxxkhfw) {
		this.grxxkhfw = grxxkhfw;
	}
	
	@ExcelField(title="机构绩效考核服务", dictType="", align=2, sort=16)
	public String getJgxykhfw() {
		return jgxykhfw;
	}

	public void setJgxykhfw(String jgxykhfw) {
		this.jgxykhfw = jgxykhfw;
	}
	
	@ExcelField(title="统计分析与综合查询服务", dictType="", align=2, sort=17)
	public String getTjfxyzhcxfw() {
		return tjfxyzhcxfw;
	}

	public void setTjfxyzhcxfw(String tjfxyzhcxfw) {
		this.tjfxyzhcxfw = tjfxyzhcxfw;
	}
	
	@ExcelField(title="院感管理服务", dictType="", align=2, sort=18)
	public String getYgglfw() {
		return ygglfw;
	}

	public void setYgglfw(String ygglfw) {
		this.ygglfw = ygglfw;
	}
	
	@ExcelField(title="医疗废物管理服务", dictType="", align=2, sort=19)
	public String getYlfwglfw() {
		return ylfwglfw;
	}

	public void setYlfwglfw(String ylfwglfw) {
		this.ylfwglfw = ylfwglfw;
	}
	
	@ExcelField(title="消毒供应管理服务", dictType="", align=2, sort=20)
	public String getXdgyglfw() {
		return xdgyglfw;
	}

	public void setXdgyglfw(String xdgyglfw) {
		this.xdgyglfw = xdgyglfw;
	}
	
}