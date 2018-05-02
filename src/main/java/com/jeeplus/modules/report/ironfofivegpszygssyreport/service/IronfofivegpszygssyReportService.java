/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszygssyreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivegpszygssyreport.entity.IronfofivegpszygssyReport;
import com.jeeplus.modules.report.ironfofivegpszygssyreport.dao.IronfofivegpszygssyReportDao;

/**
 * 给水水源Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivegpszygssyReportService extends CrudService<IronfofivegpszygssyReportDao, IronfofivegpszygssyReport> {

	public IronfofivegpszygssyReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivegpszygssyReport> findList(IronfofivegpszygssyReport ironfofivegpszygssy) {
		return super.findList(ironfofivegpszygssy);
	}
	
	public Page<IronfofivegpszygssyReport> findPage(Page<IronfofivegpszygssyReport> page, IronfofivegpszygssyReport ironfofivegpszygssy) {
		return super.findPage(page, ironfofivegpszygssy);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivegpszygssyReport ironfofivegpszygssy) {
		super.save(ironfofivegpszygssy);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivegpszygssyReport ironfofivegpszygssy) {
		super.delete(ironfofivegpszygssy);
	}
	
	
	
	
}