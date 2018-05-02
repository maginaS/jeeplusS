/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzwkfck.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.6外科、妇（产）科病种	Entity
 * @author mikesun
 * @version 2018-04-21
 */
public class Ironfobzwkfck extends DataEntity<Ironfobzwkfck> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String wkfckjbbz;		// 基本病种
	private String wkfcktjbz;		// 推荐病种
	private String wkfckjbbztext;		// 基本病种添加
	private String wkfcktjbztext;		// 推荐病种添加
	
	public Ironfobzwkfck() {
		super();
	}

	public Ironfobzwkfck(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="基本病种", align=2, sort=8)
	public String getWkfckjbbz() {
		return wkfckjbbz;
	}

	public void setWkfckjbbz(String wkfckjbbz) {
		this.wkfckjbbz = wkfckjbbz;
	}
	
	@ExcelField(title="推荐病种", align=2, sort=9)
	public String getWkfcktjbz() {
		return wkfcktjbz;
	}

	public void setWkfcktjbz(String wkfcktjbz) {
		this.wkfcktjbz = wkfcktjbz;
	}
	
	@ExcelField(title="基本病种添加", align=2, sort=10)
	public String getWkfckjbbztext() {
		return wkfckjbbztext;
	}

	public void setWkfckjbbztext(String wkfckjbbztext) {
		this.wkfckjbbztext = wkfckjbbztext;
	}
	
	@ExcelField(title="推荐病种添加", align=2, sort=11)
	public String getWkfcktjbztext() {
		return wkfcktjbztext;
	}

	public void setWkfcktjbztext(String wkfcktjbztext) {
		this.wkfcktjbztext = wkfcktjbztext;
	}
	
}