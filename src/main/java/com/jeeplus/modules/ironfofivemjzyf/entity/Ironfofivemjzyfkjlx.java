/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivemjzyf.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5.2门急诊用房Entity
 * @author mikesun
 * @version 2018-04-13
 */
public class Ironfofivemjzyfkjlx extends DataEntity<Ironfofivemjzyfkjlx> {
	
	private static final long serialVersionUID = 1L;
	
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private String mjzyfId;		// 5.2门急诊用房id
	private String ghsfs;		// 挂号收费室
	private String fwzx;		// 服务中心
	private String fzt;		// 分诊台
	private String hzq;		// 候诊区
	private String qkylkzs;		// 全科医疗科诊室
	private String ptnkzsnkyf;		// 普通内科诊室-内科用房
	private String cdjfrmzsnkyf;		// 肠道及发热门诊室-内科用房
	private String ptwkzswkyf;		// 普通外科诊室-外科用房
	private String gkzswkyf;		// 骨科诊室-外科用房
	private String fckzsfckyf;		// 妇产科诊室-妇产科用房
	private String jcsfckyf;		// 检查室-妇产科用房
	private String ekzs;		// 儿科诊室
	private String zykzszykyf;		// 中医科诊室-中医科用房
	private String zyzlszykyf;		// 中医治疗室-中医科用房
	private String kqkzskqkyf;		// 口腔科诊室-口腔科用房
	private String kqzlskqkyf;		// 口腔治疗室-口腔科用房
	private String jgskqkyf;		// 技工室-口腔科用房
	private String ykzs;		// 眼科诊室
	private String ebhkzs;		// 耳鼻喉科诊室
	private String pfkzs;		// 皮肤科诊室
	private String grxjbkzsgrxjbkyf;		// 感染性疾病科诊室-感染性疾病科用房
	private String glsgrxjbkyf;		// 隔离室-感染性疾病科用房
	private String kfkzskfkyf;		// 康复科诊室-康复科用房
	private String xyllskfkyf;		// 西医理疗室-康复科用房
	private String ydzlskfkyf;		// 运动治疗室-康复科用房
	private String yyzlskfkyf;		// 言语治疗室-康复科用房
	private String hszsyyf;		// 护士站-输液用房
	private String zlzbssyyf;		// 治疗准备室-输液用房
	private String zsssyyf;		// 注射室-输液用房
	private String syssyyf;		// 输液室-输液用房
	private String zsgcssyyf;		// 注射观察室-输液用房
	private String jzkzsjzkyf;		// 急诊科诊室-急诊科用房
	private String qjsjzkyf;		// 抢救室-急诊科用房
	private String lgsjzkyf;		// 留观室-急诊科用房
	private String yszbsjzkyf;		// 医生值班室-急诊科用房
	private String qtqzm;		// 其它（请注明）
	private String doc_id;		// 主表id
	
	
	
	
	public Ironfofivemjzyfkjlx() {
		super();
	}

	public Ironfofivemjzyfkjlx(String id){
		super(id);
	}
	
	
	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=8)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}

	@ExcelField(title="5.2门急诊用房id", align=2, sort=7)
	public String getMjzyfId() {
		return mjzyfId;
	}

	public void setMjzyfId(String mjzyfId) {
		this.mjzyfId = mjzyfId;
	}
	
	@ExcelField(title="挂号收费室", dictType="", align=2, sort=8)
	public String getGhsfs() {
		return ghsfs;
	}

	public void setGhsfs(String ghsfs) {
		this.ghsfs = ghsfs;
	}
	
	
	
	
//	public String getGhsfs() {
//		return ghsfs;
//	}
//
//	public void setGhsfs(String ghsfs) {
//		this.ghsfs = ghsfs;
//	}
	
	@ExcelField(title="分诊台", dictType="", align=2, sort=10)
	public String getFzt() {
		return fzt;
	}

	
