/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivefjpz.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5.2房间配置Entity
 * @author mikesun
 * @version 2018-03-23
 */
public class Ironfofivefjlx extends DataEntity<Ironfofivefjlx> {
	
	private static final long serialVersionUID = 1L;
	private String fjpz_id;		// 配置表id
	private String kjlx;		// 空间类型
	
	public Ironfofivefjlx() {
		super();
	}

	public Ironfofivefjlx(String id){
		super(id);
	}

	@ExcelField(title="配置表id", align=2, sort=7)
	public String getFjpz_id() {
		return fjpz_id;
	}

	public void setFjpz_id(String fjpz_id) {
		this.fjpz_id = fjpz_id;
	}
	
	@ExcelField(title="空间类型", dictType="", align=2, sort=8)
	public String getKjlx() {
		return kjlx;
	}

	public void setKjlx(String kjlx) {
		this.kjlx = kjlx;
	}
	
}