/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopublichealth.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 2.3基本公共卫生服务Entity
 * @author mikesun
 * @version 2018-03-16
 */
public class Ironfopublichealth extends DataEntity<Ironfopublichealth> {
	
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
	
	
	
	private String nmfwczrks1;		// 年末服务(常住)人口数（人）
	private String qzldlsets1;		// 其中0-6岁儿童数（人）
	private String qzldssets1;		// 其中0-3岁儿童数（人）
	private String qzlswsysrks1;		// 其中65岁以上人口数（人）
	private String nmjmjkdaljjdrs1;		// 年末居民健康档案累计建档人数（人）
	private String qzgfhdzdars1;		// 其中规范化电子建档人数（人）
	private String nnjsjkjyrcs1;		// 年内接受健康教育人次数（人次）
	private String nnldlsetyfjzrcs1;		// 年内0-6岁儿童预防接种人次数（人次）
	private String nmldlsetjkglrs1;		// 年末0-6岁儿童健康管理人数（人次）
	private String nmycfjkglrs1;		// 年末孕产妇健康管理人数（人）
	private String nmlswsyslrjkglr1;		// 年末65岁以上老人健康管理人（人）
	private String nmgxygfglrs1;		// 年末高血压规范管理人数（人）
	private String nmtnbgfglrs1;		// 年末糖尿病规范管理人数（人）
	private String nmzxjszahzglrs1;		// 年末重性精神障碍患者管理人数（人）
	private String nmfjhhzglrs1;		// 年末肺结核患者管理人数（人）
	private String nncrbhtfggwssjbgls1;		// 年内传染病和突发公共卫生事件报告例数（例）
	private String nnwsjdxgxxbgls1;		// 年内卫生监督协管信息报告例数（例）
	private String nmldssetzyyjkglrs1;		// 年末0-3岁儿童中医药健康管理人数（人）
	private String nmlswyslrzyyjkglrs1;		// 年末65岁以上老人中医药健康管理人数（人）
	private String date1;		// 时间
	private String doc_id1;		// 主表id
	
	
	
	private String nmfwczrks2;		// 年末服务(常住)人口数（人）
	private String qzldlsets2;		// 其中0-6岁儿童数（人）
	private String qzldssets2;		// 其中0-3岁儿童数（人）
	private String qzlswsysrks2;		// 其中65岁以上人口数（人）
	private String nmjmjkdaljjdrs2;		// 年末居民健康档案累计建档人数（人）
	private String qzgfhdzdars2;		// 其中规范化电子建档人数（人）
	private String nnjsjkjyrcs2;		// 年内接受健康教育人次数（人次）
	private String nnldlsetyfjzrcs2;		// 年内0-6岁儿童预防接种人次数（人次）
	private String nmldlsetjkglrs2;		// 年末0-6岁儿童健康管理人数（人次）
	private String nmycfjkglrs2;		// 年末孕产妇健康管理人数（人）
	private String nmlswsyslrjkglr2;		// 年末65岁以上老人健康管理人（人）
	private String nmgxygfglrs2;		// 年末高血压规范管理人数（人）
	private String nmtnbgfglrs2;		// 年末糖尿病规范管理人数（人）
	private String nmzxjszahzglrs2;		// 年末重性精神障碍患者管理人数（人）
	private String nmfjhhzglrs2;		// 年末肺结核患者管理人数（人）
	private String nncrbhtfggwssjbgls2;		// 年内传染病和突发公共卫生事件报告例数（例）
	private String nnwsjdxgxxbgls2;		// 年内卫生监督协管信息报告例数（例）
	private String nmldssetzyyjkglrs2;		// 年末0-3岁儿童中医药健康管理人数（人）
	private String nmlswyslrzyyjkglrs2;		// 年末65岁以上老人中医药健康管理人数（人）
	private String date2;		// 时间
	private String doc_id2;		// 主表id
	
	
	
	
	
	
	
	
	
	public String getNmfwczrks1() {
		return nmfwczrks1;
	}

	public void setNmfwczrks1(String nmfwczrks1) {
		this.nmfwczrks1 = nmfwczrks1;
	}

	public String getQzldlsets1() {
		return qzldlsets1;
	}

	public void setQzldlsets1(String qzldlsets1) {
		this.qzldlsets1 = qzldlsets1;
	}

	public String getQzldssets1() {
		return qzldssets1;
	}

	public void setQzldssets1(String qzldssets1) {
		this.qzldssets1 = qzldssets1;
	}

	public String getQzlswsysrks1() {
		return qzlswsysrks1;
	}

	public void setQzlswsysrks1(String qzlswsysrks1) {
		this.qzlswsysrks1 = qzlswsysrks1;
	}

