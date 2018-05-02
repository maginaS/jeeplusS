/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfomedicalservicesdatas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfomedicalservicesdatas.entity.IronfoMedicalService;
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;
import com.jeeplus.modules.ironfomedicalservicesdatas.dao.IronfoMedicalServiceDao;

/**
 * 2.1年度医疗服务量Service
 * @author mikesun
 * @version 2018-04-11
 */
@Service
@Transactional(readOnly = true)
public class IronfoMedicalServiceService extends CrudService<IronfoMedicalServiceDao, IronfoMedicalService> {

	
	@Autowired
	private IronfoMedicalServiceDao dao;
	
	public IronfoMedicalService get(String id) {
		return super.get(id);
	}
	
	public List<IronfoMedicalService> findList(IronfoMedicalService ironfoMedicalServices) {
		return super.findList(ironfoMedicalServices);
	}
	
	public Page<IronfoMedicalService> findPage(Page<IronfoMedicalService> page, IronfoMedicalService ironfoMedicalServices) {
		return super.findPage(page, ironfoMedicalServices);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoMedicalService ironfoMedicalServices) {
		super.save(ironfoMedicalServices);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoMedicalService ironfoMedicalServices) {
		super.delete(ironfoMedicalServices);
	}
	
	
	
	
	public List<IronfoMedicalService> queryForList(IronfoMedicalService ironfoMedicalService){
		
		return dao.queryForList(ironfoMedicalService);
	}
	
	
	
	
}