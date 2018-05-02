/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivedqzygdfsreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivedqzygdfsreport.entity.IronfofivedqzygdfsReport;
import com.jeeplus.modules.report.ironfofivedqzygdfsreport.dao.IronfofivedqzygdfsReportDao;

/**
 * 供电方式Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivedqzygdfsReportService extends CrudService<IronfofivedqzygdfsReportDao, IronfofivedqzygdfsReport> {

	public IronfofivedqzygdfsReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivedqzygdfsReport> findList(IronfofivedqzygdfsReport ironfofivedqzygdfs) {
		return super.findList(ironfofivedqzygdfs);
	}
	
	public Page<IronfofivedqzygdfsReport> findPage(Page<IronfofivedqzygdfsReport> page, IronfofivedqzygdfsReport ironfofivedqzygdfs) {
		return super.findPage(page, ironfofivedqzygdfs);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivedqzygdfsReport ironfofivedqzygdfs) {
		super.save(ironfofivedqzygdfs);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivedqzygdfsReport ironfofivedqzygdfs) {
		super.delete(ironfofivedqzygdfs);
	}
	
	
	
	
}