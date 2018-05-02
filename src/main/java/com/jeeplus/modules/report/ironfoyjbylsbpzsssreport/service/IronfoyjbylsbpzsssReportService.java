/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.entity.IronfoyjbylsbpzsssReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.dao.IronfoyjbylsbpzsssReportDao;

/**
 * 手术室Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzsssReportService extends CrudService<IronfoyjbylsbpzsssReportDao, IronfoyjbylsbpzsssReport> {

	public IronfoyjbylsbpzsssReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzsssReport> findList(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss) {
		return super.findList(ironfoyjbylsbpzsss);
	}
	
	public Page<IronfoyjbylsbpzsssReport> findPage(Page<IronfoyjbylsbpzsssReport> page, IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss) {
		return super.findPage(page, ironfoyjbylsbpzsss);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss) {
		super.save(ironfoyjbylsbpzsss);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss) {
		super.delete(ironfoyjbylsbpzsss);
	}
	
	
	
	
}