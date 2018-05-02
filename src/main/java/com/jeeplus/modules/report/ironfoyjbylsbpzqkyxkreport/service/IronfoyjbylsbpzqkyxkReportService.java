/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzqkyxkreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzqkyxkreport.entity.IronfoyjbylsbpzqkyxkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzqkyxkreport.dao.IronfoyjbylsbpzqkyxkReportDao;

/**
 * 全科医学科Service
 * @author anti_magina
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzqkyxkReportService extends CrudService<IronfoyjbylsbpzqkyxkReportDao, IronfoyjbylsbpzqkyxkReport> {

	public IronfoyjbylsbpzqkyxkReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzqkyxkReport> findList(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk) {
		return super.findList(ironfoyjbylsbpzqkyxk);
	}
	
	public Page<IronfoyjbylsbpzqkyxkReport> findPage(Page<IronfoyjbylsbpzqkyxkReport> page, IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk) {
		return super.findPage(page, ironfoyjbylsbpzqkyxk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk) {
		super.save(ironfoyjbylsbpzqkyxk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk) {
		super.delete(ironfoyjbylsbpzqkyxk);
	}
	
	
	
	
}