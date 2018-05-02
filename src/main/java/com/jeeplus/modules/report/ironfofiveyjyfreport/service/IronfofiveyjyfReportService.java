/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveyjyfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiveyjyfreport.entity.IronfofiveyjyfReport;
import com.jeeplus.modules.report.ironfofiveyjyfreport.dao.IronfofiveyjyfReportDao;

/**
 * 5.3医技用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveyjyfReportService extends CrudService<IronfofiveyjyfReportDao, IronfofiveyjyfReport> {

	public IronfofiveyjyfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiveyjyfReport> findList(IronfofiveyjyfReport ironfofiveyjyf) {
		return super.findList(ironfofiveyjyf);
	}
	
	public Page<IronfofiveyjyfReport> findPage(Page<IronfofiveyjyfReport> page, IronfofiveyjyfReport ironfofiveyjyf) {
		return super.findPage(page, ironfofiveyjyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiveyjyfReport ironfofiveyjyf) {
		super.save(ironfofiveyjyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiveyjyfReport ironfofiveyjyf) {
		super.delete(ironfofiveyjyf);
	}
	
	
	
	
}