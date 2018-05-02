/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfomedicalservices.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.1年度医疗服务量Entity
 * @author mikesun
 * @version 2018-03-13
 */
public class IronfoMedicalServices extends DataEntity<IronfoMedicalServices> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 基本资料及医院情况表的id
	private String date;		// 时间
	private String bzcw;		// 编制床位（张）
	private String sycw;		// 实有床位（张）
	private String sjkfzcrs;		// 实际开放总床日数（日）
	private String sjzyzcrs;		// 实际占用总床日数（日）
	private String gccs;		// 观察床数（床）
	private String zzlrcs;		// 总诊疗人次数（人次）
	private String mzrcs;		// 门诊人次数（人次）
	private String jzrcs;		// 急诊人次数（人次）
	private String qzswrs;		// 其中死亡人数（人）
	private String cyrs;		// 出院人数（人）
	private String sjyyxxzzrcs;		// 上级医院向下转诊人次数（人次）
	private String xsjyyzzrcs;		// 向上级医院转诊人次数（人次）
	
	
	
	
	
	
	private String id1;
	private String doc_id1;		// 基本资料及医院情况表的id
	private String date1;		// 时间
	private String bzcw1;		// 编制床位（张）
	private String sycw1;		// 实有床位（张）
	private String sjkfzcrs1;		// 实际开放总床日数（日）
	private String sjzyzcrs1;		// 实际占用总床日数（日）
	private String gccs1;		// 观察床数（床）
	private String zzlrcs1;		// 总诊疗人次数（人次）
	private String mzrcs1;		// 门诊人次数（人次）
	private String jzrcs1;		// 急诊人次数（人次）
	private String qzswrs1;		// 其中死亡人数（人）
	private String cyrs1;		// 出院人数（人）
	private String sjyyxxzzrcs1;		// 上级医院向下转诊人次数（人次）
	private String xsjyyzzrcs1;		// 向上级医院转诊人次数（人次）
	
	
	
	private String id2;
	private String doc_id2;		// 基本资料及医院情况表的id
	private String date2;		// 时间
	private String bzcw2;		// 编制床位（张）
	private String sycw2;		// 实有床位（张）
	private String sjkfzcrs2;		// 实际开放总床日数（日）
	private String sjzyzcrs2;		// 实际占用总床日数（日）
	private String gccs2;		// 观察床数（床）
	private String zzlrcs2;		// 总诊疗人次数（人次）
	private String mzrcs2;		// 门诊人次数（人次）
	private String jzrcs2;		// 急诊人次数（人次）
	private String qzswrs2;		// 其中死亡人数（人）
	private String cyrs2;		// 出院人数（人）
	private String sjyyxxzzrcs2;		// 上级医院向下转诊人次数（人次）
	private String xsjyyzzrcs2;		// 向上级医院转诊人次数（人次）
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getDoc_id1() {
		return doc_id1;
	}

	public void setDoc_id1(String doc_id1) {
		this.doc_id1 = doc_id1;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getBzcw1() {
		return bzcw1;
	}

	public void setBzcw1(String bzcw1) {
		this.bzcw1 = bzcw1;
	}

	public String getSycw1() {
		return sycw1;
	}

	public void setSycw1(String sycw1) {
		this.sycw1 = sycw1;
	}

	public String getSjkfzcrs1() {
		return sjkfzcrs1;
	}

	public void setSjkfzcrs1(String sjkfzcrs1) {
		this.sjkfzcrs1 = sjkfzcrs1;
	}

	public String getSjzyzcrs1() {
		return sjzyzcrs1;
	}

	public void setSjzyzcrs1(String sjzyzcrs1) {
		this.sjzyzcrs1 = sjzyzcrs1;
	}

	public String getGccs1() {
		return gccs1;
	}

	public void setGccs1(String gccs1) {
		this.gccs1 = gccs1;
	}

	public String getZzlrcs1() {
		return zzlrcs1;
	}

	public void setZzlrcs1(String zzlrcs1) {
		this.zzlrcs1 = zzlrcs1;
	}

	public String getMzrcs1() {
		return mzrcs1;
	}

	public void setMzrcs1(String mzrcs1) {
		this.mzrcs1 = mzrcs1;
	}

	public String getJzrcs1() {
		return jzrcs1;
	}

	public void setJzrcs1(String jzrcs1) {
		this.jzrcs1 = jzrcs1;
	}

	public String getQzswrs1() {
		return qzswrs1;
	}

	public void setQzswrs1(String qzswrs1) {
		this.qzswrs1 = qzswrs1;
	}

	public String getCyrs1() {
		return cyrs1;
	}

	public void setCyrs1(String cyrs1) {
		this.cyrs1 = cyrs1;
	}

	public String getSjyyxxzzrcs1() {
		return sjyyxxzzrcs1;
	}

	public void setSjyyxxzzrcs1(String sjyyxxzzrcs1) {
		this.sjyyxxzzrcs1 = sjyyxxzzrcs1;
	}

	public String getXsjyyzzrcs1() {
		return xsjyyzzrcs1;
	}

	public void setXsjyyzzrcs1(String xsjyyzzrcs1) {
		this.xsjyyzzrcs1 = xsjyyzzrcs1;
	}

	public String getDoc_id2() {
		return doc_id2;
	}

	public void setDoc_id2(String doc_id2) {
		this.doc_id2 = doc_id2;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getBzcw2() {
		return bzcw2;
	}

	public void setBzcw2(String bzcw2) {
		this.bzcw2 = bzcw2;
	}

	public String getSycw2() {
		return sycw2;
	}

	public void setSycw2(String sycw2) {
		this.sycw2 = sycw2;
	}

	public String getSjkfzcrs2() {
		return sjkfzcrs2;
	}

	public void setSjkfzcrs2(String sjkfzcrs2) {
		this.sjkfzcrs2 = sjkfzcrs2;
	}

	public String getSjzyzcrs2() {
		return sjzyzcrs2;
	}

	public void setSjzyzcrs2(String sjzyzcrs2) {
		this.sjzyzcrs2 = sjzyzcrs2;
	}

	public String getGccs2() {
		return gccs2;
	}

	public void setGccs2(String gccs2) {
		this.gccs2 = gccs2;
	}

	public String getZzlrcs2() {
		return zzlrcs2;
	}

	public void setZzlrcs2(String zzlrcs2) {
		this.zzlrcs2 = zzlrcs2;
	}

	public String getMzrcs2() {
		return mzrcs2;
	}

	public void setMzrcs2(String mzrcs2) {
		this.mzrcs2 = mzrcs2;
	}

	public String getJzrcs2() {
		return jzrcs2;
	}

	public void setJzrcs2(String jzrcs2) {
		this.jzrcs2 = jzrcs2;
	}

	public String getQzswrs2() {
		return qzswrs2;
	}

	public void setQzswrs2(String qzswrs2) {
		this.qzswrs2 = qzswrs2;
	}

	public String getCyrs2() {
		return cyrs2;
	}

	public void setCyrs2(String cyrs2) {
		this.cyrs2 = cyrs2;
	}

	public String getSjyyxxzzrcs2() {
		return sjyyxxzzrcs2;
	}

	public void setSjyyxxzzrcs2(String sjyyxxzzrcs2) {
		this.sjyyxxzzrcs2 = sjyyxxzzrcs2;
	}

	public String getXsjyyzzrcs2() {
		return xsjyyzzrcs2;
	}

	public void setXsjyyzzrcs2(String xsjyyzzrcs2) {
		this.xsjyyzzrcs2 = xsjyyzzrcs2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IronfoMedicalServices() {
		super();
	}

	public IronfoMedicalServices(String id){
		super(id);
	}

	@ExcelField(title="基本资料及医院情况表的id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="时间", align=2, sort=8)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@ExcelField(title="编制床位（张）", align=2, sort=9)
	public String getBzcw() {
		return bzcw;
	}

	public void setBzcw(String bzcw) {
		this.bzcw = bzcw;
	}
	
	@ExcelField(title="实有床位（张）", align=2, sort=10)
	public String getSycw() {
		return sycw;
	}

	public void setSycw(String sycw) {
		this.sycw = sycw;
	}
	
	@ExcelField(title="实际开放总床日数（日）", align=2, sort=11)
	public String getSjkfzcrs() {
		return sjkfzcrs;
	}

	public void setSjkfzcrs(String sjkfzcrs) {
		this.sjkfzcrs = sjkfzcrs;
	}
	
	@ExcelField(title="实际占用总床日数（日）", align=2, sort=12)
	public String getSjzyzcrs() {
		return sjzyzcrs;
	}

	public void setSjzyzcrs(String sjzyzcrs) {
		this.sjzyzcrs = sjzyzcrs;
	}
	
	@ExcelField(title="观察床数（床）", align=2, sort=13)
	public String getGccs() {
		return gccs;
	}

	public void setGccs(String gccs) {
		this.gccs = gccs;
	}
	
	@ExcelField(title="总诊疗人次数（人次）", align=2, sort=14)
	public String getZzlrcs() {
		return zzlrcs;
	}

	public void setZzlrcs(String zzlrcs) {
		this.zzlrcs = zzlrcs;
	}
	
	@ExcelField(title="门诊人次数（人次）", align=2, sort=15)
	public String getMzrcs() {
		return mzrcs;
	}

	public void setMzrcs(String mzrcs) {
		this.mzrcs = mzrcs;
	}
	
	@ExcelField(title="急诊人次数（人次）", align=2, sort=16)
	public String getJzrcs() {
		return jzrcs;
	}

	public void setJzrcs(String jzrcs) {
		this.jzrcs = jzrcs;
	}
	
	@ExcelField(title="其中死亡人数（人）", align=2, sort=17)
	public String getQzswrs() {
		return qzswrs;
	}

	public void setQzswrs(String qzswrs) {
		this.qzswrs = qzswrs;
	}
	
	@ExcelField(title="出院人数（人）", align=2, sort=18)
	public String getCyrs() {
		return cyrs;
	}

	public void setCyrs(String cyrs) {
		this.cyrs = cyrs;
	}
	
	@ExcelField(title="上级医院向下转诊人次数（人次）", align=2, sort=19)
	public String getSjyyxxzzrcs() {
		return sjyyxxzzrcs;
	}

	public void setSjyyxxzzrcs(String sjyyxxzzrcs) {
		this.sjyyxxzzrcs = sjyyxxzzrcs;
	}
	
	@ExcelField(title="向上级医院转诊人次数（人次）", align=2, sort=20)
	public String getXsjyyzzrcs() {
		return xsjyyzzrcs;
	}

	public void setXsjyyzzrcs(String xsjyyzzrcs) {
		this.xsjyyzzrcs = xsjyyzzrcs;
	}
	
}