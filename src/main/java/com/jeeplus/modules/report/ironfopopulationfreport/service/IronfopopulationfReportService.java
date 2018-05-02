/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopopulationfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfopopulationfreport.entity.IronfopopulationfReport;
import com.jeeplus.modules.report.ironfopopulationfreport.dao.IronfopopulationfReportDao;

/**
 * 5.1.2建筑分布概况Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfopopulationfReportService extends CrudService<IronfopopulationfReportDao, IronfopopulationfReport> {

	public IronfopopulationfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfopopulationfReport> findList(IronfopopulationfReport ironfopopulationf) {
		return super.findList(ironfopopulationf);
	}
	
	public Page<IronfopopulationfReport> findPage(Page<IronfopopulationfReport> page, IronfopopulationfReport ironfopopulationf) {
		return super.findPage(page, ironfopopulationf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfopopulationfReport ironfopopulationf) {
		super.save(ironfopopulationf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfopopulationfReport ironfopopulationf) {
		super.delete(ironfopopulationf);
	}
	
	
	
	
}