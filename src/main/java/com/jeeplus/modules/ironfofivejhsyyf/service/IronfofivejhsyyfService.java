/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivejhsyyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivejhsyyf.entity.Ironfofivejhsyyf;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivejhsyyf.dao.IronfofivejhsyyfDao;

/**
 * 5.6计划生育用房Service
 * @author mikesun
 * @version 2018-04-15
 */
@Service
@Transactional(readOnly = true)
public class IronfofivejhsyyfService extends CrudService<IronfofivejhsyyfDao, Ironfofivejhsyyf> {

	
	@Autowired
	private IronfofivejhsyyfDao dao;
	
	
	public Ironfofivejhsyyf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivejhsyyf> findList(Ironfofivejhsyyf ironfofivejhsyyf) {
		return super.findList(ironfofivejhsyyf);
	}
	
	public Page<Ironfofivejhsyyf> findPage(Page<Ironfofivejhsyyf> page, Ironfofivejhsyyf ironfofivejhsyyf) {
		return super.findPage(page, ironfofivejhsyyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivejhsyyf ironfofivejhsyyf) {
		super.save(ironfofivejhsyyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivejhsyyf ironfofivejhsyyf) {
		super.delete(ironfofivejhsyyf);
	}
	
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivejhsyyf> queryForList(Ironfofivejhsyyf ironfofivejhsyyf){
		
		return dao.queryForList(ironfofivejhsyyf);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivejhsyyf ironfofivejhsyyf) {
		dao.updateIronfo(ironfofivejhsyyf);
	}
	
	
	
	
	
}