	public String getNmjmjkdaljjdrs1() {
		return nmjmjkdaljjdrs1;
	}

	public void setNmjmjkdaljjdrs1(String nmjmjkdaljjdrs1) {
		this.nmjmjkdaljjdrs1 = nmjmjkdaljjdrs1;
	}

	public String getQzgfhdzdars1() {
		return qzgfhdzdars1;
	}

	public void setQzgfhdzdars1(String qzgfhdzdars1) {
		this.qzgfhdzdars1 = qzgfhdzdars1;
	}

	public String getNnjsjkjyrcs1() {
		return nnjsjkjyrcs1;
	}

	public void setNnjsjkjyrcs1(String nnjsjkjyrcs1) {
		this.nnjsjkjyrcs1 = nnjsjkjyrcs1;
	}

	public String getNnldlsetyfjzrcs1() {
		return nnldlsetyfjzrcs1;
	}

	public void setNnldlsetyfjzrcs1(String nnldlsetyfjzrcs1) {
		this.nnldlsetyfjzrcs1 = nnldlsetyfjzrcs1;
	}

	public String getNmldlsetjkglrs1() {
		return nmldlsetjkglrs1;
	}

	public void setNmldlsetjkglrs1(String nmldlsetjkglrs1) {
		this.nmldlsetjkglrs1 = nmldlsetjkglrs1;
	}

	public String getNmycfjkglrs1() {
		return nmycfjkglrs1;
	}

	public void setNmycfjkglrs1(String nmycfjkglrs1) {
		this.nmycfjkglrs1 = nmycfjkglrs1;
	}

	public String getNmlswsyslrjkglr1() {
		return nmlswsyslrjkglr1;
	}

	public void setNmlswsyslrjkglr1(String nmlswsyslrjkglr1) {
		this.nmlswsyslrjkglr1 = nmlswsyslrjkglr1;
	}

	public String getNmgxygfglrs1() {
		return nmgxygfglrs1;
	}

	public void setNmgxygfglrs1(String nmgxygfglrs1) {
		this.nmgxygfglrs1 = nmgxygfglrs1;
	}

	public String getNmtnbgfglrs1() {
		return nmtnbgfglrs1;
	}

	public void setNmtnbgfglrs1(String nmtnbgfglrs1) {
		this.nmtnbgfglrs1 = nmtnbgfglrs1;
	}

	public String getNmzxjszahzglrs1() {
		return nmzxjszahzglrs1;
	}

	public void setNmzxjszahzglrs1(String nmzxjszahzglrs1) {
		this.nmzxjszahzglrs1 = nmzxjszahzglrs1;
	}

	public String getNmfjhhzglrs1() {
		return nmfjhhzglrs1;
	}

	public void setNmfjhhzglrs1(String nmfjhhzglrs1) {
		this.nmfjhhzglrs1 = nmfjhhzglrs1;
	}

	public String getNncrbhtfggwssjbgls1() {
		return nncrbhtfggwssjbgls1;
	}

	public void setNncrbhtfggwssjbgls1(String nncrbhtfggwssjbgls1) {
		this.nncrbhtfggwssjbgls1 = nncrbhtfggwssjbgls1;
	}

	public String getNnwsjdxgxxbgls1() {
		return nnwsjdxgxxbgls1;
	}

	public void setNnwsjdxgxxbgls1(String nnwsjdxgxxbgls1) {
		this.nnwsjdxgxxbgls1 = nnwsjdxgxxbgls1;
	}

	public String getNmldssetzyyjkglrs1() {
		return nmldssetzyyjkglrs1;
	}

	public void setNmldssetzyyjkglrs1(String nmldssetzyyjkglrs1) {
		this.nmldssetzyyjkglrs1 = nmldssetzyyjkglrs1;
	}

	public String getNmlswyslrzyyjkglrs1() {
		return nmlswyslrzyyjkglrs1;
	}

