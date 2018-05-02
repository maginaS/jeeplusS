/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopopulationreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfopopulationreport.entity.IronfopopulationReport;
import com.jeeplus.modules.report.ironfopopulationreport.dao.IronfopopulationReportDao;

/**
 * 5.1.1建筑总体概况Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfopopulationReportService extends CrudService<IronfopopulationReportDao, IronfopopulationReport> {

	public IronfopopulationReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfopopulationReport> findList(IronfopopulationReport ironfopopulation) {
		return super.findList(ironfopopulation);
	}
	
	public Page<IronfopopulationReport> findPage(Page<IronfopopulationReport> page, IronfopopulationReport ironfopopulation) {
		return super.findPage(page, ironfopopulation);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfopopulationReport ironfopopulation) {
		super.save(ironfopopulation);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfopopulationReport ironfopopulation) {
		super.delete(ironfopopulation);
	}
	
	
	
	
}