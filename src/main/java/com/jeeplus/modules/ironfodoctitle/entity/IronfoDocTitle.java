/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfodoctitle.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.sys.entity.User;

/**
 * 1.1乡镇卫生院基本概况Entity
 * @author mikesun
 * @version 2018-03-15
 */
public class IronfoDocTitle extends DataEntity<IronfoDocTitle> {
	
	private static final long serialVersionUID = 1L;
	private String title_name;		// 问卷名称
	
	private User  user;
	
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IronfoDocTitle() {
		super();
	}

	public IronfoDocTitle(String id){
		super(id);
	}

	@ExcelField(title="问卷名称", align=2, sort=7)
	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}
	
}