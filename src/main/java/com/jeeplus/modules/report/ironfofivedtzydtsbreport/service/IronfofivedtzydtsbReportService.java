/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivedtzydtsbreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivedtzydtsbreport.entity.IronfofivedtzydtsbReport;
import com.jeeplus.modules.report.ironfofivedtzydtsbreport.dao.IronfofivedtzydtsbReportDao;

/**
 * 电梯设备Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivedtzydtsbReportService extends CrudService<IronfofivedtzydtsbReportDao, IronfofivedtzydtsbReport> {

	public IronfofivedtzydtsbReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivedtzydtsbReport> findList(IronfofivedtzydtsbReport ironfofivedtzydtsb) {
		return super.findList(ironfofivedtzydtsb);
	}
	
	public Page<IronfofivedtzydtsbReport> findPage(Page<IronfofivedtzydtsbReport> page, IronfofivedtzydtsbReport ironfofivedtzydtsb) {
		return super.findPage(page, ironfofivedtzydtsb);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivedtzydtsbReport ironfofivedtzydtsb) {
		super.save(ironfofivedtzydtsb);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivedtzydtsbReport ironfofivedtzydtsb) {
		super.delete(ironfofivedtzydtsb);
	}
	
	
	
	
}