	public void setNmlswyslrzyyjkglrs1(String nmlswyslrzyyjkglrs1) {
		this.nmlswyslrzyyjkglrs1 = nmlswyslrzyyjkglrs1;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDoc_id1() {
		return doc_id1;
	}

	public void setDoc_id1(String doc_id1) {
		this.doc_id1 = doc_id1;
	}

	public String getNmfwczrks2() {
		return nmfwczrks2;
	}

	public void setNmfwczrks2(String nmfwczrks2) {
		this.nmfwczrks2 = nmfwczrks2;
	}

	public String getQzldlsets2() {
		return qzldlsets2;
	}

	public void setQzldlsets2(String qzldlsets2) {
		this.qzldlsets2 = qzldlsets2;
	}

	public String getQzldssets2() {
		return qzldssets2;
	}

	public void setQzldssets2(String qzldssets2) {
		this.qzldssets2 = qzldssets2;
	}

	public String getQzlswsysrks2() {
		return qzlswsysrks2;
	}

	public void setQzlswsysrks2(String qzlswsysrks2) {
		this.qzlswsysrks2 = qzlswsysrks2;
	}

	public String getNmjmjkdaljjdrs2() {
		return nmjmjkdaljjdrs2;
	}

	public void setNmjmjkdaljjdrs2(String nmjmjkdaljjdrs2) {
		this.nmjmjkdaljjdrs2 = nmjmjkdaljjdrs2;
	}

	public String getQzgfhdzdars2() {
		return qzgfhdzdars2;
	}

	public void setQzgfhdzdars2(String qzgfhdzdars2) {
		this.qzgfhdzdars2 = qzgfhdzdars2;
	}

	public String getNnjsjkjyrcs2() {
		return nnjsjkjyrcs2;
	}

	public void setNnjsjkjyrcs2(String nnjsjkjyrcs2) {
		this.nnjsjkjyrcs2 = nnjsjkjyrcs2;
	}

	public String getNnldlsetyfjzrcs2() {
		return nnldlsetyfjzrcs2;
	}

	public void setNnldlsetyfjzrcs2(String nnldlsetyfjzrcs2) {
		this.nnldlsetyfjzrcs2 = nnldlsetyfjzrcs2;
	}

	public String getNmldlsetjkglrs2() {
		return nmldlsetjkglrs2;
	}

	public void setNmldlsetjkglrs2(String nmldlsetjkglrs2) {
		this.nmldlsetjkglrs2 = nmldlsetjkglrs2;
	}

	public String getNmycfjkglrs2() {
		return nmycfjkglrs2;
	}

	public void setNmycfjkglrs2(String nmycfjkglrs2) {
		this.nmycfjkglrs2 = nmycfjkglrs2;
	}

	public String getNmlswsyslrjkglr2() {
		return nmlswsyslrjkglr2;
	}

	public void setNmlswsyslrjkglr2(String nmlswsyslrjkglr2) {
		this.nmlswsyslrjkglr2 = nmlswsyslrjkglr2;
	}

	public String getNmgxygfglrs2() {
		return nmgxygfglrs2;
	}

	public void setNmgxygfglrs2(String nmgxygfglrs2) {
		this.nmgxygfglrs2 = nmgxygfglrs2;
	}

	public String getNmtnbgfglrs2() {
		return nmtnbgfglrs2;
	}

	public void setNmtnbgfglrs2(String nmtnbgfglrs2) {
		this.nmtnbgfglrs2 = nmtnbgfglrs2;
	}

	public String getNmzxjszahzglrs2() {
		return nmzxjszahzglrs2;
	}

	public void setNmzxjszahzglrs2(String nmzxjszahzglrs2) {
		this.nmzxjszahzglrs2 = nmzxjszahzglrs2;
	}

	public String getNmfjhhzglrs2() {
		return nmfjhhzglrs2;
	}

	public void setNmfjhhzglrs2(String nmfjhhzglrs2) {
		this.nmfjhhzglrs2 = nmfjhhzglrs2;
	}

	public String getNncrbhtfggwssjbgls2() {
		return nncrbhtfggwssjbgls2;
	}

	public void setNncrbhtfggwssjbgls2(String nncrbhtfggwssjbgls2) {
		this.nncrbhtfggwssjbgls2 = nncrbhtfggwssjbgls2;
	}

	public String getNnwsjdxgxxbgls2() {
		return nnwsjdxgxxbgls2;
	}

	public void setNnwsjdxgxxbgls2(String nnwsjdxgxxbgls2) {
		this.nnwsjdxgxxbgls2 = nnwsjdxgxxbgls2;
	}

	public String getNmldssetzyyjkglrs2() {
		return nmldssetzyyjkglrs2;
	}

	public void setNmldssetzyyjkglrs2(String nmldssetzyyjkglrs2) {
		this.nmldssetzyyjkglrs2 = nmldssetzyyjkglrs2;
	}

	public String getNmlswyslrzyyjkglrs2() {
		return nmlswyslrzyyjkglrs2;
	}

	public void setNmlswyslrzyyjkglrs2(String nmlswyslrzyyjkglrs2) {
		this.nmlswyslrzyyjkglrs2 = nmlswyslrzyyjkglrs2;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDoc_id2() {
		return doc_id2;
	}

	public void setDoc_id2(String doc_id2) {
		this.doc_id2 = doc_id2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ironfopublichealth() {
		super();
	}

	public Ironfopublichealth(String id){
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
	
	@ExcelField(title="主表id", align=2, sort=27)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}