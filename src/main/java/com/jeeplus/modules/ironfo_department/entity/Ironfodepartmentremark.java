/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.4科室设置Entity
 * @author mikesun
 * @version 2018-03-16
 */
public class Ironfodepartmentremark extends DataEntity<Ironfodepartmentremark> {
	
	private static final long serialVersionUID = 1L;
	private String dep_id;		// 主表id
	private String jzs;		// 急诊室
	private String nk;		// 内科
	private String ek;		// 儿科
	private String wk;		// 外科
	private String fck;		// 妇产科
	private String qkyxk;		// 全科医学科
	private String zyk;		// 中医科
	private String yk;		// 眼科
	private String ebhk;		// 耳鼻喉科
	private String kqk;		// 口腔科
	private String kfk;		// 康复科
	private String pfk;		// 皮肤科
	private String grxjbk;		// 感染性疾病科
	private String jsk;		// 精神科
	private String zjremark;		// 增加科室
	private String doc_id;
	
	
	
	
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public Ironfodepartmentremark() {
		super();
	}

	public Ironfodepartmentremark(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
	@ExcelField(title="急诊室", dictType="", align=2, sort=8)
	public String getJzs() {
		return jzs;
	}

	public void setJzs(String jzs) {
		this.jzs = jzs;
	}
	
	@ExcelField(title="内科", dictType="", align=2, sort=9)
	public String getNk() {
		return nk;
	}

	public void setNk(String nk) {
		this.nk = nk;
	}
	
	@ExcelField(title="儿科", dictType="", align=2, sort=10)
	public String getEk() {
		return ek;
	}

	public void setEk(String ek) {
		this.ek = ek;
	}
	
	@ExcelField(title="外科", dictType="", align=2, sort=11)
	public String getWk() {
		return wk;
	}

	public void setWk(String wk) {
		this.wk = wk;
	}
	
	@ExcelField(title="妇产科", dictType="", align=2, sort=12)
	public String getFck() {
		return fck;
	}

	public void setFck(String fck) {
		this.fck = fck;
	}
	
	@ExcelField(title="全科医学科", dictType="", align=2, sort=13)
	public String getQkyxk() {
		return qkyxk;
	}

	public void setQkyxk(String qkyxk) {
		this.qkyxk = qkyxk;
	}
	
	@ExcelField(title="中医科", dictType="", align=2, sort=14)
	public String getZyk() {
		return zyk;
	}

	public void setZyk(String zyk) {
		this.zyk = zyk;
	}
	
	@ExcelField(title="眼科", dictType="", align=2, sort=15)
	public String getYk() {
		return yk;
	}

	public void setYk(String yk) {
		this.yk = yk;
	}
	
	@ExcelField(title="耳鼻喉科", dictType="", align=2, sort=16)
	public String getEbhk() {
		return ebhk;
	}

	public void setEbhk(String ebhk) {
		this.ebhk = ebhk;
	}
	
	@ExcelField(title="口腔科", dictType="", align=2, sort=17)
	public String getKqk() {
		return kqk;
	}

	public void setKqk(String kqk) {
		this.kqk = kqk;
	}
	
	@ExcelField(title="康复科", dictType="", align=2, sort=18)
	public String getKfk() {
		return kfk;
	}

	public void setKfk(String kfk) {
		this.kfk = kfk;
	}
	
	@ExcelField(title="皮肤科", dictType="", align=2, sort=19)
	public String getPfk() {
		return pfk;
	}

	public void setPfk(String pfk) {
		this.pfk = pfk;
	}
	
	@ExcelField(title="感染性疾病科", dictType="", align=2, sort=20)
	public String getGrxjbk() {
		return grxjbk;
	}

	public void setGrxjbk(String grxjbk) {
		this.grxjbk = grxjbk;
	}
	
	@ExcelField(title="精神科", dictType="", align=2, sort=21)
	public String getJsk() {
		return jsk;
	}

	public void setJsk(String jsk) {
		this.jsk = jsk;
	}
	
	@ExcelField(title="增加科室", dictType="", align=2, sort=22)
	public String getZjremark() {
		return zjremark;
	}

	public void setZjremark(String zjremark) {
		this.zjremark = zjremark;
	}
	
}