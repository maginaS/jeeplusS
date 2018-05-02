/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_departmentreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.4科室设置Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfodepartmentzybReport extends DataEntity<IronfodepartmentzybReport> {
	
	private static final long serialVersionUID = 1L;
	private String ptbq;		// 普通病区
	private String kfbq;		// 康复病区
	private String lzghk;		// 临终关怀科
	private String tj_remarks;		// 添加
	private String dep_id;		// 主表id
	
	
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
	public IronfodepartmentzybReport() {
		super();
	}

	public IronfodepartmentzybReport(String id){
		super(id);
	}

	@ExcelField(title="普通病区", dictType="", align=2, sort=7)
	public String getPtbq() {
		return ptbq;
	}

	public void setPtbq(String ptbq) {
		this.ptbq = ptbq;
	}
	
	@ExcelField(title="康复病区", dictType="", align=2, sort=8)
	public String getKfbq() {
		return kfbq;
	}

	public void setKfbq(String kfbq) {
		this.kfbq = kfbq;
	}
	
	@ExcelField(title="临终关怀科", dictType="", align=2, sort=9)
	public String getLzghk() {
		return lzghk;
	}

	public void setLzghk(String lzghk) {
		this.lzghk = lzghk;
	}
	
	@ExcelField(title="添加", align=2, sort=10)
	public String getTj_remarks() {
		return tj_remarks;
	}

	public void setTj_remarks(String tj_remarks) {
		this.tj_remarks = tj_remarks;
	}
	
	@ExcelField(title="主表id", align=2, sort=11)
	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
}