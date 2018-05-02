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
public class Ironfoinformationsxjgjk extends DataEntity<Ironfoinformationsxjgjk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String se_id;		//  4.2信息化系统功能实现id
	private String jbggwsfwjgjk;		// 基本公共卫生服务监管接口
	private String jbylfwjgjk;		// 基本医疗服务监管接口
	private String jbywjgjk;		// 基本药物监管接口
	private String xnhbcjgjk;		// 新农合补偿监管接口
	
	public Ironfoinformationsxjgjk() {
		super();
	}

	public Ironfoinformationsxjgjk(String id){
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
	
	@ExcelField(title="基本公共卫生服务监管接口", dictType="", align=2, sort=9)
	public String getJbggwsfwjgjk() {
		return jbggwsfwjgjk;
	}

	public void setJbggwsfwjgjk(String jbggwsfwjgjk) {
		this.jbggwsfwjgjk = jbggwsfwjgjk;
	}
	
	@ExcelField(title="基本医疗服务监管接口", dictType="", align=2, sort=10)
	public String getJbylfwjgjk() {
		return jbylfwjgjk;
	}

	public void setJbylfwjgjk(String jbylfwjgjk) {
		this.jbylfwjgjk = jbylfwjgjk;
	}
	
	@ExcelField(title="基本药物监管接口", dictType="", align=2, sort=11)
	public String getJbywjgjk() {
		return jbywjgjk;
	}

	public void setJbywjgjk(String jbywjgjk) {
		this.jbywjgjk = jbywjgjk;
	}
	
	@ExcelField(title="新农合补偿监管接口", dictType="", align=2, sort=12)
	public String getXnhbcjgjk() {
		return xnhbcjgjk;
	}

	public void setXnhbcjgjk(String xnhbcjgjk) {
		this.xnhbcjgjk = xnhbcjgjk;
	}
	
}