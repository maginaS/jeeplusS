/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationexperience.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoinformationexperience.dao.IronfoinformationexperienceDao;

/**
 * 4.3信息化系统使用体验Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationexperienceService extends CrudService<IronfoinformationexperienceDao, Ironfoinformationexperience> {

	@Autowired
	private IronfoinformationexperienceDao dao;
	
	public Ironfoinformationexperience get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoinformationexperience> findList(Ironfoinformationexperience ironfoinformationexperience) {
		return super.findList(ironfoinformationexperience);
	}
	
	public Page<Ironfoinformationexperience> findPage(Page<Ironfoinformationexperience> page, Ironfoinformationexperience ironfoinformationexperience) {
		return super.findPage(page, ironfoinformationexperience);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoinformationexperience ironfoinformationexperience) {
		super.save(ironfoinformationexperience);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoinformationexperience ironfoinformationexperience) {
		super.delete(ironfoinformationexperience);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoinformationexperience ironfoinformationexperience) {
		
		dao.updateIronfo(ironfoinformationexperience);
	}
	
	
	public List<Ironfoinformationexperience> queryForList(Ironfoinformationexperience ironfoinformationexperience){
		
		return dao.queryForList(ironfoinformationexperience);
	}
	
	
	
	
	
	
	
	
}