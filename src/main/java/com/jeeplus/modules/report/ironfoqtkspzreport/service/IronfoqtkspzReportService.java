/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoqtkspzreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoqtkspzreport.entity.IronfoqtkspzReport;
import com.jeeplus.modules.report.ironfoqtkspzreport.dao.IronfoqtkspzReportDao;

/**
 * 3.6其他科室医疗设备配置Service
 * @author anti_magina
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfoqtkspzReportService extends CrudService<IronfoqtkspzReportDao, IronfoqtkspzReport> {

	public IronfoqtkspzReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoqtkspzReport> findList(IronfoqtkspzReport ironfoqtkspz) {
		return super.findList(ironfoqtkspz);
	}
	
	public Page<IronfoqtkspzReport> findPage(Page<IronfoqtkspzReport> page, IronfoqtkspzReport ironfoqtkspz) {
		return super.findPage(page, ironfoqtkspz);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoqtkspzReport ironfoqtkspz) {
		super.save(ironfoqtkspz);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoqtkspzReport ironfoqtkspz) {
		super.delete(ironfoqtkspz);
	}
	
	
	
	
}