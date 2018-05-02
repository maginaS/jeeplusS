/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoggwsylsbpzreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoggwsylsbpzreport.entity.IronfoggwsylsbpzReport;
import com.jeeplus.modules.report.ironfoggwsylsbpzreport.dao.IronfoggwsylsbpzReportDao;

/**
 * 3.4公共卫生部医疗设备配置Service
 * @author anti_magina
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfoggwsylsbpzReportService extends CrudService<IronfoggwsylsbpzReportDao, IronfoggwsylsbpzReport> {

	public IronfoggwsylsbpzReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoggwsylsbpzReport> findList(IronfoggwsylsbpzReport ironfoggwsylsbpz) {
		return super.findList(ironfoggwsylsbpz);
	}
	
	public Page<IronfoggwsylsbpzReport> findPage(Page<IronfoggwsylsbpzReport> page, IronfoggwsylsbpzReport ironfoggwsylsbpz) {
		return super.findPage(page, ironfoggwsylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoggwsylsbpzReport ironfoggwsylsbpz) {
		super.save(ironfoggwsylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoggwsylsbpzReport ironfoggwsylsbpz) {
		super.delete(ironfoggwsylsbpz);
	}
	
	
	
	
}