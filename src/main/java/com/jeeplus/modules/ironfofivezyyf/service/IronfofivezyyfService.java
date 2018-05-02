/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezyyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivezyyf.entity.Ironfofivezyyf;
import com.jeeplus.modules.ironfofiveyjyf.entity.Ironfofiveyjyf;
import com.jeeplus.modules.ironfofivezyyf.dao.IronfofivezyyfDao;

/**
 * 5.4住院用房Service
 * @author mikesun
 * @version 2018-04-14
 */
@Service
@Transactional(readOnly = true)
public class IronfofivezyyfService extends CrudService<IronfofivezyyfDao, Ironfofivezyyf> {

	
	@Autowired
	private IronfofivezyyfDao dao;
	public Ironfofivezyyf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivezyyf> findList(Ironfofivezyyf ironfofivezyyf) {
		return super.findList(ironfofivezyyf);
	}
	
	public Page<Ironfofivezyyf> findPage(Page<Ironfofivezyyf> page, Ironfofivezyyf ironfofivezyyf) {
		return super.findPage(page, ironfofivezyyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivezyyf ironfofivezyyf) {
		super.save(ironfofivezyyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivezyyf ironfofivezyyf) {
		super.delete(ironfofivezyyf);
	}
	
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivezyyf> queryForList(Ironfofivezyyf ironfofivezyyf){
		
		return dao.queryForList(ironfofivezyyf);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivezyyf ironfofivezyyf) {
		dao.updateIronfo(ironfofivezyyf);
	}
	
	
	
	
	
}