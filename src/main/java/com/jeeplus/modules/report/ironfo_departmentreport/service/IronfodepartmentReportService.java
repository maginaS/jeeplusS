/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_departmentreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentReportDao;


import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentggwsbReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentggwsbReportDao;
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentjhsybReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentjhsybReportDao;
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentremarkReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentremarkReportDao;
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentyjbReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentyjbReportDao;
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentznglbReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentznglbReportDao;
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentzybReport;
import com.jeeplus.modules.report.ironfo_departmentreport.dao.IronfodepartmentzybReportDao;

/**
 * 2.4科室设置Service
 * @author mao
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class IronfodepartmentReportService extends CrudService<IronfodepartmentReportDao, IronfodepartmentReport> {

	@Autowired
	private IronfodepartmentggwsbReportDao ironfodepartmentggwsbDao;
	@Autowired
	private IronfodepartmentjhsybReportDao ironfodepartmentjhsybDao;
	@Autowired
	private IronfodepartmentremarkReportDao ironfodepartmentremarkDao;
	@Autowired
	private IronfodepartmentyjbReportDao ironfodepartmentyjbDao;
	@Autowired
	private IronfodepartmentznglbReportDao ironfodepartmentznglbDao;
	@Autowired
	private IronfodepartmentzybReportDao ironfodepartmentzybDao;
	
	public IronfodepartmentReport get(String id) {
		IronfodepartmentReport ironfodepartment = super.get(id);
		ironfodepartment.setIronfodepartmentggwsbList(ironfodepartmentggwsbDao.findList(new IronfodepartmentggwsbReport()));
		ironfodepartment.setIronfodepartmentjhsybList(ironfodepartmentjhsybDao.findList(new IronfodepartmentjhsybReport()));
		ironfodepartment.setIronfodepartmentremarkList(ironfodepartmentremarkDao.findList(new IronfodepartmentremarkReport()));
		ironfodepartment.setIronfodepartmentyjbList(ironfodepartmentyjbDao.findList(new IronfodepartmentyjbReport()));
		ironfodepartment.setIronfodepartmentznglbList(ironfodepartmentznglbDao.findList(new IronfodepartmentznglbReport()));
		ironfodepartment.setIronfodepartmentzybList(ironfodepartmentzybDao.findList(new IronfodepartmentzybReport()));
		return ironfodepartment;
	}
	
	public List<IronfodepartmentReport> findList(IronfodepartmentReport ironfodepartment) {
		return super.findList(ironfodepartment);
	}
	
	public Page<IronfodepartmentReport> findPage(Page<IronfodepartmentReport> page, IronfodepartmentReport ironfodepartment) {
		return super.findPage(page, ironfodepartment);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfodepartmentReport ironfodepartment) {
		super.save(ironfodepartment);
		for (IronfodepartmentggwsbReport ironfodepartmentggwsb : ironfodepartment.getIronfodepartmentggwsbList()){
			if (ironfodepartmentggwsb.getId() == null){
				continue;
			}
			if (IronfodepartmentggwsbReport.DEL_FLAG_NORMAL.equals(ironfodepartmentggwsb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentggwsb.getId())){
					ironfodepartmentggwsb.preInsert();
					ironfodepartmentggwsbDao.insert(ironfodepartmentggwsb);
				}else{
					ironfodepartmentggwsb.preUpdate();
					ironfodepartmentggwsbDao.update(ironfodepartmentggwsb);
				}
			}else{
				ironfodepartmentggwsbDao.delete(ironfodepartmentggwsb);
			}
		}
		for (IronfodepartmentjhsybReport ironfodepartmentjhsyb : ironfodepartment.getIronfodepartmentjhsybList()){
			if (ironfodepartmentjhsyb.getId() == null){
				continue;
			}
			if (IronfodepartmentjhsybReport.DEL_FLAG_NORMAL.equals(ironfodepartmentjhsyb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentjhsyb.getId())){
					ironfodepartmentjhsyb.preInsert();
					ironfodepartmentjhsybDao.insert(ironfodepartmentjhsyb);
				}else{
					ironfodepartmentjhsyb.preUpdate();
					ironfodepartmentjhsybDao.update(ironfodepartmentjhsyb);
				}
			}else{
				ironfodepartmentjhsybDao.delete(ironfodepartmentjhsyb);
			}
		}
		for (IronfodepartmentremarkReport ironfodepartmentremark : ironfodepartment.getIronfodepartmentremarkList()){
			if (ironfodepartmentremark.getId() == null){
				continue;
			}
			if (IronfodepartmentremarkReport.DEL_FLAG_NORMAL.equals(ironfodepartmentremark.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentremark.getId())){
					ironfodepartmentremark.preInsert();
					ironfodepartmentremarkDao.insert(ironfodepartmentremark);
				}else{
					ironfodepartmentremark.preUpdate();
					ironfodepartmentremarkDao.update(ironfodepartmentremark);
				}
			}else{
				ironfodepartmentremarkDao.delete(ironfodepartmentremark);
			}
		}
		for (IronfodepartmentyjbReport ironfodepartmentyjb : ironfodepartment.getIronfodepartmentyjbList()){
			if (ironfodepartmentyjb.getId() == null){
				continue;
			}
			if (IronfodepartmentyjbReport.DEL_FLAG_NORMAL.equals(ironfodepartmentyjb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentyjb.getId())){
					ironfodepartmentyjb.preInsert();
					ironfodepartmentyjbDao.insert(ironfodepartmentyjb);
				}else{
					ironfodepartmentyjb.preUpdate();
					ironfodepartmentyjbDao.update(ironfodepartmentyjb);
				}
			}else{
				ironfodepartmentyjbDao.delete(ironfodepartmentyjb);
			}
		}
		for (IronfodepartmentznglbReport ironfodepartmentznglb : ironfodepartment.getIronfodepartmentznglbList()){
			if (ironfodepartmentznglb.getId() == null){
				continue;
			}
			if (IronfodepartmentznglbReport.DEL_FLAG_NORMAL.equals(ironfodepartmentznglb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentznglb.getId())){
					ironfodepartmentznglb.preInsert();
					ironfodepartmentznglbDao.insert(ironfodepartmentznglb);
				}else{
					ironfodepartmentznglb.preUpdate();
					ironfodepartmentznglbDao.update(ironfodepartmentznglb);
				}
			}else{
				ironfodepartmentznglbDao.delete(ironfodepartmentznglb);
			}
		}
		for (IronfodepartmentzybReport ironfodepartmentzyb : ironfodepartment.getIronfodepartmentzybList()){
			if (ironfodepartmentzyb.getId() == null){
				continue;
			}
			if (IronfodepartmentzybReport.DEL_FLAG_NORMAL.equals(ironfodepartmentzyb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentzyb.getId())){
					ironfodepartmentzyb.preInsert();
					ironfodepartmentzybDao.insert(ironfodepartmentzyb);
				}else{
					ironfodepartmentzyb.preUpdate();
					ironfodepartmentzybDao.update(ironfodepartmentzyb);
				}
			}else{
				ironfodepartmentzybDao.delete(ironfodepartmentzyb);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfodepartmentReport ironfodepartment) {
		super.delete(ironfodepartment);
		ironfodepartmentggwsbDao.delete(new IronfodepartmentggwsbReport());
		ironfodepartmentjhsybDao.delete(new IronfodepartmentjhsybReport());
		ironfodepartmentremarkDao.delete(new IronfodepartmentremarkReport());
		ironfodepartmentyjbDao.delete(new IronfodepartmentyjbReport());
		ironfodepartmentznglbDao.delete(new IronfodepartmentznglbReport());
		ironfodepartmentzybDao.delete(new IronfodepartmentzybReport());
	}
	
	
}