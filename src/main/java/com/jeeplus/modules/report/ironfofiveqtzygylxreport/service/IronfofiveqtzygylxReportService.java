/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveqtzygylxreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiveqtzygylxreport.entity.IronfofiveqtzygylxReport;
import com.jeeplus.modules.report.ironfofiveqtzygylxreport.dao.IronfofiveqtzygylxReportDao;

/**
 * 供应类型Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveqtzygylxReportService extends CrudService<IronfofiveqtzygylxReportDao, IronfofiveqtzygylxReport> {

	public IronfofiveqtzygylxReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiveqtzygylxReport> findList(IronfofiveqtzygylxReport ironfofiveqtzygylx) {
		return super.findList(ironfofiveqtzygylx);
	}
	
	public Page<IronfofiveqtzygylxReport> findPage(Page<IronfofiveqtzygylxReport> page, IronfofiveqtzygylxReport ironfofiveqtzygylx) {
		return super.findPage(page, ironfofiveqtzygylx);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiveqtzygylxReport ironfofiveqtzygylx) {
		super.save(ironfofiveqtzygylx);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiveqtzygylxReport ironfofiveqtzygylx) {
		super.delete(ironfofiveqtzygylx);
	}
	
	
	
	
}