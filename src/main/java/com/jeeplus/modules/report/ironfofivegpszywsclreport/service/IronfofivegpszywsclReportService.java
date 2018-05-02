/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszywsclreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivegpszywsclreport.entity.IronfofivegpszywsclReport;
import com.jeeplus.modules.report.ironfofivegpszywsclreport.dao.IronfofivegpszywsclReportDao;

/**
 * 污水处理Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivegpszywsclReportService extends CrudService<IronfofivegpszywsclReportDao, IronfofivegpszywsclReport> {

	public IronfofivegpszywsclReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivegpszywsclReport> findList(IronfofivegpszywsclReport ironfofivegpszywscl) {
		return super.findList(ironfofivegpszywscl);
	}
	
	public Page<IronfofivegpszywsclReport> findPage(Page<IronfofivegpszywsclReport> page, IronfofivegpszywsclReport ironfofivegpszywscl) {
		return super.findPage(page, ironfofivegpszywscl);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivegpszywsclReport ironfofivegpszywscl) {
		super.save(ironfofivegpszywscl);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivegpszywsclReport ironfofivegpszywscl) {
		super.delete(ironfofivegpszywscl);
	}
	
	
	
	
}