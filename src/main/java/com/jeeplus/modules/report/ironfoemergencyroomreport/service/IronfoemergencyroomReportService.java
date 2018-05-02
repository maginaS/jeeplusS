/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoemergencyroomreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoemergencyroomreport.entity.IronfoemergencyroomReport;
import com.jeeplus.modules.report.ironfoemergencyroomreport.dao.IronfoemergencyroomReportDao;

/**
 * 门急诊部医疗设备配置Service
 * @author mikesun
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class IronfoemergencyroomReportService extends CrudService<IronfoemergencyroomReportDao, IronfoemergencyroomReport> {

	public IronfoemergencyroomReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoemergencyroomReport> findList(IronfoemergencyroomReport ironfoemergencyroom) {
		return super.findList(ironfoemergencyroom);
	}
	
	public Page<IronfoemergencyroomReport> findPage(Page<IronfoemergencyroomReport> page, IronfoemergencyroomReport ironfoemergencyroom) {
		return super.findPage(page, ironfoemergencyroom);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoemergencyroomReport ironfoemergencyroom) {
		super.save(ironfoemergencyroom);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoemergencyroomReport ironfoemergencyroom) {
		super.delete(ironfoemergencyroom);
	}
	
	
	
	
}