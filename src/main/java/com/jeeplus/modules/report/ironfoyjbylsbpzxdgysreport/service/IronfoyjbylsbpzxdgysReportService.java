/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzxdgysreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzxdgysreport.entity.IronfoyjbylsbpzxdgysReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzxdgysreport.dao.IronfoyjbylsbpzxdgysReportDao;

/**
 * 消毒供应室Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzxdgysReportService extends CrudService<IronfoyjbylsbpzxdgysReportDao, IronfoyjbylsbpzxdgysReport> {

	public IronfoyjbylsbpzxdgysReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzxdgysReport> findList(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys) {
		return super.findList(ironfoyjbylsbpzxdgys);
	}
	
	public Page<IronfoyjbylsbpzxdgysReport> findPage(Page<IronfoyjbylsbpzxdgysReport> page, IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys) {
		return super.findPage(page, ironfoyjbylsbpzxdgys);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys) {
		super.save(ironfoyjbylsbpzxdgys);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys) {
		super.delete(ironfoyjbylsbpzxdgys);
	}
	
	
	
	
}