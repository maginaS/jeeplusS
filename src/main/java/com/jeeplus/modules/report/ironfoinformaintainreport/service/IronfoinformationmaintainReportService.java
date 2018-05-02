/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformaintainreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoinformaintainreport.entity.IronfoinformationmaintainReport;
import com.jeeplus.modules.report.ironfoinformaintainreport.dao.IronfoinformationmaintainReportDao;

/**
 * 4.4系统维护人员Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationmaintainReportService extends CrudService<IronfoinformationmaintainReportDao, IronfoinformationmaintainReport> {

	public IronfoinformationmaintainReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoinformationmaintainReport> findList(IronfoinformationmaintainReport ironfoinformationmaintain) {
		return super.findList(ironfoinformationmaintain);
	}
	
	public Page<IronfoinformationmaintainReport> findPage(Page<IronfoinformationmaintainReport> page, IronfoinformationmaintainReport ironfoinformationmaintain) {
		return super.findPage(page, ironfoinformationmaintain);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoinformationmaintainReport ironfoinformationmaintain) {
		super.save(ironfoinformationmaintain);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoinformationmaintainReport ironfoinformationmaintain) {
		super.delete(ironfoinformationmaintain);
	}
	
	
	
	
}