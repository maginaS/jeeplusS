/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzlx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * ironfobzlxEntity
 * @author mikesun
 * @version 2018-03-19
 */
public class Ironfobzlx extends DataEntity<Ironfobzlx> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 病种名称
	private String type;		// 病种分类
	private String bztype;
	
	private String No;
	
	
	
	
	public Ironfobzlx() {
		super();
	}

	public Ironfobzlx(String id){
		super(id);
	}

	
	
	
	
	
	
	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	@ExcelField(title="病种名称", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="病种分类", align=2, sort=8)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBztype() {
		return bztype;
	}

	public void setBztype(String bztype) {
		this.bztype = bztype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}