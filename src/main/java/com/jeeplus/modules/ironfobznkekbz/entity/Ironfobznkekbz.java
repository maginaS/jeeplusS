/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobznkekbz.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.5内科、儿科病种Entity
 * @author mikesun
 * @version 2018-04-18
 */
public class Ironfobznkekbz extends DataEntity<Ironfobznkekbz> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String bztype;		// 病种存储
	
	private String ektjbz;
	private String ekjbbz;
	private String nktjbz;
	private String nkjbbz;
	
	private String nkjbbzText;
	private String nktjbzText;
	private String ekjbbzText;
	private String ektjbzText;
	
	
	
	
	
	
	
	public String getNkjbbzText() {
		return nkjbbzText;
	}

	public void setNkjbbzText(String nkjbbzText) {
		this.nkjbbzText = nkjbbzText;
	}

	public String getNktjbzText() {
		return nktjbzText;
	}

	public void setNktjbzText(String nktjbzText) {
		this.nktjbzText = nktjbzText;
	}

	public String getEkjbbzText() {
		return ekjbbzText;
	}

	public void setEkjbbzText(String ekjbbzText) {
		this.ekjbbzText = ekjbbzText;
	}

	public String getEktjbzText() {
		return ektjbzText;
	}

	public void setEktjbzText(String ektjbzText) {
		this.ektjbzText = ektjbzText;
	}

	public String getEktjbz() {
		return ektjbz;
	}

	public void setEktjbz(String ektjbz) {
		this.ektjbz = ektjbz;
	}

	public String getEkjbbz() {
		return ekjbbz;
	}

	public void setEkjbbz(String ekjbbz) {
		this.ekjbbz = ekjbbz;
	}

	public String getNktjbz() {
		return nktjbz;
	}

	public void setNktjbz(String nktjbz) {
		this.nktjbz = nktjbz;
	}

	public String getNkjbbz() {
		return nkjbbz;
	}

	public void setNkjbbz(String nkjbbz) {
		this.nkjbbz = nkjbbz;
	}

	public Ironfobznkekbz() {
		super();
	}

	public Ironfobznkekbz(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="病种存储", align=2, sort=8)
	public String getBztype() {
		return bztype;
	}

	public void setBztype(String bztype) {
		this.bztype = bztype;
	}
	
}