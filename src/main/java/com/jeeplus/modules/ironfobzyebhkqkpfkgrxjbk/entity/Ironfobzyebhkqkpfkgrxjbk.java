/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.7其它临床科室病种Entity
 * @author mikesun
 * @version 2018-04-21
 */
public class Ironfobzyebhkqkpfkgrxjbk extends DataEntity<Ironfobzyebhkqkpfkgrxjbk> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String yebhjbbz;		// 眼耳鼻喉基本病种
	private String yebhtjbz;		// 眼耳鼻喉推荐病种
	private String yebhtext;		// 眼耳鼻喉添加
	
	private String yebhtjbztext;
	
	private String kqkjbbz;		// 口腔科基本病种
	private String kqktjbz;		// 口腔科推荐病种
	private String kqktext;		// 口腔科添加
	
	private String kqktjbztext;
	
	private String pfkjbbz;		// 皮肤科基本病种
	private String pfktjbz;		// 皮肤科推荐病种
	private String pfktext;		// 皮肤科添加
	
	private String pfktjbztext;
	
	private String grxjbkjbbz;		// 感染性疾病科基本病种
	private String grxjbktjbz;		// 感染性疾病科推荐病种
	private String grxjbktext;		// 感染性疾病科添加
	
	private String grxjbktjbztext;
	
	
	
	
	
	public String getYebhtjbztext() {
		return yebhtjbztext;
	}

	public void setYebhtjbztext(String yebhtjbztext) {
		this.yebhtjbztext = yebhtjbztext;
	}

	public String getKqktjbztext() {
		return kqktjbztext;
	}

	public void setKqktjbztext(String kqktjbztext) {
		this.kqktjbztext = kqktjbztext;
	}

	public String getPfktjbztext() {
		return pfktjbztext;
	}

	public void setPfktjbztext(String pfktjbztext) {
		this.pfktjbztext = pfktjbztext;
	}

	public String getGrxjbktjbztext() {
		return grxjbktjbztext;
	}

	public void setGrxjbktjbztext(String grxjbktjbztext) {
		this.grxjbktjbztext = grxjbktjbztext;
	}

	public Ironfobzyebhkqkpfkgrxjbk() {
		super();
	}

	public Ironfobzyebhkqkpfkgrxjbk(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="眼耳鼻喉基本病种", align=2, sort=8)
	public String getYebhjbbz() {
		return yebhjbbz;
	}

	public void setYebhjbbz(String yebhjbbz) {
		this.yebhjbbz = yebhjbbz;
	}
	
	@ExcelField(title="眼耳鼻喉推荐病种", align=2, sort=9)
	public String getYebhtjbz() {
		return yebhtjbz;
	}

	public void setYebhtjbz(String yebhtjbz) {
		this.yebhtjbz = yebhtjbz;
	}
	
	@ExcelField(title="眼耳鼻喉添加", align=2, sort=10)
	public String getYebhtext() {
		return yebhtext;
	}

	public void setYebhtext(String yebhtext) {
		this.yebhtext = yebhtext;
	}
	
	@ExcelField(title="口腔科基本病种", align=2, sort=11)
	public String getKqkjbbz() {
		return kqkjbbz;
	}

	public void setKqkjbbz(String kqkjbbz) {
		this.kqkjbbz = kqkjbbz;
	}
	
	@ExcelField(title="口腔科推荐病种", align=2, sort=12)
	public String getKqktjbz() {
		return kqktjbz;
	}

	public void setKqktjbz(String kqktjbz) {
		this.kqktjbz = kqktjbz;
	}
	
	@ExcelField(title="口腔科添加", align=2, sort=13)
	public String getKqktext() {
		return kqktext;
	}

	public void setKqktext(String kqktext) {
		this.kqktext = kqktext;
	}
	
	@ExcelField(title="皮肤科基本病种", align=2, sort=14)
	public String getPfkjbbz() {
		return pfkjbbz;
	}

	public void setPfkjbbz(String pfkjbbz) {
		this.pfkjbbz = pfkjbbz;
	}
	
	@ExcelField(title="皮肤科推荐病种", align=2, sort=15)
	public String getPfktjbz() {
		return pfktjbz;
	}

	public void setPfktjbz(String pfktjbz) {
		this.pfktjbz = pfktjbz;
	}
	
	@ExcelField(title="皮肤科添加", align=2, sort=16)
	public String getPfktext() {
		return pfktext;
	}

	public void setPfktext(String pfktext) {
		this.pfktext = pfktext;
	}
	
	@ExcelField(title="感染性疾病科基本病种", align=2, sort=17)
	public String getGrxjbkjbbz() {
		return grxjbkjbbz;
	}

	public void setGrxjbkjbbz(String grxjbkjbbz) {
		this.grxjbkjbbz = grxjbkjbbz;
	}
	
	@ExcelField(title="感染性疾病科推荐病种", align=2, sort=18)
	public String getGrxjbktjbz() {
		return grxjbktjbz;
	}

	public void setGrxjbktjbz(String grxjbktjbz) {
		this.grxjbktjbz = grxjbktjbz;
	}
	
	@ExcelField(title="感染性疾病科添加", align=2, sort=19)
	public String getGrxjbktext() {
		return grxjbktext;
	}

	public void setGrxjbktext(String grxjbktext) {
		this.grxjbktext = grxjbktext;
	}
	
}