/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationhardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoinformationhardware.entity.Ironfoinformationhardware;
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;
import com.jeeplus.modules.ironfoinformationhardware.dao.IronfoinformationhardwareDao;

/**
 * 4.5信息化系统配套硬件Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationhardwareService extends CrudService<IronfoinformationhardwareDao, Ironfoinformationhardware> {

	
	@Autowired
	private IronfoinformationhardwareDao dao;
	
	public Ironfoinformationhardware get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoinformationhardware> findList(Ironfoinformationhardware ironfoinformationhardware) {
		return super.findList(ironfoinformationhardware);
	}
	
	public Page<Ironfoinformationhardware> findPage(Page<Ironfoinformationhardware> page, Ironfoinformationhardware ironfoinformationhardware) {
		return super.findPage(page, ironfoinformationhardware);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoinformationhardware ironfoinformationhardware) {
		super.save(ironfoinformationhardware);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoinformationhardware ironfoinformationhardware) {
		super.delete(ironfoinformationhardware);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoinformationhardware ironfoinformationhardware) {
		
		dao.updateIronfo(ironfoinformationhardware);
	}
	
	
	public List<Ironfoinformationhardware> queryForList(Ironfoinformationhardware ironfoinformationhardware){
		
		return dao.queryForList(ironfoinformationhardware);
	}
	
	
	
	
	
	
	
	
	
	
	
}