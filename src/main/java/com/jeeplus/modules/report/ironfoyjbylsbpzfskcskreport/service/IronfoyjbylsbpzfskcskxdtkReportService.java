/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzfskcskreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzfskcskreport.entity.IronfoyjbylsbpzfskcskxdtkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzfskcskreport.dao.IronfoyjbylsbpzfskcskxdtkReportDao;

/**
 * 放射科、超声科、心电图科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzfskcskxdtkReportService extends CrudService<IronfoyjbylsbpzfskcskxdtkReportDao, IronfoyjbylsbpzfskcskxdtkReport> {

	public IronfoyjbylsbpzfskcskxdtkReport get(String id) {
		return super.get(id);
	}
	
	public List<IronfoyjbylsbpzfskcskxdtkReport> findList(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk) {
		return super.findList(ironfoyjbylsbpzfskcskxdtk);
	}
	
	public Page<IronfoyjbylsbpzfskcskxdtkReport> findPage(Page<IronfoyjbylsbpzfskcskxdtkReport> page, IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk) {
		return super.findPage(page, ironfoyjbylsbpzfskcskxdtk);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk) {
		super.save(ironfoyjbylsbpzfskcskxdtk);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk) {
		super.delete(ironfoyjbylsbpzfskcskxdtk);
	}
	
	
	
	
}