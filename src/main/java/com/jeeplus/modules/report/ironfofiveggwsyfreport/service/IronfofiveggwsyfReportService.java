/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveggwsyfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiveggwsyfreport.entity.IronfofiveggwsyfReport;
import com.jeeplus.modules.report.ironfofiveggwsyfreport.dao.IronfofiveggwsyfReportDao;

/**
 * 5.5公共卫生用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveggwsyfReportService extends CrudService<IronfofiveggwsyfReportDao, IronfofiveggwsyfReport> {

	public IronfofiveggwsyfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiveggwsyfReport> findList(IronfofiveggwsyfReport ironfofiveggwsyf) {
		return super.findList(ironfofiveggwsyf);
	}
	
	public Page<IronfofiveggwsyfReport> findPage(Page<IronfofiveggwsyfReport> page, IronfofiveggwsyfReport ironfofiveggwsyf) {
		return super.findPage(page, ironfofiveggwsyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiveggwsyfReport ironfofiveggwsyf) {
		super.save(ironfofiveggwsyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiveggwsyfReport ironfofiveggwsyf) {
		super.delete(ironfofiveggwsyf);
	}
	
	
	
	
}