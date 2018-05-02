/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveyjyfreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.3医技用房Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofiveyjyfReport extends DataEntity<IronfofiveyjyfReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积
	private String mzxyfyjkyf;		// 门诊西药房-药剂科用房
	private String mzzyfyjkyf;		// 门诊中药房-药剂科用房
	private String jzyfyjkyf;		// 急诊药房-药剂科用房
	private String tsyfyjkyf;		// 特殊药房-药剂科用房
	private String jyfyjkyf;		// 煎药房-药剂科用房
	private String ypkyjkyf;		// 药品库-药剂科用房
	private String cxsjykyf;		// 采血室-检验科用房
	private String hysjykyf;		// 化验室-检验科用房
	private String xgjspsfskyf;		// X光机摄片室-放射科用房
	private String xgjkzsfskyf;		// X光机控制室-放射科用房
	private String ctspsfskyf;		// CT摄片室-放射科用房
	private String ctkzsfskyf;		// CT控制室-放射科用房
	private String dpsfskyf;		// 读片室-放射科用房
	private String xdts;		// 心电图室
	private String css;		// 超声室
	private String xksxkyf;		// 血库-输血科用房
	private String pxssxkyf;		// 配血室-输血科用房
	private String qwqxdgys;		// 去污区-消毒供应室
	private String jcbzjmjqxdgys;		// 检查包装及灭菌区-消毒供应室
	private String wjwpcfqxdgys;		// 无菌物品存放区-消毒供应室
	private String sssssb;		// 手术室-手术部
	private String cfssb;		// 产房-手术部
	private String zbsssb;		// 准备室-手术部
	private String dcsssb;		// 待产室-手术部
	private String gysssb;		// 更衣间-手术部
	private String xsjssb;		// 洗手间-手术部
	private String shsxsssb;		// 术后苏醒室-手术部
	private String qtqzm;		// 其它（请注明）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
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

	public IronfofiveyjyfReport() {
		super();
	}

	public IronfofiveyjyfReport(String id){
		super(id);
	}

	////@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="功能单元建筑面积", align=2, sort=8)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}
	
	@ExcelField(title="门诊西药房-药剂科用房", dictType="", align=2, sort=9)
	public String getMzxyfyjkyf() {
		return mzxyfyjkyf;
	}

	public void setMzxyfyjkyf(String mzxyfyjkyf) {
		this.mzxyfyjkyf = mzxyfyjkyf;
	}
	
	@ExcelField(title="门诊中药房-药剂科用房", dictType="", align=2, sort=10)
	public String getMzzyfyjkyf() {
		return mzzyfyjkyf;
	}

	public void setMzzyfyjkyf(String mzzyfyjkyf) {
		this.mzzyfyjkyf = mzzyfyjkyf;
	}
	
	@ExcelField(title="急诊药房-药剂科用房", dictType="", align=2, sort=11)
	public String getJzyfyjkyf() {
		return jzyfyjkyf;
	}

	public void setJzyfyjkyf(String jzyfyjkyf) {
		this.jzyfyjkyf = jzyfyjkyf;
	}
	
	@ExcelField(title="特殊药房-药剂科用房", dictType="", align=2, sort=12)
	public String getTsyfyjkyf() {
		return tsyfyjkyf;
	}

	public void setTsyfyjkyf(String tsyfyjkyf) {
		this.tsyfyjkyf = tsyfyjkyf;
	}
	
	@ExcelField(title="煎药房-药剂科用房", dictType="", align=2, sort=13)
	public String getJyfyjkyf() {
		return jyfyjkyf;
	}

	public void setJyfyjkyf(String jyfyjkyf) {
		this.jyfyjkyf = jyfyjkyf;
	}
	
	@ExcelField(title="药品库-药剂科用房", dictType="", align=2, sort=14)
	public String getYpkyjkyf() {
		return ypkyjkyf;
	}

	public void setYpkyjkyf(String ypkyjkyf) {
		this.ypkyjkyf = ypkyjkyf;
	}
	
	@ExcelField(title="采血室-检验科用房", dictType="", align=2, sort=15)
	public String getCxsjykyf() {
		return cxsjykyf;
	}

	public void setCxsjykyf(String cxsjykyf) {
		this.cxsjykyf = cxsjykyf;
	}
	
	@ExcelField(title="化验室-检验科用房", dictType="", align=2, sort=16)
	public String getHysjykyf() {
		return hysjykyf;
	}

	public void setHysjykyf(String hysjykyf) {
		this.hysjykyf = hysjykyf;
	}
	
	@ExcelField(title="X光机摄片室-放射科用房", dictType="", align=2, sort=17)
	public String getXgjspsfskyf() {
		return xgjspsfskyf;
	}

	public void setXgjspsfskyf(String xgjspsfskyf) {
		this.xgjspsfskyf = xgjspsfskyf;
	}
	
	@ExcelField(title="X光机控制室-放射科用房", dictType="", align=2, sort=18)
	public String getXgjkzsfskyf() {
		return xgjkzsfskyf;
	}

	public void setXgjkzsfskyf(String xgjkzsfskyf) {
		this.xgjkzsfskyf = xgjkzsfskyf;
	}
	
	@ExcelField(title="CT摄片室-放射科用房", dictType="", align=2, sort=19)
	public String getCtspsfskyf() {
		return ctspsfskyf;
	}

	public void setCtspsfskyf(String ctspsfskyf) {
		this.ctspsfskyf = ctspsfskyf;
	}
	
	@ExcelField(title="CT控制室-放射科用房", dictType="", align=2, sort=20)
	public String getCtkzsfskyf() {
		return ctkzsfskyf;
	}

	public void setCtkzsfskyf(String ctkzsfskyf) {
		this.ctkzsfskyf = ctkzsfskyf;
	}
	
	@ExcelField(title="读片室-放射科用房", dictType="", align=2, sort=21)
	public String getDpsfskyf() {
		return dpsfskyf;
	}

	public void setDpsfskyf(String dpsfskyf) {
		this.dpsfskyf = dpsfskyf;
	}
	
	@ExcelField(title="心电图室", dictType="", align=2, sort=22)
	public String getXdts() {
		return xdts;
	}

	public void setXdts(String xdts) {
		this.xdts = xdts;
	}
	
	@ExcelField(title="超声室", dictType="", align=2, sort=23)
	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}
	
	@ExcelField(title="血库-输血科用房", dictType="", align=2, sort=24)
	public String getXksxkyf() {
		return xksxkyf;
	}

	public void setXksxkyf(String xksxkyf) {
		this.xksxkyf = xksxkyf;
	}
	
	@ExcelField(title="配血室-输血科用房", dictType="", align=2, sort=25)
	public String getPxssxkyf() {
		return pxssxkyf;
	}

	public void setPxssxkyf(String pxssxkyf) {
		this.pxssxkyf = pxssxkyf;
	}
	
	@ExcelField(title="去污区-消毒供应室", dictType="", align=2, sort=26)
	public String getQwqxdgys() {
		return qwqxdgys;
	}

	public void setQwqxdgys(String qwqxdgys) {
		this.qwqxdgys = qwqxdgys;
	}
	
	@ExcelField(title="检查包装及灭菌区-消毒供应室", dictType="", align=2, sort=27)
	public String getJcbzjmjqxdgys() {
		return jcbzjmjqxdgys;
	}

	public void setJcbzjmjqxdgys(String jcbzjmjqxdgys) {
		this.jcbzjmjqxdgys = jcbzjmjqxdgys;
	}
	
	@ExcelField(title="无菌物品存放区-消毒供应室", dictType="", align=2, sort=28)
	public String getWjwpcfqxdgys() {
		return wjwpcfqxdgys;
	}

	public void setWjwpcfqxdgys(String wjwpcfqxdgys) {
		this.wjwpcfqxdgys = wjwpcfqxdgys;
	}
	
	@ExcelField(title="手术室-手术部", dictType="", align=2, sort=29)
	public String getSssssb() {
		return sssssb;
	}

	public void setSssssb(String sssssb) {
		this.sssssb = sssssb;
	}
	
	@ExcelField(title="产房-手术部", dictType="", align=2, sort=30)
	public String getCfssb() {
		return cfssb;
	}

	public void setCfssb(String cfssb) {
		this.cfssb = cfssb;
	}
	
	@ExcelField(title="准备室-手术部", dictType="", align=2, sort=31)
	public String getZbsssb() {
		return zbsssb;
	}

	public void setZbsssb(String zbsssb) {
		this.zbsssb = zbsssb;
	}
	
	@ExcelField(title="待产室-手术部", dictType="", align=2, sort=32)
	public String getDcsssb() {
		return dcsssb;
	}

	public void setDcsssb(String dcsssb) {
		this.dcsssb = dcsssb;
	}
	
	@ExcelField(title="更衣间-手术部", dictType="", align=2, sort=33)
	public String getGysssb() {
		return gysssb;
	}

	public void setGysssb(String gysssb) {
		this.gysssb = gysssb;
	}
	
	@ExcelField(title="洗手间-手术部", dictType="", align=2, sort=34)
	public String getXsjssb() {
		return xsjssb;
	}

	public void setXsjssb(String xsjssb) {
		this.xsjssb = xsjssb;
	}
	
	@ExcelField(title="术后苏醒室-手术部", dictType="", align=2, sort=35)
	public String getShsxsssb() {
		return shsxsssb;
	}

	public void setShsxsssb(String shsxsssb) {
		this.shsxsssb = shsxsssb;
	}
	
	@ExcelField(title="其它（请注明）", align=2, sort=36)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}