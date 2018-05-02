/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveggwsyf.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 5.5公共卫生用房Entity
 * @author mikesun
 * @version 2018-04-15
 */
public class Ironfofiveggwsyf extends DataEntity<Ironfofiveggwsyf> {
	
	private static final long serialVersionUID = 1L;
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private String jkdas;		// 健康档案室
	private String jkjys;		// 健康教育室
	private String yjqjzdt;		// 预检区-接种大厅
	private String hzqjzdt;		// 候种区-接种大厅
	private String jzqjzdt;		// 接种区-接种大厅
	private String lnqjzdt;		// 冷凝区-接种大厅
	private String fnbjsjzdt;		// 妇女保健室-接种大厅
	private String etbjsjzdt;		// 儿童保健室-接种大厅
	private String lnrbjsjzdt;		// 老年人保健室-接种大厅
	private String ybjcqtjzx;		// 一般检查区-体检中心
	private String kqjcqtjzx;		// 口腔检查区-体检中心
	private String tljcqtjzx;		// 听力检查区-体检中心
	private String sljcqtjzx;		// 视力检查区-体检中心
	private String zljcqtjzx;		// 智力检查区-体检中心
	private String nanwkjcstjzx;		// 男外科检查室-体检中心
	private String nvwkjcstjzx;		// 女外科检查室-体检中心
	private String qtqzm;		// 其它（请注明）
	private String doc_id;		// 主表id
	
	public Ironfofiveggwsyf() {
		super();
	}

	public Ironfofiveggwsyf(String id){
		super(id);
	}

	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=7)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}
	
	@ExcelField(title="健康档案室", dictType="", align=2, sort=8)
	public String getJkdas() {
		return jkdas;
	}

	public void setJkdas(String jkdas) {
		this.jkdas = jkdas;
	}
	
	@ExcelField(title="健康教育室", dictType="", align=2, sort=9)
	public String getJkjys() {
		return jkjys;
	}

	public void setJkjys(String jkjys) {
		this.jkjys = jkjys;
	}
	
	@ExcelField(title="预检区-接种大厅", dictType="", align=2, sort=10)
	public String getYjqjzdt() {
		return yjqjzdt;
	}

	public void setYjqjzdt(String yjqjzdt) {
		this.yjqjzdt = yjqjzdt;
	}
	
	@ExcelField(title="候种区-接种大厅", dictType="", align=2, sort=11)
	public String getHzqjzdt() {
		return hzqjzdt;
	}

	public void setHzqjzdt(String hzqjzdt) {
		this.hzqjzdt = hzqjzdt;
	}
	
	@ExcelField(title="接种区-接种大厅", dictType="", align=2, sort=12)
	public String getJzqjzdt() {
		return jzqjzdt;
	}

	public void setJzqjzdt(String jzqjzdt) {
		this.jzqjzdt = jzqjzdt;
	}
	
	@ExcelField(title="冷凝区-接种大厅", dictType="", align=2, sort=13)
	public String getLnqjzdt() {
		return lnqjzdt;
	}

	public void setLnqjzdt(String lnqjzdt) {
		this.lnqjzdt = lnqjzdt;
	}
	
	@ExcelField(title="妇女保健室-接种大厅", dictType="", align=2, sort=14)
	public String getFnbjsjzdt() {
		return fnbjsjzdt;
	}

	public void setFnbjsjzdt(String fnbjsjzdt) {
		this.fnbjsjzdt = fnbjsjzdt;
	}
	
	@ExcelField(title="儿童保健室-接种大厅", dictType="", align=2, sort=15)
	public String getEtbjsjzdt() {
		return etbjsjzdt;
	}

	public void setEtbjsjzdt(String etbjsjzdt) {
		this.etbjsjzdt = etbjsjzdt;
	}
	
	@ExcelField(title="老年人保健室-接种大厅", dictType="", align=2, sort=16)
	public String getLnrbjsjzdt() {
		return lnrbjsjzdt;
	}

	public void setLnrbjsjzdt(String lnrbjsjzdt) {
		this.lnrbjsjzdt = lnrbjsjzdt;
	}
	
	@ExcelField(title="一般检查区-体检中心", dictType="", align=2, sort=17)
	public String getYbjcqtjzx() {
		return ybjcqtjzx;
	}

	public void setYbjcqtjzx(String ybjcqtjzx) {
		this.ybjcqtjzx = ybjcqtjzx;
	}
	
	@ExcelField(title="口腔检查区-体检中心", dictType="", align=2, sort=18)
	public String getKqjcqtjzx() {
		return kqjcqtjzx;
	}

	public void setKqjcqtjzx(String kqjcqtjzx) {
		this.kqjcqtjzx = kqjcqtjzx;
	}
	
	@ExcelField(title="听力检查区-体检中心", dictType="", align=2, sort=19)
	public String getTljcqtjzx() {
		return tljcqtjzx;
	}

	public void setTljcqtjzx(String tljcqtjzx) {
		this.tljcqtjzx = tljcqtjzx;
	}
	
	@ExcelField(title="视力检查区-体检中心", dictType="", align=2, sort=20)
	public String getSljcqtjzx() {
		return sljcqtjzx;
	}

	public void setSljcqtjzx(String sljcqtjzx) {
		this.sljcqtjzx = sljcqtjzx;
	}
	
	@ExcelField(title="智力检查区-体检中心", dictType="", align=2, sort=21)
	public String getZljcqtjzx() {
		return zljcqtjzx;
	}

	public void setZljcqtjzx(String zljcqtjzx) {
		this.zljcqtjzx = zljcqtjzx;
	}
	
