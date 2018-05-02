/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfozybreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfozybreport.entity.IronfozybReport;
import com.jeeplus.modules.report.ironfozybreport.dao.IronfozybReportDao;

/**
 * 3.3住院部医疗设备配置Service
 * @author anti_magina
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfozybReportService extends CrudService<IronfozybReportDao, IronfozybReport> {

	public IronfozybReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfozybReport> findList(IronfozybReport ironfozyb) {
		return super.findList(ironfozyb);
	}
	
	public Page<IronfozybReport> findPage(Page<IronfozybReport> page, IronfozybReport ironfozyb) {
		return super.findPage(page, ironfozyb);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfozybReport ironfozyb) {
		super.save(ironfozyb);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfozybReport ironfozyb) {
		super.delete(ironfozyb);
	}
	
	
	
	
}