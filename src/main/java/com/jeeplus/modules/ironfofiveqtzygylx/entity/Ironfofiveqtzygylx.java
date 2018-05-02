/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzygylx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 供应类型Entity
 * @author mikesun
 * @version 2018-04-17
 */
public class Ironfofiveqtzygylx extends DataEntity<Ironfofiveqtzygylx> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String zygy;		// 中央供应
	private String qpzq;		// 气瓶自取
	
	public Ironfofiveqtzygylx() {
		super();
	}

	public Ironfofiveqtzygylx(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="中央供应", dictType="", align=2, sort=8)
	public String getZygy() {
		
		return zygy;
	}

	public void setZygy(String zygy) {
		this.zygy = zygy;
	}
	
	@ExcelField(title="气瓶自取", dictType="", align=2, sort=9)
	public String getQpzq() {
				return qpzq;
	}

	public void setQpzq(String qpzq) {
		this.qpzq = qpzq;
	}
	
}