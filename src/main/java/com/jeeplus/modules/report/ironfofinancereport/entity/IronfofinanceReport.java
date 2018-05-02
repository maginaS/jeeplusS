/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofinancereport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.2财务收支Entity
 * @author mao
 * @version 2018-04-19
 */
public class IronfofinanceReport extends DataEntity<IronfofinanceReport> {
	
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
	
	private IronfoDocTitle  title;
	private User duser;
	
	
	public IronfoDocTitle getTitle() {
		return title;
	}

	public void setTitle(IronfoDocTitle title) {
		this.title = title;
	}

	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}

	public IronfofinanceReport() {
		super();
	}

	public IronfofinanceReport(String id){
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
	
	//@ExcelField(title="主表id", align=2, sort=15)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}