/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivezgshyfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivezgshyfreport.entity.IronfofivezgshyfReport;
import com.jeeplus.modules.report.ironfofivezgshyfreport.dao.IronfofivezgshyfReportDao;

/**
 * 5.8职工生活用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivezgshyfReportService extends CrudService<IronfofivezgshyfReportDao, IronfofivezgshyfReport> {

	public IronfofivezgshyfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivezgshyfReport> findList(IronfofivezgshyfReport ironfofivezgshyf) {
		return super.findList(ironfofivezgshyf);
	}
	
	public Page<IronfofivezgshyfReport> findPage(Page<IronfofivezgshyfReport> page, IronfofivezgshyfReport ironfofivezgshyf) {
		return super.findPage(page, ironfofivezgshyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivezgshyfReport ironfofivezgshyf) {
		super.save(ironfofivezgshyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivezgshyfReport ironfofivezgshyf) {
		super.delete(ironfofivezgshyf);
	}
	
	
	
	
}