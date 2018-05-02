/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfopopulation.entity.Ironfopopulation;
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;
import com.jeeplus.modules.ironfopopulation.dao.IronfopopulationDao;

/**
 * 5.1.1建筑总体概况Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfopopulationService extends CrudService<IronfopopulationDao, Ironfopopulation> {

	
	@Autowired
	private IronfopopulationDao dao;
	
	public Ironfopopulation get(String id) {
		return super.get(id);
	}
	
	public List<Ironfopopulation> findList(Ironfopopulation ironfopopulation) {
		return super.findList(ironfopopulation);
	}
	
	public Page<Ironfopopulation> findPage(Page<Ironfopopulation> page, Ironfopopulation ironfopopulation) {
		return super.findPage(page, ironfopopulation);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfopopulation ironfopopulation) {
		super.save(ironfopopulation);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfopopulation ironfopopulation) {
		super.delete(ironfopopulation);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfopopulation ironfopopulation) {
		
		dao.updateIronfo(ironfopopulation);
	}
	
	
	public List<Ironfopopulation> queryForList(Ironfopopulation ironfopopulation){
		
		return dao.queryForList(ironfopopulation);
	}
	
	
	
	
	
	
}