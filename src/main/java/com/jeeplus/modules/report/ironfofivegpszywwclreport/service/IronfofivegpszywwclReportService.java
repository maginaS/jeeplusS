/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszywwclreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofivegpszywwclreport.entity.IronfofivegpszywwclReport;
import com.jeeplus.modules.report.ironfofivegpszywwclreport.dao.IronfofivegpszywwclReportDao;

/**
 * 污物处理Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivegpszywwclReportService extends CrudService<IronfofivegpszywwclReportDao, IronfofivegpszywwclReport> {

	public IronfofivegpszywwclReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofivegpszywwclReport> findList(IronfofivegpszywwclReport ironfofivegpszywwcl) {
		return super.findList(ironfofivegpszywwcl);
	}
	
	public Page<IronfofivegpszywwclReport> findPage(Page<IronfofivegpszywwclReport> page, IronfofivegpszywwclReport ironfofivegpszywwcl) {
		return super.findPage(page, ironfofivegpszywwcl);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivegpszywwclReport ironfofivegpszywwcl) {
		super.save(ironfofivegpszywwcl);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofivegpszywwclReport ironfofivegpszywwcl) {
		super.delete(ironfofivegpszywwcl);
	}
	
	
	
	
}