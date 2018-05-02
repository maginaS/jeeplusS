/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiventzydjcnreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiventzydjcnreport.entity.IronfofiventzydjcnReport;
import com.jeeplus.modules.report.ironfofiventzydjcnreport.dao.IronfofiventzydjcnReportDao;

/**
 * 冬季采暖Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiventzydjcnReportService extends CrudService<IronfofiventzydjcnReportDao, IronfofiventzydjcnReport> {

	public IronfofiventzydjcnReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiventzydjcnReport> findList(IronfofiventzydjcnReport ironfofiventzydjcn) {
		return super.findList(ironfofiventzydjcn);
	}
	
	public Page<IronfofiventzydjcnReport> findPage(Page<IronfofiventzydjcnReport> page, IronfofiventzydjcnReport ironfofiventzydjcn) {
		return super.findPage(page, ironfofiventzydjcn);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiventzydjcnReport ironfofiventzydjcn) {
		super.save(ironfofiventzydjcn);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiventzydjcnReport ironfofiventzydjcn) {
		super.delete(ironfofiventzydjcn);
	}
	
	
	
	
}