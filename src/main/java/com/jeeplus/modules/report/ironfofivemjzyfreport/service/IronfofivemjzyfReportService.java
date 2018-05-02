/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivemjzyfreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.report.ironfofivemjzyfreport.entity.IronfofivemjzyfReport;
import com.jeeplus.modules.report.ironfofivemjzyfreport.dao.IronfofivemjzyfReportDao;


import com.jeeplus.modules.report.ironfofivemjzyfreport.entity.IronfofivemjzyfkjlxReport;
import com.jeeplus.modules.report.ironfofivemjzyfreport.dao.IronfofivemjzyfkjlxReportDao;

/**
 * 5.2门急诊用房Service
 * @author anti_magina
 * @version 2018-04-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivemjzyfReportService extends CrudService<IronfofivemjzyfReportDao, IronfofivemjzyfReport> {

	@Autowired
	private IronfofivemjzyfkjlxReportDao ironfofivemjzyfkjlxDao;
	
	/*public IronfofivemjzyfReport get(String id) {
		IronfofivemjzyfReport ironfofivemjzyf = super.get(id);
		ironfofivemjzyf.setIronfofivemjzyfkjlxList(ironfofivemjzyfkjlxDao.findList(new IronfofivemjzyfkjlxReport(ironfofivemjzyf)));
		return ironfofivemjzyf;
	}*/
	
	public List<IronfofivemjzyfReport> findList(IronfofivemjzyfReport ironfofivemjzyf) {
		return super.findList(ironfofivemjzyf);
	}
	
	public Page<IronfofivemjzyfReport> findPage(Page<IronfofivemjzyfReport> page, IronfofivemjzyfReport ironfofivemjzyf) {
		return super.findPage(page, ironfofivemjzyf);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfofivemjzyfReport ironfofivemjzyf) {
		super.save(ironfofivemjzyf);
		for (IronfofivemjzyfkjlxReport ironfofivemjzyfkjlx : ironfofivemjzyf.getIronfofivemjzyfkjlxList()){
			if (ironfofivemjzyfkjlx.getId() == null){
				continue;
			}
			if (IronfofivemjzyfkjlxReport.DEL_FLAG_NORMAL.equals(ironfofivemjzyfkjlx.getDelFlag())){
				if (StringUtils.isBlank(ironfofivemjzyfkjlx.getId())){
					ironfofivemjzyfkjlx.preInsert();
					ironfofivemjzyfkjlxDao.insert(ironfofivemjzyfkjlx);
				}else{
					ironfofivemjzyfkjlx.preUpdate();
					ironfofivemjzyfkjlxDao.update(ironfofivemjzyfkjlx);
				}
			}else{
				ironfofivemjzyfkjlxDao.delete(ironfofivemjzyfkjlx);
			}
		}
	}
	
	/*@Transactional(readOnly = false)
	public void delete(IronfofivemjzyfReport ironfofivemjzyf) {
		super.delete(ironfofivemjzyf);
		ironfofivemjzyfkjlxDao.delete(new IronfofivemjzyfkjlxReport(ironfofivemjzyf));
	}
	*/
	
}