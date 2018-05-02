/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivebfpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivebfpz.entity.Ironfofivebfpz;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfofivebfpz.dao.IronfofivebfpzDao;

/**
 * 5.3病房Service
 * @author mikesun
 * @version 2018-04-08
 */
@Service
@Transactional(readOnly = true)
public class IronfofivebfpzService extends CrudService<IronfofivebfpzDao, Ironfofivebfpz> {

	@Autowired
	private IronfofivebfpzDao dao;
	
	public Ironfofivebfpz get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivebfpz> findList(Ironfofivebfpz ironfofivebfpz) {
		return super.findList(ironfofivebfpz);
	}
	
	public Page<Ironfofivebfpz> findPage(Page<Ironfofivebfpz> page, Ironfofivebfpz ironfofivebfpz) {
		return super.findPage(page, ironfofivebfpz);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivebfpz ironfofivebfpz) {
		super.save(ironfofivebfpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivebfpz ironfofivebfpz) {
		super.delete(ironfofivebfpz);
	}
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfofivebfpz ironfofivebfpz) {
		
		dao.updateIronfo(ironfofivebfpz);
	}
	
	
	public List<Ironfofivebfpz> queryForList(Ironfofivebfpz ironfofivebfpz){
		
		return dao.queryForList(ironfofivebfpz);
	}
	
	
	
	
	
	
	
}