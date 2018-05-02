/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationsxreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.2信息化系统功能实现Entity
 * @author anti_magina
 * @version 2018-04-24
 */
public class IronfoinformationsxjkxxfwReport extends DataEntity<IronfoinformationsxjkxxfwReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String se_id;		//  4.2信息化系统功能实现id
	private String jkdacxfw;		// 健康档案查询服务
	private String jkxxfbglfw;		// 健康信息发布管理服务
	private String wsyyhtxfw;		// 网上预约和提醒服务
	private String jkjyxxfw;		// 健康教育信息服务
	
	public IronfoinformationsxjkxxfwReport() {
		super();
	}

	public IronfoinformationsxjkxxfwReport(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title=" 4.2信息化系统功能实现id", align=2, sort=8)
	public String getSe_id() {
		return se_id;
	}

	public void setSe_id(String se_id) {
		this.se_id = se_id;
	}
	
	@ExcelField(title="健康档案查询服务", dictType="", align=2, sort=9)
	public String getJkdacxfw() {
		return jkdacxfw;
	}

	public void setJkdacxfw(String jkdacxfw) {
		this.jkdacxfw = jkdacxfw;
	}
	
	@ExcelField(title="健康信息发布管理服务", dictType="", align=2, sort=10)
	public String getJkxxfbglfw() {
		return jkxxfbglfw;
	}

	public void setJkxxfbglfw(String jkxxfbglfw) {
		this.jkxxfbglfw = jkxxfbglfw;
	}
	
	@ExcelField(title="网上预约和提醒服务", dictType="", align=2, sort=11)
	public String getWsyyhtxfw() {
		return wsyyhtxfw;
	}

	public void setWsyyhtxfw(String wsyyhtxfw) {
		this.wsyyhtxfw = wsyyhtxfw;
	}
	
	@ExcelField(title="健康教育信息服务", dictType="", align=2, sort=12)
	public String getJkjyxxfw() {
		return jkjyxxfw;
	}

	public void setJkjyxxfw(String jkjyxxfw) {
		this.jkjyxxfw = jkjyxxfw;
	}
	
}