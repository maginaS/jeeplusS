///**
// * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
// */
//package com.jeeplus.modules.ironfomedicalservicesdatas.entity;
//
//
//import com.jeeplus.common.persistence.DataEntity;
//import com.jeeplus.common.utils.excel.annotation.ExcelField;
//import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
//import com.jeeplus.modules.sys.entity.User;
//
///**
// * 2.1年度医疗服务量Entity
// * @author mikesun
// * @version 2018-04-11
// */
//public class IronfoMedicalService extends DataEntity<IronfoMedicalService> {
//	
//	private static final long serialVersionUID = 1L;
//	private String doc_id;		// 基本资料及医院情况表的id
//	private String date;		// 时间
//	private String bzcw;		// 编制床位（张）
//	private String sycw;		// 实有床位（张）
//	private String sjkfzcrs;		// 实际开放总床日数（日）
//	private String sjzyzcrs;		// 实际占用总床日数（日）
//	private String gccs;		// 观察床数（床）
//	private String zzlrcs;		// 总诊疗人次数（人次）
//	private String mzrcs;		// 门诊人次数（人次）
//	private String jzrcs;		// 急诊人次数（人次）
//	private String qzswrs;		// 其中死亡人数（人）
//	private String cyrs;		// 出院人数（人）
//	private String sjyyxxzzrcs;		// 上级医院向下转诊人次数（人次）
//	private String xsjyyzzrcs;		// 向上级医院转诊人次数（人次）
//	
//	private User duser;
//	private IronfoDocTitle ironfoDocTitle;
//	
//	public User getDuser() {
//		return duser;
//	}
//
//	public void setDuser(User duser) {
//		this.duser = duser;
//	}
//
//	public IronfoDocTitle getIronfoDocTitle() {
//		return ironfoDocTitle;
//	}
//
//	public void setIronfoDocTitle(IronfoDocTitle ironfoDocTitle) {
//		this.ironfoDocTitle = ironfoDocTitle;
//	}
//
//	public IronfoMedicalService() {
//		super();
//	}
//
//	public IronfoMedicalService(String id){
//		super(id);
//	}
//
//	@ExcelField(title="基本资料及医院情况表的id", align=2, sort=7)
//	public String getDoc_id() {
//		return doc_id;
//	}
//
//	public void setDoc_id(String doc_id) {
//		this.doc_id = doc_id;
//	}
//	
//	@ExcelField(title="时间", align=2, sort=8)
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//	
//	@ExcelField(title="编制床位（张）", align=2, sort=9)
//	public String getBzcw() {
//		return bzcw;
//	}
//
//	public void setBzcw(String bzcw) {
//		this.bzcw = bzcw;
//	}
//	
//	@ExcelField(title="实有床位（张）", align=2, sort=10)
//	public String getSycw() {
//		return sycw;
//	}
//
//	public void setSycw(String sycw) {
//		this.sycw = sycw;
//	}
//	
//	@ExcelField(title="实际开放总床日数（日）", align=2, sort=11)
//	public String getSjkfzcrs() {
//		return sjkfzcrs;
//	}
//
//	public void setSjkfzcrs(String sjkfzcrs) {
//		this.sjkfzcrs = sjkfzcrs;
//	}
//	
//	@ExcelField(title="实际占用总床日数（日）", align=2, sort=12)
//	public String getSjzyzcrs() {
//		return sjzyzcrs;
//	}
//
//	public void setSjzyzcrs(String sjzyzcrs) {
//		this.sjzyzcrs = sjzyzcrs;
//	}
//	
//	@ExcelField(title="观察床数（床）", align=2, sort=13)
//	public String getGccs() {
//		return gccs;
//	}
//
//	public void setGccs(String gccs) {
//		this.gccs = gccs;
//	}
//	
//	@ExcelField(title="总诊疗人次数（人次）", align=2, sort=14)
//	public String getZzlrcs() {
//		return zzlrcs;
//	}
//
//	public void setZzlrcs(String zzlrcs) {
//		this.zzlrcs = zzlrcs;
//	}
//	
//	@ExcelField(title="门诊人次数（人次）", align=2, sort=15)
//	public String getMzrcs() {
//		return mzrcs;
//	}
//
//	public void setMzrcs(String mzrcs) {
//		this.mzrcs = mzrcs;
//	}
//	
//	@ExcelField(title="急诊人次数（人次）", align=2, sort=16)
//	public String getJzrcs() {
//		return jzrcs;
//	}
//
//	public void setJzrcs(String jzrcs) {
//		this.jzrcs = jzrcs;
//	}
//	
//	@ExcelField(title="其中死亡人数（人）", align=2, sort=17)
//	public String getQzswrs() {
//		return qzswrs;
//	}
//
//	public void setQzswrs(String qzswrs) {
//		this.qzswrs = qzswrs;
//	}
//	
//	@ExcelField(title="出院人数（人）", align=2, sort=18)
//	public String getCyrs() {
//		return cyrs;
//	}
//
//	public void setCyrs(String cyrs) {
//		this.cyrs = cyrs;
//	}
//	
//	@ExcelField(title="上级医院向下转诊人次数（人次）", align=2, sort=19)
//	public String getSjyyxxzzrcs() {
//		return sjyyxxzzrcs;
//	}
//
//	public void setSjyyxxzzrcs(String sjyyxxzzrcs) {
//		this.sjyyxxzzrcs = sjyyxxzzrcs;
//	}
//	
//	@ExcelField(title="向上级医院转诊人次数（人次）", align=2, sort=20)
//	public String getXsjyyzzrcs() {
//		return xsjyyzzrcs;
//	}
//
//	public void setXsjyyzzrcs(String xsjyyzzrcs) {
//		this.xsjyyzzrcs = xsjyyzzrcs;
//	}
//	
//}