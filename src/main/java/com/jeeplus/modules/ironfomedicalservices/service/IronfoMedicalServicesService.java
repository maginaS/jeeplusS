/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfomedicalservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;
import com.jeeplus.modules.ironfomedicalservices.dao.IronfoMedicalServicesDao;

/**
 * 2.1年度医疗服务量Service
 * @author mikesun
 * @version 2018-03-13
 */
@Service
@Transactional(readOnly = true)
public class IronfoMedicalServicesService extends CrudService<IronfoMedicalServicesDao, IronfoMedicalServices> {

	@Autowired
	private IronfoMedicalServicesDao dao;
	
	public IronfoMedicalServices get(String id) {
		return super.get(id);
	}
	
	public List<IronfoMedicalServices> findList(IronfoMedicalServices ironfoMedicalServices) {
		return super.findList(ironfoMedicalServices);
	}
	
	public Page<IronfoMedicalServices> findPage(Page<IronfoMedicalServices> page, IronfoMedicalServices ironfoMedicalServices) {
		return super.findPage(page, ironfoMedicalServices);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoMedicalServices ironfoMedicalServices) {
		super.save(ironfoMedicalServices);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoMedicalServices ironfoMedicalServices) {
		super.delete(ironfoMedicalServices);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(IronfoMedicalServices ironfoMedicalServices) {
		
		dao.updateIronfo(ironfoMedicalServices);
	}
	
	public List<IronfoMedicalServices> queryForList(IronfoMedicalServices ironfoMedicalServices){
		
		return dao.queryForList(ironfoMedicalServices);
	}
	
	
	public static void main(String[] args) {
		IronfoMedicalServices ironfoMedical = new IronfoMedicalServices();
		ironfoMedical.setDoc_id("b76ce48112894ea2b83c8668b2de58c5");
		IronfoMedicalServicesService s = new IronfoMedicalServicesService();
//		 List<IronfoMedicalServices> data = s.queryForList("b76ce48112894ea2b83c8668b2de58c5");
		 
		 List<IronfoMedicalServices> data =  s.findList(ironfoMedical);
		 System.out.println(data.size());
		
	}
	
	
	
	
}