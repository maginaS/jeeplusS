/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivejhsyyfreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.6计划生育用房Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivejhsyyfReport extends DataEntity<IronfofivejhsyyfReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private String zs;		// 诊室
	private String jcs;		// 检查室
	private String qtqzm;		// 其它（请注明）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public IronfofivejhsyyfReport() {
		super();
	}

	public IronfofivejhsyyfReport(String id){
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

	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=8)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}
	
	@ExcelField(title="诊室", dictType="", align=2, sort=9)
	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}
	
	@ExcelField(title="检查室", dictType="", align=2, sort=10)
	public String getJcs() {
		return jcs;
	}

	public void setJcs(String jcs) {
		this.jcs = jcs;
	}
	
	@ExcelField(title="其它（请注明）", align=2, sort=11)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}