/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpznekreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpznekreport.entity.IronfoyjbylsbpznekReport;
import com.jeeplus.modules.report.ironfoyjbylsbpznekreport.dao.IronfoyjbylsbpznekReportDao;

/**
 * 内（儿）科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpznekReportService extends CrudService<IronfoyjbylsbpznekReportDao, IronfoyjbylsbpznekReport> {

	public IronfoyjbylsbpznekReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpznekReport> findList(IronfoyjbylsbpznekReport ironfoyjbylsbpznek) {
		return super.findList(ironfoyjbylsbpznek);
	}
	
	public Page<IronfoyjbylsbpznekReport> findPage(Page<IronfoyjbylsbpznekReport> page, IronfoyjbylsbpznekReport ironfoyjbylsbpznek) {
		return super.findPage(page, ironfoyjbylsbpznek);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpznekReport ironfoyjbylsbpznek) {
		super.save(ironfoyjbylsbpznek);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpznekReport ironfoyjbylsbpznek) {
		super.delete(ironfoyjbylsbpznek);
	}
	
	
	
	
}