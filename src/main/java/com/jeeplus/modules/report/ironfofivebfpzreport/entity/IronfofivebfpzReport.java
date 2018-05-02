/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivebfpzreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.3病房Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivebfpzReport extends DataEntity<IronfofivebfpzReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String dcj;		// 单床（间）
	private String ecj;		// 2床（间）
	private String scj;		// 3床（间）
	private String fourcj;		// 4床（间）
	private String wcj;		// 5床（间）
	private String lcj;		// 6床（间）
	private String lcysj;		// 6床以上（间）
	private String viptj;		// VIP套间(间)
	private String lzghbfj;		// 临终关怀病房（间）
	private String icuj;		// ICU(间)
	private String nicuj;		// NICU(间)
	private String hszzyzxfwjl;		// 护士站最远直线服务距离（m）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	
	public IronfofivebfpzReport() {
		super();
	}

	public IronfofivebfpzReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
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

	@ExcelField(title="单床（间）", align=2, sort=8)
	public String getDcj() {
		return dcj;
	}

	public void setDcj(String dcj) {
		this.dcj = dcj;
	}
	
	@ExcelField(title="2床（间）", align=2, sort=9)
	public String getEcj() {
		return ecj;
	}

	public void setEcj(String ecj) {
		this.ecj = ecj;
	}
	
	@ExcelField(title="3床（间）", align=2, sort=10)
	public String getScj() {
		return scj;
	}

	public void setScj(String scj) {
		this.scj = scj;
	}
	
	@ExcelField(title="4床（间）", align=2, sort=11)
	public String getFourcj() {
		return fourcj;
	}

	public void setFourcj(String fourcj) {
		this.fourcj = fourcj;
	}
	
	@ExcelField(title="5床（间）", align=2, sort=12)
	public String getWcj() {
		return wcj;
	}

	public void setWcj(String wcj) {
		this.wcj = wcj;
	}
	
	@ExcelField(title="6床（间）", align=2, sort=13)
	public String getLcj() {
		return lcj;
	}

	public void setLcj(String lcj) {
		this.lcj = lcj;
	}
	
	@ExcelField(title="6床以上（间）", align=2, sort=14)
	public String getLcysj() {
		return lcysj;
	}

	public void setLcysj(String lcysj) {
		this.lcysj = lcysj;
	}
	
	@ExcelField(title="VIP套间(间)", align=2, sort=15)
	public String getViptj() {
		return viptj;
	}

	public void setViptj(String viptj) {
		this.viptj = viptj;
	}
	
	@ExcelField(title="临终关怀病房（间）", align=2, sort=16)
	public String getLzghbfj() {
		return lzghbfj;
	}

	public void setLzghbfj(String lzghbfj) {
		this.lzghbfj = lzghbfj;
	}
	
	@ExcelField(title="ICU(间)", align=2, sort=17)
	public String getIcuj() {
		return icuj;
	}

	public void setIcuj(String icuj) {
		this.icuj = icuj;
	}
	
	@ExcelField(title="NICU(间)", align=2, sort=18)
	public String getNicuj() {
		return nicuj;
	}

	public void setNicuj(String nicuj) {
		this.nicuj = nicuj;
	}
	
	@ExcelField(title="护士站最远直线服务距离（m）", align=2, sort=19)
	public String getHszzyzxfwjl() {
		return hszzyzxfwjl;
	}

	public void setHszzyzxfwjl(String hszzyzxfwjl) {
		this.hszzyzxfwjl = hszzyzxfwjl;
	}
	
}