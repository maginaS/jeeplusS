/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofinancereport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofinancereport.entity.IronfofinanceReport;
import com.jeeplus.modules.report.ironfofinancereport.dao.IronfofinanceReportDao;

/**
 * 2.2财务收支Service
 * @author mao
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfofinanceReportService extends CrudService<IronfofinanceReportDao, IronfofinanceReport> {

	public IronfofinanceReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofinanceReport> findList(IronfofinanceReport ironfofinance) {
		return super.findList(ironfofinance);
	}
	
	public Page<IronfofinanceReport> findPage(Page<IronfofinanceReport> page, IronfofinanceReport ironfofinance) {
		return super.findPage(page, ironfofinance);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofinanceReport ironfofinance) {
		super.save(ironfofinance);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofinanceReport ironfofinance) {
		super.delete(ironfofinance);
	}
	
	
	
	
}