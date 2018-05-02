/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszygssy.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;
import com.jeeplus.modules.report.utils.CheckBoxStatusName;

/**
 * 给水水源Entity
 * @author mikesun
 * @version 2018-04-16
 */
public class Ironfofivegpszygssy extends DataEntity<Ironfofivegpszygssy> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String szgw;		// 市政管网
	private String sjzq;		// 水井自取
	//private CheckBoxName checkBoxName = CheckBoxName.class.newInstance();
	
	public Ironfofivegpszygssy() {
		super();
	}

	public Ironfofivegpszygssy(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="市政管网", dictType="", align=2, sort=8)
	public String getSzgw() {
//		if(szgw.equals(CheckBoxStatusName.CHECKNO.getValue())){
//			szgw = CheckBoxStatusName.CHECKNO.getText();
//		}else if(szgw.equals(CheckBoxStatusName.CHECKNO.getValue())){
//			szgw = CheckBoxStatusName.CHECKYES.getText();
//		}else{
//			szgw = "";
//		}
		//szgw = Class.forName("CheckBoxName").getClassLoader().newInstance().changeName(szgw);
		
		return szgw;
	}
	
	public void setSzgw(String szgw) {
		this.szgw = szgw;
	}
	
	@ExcelField(title="水井自取", dictType="", align=2, sort=9)
	public String getSjzq() {
		
		return sjzq;
	}

	public void setSjzq(String sjzq) {
		this.sjzq = sjzq;
	}
	
	
}