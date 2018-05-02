/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinforhardwarereport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoinforhardwarereport.entity.IronfoinformationhardwareReport;
import com.jeeplus.modules.report.ironfoinforhardwarereport.dao.IronfoinformationhardwareReportDao;

/**
 * 4.5信息化系统配套硬件Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationhardwareReportService extends CrudService<IronfoinformationhardwareReportDao, IronfoinformationhardwareReport> {

	public IronfoinformationhardwareReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoinformationhardwareReport> findList(IronfoinformationhardwareReport ironfoinformationhardware) {
		return super.findList(ironfoinformationhardware);
	}
	
	public Page<IronfoinformationhardwareReport> findPage(Page<IronfoinformationhardwareReport> page, IronfoinformationhardwareReport ironfoinformationhardware) {
		return super.findPage(page, ironfoinformationhardware);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoinformationhardwareReport ironfoinformationhardware) {
		super.save(ironfoinformationhardware);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoinformationhardwareReport ironfoinformationhardware) {
		super.delete(ironfoinformationhardware);
	}
	
	
	
	
}