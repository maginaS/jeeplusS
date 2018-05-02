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
public class Ironfoinformationsxjkdagl extends DataEntity<Ironfoinformationsxjkdagl> {
	
	private static final long serialVersionUID = 1L;
	private String sx_id;		// 4.2信息化系统功能实现表id
	private String jmjkdaglfw;		// 居民健康档案管理服务
	private String jmjkkglfw;		// 居民健康卡管理服务
	private String jtjkdaglfw;		// 家庭健康档案管理服务
	private String doc_id;		// 主表id
	
	public Ironfoinformationsxjkdagl() {
		super();
	}

	public Ironfoinformationsxjkdagl(String id){
		super(id);
	}

	@ExcelField(title="4.2信息化系统功能实现表id", align=2, sort=7)
	public String getSx_id() {
		return sx_id;
	}

	public void setSx_id(String sx_id) {
		this.sx_id = sx_id;
	}
	
	@ExcelField(title="居民健康档案管理服务", dictType="", align=2, sort=8)
	public String getJmjkdaglfw() {
		return jmjkdaglfw;
	}

	public void setJmjkdaglfw(String jmjkdaglfw) {
		this.jmjkdaglfw = jmjkdaglfw;
	}
	
	@ExcelField(title="居民健康卡管理服务", dictType="", align=2, sort=9)
	public String getJmjkkglfw() {
		return jmjkkglfw;
	}

	public void setJmjkkglfw(String jmjkkglfw) {
		this.jmjkkglfw = jmjkkglfw;
	}
	
	@ExcelField(title="家庭健康档案管理服务", dictType="", align=2, sort=10)
	public String getJtjkdaglfw() {
		return jtjkdaglfw;
	}

	public void setJtjkdaglfw(String jtjkdaglfw) {
		this.jtjkdaglfw = jtjkdaglfw;
	}
	
	@ExcelField(title="主表id", align=2, sort=11)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}