/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivejhsyyfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivejhsyyfreport.entity.IronfofivejhsyyfReport;
import com.jeeplus.modules.report.ironfofivejhsyyfreport.dao.IronfofivejhsyyfReportDao;

/**
 * 5.6计划生育用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivejhsyyfReportService extends CrudService<IronfofivejhsyyfReportDao, IronfofivejhsyyfReport> {

	public IronfofivejhsyyfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivejhsyyfReport> findList(IronfofivejhsyyfReport ironfofivejhsyyf) {
		return super.findList(ironfofivejhsyyf);
	}
	
	public Page<IronfofivejhsyyfReport> findPage(Page<IronfofivejhsyyfReport> page, IronfofivejhsyyfReport ironfofivejhsyyf) {
		return super.findPage(page, ironfofivejhsyyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivejhsyyfReport ironfofivejhsyyf) {
		super.save(ironfofivejhsyyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivejhsyyfReport ironfofivejhsyyf) {
		super.delete(ironfofivejhsyyf);
	}
	
	
	
	
}