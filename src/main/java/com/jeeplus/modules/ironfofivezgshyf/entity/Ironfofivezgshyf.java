/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezgshyf.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.report.utils.CheckBoxName;

/**
 * 5.8职工生活用房Entity
 * @author mikesun
 * @version 2018-04-15
 */
public class Ironfofivezgshyf extends DataEntity<Ironfofivezgshyf> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private String zgss;		// 职工宿舍
	private String wsj;		// 卫生间
	private String hxj;		// 盥洗间
	private String lyj;		// 淋浴间
	private String zyst;		// 自饮食堂
	private String qtqzm;		// 其它（请注明）
	
	public Ironfofivezgshyf() {
		super();
	}

	public Ironfofivezgshyf(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
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
	
	@ExcelField(title="职工宿舍", dictType="", align=2, sort=9)
	public String getZgss() {
		return zgss;
	}

	public void setZgss(String zgss) {
		this.zgss = zgss;
	}
	
	@ExcelField(title="卫生间", dictType="", align=2, sort=10)
	public String getWsj() {
		return wsj;
	}

	public void setWsj(String wsj) {
		this.wsj = wsj;
	}
	
	@ExcelField(title="盥洗间", dictType="", align=2, sort=11)
	public String getHxj() {
		return hxj;
	}

	public void setHxj(String hxj) {
		this.hxj = hxj;
	}
	
	@ExcelField(title="淋浴间", dictType="", align=2, sort=12)
	public String getLyj() {
		return lyj;
	}

	public void setLyj(String lyj) {
		this.lyj = lyj;
	}
	
	@ExcelField(title="自饮食堂", dictType="", align=2, sort=13)
	public String getZyst() {
		return zyst;
	}

	public void setZyst(String zyst) {
		this.zyst = zyst;
	}
	
//	public String getZgss() {
//		try {
//			zgss = CheckBoxName.class.newInstance().changeName(zgss);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return zgss;
//	}
//
//	public void setZgss(String zgss) {
//		this.zgss = zgss;
//	}
//
//	public String getWsj() {
//		try {
//			wsj = CheckBoxName.class.newInstance().changeName(wsj);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return wsj;
//	}
//
//	public void setWsj(String wsj) {
//		this.wsj = wsj;
//	}
//
//	public String getHxj() {
//		try {
//			hxj = CheckBoxName.class.newInstance().changeName(hxj);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return hxj;
//	}
//
//	public void setHxj(String hxj) {
//		this.hxj = hxj;
//	}
//
//	public String getLyj() {
//		try {
//			lyj = CheckBoxName.class.newInstance().changeName(lyj);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return lyj;
//	}
//
//	public void setLyj(String lyj) {
//		this.lyj = lyj;
//	}
//
//	public String getZyst() {
//		try {
//			zyst = CheckBoxName.class.newInstance().changeName(zyst);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return zyst;
//	}
//
//	public void setZyst(String zyst) {
//		this.zyst = zyst;
//	}

	@ExcelField(title="其它（请注明）", align=2, sort=14)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}