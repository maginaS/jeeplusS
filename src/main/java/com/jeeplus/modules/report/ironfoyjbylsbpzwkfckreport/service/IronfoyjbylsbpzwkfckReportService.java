/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzwkfckreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzwkfckreport.entity.IronfoyjbylsbpzwkfckReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzwkfckreport.dao.IronfoyjbylsbpzwkfckReportDao;

/**
 * 外科、妇（产）科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzwkfckReportService extends CrudService<IronfoyjbylsbpzwkfckReportDao, IronfoyjbylsbpzwkfckReport> {

	public IronfoyjbylsbpzwkfckReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzwkfckReport> findList(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck) {
		return super.findList(ironfoyjbylsbpzwkfck);
	}
	
	public Page<IronfoyjbylsbpzwkfckReport> findPage(Page<IronfoyjbylsbpzwkfckReport> page, IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck) {
		return super.findPage(page, ironfoyjbylsbpzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck) {
		super.save(ironfoyjbylsbpzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck) {
		super.delete(ironfoyjbylsbpzwkfck);
	}
	
	
	
	
}