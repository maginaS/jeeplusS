/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopopulationfreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.1.2建筑分布概况Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfopopulationfReport extends DataEntity<IronfopopulationfReport> {
	
	private static final long serialVersionUID = 1L;
	private String jzmc;		// 建筑名称
	private String jzgn;		// 建筑功能
	private String dscs;		// 地上层数
	private String dxcs;		// 地下层数
	private String trsysj;		// 投入使用时间
	private String docid;		// 主表id
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
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

	public IronfopopulationfReport() {
		super();
	}

	public IronfopopulationfReport(String id){
		super(id);
	}
	@ExcelField(title="建筑名称", align=2, sort=7)
	public String getJzmc() {
		return jzmc;
	}

	public void setJzmc(String jzmc) {
		this.jzmc = jzmc;
	}
	@ExcelField(title="建筑功能", align=2, sort=8)
	public String getJzgn() {
		return jzgn;
	}

	public void setJzgn(String jzgn) {
		this.jzgn = jzgn;
	}
	@ExcelField(title="地上层数", align=2, sort=9)
	public String getDscs() {
		return dscs;
	}

	public void setDscs(String dscs) {
		this.dscs = dscs;
	}
	@ExcelField(title="地下层数", align=2, sort=10)
	public String getDxcs() {
		return dxcs;
	}

	public void setDxcs(String dxcs) {
		this.dxcs = dxcs;
	}
	@ExcelField(title="投入使用时间", align=2, sort=11)
	public String getTrsysj() {
		return trsysj;
	}

	public void setTrsysj(String trsysj) {
		this.trsysj = trsysj;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	
	//@ExcelField(title="主表id", align=2, sort=12)
	
	
}