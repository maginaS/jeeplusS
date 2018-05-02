/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofeatdepartmenttestreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.4.1特色科室Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfofeatdepartmentReport extends DataEntity<IronfofeatdepartmentReport> {
	
	private static final long serialVersionUID = 1L;
	private String tsks;		// 特色科室
	private String nmzrcs;		// 2017年门诊人次数（人次）
	private String ncyrs;		// 2017年出院人数（人）
	private String kssycw;		// 科室实有床位(张)
	private String kszyzlys;		// 科室执业(助理)医师（人）
	private String kszchs;		// 科室注册护士（人）
	private String doc_id;		// 主表id
	
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
	
	public IronfofeatdepartmentReport() {
		super();
	}

	public IronfofeatdepartmentReport(String id){
		super(id);
	}

	@ExcelField(title="特色科室", align=2, sort=7)
	public String getTsks() {
		return tsks;
	}

	public void setTsks(String tsks) {
		this.tsks = tsks;
	}
	
	@ExcelField(title="2017年门诊人次数（人次）", align=2, sort=8)
	public String getNmzrcs() {
		return nmzrcs;
	}

	public void setNmzrcs(String nmzrcs) {
		this.nmzrcs = nmzrcs;
	}
	
	@ExcelField(title="2017年出院人数（人）", align=2, sort=9)
	public String getNcyrs() {
		return ncyrs;
	}

	public void setNcyrs(String ncyrs) {
		this.ncyrs = ncyrs;
	}
	
	@ExcelField(title="科室实有床位(张)", align=2, sort=10)
	public String getKssycw() {
		return kssycw;
	}

	public void setKssycw(String kssycw) {
		this.kssycw = kssycw;
	}
	
	@ExcelField(title="科室执业(助理)医师（人）", align=2, sort=11)
	public String getKszyzlys() {
		return kszyzlys;
	}

	public void setKszyzlys(String kszyzlys) {
		this.kszyzlys = kszyzlys;
	}
	
	@ExcelField(title="科室注册护士（人）", align=2, sort=12)
	public String getKszchs() {
		return kszchs;
	}

	public void setKszchs(String kszchs) {
		this.kszchs = kszchs;
	}
	
	//@ExcelField(title="主表id", align=2, sort=13)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}