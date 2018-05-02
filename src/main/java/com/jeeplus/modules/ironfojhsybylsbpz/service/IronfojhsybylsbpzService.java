/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojhsybylsbpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfojhsybylsbpz.entity.Ironfojhsybylsbpz;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;
import com.jeeplus.modules.ironfojhsybylsbpz.dao.IronfojhsybylsbpzDao;

/**
 * 3.5计划生育部医疗设备配置Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfojhsybylsbpzService extends CrudService<IronfojhsybylsbpzDao, Ironfojhsybylsbpz> {
	
	@Autowired
	private IronfojhsybylsbpzDao dao;

	public Ironfojhsybylsbpz get(String id) {
		return super.get(id);
	}
	
	public List<Ironfojhsybylsbpz> findList(Ironfojhsybylsbpz ironfojhsybylsbpz) {
		return super.findList(ironfojhsybylsbpz);
	}
	
	public Page<Ironfojhsybylsbpz> findPage(Page<Ironfojhsybylsbpz> page, Ironfojhsybylsbpz ironfojhsybylsbpz) {
		return super.findPage(page, ironfojhsybylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfojhsybylsbpz ironfojhsybylsbpz) {
		super.save(ironfojhsybylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfojhsybylsbpz ironfojhsybylsbpz) {
		super.delete(ironfojhsybylsbpz);
	}
	
	


	@Transactional(readOnly = false)
	public void updateIronfo(Ironfojhsybylsbpz ironfojhsybylsbpz) {
		
		dao.updateIronfo(ironfojhsybylsbpz);
	}
	
	
	public List<Ironfojhsybylsbpz> queryForList(Ironfojhsybylsbpz ironfojhsybylsbpz){
		
		return dao.queryForList(ironfojhsybylsbpz);
	}
	
	
	
	
	
	
	
	
}