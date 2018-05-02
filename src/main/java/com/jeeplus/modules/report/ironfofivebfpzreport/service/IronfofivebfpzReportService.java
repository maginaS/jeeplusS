/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivebfpzreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivebfpzreport.entity.IronfofivebfpzReport;
import com.jeeplus.modules.report.ironfofivebfpzreport.dao.IronfofivebfpzReportDao;

/**
 * 5.3病房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivebfpzReportService extends CrudService<IronfofivebfpzReportDao, IronfofivebfpzReport> {

	public IronfofivebfpzReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivebfpzReport> findList(IronfofivebfpzReport ironfofivebfpz) {
		return super.findList(ironfofivebfpz);
	}
	
	public Page<IronfofivebfpzReport> findPage(Page<IronfofivebfpzReport> page, IronfofivebfpzReport ironfofivebfpz) {
		return super.findPage(page, ironfofivebfpz);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivebfpzReport ironfofivebfpz) {
		super.save(ironfofivebfpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivebfpzReport ironfofivebfpz) {
		super.delete(ironfofivebfpz);
	}
	
	
	
	
}