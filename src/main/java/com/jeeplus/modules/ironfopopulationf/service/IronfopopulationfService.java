/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulationf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfopopulationf.entity.Ironfopopulationf;
import com.jeeplus.modules.ironfopopulation.entity.Ironfopopulation;
import com.jeeplus.modules.ironfopopulationf.dao.IronfopopulationfDao;

/**
 * 5.1.2建筑分布概况Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfopopulationfService extends CrudService<IronfopopulationfDao, Ironfopopulationf> {

	
	@Autowired
	private IronfopopulationfDao dao;
	
	
	public Ironfopopulationf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfopopulationf> findList(Ironfopopulationf ironfopopulationf) {
		return super.findList(ironfopopulationf);
	}
	
	public Page<Ironfopopulationf> findPage(Page<Ironfopopulationf> page, Ironfopopulationf ironfopopulationf) {
		return super.findPage(page, ironfopopulationf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfopopulationf ironfopopulationf) {
		super.save(ironfopopulationf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfopopulationf ironfopopulationf) {
		super.delete(ironfopopulationf);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfopopulationf ironfopopulationf) {
		
		dao.updateIronfo(ironfopopulationf);
	}
	
	
	public List<Ironfopopulationf> queryForList(Ironfopopulationf ironfopopulationf){
		
		return dao.queryForList(ironfopopulationf);
	}
	
	
	
	
	
}