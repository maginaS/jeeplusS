/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveswcd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiveswcd.entity.Ironfofiveswcd;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofiveswcd.dao.IronfofiveswcdDao;

/**
 * 5.9室外场地Service
 * @author mikesun
 * @version 2018-04-15
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveswcdService extends CrudService<IronfofiveswcdDao, Ironfofiveswcd> {
	
	
	@Autowired
	private IronfofiveswcdDao dao;

	public Ironfofiveswcd get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiveswcd> findList(Ironfofiveswcd ironfofiveswcd) {
		return super.findList(ironfofiveswcd);
	}
	
	public Page<Ironfofiveswcd> findPage(Page<Ironfofiveswcd> page, Ironfofiveswcd ironfofiveswcd) {
		return super.findPage(page, ironfofiveswcd);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiveswcd ironfofiveswcd) {
		super.save(ironfofiveswcd);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiveswcd ironfofiveswcd) {
		super.delete(ironfofiveswcd);
	}
	
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiveswcd> queryForList(Ironfofiveswcd ironfofiveswcd){
		
		return dao.queryForList(ironfofiveswcd);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiveswcd ironfofiveswcd) {
		dao.updateIronfo(ironfofiveswcd);
	}
	
	
	
	
}