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
public class IronfodepartmentjhsybReport extends DataEntity<IronfodepartmentjhsybReport> {
	
	private static final long serialVersionUID = 1L;
	private String jhsyk;		// 计划生育科
	private String tj_remark;		// 添加
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
	
	public IronfodepartmentjhsybReport() {
		super();
	}

	public IronfodepartmentjhsybReport(String id){
		super(id);
	}

	@ExcelField(title="计划生育科", dictType="", align=2, sort=7)
	public String getJhsyk() {
		return jhsyk;
	}

	public void setJhsyk(String jhsyk) {
		this.jhsyk = jhsyk;
	}
	
	@ExcelField(title="添加", align=2, sort=8)
	public String getTj_remark() {
		return tj_remark;
	}

	public void setTj_remark(String tj_remark) {
		this.tj_remark = tj_remark;
	}
	
	@ExcelField(title="主表id", align=2, sort=9)
	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
}