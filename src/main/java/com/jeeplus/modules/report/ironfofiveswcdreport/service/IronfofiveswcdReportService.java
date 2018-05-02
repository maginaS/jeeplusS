/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveswcdreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiveswcdreport.entity.IronfofiveswcdReport;
import com.jeeplus.modules.report.ironfofiveswcdreport.dao.IronfofiveswcdReportDao;

/**
 * 5.9室外场地Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveswcdReportService extends CrudService<IronfofiveswcdReportDao, IronfofiveswcdReport> {

	public IronfofiveswcdReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiveswcdReport> findList(IronfofiveswcdReport ironfofiveswcd) {
		return super.findList(ironfofiveswcd);
	}
	
	public Page<IronfofiveswcdReport> findPage(Page<IronfofiveswcdReport> page, IronfofiveswcdReport ironfofiveswcd) {
		return super.findPage(page, ironfofiveswcd);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiveswcdReport ironfofiveswcd) {
		super.save(ironfofiveswcd);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiveswcdReport ironfofiveswcd) {
		super.delete(ironfofiveswcd);
	}
	
	
	
	
}