//	public String getHsfs() {
//		return hsfs;
//	}
//
//	public void setHsfs(String hsfs) {
//		this.hsfs = hsfs;
//	}
	@ExcelField(title="服务中心", dictType="", align=2, sort=9)
	public String getFwzx() {
		return fwzx;
	}

	public void setFwzx(String fwzx) {
		this.fwzx = fwzx;
	}

	public void setFzt(String fzt) {
		this.fzt = fzt;
	}
	
	@ExcelField(title="候诊区", dictType="", align=2, sort=11)
	public String getHzq() {
		return hzq;
	}

	public void setHzq(String hzq) {
		this.hzq = hzq;
	}
	
	@ExcelField(title="全科医疗科诊室", dictType="", align=2, sort=12)
	public String getQkylkzs() {
		return qkylkzs;
	}

	public void setQkylkzs(String qkylkzs) {
		this.qkylkzs = qkylkzs;
	}
	
	@ExcelField(title="普通内科诊室-内科用房", dictType="", align=2, sort=13)
	public String getPtnkzsnkyf() {
		return ptnkzsnkyf;
	}

	public void setPtnkzsnkyf(String ptnkzsnkyf) {
		this.ptnkzsnkyf = ptnkzsnkyf;
	}
	
	@ExcelField(title="肠道及发热门诊室-内科用房", dictType="", align=2, sort=14)
	public String getCdjfrmzsnkyf() {
		return cdjfrmzsnkyf;
	}

	public void setCdjfrmzsnkyf(String cdjfrmzsnkyf) {
		this.cdjfrmzsnkyf = cdjfrmzsnkyf;
	}
	
	@ExcelField(title="普通外科诊室-外科用房", dictType="", align=2, sort=15)
	public String getPtwkzswkyf() {
		return ptwkzswkyf;
	}

	public void setPtwkzswkyf(String ptwkzswkyf) {
		this.ptwkzswkyf = ptwkzswkyf;
	}
	
	@ExcelField(title="骨科诊室-外科用房", dictType="", align=2, sort=16)
	public String getGkzswkyf() {
		return gkzswkyf;
	}

	public void setGkzswkyf(String gkzswkyf) {
		this.gkzswkyf = gkzswkyf;
	}
	
	@ExcelField(title="妇产科诊室-妇产科用房", dictType="", align=2, sort=17)
	public String getFckzsfckyf() {
		return fckzsfckyf;
	}

	public void setFckzsfckyf(String fckzsfckyf) {
		this.fckzsfckyf = fckzsfckyf;
	}
	
	@ExcelField(title="检查室-妇产科用房", dictType="", align=2, sort=18)
	public String getJcsfckyf() {
		return jcsfckyf;
	}

	public void setJcsfckyf(String jcsfckyf) {
		this.jcsfckyf = jcsfckyf;
	}
	
	@ExcelField(title="儿科诊室", dictType="", align=2, sort=19)
	public String getEkzs() {
		return ekzs;
	}

	public void setEkzs(String ekzs) {
		this.ekzs = ekzs;
	}
	
	@ExcelField(title="中医科诊室-中医科用房", dictType="", align=2, sort=20)
	public String getZykzszykyf() {
		return zykzszykyf;
	}

	public void setZykzszykyf(String zykzszykyf) {
		this.zykzszykyf = zykzszykyf;
	}
	
	@ExcelField(title="中医治疗室-中医科用房", dictType="", align=2, sort=21)
	public String getZyzlszykyf() {
		return zyzlszykyf;
	}

	public void setZyzlszykyf(String zyzlszykyf) {
		this.zyzlszykyf = zyzlszykyf;
	}
	
	@ExcelField(title="口腔科诊室-口腔科用房", dictType="", align=2, sort=22)
	public String getKqkzskqkyf() {
		return kqkzskqkyf;
	}

	public void setKqkzskqkyf(String kqkzskqkyf) {
		this.kqkzskqkyf = kqkzskqkyf;
	}
	
	@ExcelField(title="口腔治疗室-口腔科用房", dictType="", align=2, sort=23)
	public String getKqzlskqkyf() {
		return kqzlskqkyf;
	}

	public void setKqzlskqkyf(String kqzlskqkyf) {
		this.kqzlskqkyf = kqzlskqkyf;
	}
	
	@ExcelField(title="技工室-口腔科用房", dictType="", align=2, sort=24)
	public String getJgskqkyf() {
		return jgskqkyf;
	}

	public void setJgskqkyf(String jgskqkyf) {
		this.jgskqkyf = jgskqkyf;
	}
	
	@ExcelField(title="眼科诊室", dictType="", align=2, sort=25)
	public String getYkzs() {
		return ykzs;
	}

	public void setYkzs(String ykzs) {
		this.ykzs = ykzs;
	}
	
	@ExcelField(title="耳鼻喉科诊室", dictType="", align=2, sort=26)
	public String getEbhkzs() {
		return ebhkzs;
	}

	public void setEbhkzs(String ebhkzs) {
		this.ebhkzs = ebhkzs;
	}
	
	@ExcelField(title="皮肤科诊室", dictType="", align=2, sort=27)
	public String getPfkzs() {
		return pfkzs;
	}

	public void setPfkzs(String pfkzs) {
		this.pfkzs = pfkzs;
	}
	
	@ExcelField(title="感染性疾病科诊室-感染性疾病科用房", dictType="", align=2, sort=28)
	public String getGrxjbkzsgrxjbkyf() {
		return grxjbkzsgrxjbkyf;
	}

	public void setGrxjbkzsgrxjbkyf(String grxjbkzsgrxjbkyf) {
		this.grxjbkzsgrxjbkyf = grxjbkzsgrxjbkyf;
	}
	
	@ExcelField(title="隔离室-感染性疾病科用房", dictType="", align=2, sort=29)
	public String getGlsgrxjbkyf() {
		return glsgrxjbkyf;
	}

	public void setGlsgrxjbkyf(String glsgrxjbkyf) {
		this.glsgrxjbkyf = glsgrxjbkyf;
	}
	
	@ExcelField(title="康复科诊室-康复科用房", dictType="", align=2, sort=30)
	public String getKfkzskfkyf() {
		return kfkzskfkyf;
	}

	public void setKfkzskfkyf(String kfkzskfkyf) {
		this.kfkzskfkyf = kfkzskfkyf;
	}
	
	@ExcelField(title="西医理疗室-康复科用房", dictType="", align=2, sort=31)
	public String getXyllskfkyf() {
		return xyllskfkyf;
	}

	public void setXyllskfkyf(String xyllskfkyf) {
		this.xyllskfkyf = xyllskfkyf;
	}
	
	@ExcelField(title="运动治疗室-康复科用房", dictType="", align=2, sort=32)
	public String getYdzlskfkyf() {
		return ydzlskfkyf;
	}

	public void setYdzlskfkyf(String ydzlskfkyf) {
		this.ydzlskfkyf = ydzlskfkyf;
	}
	
	@ExcelField(title="言语治疗室-康复科用房", dictType="", align=2, sort=33)
	public String getYyzlskfkyf() {
		return yyzlskfkyf;
	}

	public void setYyzlskfkyf(String yyzlskfkyf) {
		this.yyzlskfkyf = yyzlskfkyf;
	}
	
	@ExcelField(title="护士站-输液用房", dictType="", align=2, sort=34)
	public String getHszsyyf() {
		return hszsyyf;
	}

	public void setHszsyyf(String hszsyyf) {
		this.hszsyyf = hszsyyf;
	}
	
	@ExcelField(title="治疗准备室-输液用房", dictType="", align=2, sort=35)
	public String getZlzbssyyf() {
		return zlzbssyyf;
	}

	public void setZlzbssyyf(String zlzbssyyf) {
		this.zlzbssyyf = zlzbssyyf;
	}
	
	@ExcelField(title="注射室-输液用房", dictType="", align=2, sort=36)
	public String getZsssyyf() {
		return zsssyyf;
	}

	public void setZsssyyf(String zsssyyf) {
		this.zsssyyf = zsssyyf;
	}
	
	@ExcelField(title="输液室-输液用房", dictType="", align=2, sort=37)
	public String getSyssyyf() {
		return syssyyf;
	}

	public void setSyssyyf(String syssyyf) {
		this.syssyyf = syssyyf;
	}
	
	@ExcelField(title="注射观察室-输液用房", dictType="", align=2, sort=38)
	public String getZsgcssyyf() {
		return zsgcssyyf;
	}

	public void setZsgcssyyf(String zsgcssyyf) {
		this.zsgcssyyf = zsgcssyyf;
	}
	
	@ExcelField(title="急诊科诊室-急诊科用房", dictType="", align=2, sort=39)
	public String getJzkzsjzkyf() {
		return jzkzsjzkyf;
	}

	public void setJzkzsjzkyf(String jzkzsjzkyf) {
		this.jzkzsjzkyf = jzkzsjzkyf;
	}
	
	@ExcelField(title="抢救室-急诊科用房", dictType="", align=2, sort=40)
	public String getQjsjzkyf() {
		return qjsjzkyf;
	}

	public void setQjsjzkyf(String qjsjzkyf) {
		this.qjsjzkyf = qjsjzkyf;
	}
	
	@ExcelField(title="留观室-急诊科用房", dictType="", align=2, sort=41)
	public String getLgsjzkyf() {
		return lgsjzkyf;
	}

	public void setLgsjzkyf(String lgsjzkyf) {
		this.lgsjzkyf = lgsjzkyf;
	}
	
	@ExcelField(title="医生值班室-急诊科用房", dictType="", align=2, sort=42)
	public String getYszbsjzkyf() {
		return yszbsjzkyf;
	}

	public void setYszbsjzkyf(String yszbsjzkyf) {
		this.yszbsjzkyf = yszbsjzkyf;
	}
	
	@ExcelField(title="其它（请注明）", align=2, sort=43)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
	@ExcelField(title="主表id", align=2, sort=44)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
}