/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationbuildreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoinformationbuildreport.entity.IronfoinformationbuildReport;
import com.jeeplus.modules.report.ironfoinformationbuildreport.dao.IronfoinformationbuildReportDao;

/**
 * 4.1信息化系统建设情况Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationbuildReportService extends CrudService<IronfoinformationbuildReportDao, IronfoinformationbuildReport> {

	public IronfoinformationbuildReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoinformationbuildReport> findList(IronfoinformationbuildReport ironfoinformationbuild) {
		return super.findList(ironfoinformationbuild);
	}
	
	public Page<IronfoinformationbuildReport> findPage(Page<IronfoinformationbuildReport> page, IronfoinformationbuildReport ironfoinformationbuild) {
		return super.findPage(page, ironfoinformationbuild);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoinformationbuildReport ironfoinformationbuild) {
		super.save(ironfoinformationbuild);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoinformationbuildReport ironfoinformationbuild) {
		super.delete(ironfoinformationbuild);
	}
	
	
	
	
}