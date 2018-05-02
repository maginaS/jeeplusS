/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveznglyfreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfofiveznglyfreport.entity.IronfofiveznglyfReport;
import com.jeeplus.modules.report.ironfofiveznglyfreport.dao.IronfofiveznglyfReportDao;

/**
 * 5.7职能管理用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveznglyfReportService extends CrudService<IronfofiveznglyfReportDao, IronfofiveznglyfReport> {

	public IronfofiveznglyfReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfofiveznglyfReport> findList(IronfofiveznglyfReport ironfofiveznglyf) {
		return super.findList(ironfofiveznglyf);
	}
	
	public Page<IronfofiveznglyfReport> findPage(Page<IronfofiveznglyfReport> page, IronfofiveznglyfReport ironfofiveznglyf) {
		return super.findPage(page, ironfofiveznglyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofiveznglyfReport ironfofiveznglyf) {
		super.save(ironfofiveznglyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfofiveznglyfReport ironfofiveznglyf) {
		super.delete(ironfofiveznglyf);
	}
	
	
	
	
}