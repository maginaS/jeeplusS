/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopublichealthreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 2.3基本公共卫生服务Entity
 * @author mao
 * @version 2018-04-20
 */
public class IronfopublichealthReport extends DataEntity<IronfopublichealthReport> {
	
	private static final long serialVersionUID = 1L;
	private String nmfwczrks;		// 年末服务(常住)人口数（人）
	private String qzldlsets;		// 其中0-6岁儿童数（人）
	private String qzldssets;		// 其中0-3岁儿童数（人）
	private String qzlswsysrks;		// 其中65岁以上人口数（人）
	private String nmjmjkdaljjdrs;		// 年末居民健康档案累计建档人数（人）
	private String qzgfhdzdars;		// 其中规范化电子建档人数（人）
	private String nnjsjkjyrcs;		// 年内接受健康教育人次数（人次）
	private String nnldlsetyfjzrcs;		// 年内0-6岁儿童预防接种人次数（人次）
	private String nmldlsetjkglrs;		// 年末0-6岁儿童健康管理人数（人次）
	private String nmycfjkglrs;		// 年末孕产妇健康管理人数（人）
	private String nmlswsyslrjkglr;		// 年末65岁以上老人健康管理人（人）
	private String nmgxygfglrs;		// 年末高血压规范管理人数（人）
	private String nmtnbgfglrs;		// 年末糖尿病规范管理人数（人）
	private String nmzxjszahzglrs;		// 年末重性精神障碍患者管理人数（人）
	private String nmfjhhzglrs;		// 年末肺结核患者管理人数（人）
	private String nncrbhtfggwssjbgls;		// 年内传染病和突发公共卫生事件报告例数（例）
	private String nnwsjdxgxxbgls;		// 年内卫生监督协管信息报告例数（例）
	private String nmldssetzyyjkglrs;		// 年末0-3岁儿童中医药健康管理人数（人）
	private String nmlswyslrzyyjkglrs;		// 年末65岁以上老人中医药健康管理人数（人）
	private String date;		// 时间
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

	public IronfopublichealthReport() {
		super();
	}

	public IronfopublichealthReport(String id){
		super(id);
	}

	@ExcelField(title="年末服务(常住)人口数（人）", align=2, sort=7)
	public String getNmfwczrks() {
		return nmfwczrks;
	}

	public void setNmfwczrks(String nmfwczrks) {
		this.nmfwczrks = nmfwczrks;
	}
	
	@ExcelField(title="其中0-6岁儿童数（人）", align=2, sort=8)
	public String getQzldlsets() {
		return qzldlsets;
	}

	public void setQzldlsets(String qzldlsets) {
		this.qzldlsets = qzldlsets;
	}
	
	@ExcelField(title="其中0-3岁儿童数（人）", align=2, sort=9)
	public String getQzldssets() {
		return qzldssets;
	}

	public void setQzldssets(String qzldssets) {
		this.qzldssets = qzldssets;
	}
	
	@ExcelField(title="其中65岁以上人口数（人）", align=2, sort=10)
	public String getQzlswsysrks() {
		return qzlswsysrks;
	}

	public void setQzlswsysrks(String qzlswsysrks) {
		this.qzlswsysrks = qzlswsysrks;
	}
	
	@ExcelField(title="年末居民健康档案累计建档人数（人）", align=2, sort=11)
	public String getNmjmjkdaljjdrs() {
		return nmjmjkdaljjdrs;
	}

	public void setNmjmjkdaljjdrs(String nmjmjkdaljjdrs) {
		this.nmjmjkdaljjdrs = nmjmjkdaljjdrs;
	}
	
	@ExcelField(title="其中规范化电子建档人数（人）", align=2, sort=12)
	public String getQzgfhdzdars() {
		return qzgfhdzdars;
	}

	public void setQzgfhdzdars(String qzgfhdzdars) {
		this.qzgfhdzdars = qzgfhdzdars;
	}
	
	@ExcelField(title="年内接受健康教育人次数（人次）", align=2, sort=13)
	public String getNnjsjkjyrcs() {
		return nnjsjkjyrcs;
	}

	public void setNnjsjkjyrcs(String nnjsjkjyrcs) {
		this.nnjsjkjyrcs = nnjsjkjyrcs;
	}
	
	@ExcelField(title="年内0-6岁儿童预防接种人次数（人次）", align=2, sort=14)
	public String getNnldlsetyfjzrcs() {
		return nnldlsetyfjzrcs;
	}

