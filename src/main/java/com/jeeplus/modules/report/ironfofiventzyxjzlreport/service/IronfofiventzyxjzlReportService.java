/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiventzyxjzlreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiventzyxjzlreport.entity.IronfofiventzyxjzlReport;
import com.jeeplus.modules.report.ironfofiventzyxjzlreport.dao.IronfofiventzyxjzlReportDao;

/**
 * 夏季制冷Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiventzyxjzlReportService extends CrudService<IronfofiventzyxjzlReportDao, IronfofiventzyxjzlReport> {

	public IronfofiventzyxjzlReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiventzyxjzlReport> findList(IronfofiventzyxjzlReport ironfofiventzyxjzl) {
		return super.findList(ironfofiventzyxjzl);
	}
	
	public Page<IronfofiventzyxjzlReport> findPage(Page<IronfofiventzyxjzlReport> page, IronfofiventzyxjzlReport ironfofiventzyxjzl) {
		return super.findPage(page, ironfofiventzyxjzl);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiventzyxjzlReport ironfofiventzyxjzl) {
		super.save(ironfofiventzyxjzl);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiventzyxjzlReport ironfofiventzyxjzl) {
		super.delete(ironfofiventzyxjzl);
	}
	
	
	
	
}