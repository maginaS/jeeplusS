/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.2信息化系统功能实现Entity
 * @author mikesun
 * @version 2018-04-08
 */
public class Ironfoinformationsxjbggwsfw extends DataEntity<Ironfoinformationsxjbggwsfw> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String se_id;		// 4.2信息化系统功能实现表ID
	private String jkjyfw;		// 健康教育服务
	private String yfjzfw;		// 预防接种服务
	private String etjkglfw;		// 儿童健康管理服务
	private String ycfjkglfw;		// 孕产妇健康管理服务
	private String lnrjkglfw;		// 老年人健康管理服务
	private String gxyhzjkglfw;		// 高血压患者健康管理服务
	private String extnbhzjkglfw;		// 2型糖尿病患者健康管理服务
	private String yzjszahzjkglfw;		// 严重精神障碍患者健康管理服务
	private String fjhhzjkglfw;		// 肺结核患者健康管理服务
	private String lnrzyyjkglfw;		// 老年人中医药健康管理服务
	private String etzyyjkglfw;		// 儿童中医药健康管理服务
	private String crbjtfggwssjglfw;		// 传染病及突发公共卫生事件管理服务
	private String wsjsjdxgfw;		// 卫生计生监督协管服务
	private String jhsyjsfw;		// 计划生育技术服务
	private String mxbjcfw;		// 慢性病检测服务
	
	public Ironfoinformationsxjbggwsfw() {
		super();
	}

	public Ironfoinformationsxjbggwsfw(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="4.2信息化系统功能实现表ID", align=2, sort=8)
	public String getSe_id() {
		return se_id;
	}

	public void setSe_id(String se_id) {
		this.se_id = se_id;
	}
	
	@ExcelField(title="健康教育服务", dictType="", align=2, sort=9)
	public String getJkjyfw() {
		return jkjyfw;
	}

	public void setJkjyfw(String jkjyfw) {
		this.jkjyfw = jkjyfw;
	}
	
	@ExcelField(title="预防接种服务", dictType="", align=2, sort=10)
	public String getYfjzfw() {
		return yfjzfw;
	}

	public void setYfjzfw(String yfjzfw) {
		this.yfjzfw = yfjzfw;
	}
	
	@ExcelField(title="儿童健康管理服务", dictType="", align=2, sort=11)
	public String getEtjkglfw() {
		return etjkglfw;
	}

	public void setEtjkglfw(String etjkglfw) {
		this.etjkglfw = etjkglfw;
	}
	
	@ExcelField(title="孕产妇健康管理服务", dictType="", align=2, sort=12)
	public String getYcfjkglfw() {
		return ycfjkglfw;
	}

	public void setYcfjkglfw(String ycfjkglfw) {
		this.ycfjkglfw = ycfjkglfw;
	}
	
	@ExcelField(title="老年人健康管理服务", dictType="", align=2, sort=13)
	public String getLnrjkglfw() {
		return lnrjkglfw;
	}

	public void setLnrjkglfw(String lnrjkglfw) {
		this.lnrjkglfw = lnrjkglfw;
	}
	
	@ExcelField(title="高血压患者健康管理服务", dictType="", align=2, sort=14)
	public String getGxyhzjkglfw() {
		return gxyhzjkglfw;
	}

	public void setGxyhzjkglfw(String gxyhzjkglfw) {
		this.gxyhzjkglfw = gxyhzjkglfw;
	}
	
	@ExcelField(title="2型糖尿病患者健康管理服务", dictType="", align=2, sort=15)
	public String getExtnbhzjkglfw() {
		return extnbhzjkglfw;
	}

	public void setExtnbhzjkglfw(String extnbhzjkglfw) {
		this.extnbhzjkglfw = extnbhzjkglfw;
	}
	
	@ExcelField(title="严重精神障碍患者健康管理服务", dictType="", align=2, sort=16)
	public String getYzjszahzjkglfw() {
		return yzjszahzjkglfw;
	}

	public void setYzjszahzjkglfw(String yzjszahzjkglfw) {
		this.yzjszahzjkglfw = yzjszahzjkglfw;
	}
	
	@ExcelField(title="肺结核患者健康管理服务", dictType="", align=2, sort=17)
	public String getFjhhzjkglfw() {
		return fjhhzjkglfw;
	}

	public void setFjhhzjkglfw(String fjhhzjkglfw) {
		this.fjhhzjkglfw = fjhhzjkglfw;
	}
	
	@ExcelField(title="老年人中医药健康管理服务", dictType="", align=2, sort=18)
	public String getLnrzyyjkglfw() {
		return lnrzyyjkglfw;
	}

	public void setLnrzyyjkglfw(String lnrzyyjkglfw) {
		this.lnrzyyjkglfw = lnrzyyjkglfw;
	}
	
	@ExcelField(title="儿童中医药健康管理服务", dictType="", align=2, sort=19)
	public String getEtzyyjkglfw() {
		return etzyyjkglfw;
	}

	public void setEtzyyjkglfw(String etzyyjkglfw) {
		this.etzyyjkglfw = etzyyjkglfw;
	}
	
	@ExcelField(title="传染病及突发公共卫生事件管理服务", dictType="", align=2, sort=20)
	public String getCrbjtfggwssjglfw() {
		return crbjtfggwssjglfw;
	}

	public void setCrbjtfggwssjglfw(String crbjtfggwssjglfw) {
		this.crbjtfggwssjglfw = crbjtfggwssjglfw;
	}
	
	@ExcelField(title="卫生计生监督协管服务", dictType="", align=2, sort=21)
	public String getWsjsjdxgfw() {
		return wsjsjdxgfw;
	}

	public void setWsjsjdxgfw(String wsjsjdxgfw) {
		this.wsjsjdxgfw = wsjsjdxgfw;
	}
	
	@ExcelField(title="计划生育技术服务", dictType="", align=2, sort=22)
	public String getJhsyjsfw() {
		return jhsyjsfw;
	}

	public void setJhsyjsfw(String jhsyjsfw) {
		this.jhsyjsfw = jhsyjsfw;
	}
	
	@ExcelField(title="慢性病检测服务", dictType="", align=2, sort=23)
	public String getMxbjcfw() {
		return mxbjcfw;
	}

	public void setMxbjcfw(String mxbjcfw) {
		this.mxbjcfw = mxbjcfw;
	}
	
}