/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveyjyf.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 5.3医技用房Entity
 * @author mikesun
 * @version 2018-04-14
 */
public class Ironfofiveyjyf extends DataEntity<Ironfofiveyjyf> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积
	private String mzxyfyjkyf;		// 门诊西药房-药剂科用房
	
	//anti_magina add
	private String mzxyfyjkyfName;
	
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
	
	

	public Ironfofiveyjyf() {
		super();
	}

	public Ironfofiveyjyf(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
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
//	public String getMzxyfyjkyf() {
//		try {
//			mzxyfyjkyf = CheckBoxName.class.newInstance().changeName(mzxyfyjkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mzxyfyjkyf;
//	}
//
//	public void setMzxyfyjkyf(String mzxyfyjkyf) {
//		this.mzxyfyjkyf = mzxyfyjkyf;
//	}
//
//	public String getMzzyfyjkyf() {
//		try {
//			mzzyfyjkyf = CheckBoxName.class.newInstance().changeName(mzzyfyjkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mzzyfyjkyf;
//	}
//
//	public void setMzzyfyjkyf(String mzzyfyjkyf) {
//		this.mzzyfyjkyf = mzzyfyjkyf;
//	}
//
//	public String getJzyfyjkyf() {
//		try {
//			jzyfyjkyf = CheckBoxName.class.newInstance().changeName(jzyfyjkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jzyfyjkyf;
//	}
//
//	public void setJzyfyjkyf(String jzyfyjkyf) {
//		this.jzyfyjkyf = jzyfyjkyf;
//	}
//
//	public String getTsyfyjkyf() {
//		try {
//			tsyfyjkyf = CheckBoxName.class.newInstance().changeName(tsyfyjkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return tsyfyjkyf;
//	}
//
//	public void setTsyfyjkyf(String tsyfyjkyf) {
//		this.tsyfyjkyf = tsyfyjkyf;
//	}
//
//	public String getJyfyjkyf() {
//		try {
//			jyfyjkyf = CheckBoxName.class.newInstance().changeName(jyfyjkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jyfyjkyf;
//	}
//
//	public void setJyfyjkyf(String jyfyjkyf) {
//		this.jyfyjkyf = jyfyjkyf;
//	}
//
//	public String getYpkyjkyf() {
//		try {
//			ypkyjkyf = CheckBoxName.class.newInstance().changeName(ypkyjkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ypkyjkyf;
//	}
//
//	public void setYpkyjkyf(String ypkyjkyf) {
//		this.ypkyjkyf = ypkyjkyf;
//	}
//
//	public String getCxsjykyf() {
//		try {
//			cxsjykyf = CheckBoxName.class.newInstance().changeName(cxsjykyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return cxsjykyf;
//	}
//
//	public void setCxsjykyf(String cxsjykyf) {
//		this.cxsjykyf = cxsjykyf;
//	}
//
//	public String getHysjykyf() {
//		try {
//			hysjykyf = CheckBoxName.class.newInstance().changeName(hysjykyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return hysjykyf;
//	}
//
//	public void setHysjykyf(String hysjykyf) {
//		this.hysjykyf = hysjykyf;
//	}
//
//	public String getXgjspsfskyf() {
//		try {
//			xgjspsfskyf = CheckBoxName.class.newInstance().changeName(xgjspsfskyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return xgjspsfskyf;
//	}
//
//	public void setXgjspsfskyf(String xgjspsfskyf) {
//		this.xgjspsfskyf = xgjspsfskyf;
//	}
//
//	public String getXgjkzsfskyf() {
//		try {
//			xgjkzsfskyf = CheckBoxName.class.newInstance().changeName(xgjkzsfskyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return xgjkzsfskyf;
//	}
//
//	public void setXgjkzsfskyf(String xgjkzsfskyf) {
//		this.xgjkzsfskyf = xgjkzsfskyf;
//	}
//
//	public String getCtspsfskyf() {
//		try {
//			ctspsfskyf = CheckBoxName.class.newInstance().changeName(ctspsfskyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ctspsfskyf;
//	}
//
//	public void setCtspsfskyf(String ctspsfskyf) {
//		this.ctspsfskyf = ctspsfskyf;
//	}
//
//	public String getCtkzsfskyf() {
//		try {
//			ctkzsfskyf = CheckBoxName.class.newInstance().changeName(ctkzsfskyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ctkzsfskyf;
//	}
//
//	public void setCtkzsfskyf(String ctkzsfskyf) {
//		this.ctkzsfskyf = ctkzsfskyf;
//	}
//
//	public String getDpsfskyf() {
//		try {
//			dpsfskyf = CheckBoxName.class.newInstance().changeName(dpsfskyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dpsfskyf;
//	}
//
//	public void setDpsfskyf(String dpsfskyf) {
//		this.dpsfskyf = dpsfskyf;
//	}
//
//	public String getXdts() {
//		try {
//			xdts = CheckBoxName.class.newInstance().changeName(xdts);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return xdts;
//	}
//
//	public void setXdts(String xdts) {
//		this.xdts = xdts;
//	}
//
//	public String getCss() {
//		try {
//			css = CheckBoxName.class.newInstance().changeName(css);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return css;
//	}
//
//	public void setCss(String css) {
//		this.css = css;
//	}
//
//	public String getXksxkyf() {
//		try {
//			xksxkyf = CheckBoxName.class.newInstance().changeName(xksxkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return xksxkyf;
//	}
//
//	public void setXksxkyf(String xksxkyf) {
//		this.xksxkyf = xksxkyf;
//	}
//
//	public String getPxssxkyf() {
//		try {
//			pxssxkyf = CheckBoxName.class.newInstance().changeName(pxssxkyf);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return pxssxkyf;
//	}
//
//	public void setPxssxkyf(String pxssxkyf) {
//		this.pxssxkyf = pxssxkyf;
//	}
//
//	public String getQwqxdgys() {
//		try {
//			qwqxdgys = CheckBoxName.class.newInstance().changeName(qwqxdgys);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return qwqxdgys;
//	}
//
//	public void setQwqxdgys(String qwqxdgys) {
//		this.qwqxdgys = qwqxdgys;
//	}
//
//	public String getJcbzjmjqxdgys() {
//		try {
//			jcbzjmjqxdgys = CheckBoxName.class.newInstance().changeName(jcbzjmjqxdgys);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jcbzjmjqxdgys;
//	}
//
//	public void setJcbzjmjqxdgys(String jcbzjmjqxdgys) {
//		this.jcbzjmjqxdgys = jcbzjmjqxdgys;
//	}
//
//	public String getWjwpcfqxdgys() {
//		try {
//			wjwpcfqxdgys = CheckBoxName.class.newInstance().changeName(wjwpcfqxdgys);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return wjwpcfqxdgys;
//	}
//
//	public void setWjwpcfqxdgys(String wjwpcfqxdgys) {
//		this.wjwpcfqxdgys = wjwpcfqxdgys;
//	}
//
//	public String getSssssb() {
//		try {
//			sssssb = CheckBoxName.class.newInstance().changeName(sssssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sssssb;
//	}
//
//	public void setSssssb(String sssssb) {
//		this.sssssb = sssssb;
//	}
//
//	public String getCfssb() {
//		try {
//			cfssb = CheckBoxName.class.newInstance().changeName(cfssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return cfssb;
//	}
//
//	public void setCfssb(String cfssb) {
//		this.cfssb = cfssb;
//	}
//
//	public String getZbsssb() {
//		try {
//			zbsssb = CheckBoxName.class.newInstance().changeName(zbsssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return zbsssb;
//	}
//
//	public void setZbsssb(String zbsssb) {
//		this.zbsssb = zbsssb;
//	}
//
//	public String getDcsssb() {
//		try {
//			dcsssb = CheckBoxName.class.newInstance().changeName(dcsssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dcsssb;
//	}
//
//	public void setDcsssb(String dcsssb) {
//		this.dcsssb = dcsssb;
//	}
//
//	public String getGysssb() {
//		try {
//			gysssb = CheckBoxName.class.newInstance().changeName(gysssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return gysssb;
//	}
//
//	public void setGysssb(String gysssb) {
//		this.gysssb = gysssb;
//	}
//
//	public String getXsjssb() {
//		try {
//			xsjssb = CheckBoxName.class.newInstance().changeName(xsjssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return xsjssb;
//	}
//
//	public void setXsjssb(String xsjssb) {
//		this.xsjssb = xsjssb;
//	}
//
//	public String getShsxsssb() {
//		try {
//			shsxsssb = CheckBoxName.class.newInstance().changeName(shsxsssb);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return shsxsssb;
//	}
//
//	public void setShsxsssb(String shsxsssb) {
//		this.shsxsssb = shsxsssb;
//	}

	public String getMzxyfyjkyfName() {
//		if(mzxyfyjkyfName==null||"".equals(mzxyfyjkyfName))
//			return (mzxyfyjkyf!=null&&mzxyfyjkyf.equals("1"))?"是":"否";
		return mzxyfyjkyfName;
	}

	public void setMzxyfyjkyfName(String mzxyfyjkyfName) {
		this.mzxyfyjkyfName = mzxyfyjkyfName;
	}

	
	
}