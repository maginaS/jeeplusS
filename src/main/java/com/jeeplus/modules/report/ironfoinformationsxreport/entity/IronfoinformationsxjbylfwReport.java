/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationsxreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 4.2信息化系统功能实现Entity
 * @author anti_magina
 * @version 2018-04-24
 */
public class IronfoinformationsxjbylfwReport extends DataEntity<IronfoinformationsxjbylfwReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String se_id;		// 4.2信息化系统功能实现表id
	private String qkzlfw;		// 全科诊疗服务
	private String zyglfw;		// 住院管理服务
	private String jtbcyhlfw;		// 家庭病床与护理服务
	private String jktyfw;		// 健康体检服务
	private String jyhjcfw;		// 检验和检查服务
	private String ycsxzzfw;		// 远程双向转诊服务
	private String ychzfw;		// 远程会诊服务
	private String ycyyfw;		// 远程预约服务
	private String ycyxzdfw;		// 远程影像诊断服务
	private String ycxdzdfw;		// 远程心电诊断服务
	private String ycyxjyfw;		// 远程医学教育服务
	private String yczzjhfw;		// 远程重症监护服务
	private String ycsssjfw;		// 远程手术示教服务
	private String ssmzglfw;		// 手术麻醉管理服务
	private String zyjhfw;		// 中央监护服务
	
	public IronfoinformationsxjbylfwReport() {
		super();
	}

	public IronfoinformationsxjbylfwReport(String id){
		super(id);
	}

	@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="4.2信息化系统功能实现表id", align=2, sort=8)
	public String getSe_id() {
		return se_id;
	}

	public void setSe_id(String se_id) {
		this.se_id = se_id;
	}
	
	@ExcelField(title="全科诊疗服务", dictType="", align=2, sort=9)
	public String getQkzlfw() {
		return qkzlfw;
	}

	public void setQkzlfw(String qkzlfw) {
		this.qkzlfw = qkzlfw;
	}
	
	@ExcelField(title="住院管理服务", dictType="", align=2, sort=10)
	public String getZyglfw() {
		return zyglfw;
	}

	public void setZyglfw(String zyglfw) {
		this.zyglfw = zyglfw;
	}
	
	@ExcelField(title="家庭病床与护理服务", dictType="", align=2, sort=11)
	public String getJtbcyhlfw() {
		return jtbcyhlfw;
	}

	public void setJtbcyhlfw(String jtbcyhlfw) {
		this.jtbcyhlfw = jtbcyhlfw;
	}
	
	@ExcelField(title="健康体检服务", dictType="", align=2, sort=12)
	public String getJktyfw() {
		return jktyfw;
	}

	public void setJktyfw(String jktyfw) {
		this.jktyfw = jktyfw;
	}
	
	@ExcelField(title="检验和检查服务", dictType="", align=2, sort=13)
	public String getJyhjcfw() {
		return jyhjcfw;
	}

	public void setJyhjcfw(String jyhjcfw) {
		this.jyhjcfw = jyhjcfw;
	}
	
	@ExcelField(title="远程双向转诊服务", dictType="", align=2, sort=14)
	public String getYcsxzzfw() {
		return ycsxzzfw;
	}

	public void setYcsxzzfw(String ycsxzzfw) {
		this.ycsxzzfw = ycsxzzfw;
	}
	
	@ExcelField(title="远程会诊服务", dictType="", align=2, sort=15)
	public String getYchzfw() {
		return ychzfw;
	}

	public void setYchzfw(String ychzfw) {
		this.ychzfw = ychzfw;
	}
	
	@ExcelField(title="远程预约服务", dictType="", align=2, sort=16)
	public String getYcyyfw() {
		return ycyyfw;
	}

	public void setYcyyfw(String ycyyfw) {
		this.ycyyfw = ycyyfw;
	}
	
	@ExcelField(title="远程影像诊断服务", dictType="", align=2, sort=17)
	public String getYcyxzdfw() {
		return ycyxzdfw;
	}

	public void setYcyxzdfw(String ycyxzdfw) {
		this.ycyxzdfw = ycyxzdfw;
	}
	
	@ExcelField(title="远程心电诊断服务", dictType="", align=2, sort=18)
	public String getYcxdzdfw() {
		return ycxdzdfw;
	}

	public void setYcxdzdfw(String ycxdzdfw) {
		this.ycxdzdfw = ycxdzdfw;
	}
	
	@ExcelField(title="远程医学教育服务", dictType="", align=2, sort=19)
	public String getYcyxjyfw() {
		return ycyxjyfw;
	}

	public void setYcyxjyfw(String ycyxjyfw) {
		this.ycyxjyfw = ycyxjyfw;
	}
	
	@ExcelField(title="远程重症监护服务", dictType="", align=2, sort=20)
	public String getYczzjhfw() {
		return yczzjhfw;
	}

	public void setYczzjhfw(String yczzjhfw) {
		this.yczzjhfw = yczzjhfw;
	}
	
	@ExcelField(title="远程手术示教服务", dictType="", align=2, sort=21)
	public String getYcsssjfw() {
		return ycsssjfw;
	}

	public void setYcsssjfw(String ycsssjfw) {
		this.ycsssjfw = ycsssjfw;
	}
	
	@ExcelField(title="手术麻醉管理服务", dictType="", align=2, sort=22)
	public String getSsmzglfw() {
		return ssmzglfw;
	}

	public void setSsmzglfw(String ssmzglfw) {
		this.ssmzglfw = ssmzglfw;
	}
	
	@ExcelField(title="中央监护服务", dictType="", align=2, sort=23)
	public String getZyjhfw() {
		return zyjhfw;
	}

	public void setZyjhfw(String zyjhfw) {
		this.zyjhfw = zyjhfw;
	}
	
}