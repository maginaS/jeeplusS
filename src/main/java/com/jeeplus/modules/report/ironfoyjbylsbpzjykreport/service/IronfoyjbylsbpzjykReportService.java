/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzjykreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzjykreport.entity.IronfoyjbylsbpzjykReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzjykreport.dao.IronfoyjbylsbpzjykReportDao;

/**
 * 检验科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzjykReportService extends CrudService<IronfoyjbylsbpzjykReportDao, IronfoyjbylsbpzjykReport> {

	public IronfoyjbylsbpzjykReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzjykReport> findList(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk) {
		return super.findList(ironfoyjbylsbpzjyk);
	}
	
	public Page<IronfoyjbylsbpzjykReport> findPage(Page<IronfoyjbylsbpzjykReport> page, IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk) {
		return super.findPage(page, ironfoyjbylsbpzjyk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk) {
		super.save(ironfoyjbylsbpzjyk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk) {
		super.delete(ironfoyjbylsbpzjyk);
	}
	
	
	
	
}