/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.entity.IronfofiveqtzyqtzlReport;
import com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.dao.IronfofiveqtzyqtzlReportDao;

/**
 * 气体种类Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveqtzyqtzlReportService extends CrudService<IronfofiveqtzyqtzlReportDao, IronfofiveqtzyqtzlReport> {

	public IronfofiveqtzyqtzlReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiveqtzyqtzlReport> findList(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl) {
		return super.findList(ironfofiveqtzyqtzl);
	}
	
	public Page<IronfofiveqtzyqtzlReport> findPage(Page<IronfofiveqtzyqtzlReport> page, IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl) {
		return super.findPage(page, ironfofiveqtzyqtzl);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl) {
		super.save(ironfofiveqtzyqtzl);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl) {
		super.delete(ironfofiveqtzyqtzl);
	}
	
	
	
	
}