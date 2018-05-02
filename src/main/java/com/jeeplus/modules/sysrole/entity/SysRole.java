/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.entity;


import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sysrole.entity.FeatureList;

/**
 * 角色管理Entity
 * @author mikesun
 * @version 2017-10-12
 */
public class SysRole extends DataEntity<SysRole> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 角色类型
	private String name;		// 角色名称
	private String explain;		// 角色描述
	private FeatureList feature; //角色功能类
	
	public SysRole() {
		super();
	}

	public SysRole(String id){
		super(id);
	}

	@ExcelField(title="角色类型", align=2, sort=7)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="功能", fieldType=FeatureList.class, value="feature.name", align=2, sort=9)
	public FeatureList getFeature() {
		return feature;
	}

	public void setFeature(FeatureList feature) {
		this.feature = feature;
	}
	
	@ExcelField(title="角色名称", align=2, sort=8)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="角色描述", align=2, sort=9)
	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
}