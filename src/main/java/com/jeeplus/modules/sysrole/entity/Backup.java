/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 数据库管理Entity
 * @author 瞿高青
 * @version 2017-10-18
 */
public class Backup extends DataEntity<Backup> {
	
	private static final long serialVersionUID = 1L;
	private Date date;		// 备份时间
	private String content;		// 备份内容
	private String dataName;		// 备份数据库
	private String path;		// 备份文件路径
	private String size;		// 备份文件大小（单位：g）
	private String status;		// 备份状态0--未备份 1--备份中 2--备份成功
	
	public Backup() {
		super();
	}

	public Backup(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="备份时间", align=2, sort=7)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ExcelField(title="备份内容", align=2, sort=8)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@ExcelField(title="备份数据库", align=2, sort=9)
	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	
	@ExcelField(title="备份文件路径", align=2, sort=10)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@ExcelField(title="备份文件大小（单位：g）", align=2, sort=11)
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@ExcelField(title="备份状态0--未备份 1--备份中 2--备份成功", align=2, sort=12)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}