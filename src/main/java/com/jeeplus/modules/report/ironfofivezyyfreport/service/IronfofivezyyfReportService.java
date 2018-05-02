/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivezyyfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivezyyfreport.entity.IronfofivezyyfReport;
import com.jeeplus.modules.report.ironfofivezyyfreport.dao.IronfofivezyyfReportDao;

/**
 * 5.4住院用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivezyyfReportService extends CrudService<IronfofivezyyfReportDao, IronfofivezyyfReport> {

	public IronfofivezyyfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivezyyfReport> findList(IronfofivezyyfReport ironfofivezyyf) {
		return super.findList(ironfofivezyyf);
	}
	
	public Page<IronfofivezyyfReport> findPage(Page<IronfofivezyyfReport> page, IronfofivezyyfReport ironfofivezyyf) {
		return super.findPage(page, ironfofivezyyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivezyyfReport ironfofivezyyf) {
		super.save(ironfofivezyyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivezyyfReport ironfofivezyyf) {
		super.delete(ironfofivezyyf);
	}
	
	
	
	
}