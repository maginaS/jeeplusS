/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivesssglreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivesssglreport.entity.IronfofivesssglReport;
import com.jeeplus.modules.report.ironfofivesssglreport.dao.IronfofivesssglReportDao;

/**
 * 5.11手术室Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivesssglReportService extends CrudService<IronfofivesssglReportDao, IronfofivesssglReport> {

	public IronfofivesssglReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivesssglReport> findList(IronfofivesssglReport ironfofivesssgl) {
		return super.findList(ironfofivesssgl);
	}
	
	public Page<IronfofivesssglReport> findPage(Page<IronfofivesssglReport> page, IronfofivesssglReport ironfofivesssgl) {
		return super.findPage(page, ironfofivesssgl);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivesssglReport ironfofivesssgl) {
		super.save(ironfofivesssgl);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivesssglReport ironfofivesssgl) {
		super.delete(ironfofivesssgl);
	}
	
	
	
	
}