/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofinance.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.2财务收支Entity
 * @author mikesun
 * @version 2018-03-16
 */
public class Ironfofinance extends DataEntity<Ironfofinance> {
	
	private static final long serialVersionUID = 1L;
	private String ylsr;		// 医疗收入 （千元）
	private String ypsr;		// 药品收入 （千元）
	private String sfbtsr;		// 财政补助收入 （千元）
	private String sjbzsr;		// 上级补助收入 （千元）
	private String qtsr;		// 其它收入 （千元）
	private String zzc;		// 总支出 （千元）
	private String ylzc;		// 医疗支出 （千元）
	private String date;		// 时间
	private String doc_id;		// 主表id
	
	
	private String ylsr1;		// 医疗收入 （千元）
	private String ypsr1;		// 药品收入 （千元）
	private String sfbtsr1;		// 财政补助收入 （千元）
	private String sjbzsr1;		// 上级补助收入 （千元）
	private String qtsr1;		// 其它收入 （千元）
	private String zzc1;		// 总支出 （千元）
	private String ylzc1;		// 医疗支出 （千元）
	private String date1;		// 时间
	private String doc_id1;		// 主表id
	
	private String ylsr2;		// 医疗收入 （千元）
	private String ypsr2;		// 药品收入 （千元）
	private String sfbtsr2;		// 财政补助收入 （千元）
	private String sjbzsr2;		// 上级补助收入 （千元）
	private String qtsr2;		// 其它收入 （千元）
	private String zzc2;		// 总支出 （千元）
	private String ylzc2;		// 医疗支出 （千元）
	private String date2;		// 时间
	private String doc_id2;		// 主表id
	
	
	
	
	
	
	
	
	
	
	public String getYlsr1() {
		return ylsr1;
	}

	public void setYlsr1(String ylsr1) {
		this.ylsr1 = ylsr1;
	}

	public String getYpsr1() {
		return ypsr1;
	}

	public void setYpsr1(String ypsr1) {
		this.ypsr1 = ypsr1;
	}

	public String getSfbtsr1() {
		return sfbtsr1;
	}

	public void setSfbtsr1(String sfbtsr1) {
		this.sfbtsr1 = sfbtsr1;
	}

	public String getSjbzsr1() {
		return sjbzsr1;
	}

	public void setSjbzsr1(String sjbzsr1) {
		this.sjbzsr1 = sjbzsr1;
	}

	public String getQtsr1() {
		return qtsr1;
	}

	public void setQtsr1(String qtsr1) {
		this.qtsr1 = qtsr1;
	}

	public String getZzc1() {
		return zzc1;
	}

	public void setZzc1(String zzc1) {
		this.zzc1 = zzc1;
	}

	public String getYlzc1() {
		return ylzc1;
	}

	public void setYlzc1(String ylzc1) {
		this.ylzc1 = ylzc1;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDoc_id1() {
		return doc_id1;
	}

	public void setDoc_id1(String doc_id1) {
		this.doc_id1 = doc_id1;
	}

	public String getYlsr2() {
		return ylsr2;
	}

	public void setYlsr2(String ylsr2) {
		this.ylsr2 = ylsr2;
	}

	public String getYpsr2() {
		return ypsr2;
	}

	public void setYpsr2(String ypsr2) {
		this.ypsr2 = ypsr2;
	}

	public String getSfbtsr2() {
		return sfbtsr2;
	}

	public void setSfbtsr2(String sfbtsr2) {
		this.sfbtsr2 = sfbtsr2;
	}

	public String getSjbzsr2() {
		return sjbzsr2;
	}

	public void setSjbzsr2(String sjbzsr2) {
		this.sjbzsr2 = sjbzsr2;
	}

	public String getQtsr2() {
		return qtsr2;
	}

	public void setQtsr2(String qtsr2) {
		this.qtsr2 = qtsr2;
	}

	public String getZzc2() {
		return zzc2;
	}

	public void setZzc2(String zzc2) {
		this.zzc2 = zzc2;
	}

	public String getYlzc2() {
		return ylzc2;
	}

	public void setYlzc2(String ylzc2) {
		this.ylzc2 = ylzc2;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDoc_id2() {
		return doc_id2;
	}

	public void setDoc_id2(String doc_id2) {
		this.doc_id2 = doc_id2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ironfofinance() {
		super();
	}

	public Ironfofinance(String id){
		super(id);
	}

	@ExcelField(title="医疗收入 （千元）", align=2, sort=7)
	public String getYlsr() {
		return ylsr;
	}

	public void setYlsr(String ylsr) {
		this.ylsr = ylsr;
	}
	
	@ExcelField(title="药品收入 （千元）", align=2, sort=8)
	public String getYpsr() {
		return ypsr;
	}

	public void setYpsr(String ypsr) {
		this.ypsr = ypsr;
	}
	
	@ExcelField(title="财政补助收入 （千元）", align=2, sort=9)
	public String getSfbtsr() {
		return sfbtsr;
	}

	public void setSfbtsr(String sfbtsr) {
		this.sfbtsr = sfbtsr;
	}
	
	@ExcelField(title="上级补助收入 （千元）", align=2, sort=10)
	public String getSjbzsr() {
		return sjbzsr;
	}

	public void setSjbzsr(String sjbzsr) {
		this.sjbzsr = sjbzsr;
	}
	
	@ExcelField(title="其它收入 （千元）", align=2, sort=11)
	public String getQtsr() {
		return qtsr;
	}

	public void setQtsr(String qtsr) {
		this.qtsr = qtsr;
	}
	
	@ExcelField(title="总支出 （千元）", align=2, sort=12)
	public String getZzc() {
		return zzc;
	}

	public void setZzc(String zzc) {
		this.zzc = zzc;
	}
	
	@ExcelField(title="医疗支出 （千元）", align=2, sort=13)
	public String getYlzc() {
		return ylzc;
	}

	public void setYlzc(String ylzc) {
		this.ylzc = ylzc;
	}
	
	@ExcelField(title="时间", align=2, sort=14)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@ExcelField(title="主表id", align=2, sort=15)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}