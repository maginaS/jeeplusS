/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveswcd.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 5.9室外场地Entity
 * @author mikesun
 * @version 2018-04-15
 */
public class Ironfofiveswcd extends DataEntity<Ironfofiveswcd> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String yhdl;		// 硬化道路
	private String ld;		// 绿地
	private String swtcc;		// 室外停车场
	private String qtqzm;		// 其它（请注明）
	
	public Ironfofiveswcd() {
		super();
	}

	public Ironfofiveswcd(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="硬化道路", dictType="", align=2, sort=8)
	public String getYhdl() {
		return yhdl;
	}

	public void setYhdl(String yhdl) {
		this.yhdl = yhdl;
	}
	
	@ExcelField(title="绿地", dictType="", align=2, sort=9)
	public String getLd() {
		return ld;
	}

	public void setLd(String ld) {
		this.ld = ld;
	}
	
	@ExcelField(title="室外停车场", dictType="", align=2, sort=10)
	public String getSwtcc() {
		return swtcc;
	}

	public void setSwtcc(String swtcc) {
		this.swtcc = swtcc;
	}
	
//	public String getYhdl() {
//		try {
//			yhdl = CheckBoxName.class.newInstance().changeName(yhdl);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return yhdl;
//	}
//
//	public void setYhdl(String yhdl) {
//		this.yhdl = yhdl;
//	}
//
//	public String getLd() {
//		try {
//			ld = CheckBoxName.class.newInstance().changeName(ld);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return ld;
//	}
//
//	public void setLd(String ld) {
//		this.ld = ld;
//	}
//
//	public String getSwtcc() {
//		try {
//			swtcc = CheckBoxName.class.newInstance().changeName(swtcc);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return swtcc;
//	}
//
//	public void setSwtcc(String swtcc) {
//		this.swtcc = swtcc;
//	}

	@ExcelField(title="其它（请注明）", align=2, sort=11)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}