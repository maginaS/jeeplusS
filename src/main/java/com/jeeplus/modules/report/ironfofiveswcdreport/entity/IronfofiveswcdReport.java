/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveswcdreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.9室外场地Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofiveswcdReport extends DataEntity<IronfofiveswcdReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String yhdl;		// 硬化道路
	private String ld;		// 绿地
	private String swtcc;		// 室外停车场
	private String qtqzm;		// 其它（请注明）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfofiveswcdReport() {
		super();
	}

	public IronfofiveswcdReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
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
	
	@ExcelField(title="其它（请注明）", align=2, sort=11)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}