/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfojhsybylsbpzreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfojhsybylsbpzreport.entity.IronfojhsybylsbpzReport;
import com.jeeplus.modules.report.ironfojhsybylsbpzreport.dao.IronfojhsybylsbpzReportDao;

/**
 * 3.5计划生育部医疗设备配置Service
 * @author anti_magina
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfojhsybylsbpzReportService extends CrudService<IronfojhsybylsbpzReportDao, IronfojhsybylsbpzReport> {

	public IronfojhsybylsbpzReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfojhsybylsbpzReport> findList(IronfojhsybylsbpzReport ironfojhsybylsbpz) {
		return super.findList(ironfojhsybylsbpz);
	}
	
	public Page<IronfojhsybylsbpzReport> findPage(Page<IronfojhsybylsbpzReport> page, IronfojhsybylsbpzReport ironfojhsybylsbpz) {
		return super.findPage(page, ironfojhsybylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfojhsybylsbpzReport ironfojhsybylsbpz) {
		super.save(ironfojhsybylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfojhsybylsbpzReport ironfojhsybylsbpz) {
		super.delete(ironfojhsybylsbpz);
	}
	
	
	
	
}