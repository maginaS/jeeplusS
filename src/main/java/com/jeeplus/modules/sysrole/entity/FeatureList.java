/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 角色管理Entity
 * @author 瞿高青
 * @version 2017-11-02
 */
public class FeatureList extends DataEntity<FeatureList> {
	
	private static final long serialVersionUID = 1L;
	private String bar_id;		// 菜单表的外键id
	private String name;		// 功能名称
	
	public FeatureList() {
		super();
	}

	public FeatureList(String id){
		super(id);
	}

	@ExcelField(title="菜单表的外键id", align=2, sort=7)
	public String getBar_id() {
		return bar_id;
	}

	public void setBar_id(String bar_id) {
		this.bar_id = bar_id;
	}
	
	@ExcelField(title="功能名称", align=2, sort=8)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}