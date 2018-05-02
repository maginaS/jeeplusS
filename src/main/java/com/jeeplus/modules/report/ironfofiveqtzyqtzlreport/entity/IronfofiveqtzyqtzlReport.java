/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 气体种类Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofiveqtzyqtzlReport extends DataEntity<IronfofiveqtzyqtzlReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String yq;		// 氧气
	private String xq;		// 笑气
	private String dq;		// 氮气
	private String eyht;		// 二氧化碳
	private String yskq;		// 压缩空气
	private String fyxy;		// 负压吸引
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfofiveqtzyqtzlReport() {
		super();
	}

	public IronfofiveqtzyqtzlReport(String id){
		super(id);
	}

	////@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}

	public IronfoDocTitle getIronfoDocTitle() {
		return ironfoDocTitle;
	}

	public void setIronfoDocTitle(IronfoDocTitle ironfoDocTitle) {
		this.ironfoDocTitle = ironfoDocTitle;
	}

	@ExcelField(title="氧气", dictType="", align=2, sort=8)
	public String getYq() {
		return yq;
	}

	public void setYq(String yq) {
		this.yq = yq;
	}
	
	@ExcelField(title="笑气", dictType="", align=2, sort=9)
	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}
	
	@ExcelField(title="氮气", dictType="", align=2, sort=10)
	public String getDq() {
		return dq;
	}

	public void setDq(String dq) {
		this.dq = dq;
	}
	
	@ExcelField(title="二氧化碳", dictType="", align=2, sort=11)
	public String getEyht() {
		return eyht;
	}

	public void setEyht(String eyht) {
		this.eyht = eyht;
	}
	
	@ExcelField(title="压缩空气", dictType="", align=2, sort=12)
	public String getYskq() {
		return yskq;
	}

	public void setYskq(String yskq) {
		this.yskq = yskq;
	}
	
	@ExcelField(title="负压吸引", dictType="", align=2, sort=13)
	public String getFyxy() {
		return fyxy;
	}

	public void setFyxy(String fyxy) {
		this.fyxy = fyxy;
	}
	
}