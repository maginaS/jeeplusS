/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.paytype.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 支付方式Entity
 * @author 瞿高青
 * @version 2017-11-08
 */
public class PayType extends DataEntity<PayType> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 支付编号
	private String name;		// 支付方式名称
	
	public PayType() {
		super();
	}

	public PayType(String id){
		super(id);
	}

	@ExcelField(title="支付编号", align=2, sort=7)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@ExcelField(title="支付方式名称", align=2, sort=8)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}