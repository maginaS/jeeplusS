/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.statistics.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 会员统计Entity
 * @author 瞿高青
 * @version 2017-10-17
 */
public class Member extends DataEntity<Member> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 会员用户名
	private String phone;		// 会员手机号
	private String pwd;		// 会员密码
	private String gender;		// 会员性别
	private String head;		// 会员头像路径
	private String real_name;		// 会员真实姓名
	private String level_id;		// 会员等级表id
	private String name_ID;		// 会员身份证号
	private String status;		// 会员状态
	
	public Member() {
		super();
	}

	public Member(String id){
		super(id);
	}

	@ExcelField(title="会员用户名", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="会员手机号", align=2, sort=8)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@ExcelField(title="会员密码", align=2, sort=9)
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@ExcelField(title="会员性别", align=2, sort=10)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@ExcelField(title="会员头像路径", align=2, sort=11)
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	
	@ExcelField(title="会员真实姓名", align=2, sort=12)
	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	
	@ExcelField(title="会员等级表id", align=2, sort=13)
	public String getLevel_id() {
		return level_id;
	}

	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	
	@ExcelField(title="会员身份证号", align=2, sort=14)
	public String getName_ID() {
		return name_ID;
	}

	public void setName_ID(String name_ID) {
		this.name_ID = name_ID;
	}
	
	@ExcelField(title="会员状态", align=2, sort=15)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}