	public void setNnldlsetyfjzrcs(String nnldlsetyfjzrcs) {
		this.nnldlsetyfjzrcs = nnldlsetyfjzrcs;
	}
	
	@ExcelField(title="年末0-6岁儿童健康管理人数（人次）", align=2, sort=15)
	public String getNmldlsetjkglrs() {
		return nmldlsetjkglrs;
	}

	public void setNmldlsetjkglrs(String nmldlsetjkglrs) {
		this.nmldlsetjkglrs = nmldlsetjkglrs;
	}
	
	@ExcelField(title="年末孕产妇健康管理人数（人）", align=2, sort=16)
	public String getNmycfjkglrs() {
		return nmycfjkglrs;
	}

	public void setNmycfjkglrs(String nmycfjkglrs) {
		this.nmycfjkglrs = nmycfjkglrs;
	}
	
	@ExcelField(title="年末65岁以上老人健康管理人（人）", align=2, sort=17)
	public String getNmlswsyslrjkglr() {
		return nmlswsyslrjkglr;
	}

	public void setNmlswsyslrjkglr(String nmlswsyslrjkglr) {
		this.nmlswsyslrjkglr = nmlswsyslrjkglr;
	}
	
	@ExcelField(title="年末高血压规范管理人数（人）", align=2, sort=18)
	public String getNmgxygfglrs() {
		return nmgxygfglrs;
	}

	public void setNmgxygfglrs(String nmgxygfglrs) {
		this.nmgxygfglrs = nmgxygfglrs;
	}
	
	@ExcelField(title="年末糖尿病规范管理人数（人）", align=2, sort=19)
	public String getNmtnbgfglrs() {
		return nmtnbgfglrs;
	}

	public void setNmtnbgfglrs(String nmtnbgfglrs) {
		this.nmtnbgfglrs = nmtnbgfglrs;
	}
	
	@ExcelField(title="年末重性精神障碍患者管理人数（人）", align=2, sort=20)
	public String getNmzxjszahzglrs() {
		return nmzxjszahzglrs;
	}

	public void setNmzxjszahzglrs(String nmzxjszahzglrs) {
		this.nmzxjszahzglrs = nmzxjszahzglrs;
	}
	
	@ExcelField(title="年末肺结核患者管理人数（人）", align=2, sort=21)
	public String getNmfjhhzglrs() {
		return nmfjhhzglrs;
	}

	public void setNmfjhhzglrs(String nmfjhhzglrs) {
		this.nmfjhhzglrs = nmfjhhzglrs;
	}
	
	@ExcelField(title="年内传染病和突发公共卫生事件报告例数（例）", align=2, sort=22)
	public String getNncrbhtfggwssjbgls() {
		return nncrbhtfggwssjbgls;
	}

	public void setNncrbhtfggwssjbgls(String nncrbhtfggwssjbgls) {
		this.nncrbhtfggwssjbgls = nncrbhtfggwssjbgls;
	}
	
	@ExcelField(title="年内卫生监督协管信息报告例数（例）", align=2, sort=23)
	public String getNnwsjdxgxxbgls() {
		return nnwsjdxgxxbgls;
	}

	public void setNnwsjdxgxxbgls(String nnwsjdxgxxbgls) {
		this.nnwsjdxgxxbgls = nnwsjdxgxxbgls;
	}
	
	@ExcelField(title="年末0-3岁儿童中医药健康管理人数（人）", align=2, sort=24)
	public String getNmldssetzyyjkglrs() {
		return nmldssetzyyjkglrs;
	}

	public void setNmldssetzyyjkglrs(String nmldssetzyyjkglrs) {
		this.nmldssetzyyjkglrs = nmldssetzyyjkglrs;
	}
	
	@ExcelField(title="年末65岁以上老人中医药健康管理人数（人）", align=2, sort=25)
	public String getNmlswyslrzyyjkglrs() {
		return nmlswyslrzyyjkglrs;
	}

	public void setNmlswyslrzyyjkglrs(String nmlswyslrzyyjkglrs) {
		this.nmlswyslrzyyjkglrs = nmlswyslrzyyjkglrs;
	}
	
	@ExcelField(title="时间", dictType="", align=2, sort=26)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	//@ExcelField(title="主表id", align=2, sort=27)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}