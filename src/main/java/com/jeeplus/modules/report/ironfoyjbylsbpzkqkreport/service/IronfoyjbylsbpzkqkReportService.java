/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzkqkreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzkqkreport.entity.IronfoyjbylsbpzkqkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzkqkreport.dao.IronfoyjbylsbpzkqkReportDao;

/**
 * 口腔科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzkqkReportService extends CrudService<IronfoyjbylsbpzkqkReportDao, IronfoyjbylsbpzkqkReport> {

	public IronfoyjbylsbpzkqkReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzkqkReport> findList(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk) {
		return super.findList(ironfoyjbylsbpzkqk);
	}
	
	public Page<IronfoyjbylsbpzkqkReport> findPage(Page<IronfoyjbylsbpzkqkReport> page, IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk) {
		return super.findPage(page, ironfoyjbylsbpzkqk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk) {
		super.save(ironfoyjbylsbpzkqk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk) {
		super.delete(ironfoyjbylsbpzkqk);
	}
	
	
	
	
}