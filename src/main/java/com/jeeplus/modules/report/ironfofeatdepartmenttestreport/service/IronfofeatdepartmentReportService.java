/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofeatdepartmenttestreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofeatdepartmenttestreport.entity.IronfofeatdepartmentReport;
import com.jeeplus.modules.report.ironfofeatdepartmenttestreport.dao.IronfofeatdepartmentReportDao;

/**
 * 2.4.1特色科室Service
 * @author mao
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfofeatdepartmentReportService extends CrudService<IronfofeatdepartmentReportDao, IronfofeatdepartmentReport> {

	public IronfofeatdepartmentReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofeatdepartmentReport> findList(IronfofeatdepartmentReport ironfofeatdepartment) {
		return super.findList(ironfofeatdepartment);
	}
	
	public Page<IronfofeatdepartmentReport> findPage(Page<IronfofeatdepartmentReport> page, IronfofeatdepartmentReport ironfofeatdepartment) {
		return super.findPage(page, ironfofeatdepartment);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofeatdepartmentReport ironfofeatdepartment) {
		super.save(ironfofeatdepartment);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofeatdepartmentReport ironfofeatdepartment) {
		super.delete(ironfofeatdepartment);
	}
	
	
	
	
}