/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzgrxjbkreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzgrxjbkreport.dao.IronfoyjbylsbpzgrxjbkReportDao;
import com.jeeplus.modules.report.ironfoyjbylsbpzgrxjbkreport.entity.IronfoyjbylsbpzgrxjbkReport;


/**
 * 感染性疾病科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzgrxjbkReportService extends CrudService<IronfoyjbylsbpzgrxjbkReportDao, IronfoyjbylsbpzgrxjbkReport> {

	public IronfoyjbylsbpzgrxjbkReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzgrxjbkReport> findList(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk) {
		return super.findList(ironfoyjbylsbpzgrxjbk);
	}
	
	public Page<IronfoyjbylsbpzgrxjbkReport> findPage(Page<IronfoyjbylsbpzgrxjbkReport> page, IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk) {
		return super.findPage(page, ironfoyjbylsbpzgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk) {
		super.save(ironfoyjbylsbpzgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk) {
		super.delete(ironfoyjbylsbpzgrxjbk);
	}
	
	
	
	
}