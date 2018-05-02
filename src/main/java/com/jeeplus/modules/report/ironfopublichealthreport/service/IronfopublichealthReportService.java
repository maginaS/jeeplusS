/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopublichealthreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfopublichealthreport.entity.IronfopublichealthReport;
import com.jeeplus.modules.report.ironfopublichealthreport.dao.IronfopublichealthReportDao;

/**
 * 2.3基本公共卫生服务Service
 * @author mao
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfopublichealthReportService extends CrudService<IronfopublichealthReportDao, IronfopublichealthReport> {

	public IronfopublichealthReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfopublichealthReport> findList(IronfopublichealthReport ironfopublichealth) {
		return super.findList(ironfopublichealth);
	}
	
	public Page<IronfopublichealthReport> findPage(Page<IronfopublichealthReport> page, IronfopublichealthReport ironfopublichealth) {
		return super.findPage(page, ironfopublichealth);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfopublichealthReport ironfopublichealth) {
		super.save(ironfopublichealth);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfopublichealthReport ironfopublichealth) {
		super.delete(ironfopublichealth);
	}
	
	
	
	
}