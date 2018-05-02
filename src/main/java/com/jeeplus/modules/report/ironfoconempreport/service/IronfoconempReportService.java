/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoconempreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoconempreport.entity.IronfoconempReport;
import com.jeeplus.modules.report.ironfoconempreport.dao.IronfoconempReportDao;

/**
 * 2.7.1职工构成Service
 * @author mao
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoconempReportService extends CrudService<IronfoconempReportDao, IronfoconempReport> {

	public IronfoconempReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoconempReport> findList(IronfoconempReport ironfoconemp) {
		return super.findList(ironfoconemp);
	}
	
	public Page<IronfoconempReport> findPage(Page<IronfoconempReport> page, IronfoconempReport ironfoconemp) {
		return super.findPage(page, ironfoconemp);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoconempReport ironfoconemp) {
		super.save(ironfoconemp);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoconempReport ironfoconemp) {
		super.delete(ironfoconemp);
	}
	
	
	
	
}