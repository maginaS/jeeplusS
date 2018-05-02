/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_departmentreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.4科室设置Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfodepartmentyjbReport extends DataEntity<IronfodepartmentyjbReport> {
	
	private static final long serialVersionUID = 1L;
	private String dep_id;		// 主表id
	private String yjk;		// 药剂科
	private String jyk;		// 检验科
	private String fsk;		// 放射科
	private String csk;		// 超声科
	private String xdtk;		// 心电图科
	private String xdgys;		// 消毒供应室
	private String sss;		// 手术室
	private String tjremark;		// 添加科室
	
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
	
	public IronfodepartmentyjbReport() {
		super();
	}

	public IronfodepartmentyjbReport(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
	@ExcelField(title="药剂科", dictType="", align=2, sort=8)
	public String getYjk() {
		return yjk;
	}

	public void setYjk(String yjk) {
		this.yjk = yjk;
	}
	
	@ExcelField(title="检验科", dictType="", align=2, sort=9)
	public String getJyk() {
		return jyk;
	}

	public void setJyk(String jyk) {
		this.jyk = jyk;
	}
	
	@ExcelField(title="放射科", dictType="", align=2, sort=10)
	public String getFsk() {
		return fsk;
	}

	public void setFsk(String fsk) {
		this.fsk = fsk;
	}
	
	@ExcelField(title="超声科", dictType="", align=2, sort=11)
	public String getCsk() {
		return csk;
	}

	public void setCsk(String csk) {
		this.csk = csk;
	}
	
	@ExcelField(title="心电图科", dictType="", align=2, sort=12)
	public String getXdtk() {
		return xdtk;
	}

	public void setXdtk(String xdtk) {
		this.xdtk = xdtk;
	}
	
	@ExcelField(title="消毒供应室", dictType="", align=2, sort=13)
	public String getXdgys() {
		return xdgys;
	}

	public void setXdgys(String xdgys) {
		this.xdgys = xdgys;
	}
	
	@ExcelField(title="手术室", dictType="", align=2, sort=14)
	public String getSss() {
		return sss;
	}

	public void setSss(String sss) {
		this.sss = sss;
	}
	
	@ExcelField(title="添加科室", dictType="", align=2, sort=15)
	public String getTjremark() {
		return tjremark;
	}

	public void setTjremark(String tjremark) {
		this.tjremark = tjremark;
	}
	
}