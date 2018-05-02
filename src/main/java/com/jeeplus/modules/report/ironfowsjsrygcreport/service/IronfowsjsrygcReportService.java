/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfowsjsrygcreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfowsjsrygcreport.entity.IronfowsjsrygcReport;
import com.jeeplus.modules.report.ironfowsjsrygcreport.dao.IronfowsjsrygcReportDao;

/**
 * 2.7.2卫生技术人员构成Service
 * @author mao
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfowsjsrygcReportService extends CrudService<IronfowsjsrygcReportDao, IronfowsjsrygcReport> {

	public IronfowsjsrygcReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfowsjsrygcReport> findList(IronfowsjsrygcReport ironfowsjsrygc) {
		return super.findList(ironfowsjsrygc);
	}
	
	public Page<IronfowsjsrygcReport> findPage(Page<IronfowsjsrygcReport> page, IronfowsjsrygcReport ironfowsjsrygc) {
		return super.findPage(page, ironfowsjsrygc);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfowsjsrygcReport ironfowsjsrygc) {
		super.save(ironfowsjsrygc);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfowsjsrygcReport ironfowsjsrygc) {
		super.delete(ironfowsjsrygc);
	}
	
	
	
	
}