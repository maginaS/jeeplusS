/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationbuildreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 4.1信息化系统建设情况Entity
 * @author anti_magina
 * @version 2018-04-20
 */
public class IronfoinformationbuildReport extends DataEntity<IronfoinformationbuildReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String rjmc;		// 软件名称
	private String csmc;		// 厂商名称
	private String rjzj;		// 软件造价（元）
	private String trsysj;		// 投入使用时间
	private String xtbsfs;		// 系统部署方式
	private String xtgnsx;		// 系统功能实现
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfoinformationbuildReport() {
		super();
	}

	public IronfoinformationbuildReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	@ExcelField(title="软件名称", align=2, sort=8)
	public String getRjmc() {
		return rjmc;
	}

	public void setRjmc(String rjmc) {
		this.rjmc = rjmc;
	}
	@ExcelField(title="厂商名称", align=2, sort=9)
	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}
	@ExcelField(title="软件造价（元）", align=2, sort=10)
	public String getRjzj() {
		return rjzj;
	}

	public void setRjzj(String rjzj) {
		this.rjzj = rjzj;
	}
	@ExcelField(title="投入使用时间", align=2, sort=11)
	public String getTrsysj() {
		return trsysj;
	}

	public void setTrsysj(String trsysj) {
		this.trsysj = trsysj;
	}
	@ExcelField(title="系统部署方式", align=2, sort=12)
	public String getXtbsfs() {
		return xtbsfs;
	}

	public void setXtbsfs(String xtbsfs) {
		this.xtbsfs = xtbsfs;
	}
	@ExcelField(title="系统功能实现", align=2, sort=13)
	public String getXtgnsx() {
		return xtgnsx;
	}

	public void setXtgnsx(String xtgnsx) {
		this.xtgnsx = xtgnsx;
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