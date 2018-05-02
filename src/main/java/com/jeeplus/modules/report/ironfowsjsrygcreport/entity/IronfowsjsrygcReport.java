/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfowsjsrygcreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.7.2卫生技术人员构成Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfowsjsrygcReport extends DataEntity<IronfowsjsrygcReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String date;		// 日期
	private String zyys;		// 执业医师（人）
	private String zyysqzggwslb;		// 执业医师其中公共卫生类别（人）
	private String zyzlys;		// 执业助理医师（人）
	private String zyzlysqzggwslb;		// 执业助理医师其中公共卫生类别（人）
	private String zcqkys;		// 注册全科医生（人）
	private String qdqkyspxhgzdrs;		// 取得全科医生培训合格证的人数（人）
	private String zchs;		// 注册护士（人）
	private String zcs;		// 助产士（人）
	private String yss;		// 药师（士） （人）
	private String zys;		// 中药师（士） （人）
	private String jyys;		// 检验医师（士） （人）
	private String yxys;		// 影像医师（士） （人）
	private String kfzls;		// 康复治疗师（人）
	private String qtwsjsry;		// 其他卫生技术人员（人）
	
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
	
	public IronfowsjsrygcReport() {
		super();
	}

	public IronfowsjsrygcReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="日期", align=2, sort=8)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@ExcelField(title="执业医师（人）", align=2, sort=9)
	public String getZyys() {
		return zyys;
	}

	public void setZyys(String zyys) {
		this.zyys = zyys;
	}
	
	@ExcelField(title="执业医师其中公共卫生类别（人）", align=2, sort=10)
	public String getZyysqzggwslb() {
		return zyysqzggwslb;
	}

	public void setZyysqzggwslb(String zyysqzggwslb) {
		this.zyysqzggwslb = zyysqzggwslb;
	}
	
	@ExcelField(title="执业助理医师（人）", align=2, sort=11)
	public String getZyzlys() {
		return zyzlys;
	}

	public void setZyzlys(String zyzlys) {
		this.zyzlys = zyzlys;
	}
	
	@ExcelField(title="执业助理医师其中公共卫生类别（人）", align=2, sort=12)
	public String getZyzlysqzggwslb() {
		return zyzlysqzggwslb;
	}

	public void setZyzlysqzggwslb(String zyzlysqzggwslb) {
		this.zyzlysqzggwslb = zyzlysqzggwslb;
	}
	
	@ExcelField(title="注册全科医生（人）", align=2, sort=13)
	public String getZcqkys() {
		return zcqkys;
	}

	public void setZcqkys(String zcqkys) {
		this.zcqkys = zcqkys;
	}
	
	@ExcelField(title="取得全科医生培训合格证的人数（人）", align=2, sort=14)
	public String getQdqkyspxhgzdrs() {
		return qdqkyspxhgzdrs;
	}

	public void setQdqkyspxhgzdrs(String qdqkyspxhgzdrs) {
		this.qdqkyspxhgzdrs = qdqkyspxhgzdrs;
	}
	
	@ExcelField(title="注册护士（人）", align=2, sort=15)
	public String getZchs() {
		return zchs;
	}

	public void setZchs(String zchs) {
		this.zchs = zchs;
	}
	
	@ExcelField(title="助产士（人）", align=2, sort=16)
	public String getZcs() {
		return zcs;
	}

	public void setZcs(String zcs) {
		this.zcs = zcs;
	}
	
	@ExcelField(title="药师（士） （人）", align=2, sort=17)
	public String getYss() {
		return yss;
	}

	public void setYss(String yss) {
		this.yss = yss;
	}
	
	@ExcelField(title="中药师（士） （人）", align=2, sort=18)
	public String getZys() {
		return zys;
	}

	public void setZys(String zys) {
		this.zys = zys;
	}
	
	@ExcelField(title="检验医师（士） （人）", align=2, sort=19)
	public String getJyys() {
		return jyys;
	}

	public void setJyys(String jyys) {
		this.jyys = jyys;
	}
	
	@ExcelField(title="影像医师（士） （人）", align=2, sort=20)
	public String getYxys() {
		return yxys;
	}

	public void setYxys(String yxys) {
		this.yxys = yxys;
	}
	
	@ExcelField(title="康复治疗师（人）", align=2, sort=21)
	public String getKfzls() {
		return kfzls;
	}

	public void setKfzls(String kfzls) {
		this.kfzls = kfzls;
	}
	
	@ExcelField(title="其他卫生技术人员（人）", align=2, sort=22)
	public String getQtwsjsry() {
		return qtwsjsry;
	}

	public void setQtwsjsry(String qtwsjsry) {
		this.qtwsjsry = qtwsjsry;
	}
	
}