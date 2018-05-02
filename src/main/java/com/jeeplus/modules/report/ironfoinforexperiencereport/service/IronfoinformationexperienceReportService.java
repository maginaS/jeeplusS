/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinforexperiencereport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoinforexperiencereport.entity.IronfoinformationexperienceReport;
import com.jeeplus.modules.report.ironfoinforexperiencereport.dao.IronfoinformationexperienceReportDao;

/**
 * 4.3信息化系统使用体验Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationexperienceReportService extends CrudService<IronfoinformationexperienceReportDao, IronfoinformationexperienceReport> {

	public IronfoinformationexperienceReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoinformationexperienceReport> findList(IronfoinformationexperienceReport ironfoinformationexperience) {
		return super.findList(ironfoinformationexperience);
	}
	
	public Page<IronfoinformationexperienceReport> findPage(Page<IronfoinformationexperienceReport> page, IronfoinformationexperienceReport ironfoinformationexperience) {
		return super.findPage(page, ironfoinformationexperience);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoinformationexperienceReport ironfoinformationexperience) {
		super.save(ironfoinformationexperience);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoinformationexperienceReport ironfoinformationexperience) {
		super.delete(ironfoinformationexperience);
	}
	
	
	
	
}