/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformaintainreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 4.4系统维护人员Entity
 * @author anti_magina
 * @version 2018-04-20
 */
public class IronfoinformationmaintainReport extends DataEntity<IronfoinformationmaintainReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String ryzc;		// 人员职称
	private String whcd;		// 文化程度
	private String sxzy;		// 所学专业
	private String xggznx;		// 现岗工作年限
	private String rypz;		// 人员配置
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfoinformationmaintainReport() {
		super();
	}

	public IronfoinformationmaintainReport(String id){
		super(id);
	}
	
	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="人员职称", align=2, sort=8)
	public String getRyzc() {
		return ryzc;
	}

	public void setRyzc(String ryzc) {
		this.ryzc = ryzc;
	}
	@ExcelField(title="文化程度", align=2, sort=9)
	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	@ExcelField(title="所学专业", align=2, sort=10)
	public String getSxzy() {
		return sxzy;
	}

	public void setSxzy(String sxzy) {
		this.sxzy = sxzy;
	}
	@ExcelField(title="现岗工作年限", align=2, sort=11)
	public String getXggznx() {
		return xggznx;
	}

	public void setXggznx(String xggznx) {
		this.xggznx = xggznx;
	}
	@ExcelField(title="人员配置", align=2, sort=12)
	public String getRypz() {
		return rypz;
	}

	public void setRypz(String rypz) {
		this.rypz = rypz;
	}

	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}

	public IronfoDocTitle getIronfoDocTitle() {
		return ironfoDocTitle;
	}

	public void setIronfoDocTitle(IronfoDocTitle ironfoDocTitle) {
		this.ironfoDocTitle = ironfoDocTitle;
	}
	
}