/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationsxreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxReport;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxDao;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjbggwsfwDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbggwsfw;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxReportDao;


import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjbggwsfwReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjbggwsfwReportDao;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjbylfwReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjbylfwReportDao;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjgjkReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjgjkReportDao;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjgyyglReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjgyyglReportDao;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjkdaglReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjkdaglReportDao;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjkxxfwReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjkxxfwReportDao;

/**
 * 4.2信息化系统功能实现Service
 * @author anti_magina
 * @version 2018-04-24
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationsxReportService extends CrudService<IronfoinformationsxReportDao, IronfoinformationsxReport> {

	@Autowired
	private IronfoinformationsxjbggwsfwReportDao ironfoinformationsxjbggwsfwDao;
	@Autowired
	private IronfoinformationsxjbylfwReportDao ironfoinformationsxjbylfwDao;
	@Autowired
	private IronfoinformationsxjgjkReportDao ironfoinformationsxjgjkDao;
	@Autowired
	private IronfoinformationsxjgyyglReportDao ironfoinformationsxjgyyglDao;
	@Autowired
	private IronfoinformationsxjkdaglReportDao ironfoinformationsxjkdaglDao;
	@Autowired
	private IronfoinformationsxjkxxfwReportDao ironfoinformationsxjkxxfwDao;
	
	@Autowired
	private IronfoinformationsxReportDao ironfoinformationsxDao;
	@Autowired
	private IronfoinformationsxDao ironfoinformationsx_Dao;
	@Autowired
	private IronfoinformationsxjbggwsfwDao ironfoinformationsxjbggwsfw_Dao;
	
	public IronfoinformationsxReport get(String id) {
		IronfoinformationsxReport ironfoinformationsx = super.get(id);
//		ironfoinformationsx.setIronfoinformationsxjbggwsfwList(ironfoinformationsxjbggwsfwDao.findList(new Ironfoinformationsxjbggwsfw(ironfoinformationsx)));
//		ironfoinformationsx.setIronfoinformationsxjbylfwList(ironfoinformationsxjbylfwDao.findList(new Ironfoinformationsxjbylfw(ironfoinformationsx)));
//		ironfoinformationsx.setIronfoinformationsxjgjkList(ironfoinformationsxjgjkDao.findList(new Ironfoinformationsxjgjk(ironfoinformationsx)));
//		ironfoinformationsx.setIronfoinformationsxjgyyglList(ironfoinformationsxjgyyglDao.findList(new Ironfoinformationsxjgyygl(ironfoinformationsx)));
//		ironfoinformationsx.setIronfoinformationsxjkdaglList(ironfoinformationsxjkdaglDao.findList(new Ironfoinformationsxjkdagl(ironfoinformationsx)));
//		ironfoinformationsx.setIronfoinformationsxjkxxfwList(ironfoinformationsxjkxxfwDao.findList(new Ironfoinformationsxjkxxfw(ironfoinformationsx)));
		return ironfoinformationsx;
	}
	
	public List<IronfoinformationsxReport> findList(IronfoinformationsxReport ironfoinformationsx) {
		return super.findList(ironfoinformationsx);
	}
	
	public Page<IronfoinformationsxReport> findPage(Page<IronfoinformationsxReport> page, IronfoinformationsxReport ironfoinformationsx) {
//		IronfoinformationsxjbggwsfwReport ironfoinformationsxjbggwsfw= null;
//		try {
//			ironfoinformationsxjbggwsfw= IronfoinformationsxjbggwsfwReport.class.newInstance();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ironfoinformationsxjbggwsfw.setDoc_id(ironfoinformationsx.getDoc_id());
//		List<IronfoinformationsxjbggwsfwReport> list1 = ironfoinformationsxjbggwsfwDao.findList(ironfoinformationsxjbggwsfw);
//		ironfoinformationsx.setPage(page);
//		
//		List<IronfoinformationsxReport> list = ironfoinformationsxDao.findList(ironfoinformationsx);
//		if(list == null ||list.size() ==0){return null;}
//		for (IronfoinformationsxReport ironfoinformationsxReport : list) {
//			ironfoinformationsxReport.setIronfoinformationsxjbggwsfwList(list1);
//		}
//		page.setList(list);
//		return page;
		return super.findPage(page, ironfoinformationsx);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoinformationsxReport ironfoinformationsx) {
		super.save(ironfoinformationsx);
		for (IronfoinformationsxjbggwsfwReport ironfoinformationsxjbggwsfw : ironfoinformationsx.getIronfoinformationsxjbggwsfwList()){
			if (ironfoinformationsxjbggwsfw.getId() == null){
				continue;
			}
			if (IronfoinformationsxjbggwsfwReport.DEL_FLAG_NORMAL.equals(ironfoinformationsxjbggwsfw.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjbggwsfw.getId())){
					ironfoinformationsxjbggwsfw.preInsert();
					ironfoinformationsxjbggwsfwDao.insert(ironfoinformationsxjbggwsfw);
				}else{
					ironfoinformationsxjbggwsfw.preUpdate();
					ironfoinformationsxjbggwsfwDao.update(ironfoinformationsxjbggwsfw);
				}
			}else{
				ironfoinformationsxjbggwsfwDao.delete(ironfoinformationsxjbggwsfw);
			}
		}
		for (IronfoinformationsxjbylfwReport ironfoinformationsxjbylfw : ironfoinformationsx.getIronfoinformationsxjbylfwList()){
			if (ironfoinformationsxjbylfw.getId() == null){
				continue;
			}
			if (IronfoinformationsxjbylfwReport.DEL_FLAG_NORMAL.equals(ironfoinformationsxjbylfw.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjbylfw.getId())){
					ironfoinformationsxjbylfw.preInsert();
					ironfoinformationsxjbylfwDao.insert(ironfoinformationsxjbylfw);
				}else{
					ironfoinformationsxjbylfw.preUpdate();
					ironfoinformationsxjbylfwDao.update(ironfoinformationsxjbylfw);
				}
			}else{
				ironfoinformationsxjbylfwDao.delete(ironfoinformationsxjbylfw);
			}
		}
		for (IronfoinformationsxjgjkReport ironfoinformationsxjgjk : ironfoinformationsx.getIronfoinformationsxjgjkList()){
			if (ironfoinformationsxjgjk.getId() == null){
				continue;
			}
			if (IronfoinformationsxjgjkReport.DEL_FLAG_NORMAL.equals(ironfoinformationsxjgjk.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjgjk.getId())){
					ironfoinformationsxjgjk.preInsert();
					ironfoinformationsxjgjkDao.insert(ironfoinformationsxjgjk);
				}else{
					ironfoinformationsxjgjk.preUpdate();
					ironfoinformationsxjgjkDao.update(ironfoinformationsxjgjk);
				}
			}else{
				ironfoinformationsxjgjkDao.delete(ironfoinformationsxjgjk);
			}
		}
		for (IronfoinformationsxjgyyglReport ironfoinformationsxjgyygl : ironfoinformationsx.getIronfoinformationsxjgyyglList()){
			if (ironfoinformationsxjgyygl.getId() == null){
				continue;
			}
			if (IronfoinformationsxjgyyglReport.DEL_FLAG_NORMAL.equals(ironfoinformationsxjgyygl.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjgyygl.getId())){
					ironfoinformationsxjgyygl.preInsert();
					ironfoinformationsxjgyyglDao.insert(ironfoinformationsxjgyygl);
				}else{
					ironfoinformationsxjgyygl.preUpdate();
					ironfoinformationsxjgyyglDao.update(ironfoinformationsxjgyygl);
				}
			}else{
				ironfoinformationsxjgyyglDao.delete(ironfoinformationsxjgyygl);
			}
		}
		for (IronfoinformationsxjkdaglReport ironfoinformationsxjkdagl : ironfoinformationsx.getIronfoinformationsxjkdaglList()){
			if (ironfoinformationsxjkdagl.getId() == null){
				continue;
			}
			if (IronfoinformationsxjkdaglReport.DEL_FLAG_NORMAL.equals(ironfoinformationsxjkdagl.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjkdagl.getId())){
					ironfoinformationsxjkdagl.preInsert();
					ironfoinformationsxjkdaglDao.insert(ironfoinformationsxjkdagl);
				}else{
					ironfoinformationsxjkdagl.preUpdate();
					ironfoinformationsxjkdaglDao.update(ironfoinformationsxjkdagl);
				}
			}else{
				ironfoinformationsxjkdaglDao.delete(ironfoinformationsxjkdagl);
			}
		}
		for (IronfoinformationsxjkxxfwReport ironfoinformationsxjkxxfw : ironfoinformationsx.getIronfoinformationsxjkxxfwList()){
			if (ironfoinformationsxjkxxfw.getId() == null){
				continue;
			}
			if (IronfoinformationsxjkxxfwReport.DEL_FLAG_NORMAL.equals(ironfoinformationsxjkxxfw.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjkxxfw.getId())){
					ironfoinformationsxjkxxfw.preInsert();
					ironfoinformationsxjkxxfwDao.insert(ironfoinformationsxjkxxfw);
				}else{
					ironfoinformationsxjkxxfw.preUpdate();
					ironfoinformationsxjkxxfwDao.update(ironfoinformationsxjkxxfw);
				}
			}else{
				ironfoinformationsxjkxxfwDao.delete(ironfoinformationsxjkxxfw);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoinformationsxReport ironfoinformationsx) {
		super.delete(ironfoinformationsx);
//		ironfoinformationsxjbggwsfwDao.delete(new Ironfoinformationsxjbggwsfw(ironfoinformationsx));
//		ironfoinformationsxjbylfwDao.delete(new Ironfoinformationsxjbylfw(ironfoinformationsx));
//		ironfoinformationsxjgjkDao.delete(new Ironfoinformationsxjgjk(ironfoinformationsx));
//		ironfoinformationsxjgyyglDao.delete(new Ironfoinformationsxjgyygl(ironfoinformationsx));
//		ironfoinformationsxjkdaglDao.delete(new Ironfoinformationsxjkdagl(ironfoinformationsx));
//		ironfoinformationsxjkxxfwDao.delete(new Ironfoinformationsxjkxxfw(ironfoinformationsx));
	}
	
	
}