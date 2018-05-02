/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.employee.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 员工管理Entity
 * @author mikesun
 * @version 2017-10-12
 */
public class Employee extends DataEntity<Employee> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String loginname;		// 登录名或手机号码
	private String loginpwd;		// 登录密码
	private String org_id;		// 所属组织 组织表外键id
	private String email;		// 邮箱
	
	public Employee() {
		super();
	}

	public Employee(String id){
		super(id);
	}

	@ExcelField(title="姓名", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="登录名或手机号码", align=2, sort=8)
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@ExcelField(title="登录密码", align=2, sort=9)
	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	@ExcelField(title="所属组织 组织表外键id", align=2, sort=10)
	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	
	@ExcelField(title="邮箱", align=2, sort=11)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}