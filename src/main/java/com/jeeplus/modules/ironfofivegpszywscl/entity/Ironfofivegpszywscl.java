/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszywscl.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 污水处理Entity
 * @author mikesun
 * @version 2018-04-16
 */
public class Ironfofivegpszywscl extends DataEntity<Ironfofivegpszywscl> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String wffl;		// 污废分流
	private String hfc;		// 化粪池
	private String clz;		// 处理站
	private String szjc;		// 水质监测
	
	public Ironfofivegpszywscl() {
		super();
	}

	public Ironfofivegpszywscl(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="污废分流", dictType="", align=2, sort=8)
	public String getWffl() {
		
		return wffl;
	}

	public void setWffl(String wffl) {
		this.wffl = wffl;
	}
	
	@ExcelField(title="化粪池", dictType="", align=2, sort=9)
	public String getHfc() {
		
		return hfc;
	}

	public void setHfc(String hfc) {
		this.hfc = hfc;
	}
	
	@ExcelField(title="处理站", dictType="", align=2, sort=10)
	public String getClz() {
		
		return clz;
	}

	public void setClz(String clz) {
		this.clz = clz;
	}
	
	@ExcelField(title="水质监测", dictType="", align=2, sort=11)
	public String getSzjc() {
		
		return szjc;
	}

	public void setSzjc(String szjc) {
		this.szjc = szjc;
	}
	
}