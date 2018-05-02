/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfojbyyreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfojbyyreport.entity.IronfojbyyReport;
import com.jeeplus.modules.report.ironfojbyyreport.dao.IronfojbyyReportDao;

/**
 * 2.6基本用药Service
 * @author mao
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfojbyyReportService extends CrudService<IronfojbyyReportDao, IronfojbyyReport> {

	public IronfojbyyReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfojbyyReport> findList(IronfojbyyReport ironfojbyy) {
		return super.findList(ironfojbyy);
	}
	
	public Page<IronfojbyyReport> findPage(Page<IronfojbyyReport> page, IronfojbyyReport ironfojbyy) {
		return super.findPage(page, ironfojbyy);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfojbyyReport ironfojbyy) {
		super.save(ironfojbyy);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfojbyyReport ironfojbyy) {
		super.delete(ironfojbyy);
	}
	
	
	
	
}