/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.2信息化系统功能实现Entity
 * @author mikesun
 * @version 2018-04-08
 */
public class Ironfoinformationsx extends DataEntity<Ironfoinformationsx> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String xxhxtgndy;		// 信息化系统功能单元
	private List<Ironfoinformationsxjbggwsfw> ironfoinformationsxjbggwsfwList = Lists.newArrayList();		// 子表列表
	private List<Ironfoinformationsxjbylfw> ironfoinformationsxjbylfwList = Lists.newArrayList();		// 子表列表
	private List<Ironfoinformationsxjgjk> ironfoinformationsxjgjkList = Lists.newArrayList();		// 子表列表
	private List<Ironfoinformationsxjgyygl> ironfoinformationsxjgyyglList = Lists.newArrayList();		// 子表列表
	private List<Ironfoinformationsxjkdagl> ironfoinformationsxjkdaglList = Lists.newArrayList();		// 子表列表
	private List<Ironfoinformationsxjkxxfw> ironfoinformationsxjkxxfwList = Lists.newArrayList();		// 子表列表
	
	public Ironfoinformationsx() {
		super();
	}

	public Ironfoinformationsx(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="信息化系统功能单元", align=2, sort=8)
	public String getXxhxtgndy() {
		return xxhxtgndy;
	}

	public void setXxhxtgndy(String xxhxtgndy) {
		this.xxhxtgndy = xxhxtgndy;
	}
	
	public List<Ironfoinformationsxjbggwsfw> getIronfoinformationsxjbggwsfwList() {
		return ironfoinformationsxjbggwsfwList;
	}

	public void setIronfoinformationsxjbggwsfwList(List<Ironfoinformationsxjbggwsfw> ironfoinformationsxjbggwsfwList) {
		this.ironfoinformationsxjbggwsfwList = ironfoinformationsxjbggwsfwList;
	}
	public List<Ironfoinformationsxjbylfw> getIronfoinformationsxjbylfwList() {
		return ironfoinformationsxjbylfwList;
	}

	public void setIronfoinformationsxjbylfwList(List<Ironfoinformationsxjbylfw> ironfoinformationsxjbylfwList) {
		this.ironfoinformationsxjbylfwList = ironfoinformationsxjbylfwList;
	}
	public List<Ironfoinformationsxjgjk> getIronfoinformationsxjgjkList() {
		return ironfoinformationsxjgjkList;
	}

	public void setIronfoinformationsxjgjkList(List<Ironfoinformationsxjgjk> ironfoinformationsxjgjkList) {
		this.ironfoinformationsxjgjkList = ironfoinformationsxjgjkList;
	}
	public List<Ironfoinformationsxjgyygl> getIronfoinformationsxjgyyglList() {
		return ironfoinformationsxjgyyglList;
	}

	public void setIronfoinformationsxjgyyglList(List<Ironfoinformationsxjgyygl> ironfoinformationsxjgyyglList) {
		this.ironfoinformationsxjgyyglList = ironfoinformationsxjgyyglList;
	}
	public List<Ironfoinformationsxjkdagl> getIronfoinformationsxjkdaglList() {
		return ironfoinformationsxjkdaglList;
	}

	public void setIronfoinformationsxjkdaglList(List<Ironfoinformationsxjkdagl> ironfoinformationsxjkdaglList) {
		this.ironfoinformationsxjkdaglList = ironfoinformationsxjkdaglList;
	}
	public List<Ironfoinformationsxjkxxfw> getIronfoinformationsxjkxxfwList() {
		return ironfoinformationsxjkxxfwList;
	}

	public void setIronfoinformationsxjkxxfwList(List<Ironfoinformationsxjkxxfw> ironfoinformationsxjkxxfwList) {
		this.ironfoinformationsxjkxxfwList = ironfoinformationsxjkxxfwList;
	}
}