/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzykebyhkreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzykebyhkreport.entity.IronfoyjbylsbpzykebyhkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzykebyhkreport.dao.IronfoyjbylsbpzykebyhkReportDao;

/**
 * 眼科、耳鼻咽喉科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzykebyhkReportService extends CrudService<IronfoyjbylsbpzykebyhkReportDao, IronfoyjbylsbpzykebyhkReport> {

	public IronfoyjbylsbpzykebyhkReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzykebyhkReport> findList(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk) {
		return super.findList(ironfoyjbylsbpzykebyhk);
	}
	
	public Page<IronfoyjbylsbpzykebyhkReport> findPage(Page<IronfoyjbylsbpzykebyhkReport> page, IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk) {
		return super.findPage(page, ironfoyjbylsbpzykebyhk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk) {
		super.save(ironfoyjbylsbpzykebyhk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk) {
		super.delete(ironfoyjbylsbpzykebyhk);
	}
	
	
	
	
}