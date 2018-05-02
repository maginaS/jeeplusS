/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzkfkreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzkfkreport.entity.IronfoyjbylsbpzkfkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzkfkreport.dao.IronfoyjbylsbpzkfkReportDao;

/**
 * 康复科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzkfkReportService extends CrudService<IronfoyjbylsbpzkfkReportDao, IronfoyjbylsbpzkfkReport> {

	public IronfoyjbylsbpzkfkReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzkfkReport> findList(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk) {
		return super.findList(ironfoyjbylsbpzkfk);
	}
	
	public Page<IronfoyjbylsbpzkfkReport> findPage(Page<IronfoyjbylsbpzkfkReport> page, IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk) {
		return super.findPage(page, ironfoyjbylsbpzkfk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk) {
		super.save(ironfoyjbylsbpzkfk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk) {
		super.delete(ironfoyjbylsbpzkfk);
	}
	
	
	
	
}