//	@ExcelField(title="男外科检查室-体检中心", dictType="", align=2, sort=22)
//	public String getNwkjcstjzx() {
//		return nwkjcstjzx;
//	}
//
//	public void setNwkjcstjzx(String nwkjcstjzx) {
//		this.nwkjcstjzx = nwkjcstjzx;
//	}
//	
//	@ExcelField(title="女外科检查室-体检中心", dictType="", align=2, sort=23)
//	public String getNwkjcstjzx() {
//		return nwkjcstjzx;
//	}
//
//	public void setNwkjcstjzx(String nwkjcstjzx) {
//		this.nwkjcstjzx = nwkjcstjzx;
//	}
	
	@ExcelField(title="其它（请注明）", align=2, sort=24)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
//	public String getJkdas() {
//		try {
//			jkdas = CheckBoxName.class.newInstance().changeName(jkdas);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return jkdas;
//	}
//
//	public void setJkdas(String jkdas) {
//		this.jkdas = jkdas;
//	}
//
//	public String getJkjys() {
//		try {
//			jkjys = CheckBoxName.class.newInstance().changeName(jkjys);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return jkjys;
//	}
//
//	public void setJkjys(String jkjys) {
//		this.jkjys = jkjys;
//	}
//
//	public String getYjqjzdt() {
//		try {
//			yjqjzdt = CheckBoxName.class.newInstance().changeName(yjqjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return yjqjzdt;
//	}
//
//	public void setYjqjzdt(String yjqjzdt) {
//		this.yjqjzdt = yjqjzdt;
//	}
//
//	public String getHzqjzdt() {
//		try {
//			hzqjzdt = CheckBoxName.class.newInstance().changeName(hzqjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return hzqjzdt;
//	}
//
//	public void setHzqjzdt(String hzqjzdt) {
//		this.hzqjzdt = hzqjzdt;
//	}
//
//	public String getJzqjzdt() {
//		try {
//			jzqjzdt = CheckBoxName.class.newInstance().changeName(jzqjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return jzqjzdt;
//	}
//
//	public void setJzqjzdt(String jzqjzdt) {
//		this.jzqjzdt = jzqjzdt;
//	}
//
//	public String getLnqjzdt() {
//		try {
//			lnqjzdt = CheckBoxName.class.newInstance().changeName(lnqjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return lnqjzdt;
//	}
//
//	public void setLnqjzdt(String lnqjzdt) {
//		this.lnqjzdt = lnqjzdt;
//	}
//
//	public String getFnbjsjzdt() {
//		try {
//			fnbjsjzdt = CheckBoxName.class.newInstance().changeName(fnbjsjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return fnbjsjzdt;
//	}
//
//	public void setFnbjsjzdt(String fnbjsjzdt) {
//		this.fnbjsjzdt = fnbjsjzdt;
//	}
//
//	public String getEtbjsjzdt() {
//		try {
//			etbjsjzdt = CheckBoxName.class.newInstance().changeName(etbjsjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return etbjsjzdt;
//	}
//
//	public void setEtbjsjzdt(String etbjsjzdt) {
//		this.etbjsjzdt = etbjsjzdt;
//	}
//
//	public String getLnrbjsjzdt() {
//		try {
//			lnrbjsjzdt = CheckBoxName.class.newInstance().changeName(lnrbjsjzdt);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return lnrbjsjzdt;
//	}
//
//	public void setLnrbjsjzdt(String lnrbjsjzdt) {
//		this.lnrbjsjzdt = lnrbjsjzdt;
//	}
//
//	public String getYbjcqtjzx() {
//		try {
//			ybjcqtjzx = CheckBoxName.class.newInstance().changeName(ybjcqtjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return ybjcqtjzx;
//	}
//
//	public void setYbjcqtjzx(String ybjcqtjzx) {
//		this.ybjcqtjzx = ybjcqtjzx;
//	}
//
//	public String getKqjcqtjzx() {
//		try {
//			kqjcqtjzx = CheckBoxName.class.newInstance().changeName(kqjcqtjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return kqjcqtjzx;
//	}
//
//	public void setKqjcqtjzx(String kqjcqtjzx) {
//		this.kqjcqtjzx = kqjcqtjzx;
//	}
//
//	public String getTljcqtjzx() {
//		try {
//			tljcqtjzx = CheckBoxName.class.newInstance().changeName(tljcqtjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return tljcqtjzx;
//	}
//
//	public void setTljcqtjzx(String tljcqtjzx) {
//		this.tljcqtjzx = tljcqtjzx;
//	}
//
//	public String getSljcqtjzx() {
//		try {
//			sljcqtjzx = CheckBoxName.class.newInstance().changeName(sljcqtjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return sljcqtjzx;
//	}
//
//	public void setSljcqtjzx(String sljcqtjzx) {
//		this.sljcqtjzx = sljcqtjzx;
//	}
//
//	public String getZljcqtjzx() {
//		try {
//			zljcqtjzx = CheckBoxName.class.newInstance().changeName(zljcqtjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return zljcqtjzx;
//	}
//
//	public void setZljcqtjzx(String zljcqtjzx) {
//		this.zljcqtjzx = zljcqtjzx;
//	}
//
//	public String getNanwkjcstjzx() {
//		try {
//			nanwkjcstjzx = CheckBoxName.class.newInstance().changeName(nanwkjcstjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return nanwkjcstjzx;
//	}
//
//	public void setNanwkjcstjzx(String nanwkjcstjzx) {
//		this.nanwkjcstjzx = nanwkjcstjzx;
//	}
//
//	public String getNvwkjcstjzx() {
//		try {
//			nvwkjcstjzx = CheckBoxName.class.newInstance().changeName(nvwkjcstjzx);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return nvwkjcstjzx;
//	}
//
//	public void setNvwkjcstjzx(String nvwkjcstjzx) {
//		this.nvwkjcstjzx = nvwkjcstjzx;
//	}
//
//	public String getQtqzm() {
//		try {
//			qtqzm = CheckBoxName.class.newInstance().changeName(qtqzm);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return qtqzm;
//	}
//
//	public void setQtqzm(String qtqzm) {
//		this.qtqzm = qtqzm;
//	}

	@ExcelField(title="主表id", align=2, sort=25)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getNanwkjcstjzx() {
		return nanwkjcstjzx;
	}

	public void setNanwkjcstjzx(String nanwkjcstjzx) {
		this.nanwkjcstjzx = nanwkjcstjzx;
	}

	public String getNvwkjcstjzx() {
		return nvwkjcstjzx;
	}

	public void setNvwkjcstjzx(String nvwkjcstjzx) {
		this.nvwkjcstjzx = nvwkjcstjzx;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}