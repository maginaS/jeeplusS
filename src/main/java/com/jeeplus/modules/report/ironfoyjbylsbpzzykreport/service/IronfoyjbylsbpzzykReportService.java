/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.entity.IronfoyjbylsbpzzykReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.dao.IronfoyjbylsbpzzykReportDao;

/**
 * 中医科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzzykReportService extends CrudService<IronfoyjbylsbpzzykReportDao, IronfoyjbylsbpzzykReport> {

	public IronfoyjbylsbpzzykReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzzykReport> findList(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk) {
		return super.findList(ironfoyjbylsbpzzyk);
	}
	
	public Page<IronfoyjbylsbpzzykReport> findPage(Page<IronfoyjbylsbpzzykReport> page, IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk) {
		return super.findPage(page, ironfoyjbylsbpzzyk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk) {
		super.save(ironfoyjbylsbpzzyk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk) {
		super.delete(ironfoyjbylsbpzzyk);
	}
	
	
	
	
}