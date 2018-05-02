/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivezyyfreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.4住院用房Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivezyyfReport extends DataEntity<IronfofivezyyfReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private String bf;		// 病房
	private String hsz;		// 护士站
	private String zlzbs;		// 治疗准备室
	private String zls;		// 治疗室
	private String qjs;		// 抢救室
	private String yhbgs;		// 医护办公室
	private String zybgs;		// 住院办公室
	private String zbs;		// 值班室
	private String ksj;		// 开水间
	private String wsj;		// 卫生间
	private String hxj;		// 盥洗间
	private String lyj;		// 淋浴间
	private String zzpcs;		// 自助配餐室
	private String hds;		// 活动室
	private String brct;		// 病人餐厅
	private String qtqzm;		// 其它（请注明
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

	public IronfofivezyyfReport() {
		super();
	}

	public IronfofivezyyfReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=8)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}
	
	@ExcelField(title="病房", dictType="", align=2, sort=9)
	public String getBf() {
		return bf;
	}

	public void setBf(String bf) {
		this.bf = bf;
	}
	
	@ExcelField(title="护士站", dictType="", align=2, sort=10)
	public String getHsz() {
		return hsz;
	}

	public void setHsz(String hsz) {
		this.hsz = hsz;
	}
	
	@ExcelField(title="治疗准备室", dictType="", align=2, sort=11)
	public String getZlzbs() {
		return zlzbs;
	}

	public void setZlzbs(String zlzbs) {
		this.zlzbs = zlzbs;
	}
	
	@ExcelField(title="治疗室", dictType="", align=2, sort=12)
	public String getZls() {
		return zls;
	}

	public void setZls(String zls) {
		this.zls = zls;
	}
	
	@ExcelField(title="抢救室", dictType="", align=2, sort=13)
	public String getQjs() {
		return qjs;
	}

	public void setQjs(String qjs) {
		this.qjs = qjs;
	}
	
	@ExcelField(title="医护办公室", dictType="", align=2, sort=14)
	public String getYhbgs() {
		return yhbgs;
	}

	public void setYhbgs(String yhbgs) {
		this.yhbgs = yhbgs;
	}
	
	@ExcelField(title="住院办公室", dictType="", align=2, sort=15)
	public String getZybgs() {
		return zybgs;
	}

	public void setZybgs(String zybgs) {
		this.zybgs = zybgs;
	}
	
	@ExcelField(title="值班室", dictType="", align=2, sort=16)
	public String getZbs() {
		return zbs;
	}

	public void setZbs(String zbs) {
		this.zbs = zbs;
	}
	
	@ExcelField(title="开水间", dictType="", align=2, sort=17)
	public String getKsj() {
		return ksj;
	}

	public void setKsj(String ksj) {
		this.ksj = ksj;
	}
	
	@ExcelField(title="卫生间", dictType="", align=2, sort=18)
	public String getWsj() {
		return wsj;
	}

	public void setWsj(String wsj) {
		this.wsj = wsj;
	}
	
	@ExcelField(title="盥洗间", dictType="", align=2, sort=19)
	public String getHxj() {
		return hxj;
	}

	public void setHxj(String hxj) {
		this.hxj = hxj;
	}
	
	@ExcelField(title="淋浴间", dictType="", align=2, sort=20)
	public String getLyj() {
		return lyj;
	}

	public void setLyj(String lyj) {
		this.lyj = lyj;
	}
	
	@ExcelField(title="自助配餐室", dictType="", align=2, sort=21)
	public String getZzpcs() {
		return zzpcs;
	}

	public void setZzpcs(String zzpcs) {
		this.zzpcs = zzpcs;
	}
	
	@ExcelField(title="活动室", dictType="", align=2, sort=22)
	public String getHds() {
		return hds;
	}

	public void setHds(String hds) {
		this.hds = hds;
	}
	
	@ExcelField(title="病人餐厅", dictType="", align=2, sort=23)
	public String getBrct() {
		return brct;
	}

	public void setBrct(String brct) {
		this.brct = brct;
	}
	
	@ExcelField(title="其它（请注明", align=2, sort=24)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}