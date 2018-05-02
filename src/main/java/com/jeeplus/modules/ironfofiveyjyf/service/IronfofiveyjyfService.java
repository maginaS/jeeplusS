/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveyjyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiveyjyf.entity.Ironfofiveyjyf;
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyfkjlx;
import com.jeeplus.modules.ironfofiveyjyf.dao.IronfofiveyjyfDao;

/**
 * 5.3医技用房Service
 * @author mikesun
 * @version 2018-04-14
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveyjyfService extends CrudService<IronfofiveyjyfDao, Ironfofiveyjyf> {
	
	
	@Autowired
	private IronfofiveyjyfDao dao;

	public Ironfofiveyjyf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiveyjyf> findList(Ironfofiveyjyf ironfofiveyjyf) {
		return super.findList(ironfofiveyjyf);
	}
	
	public Page<Ironfofiveyjyf> findPage(Page<Ironfofiveyjyf> page, Ironfofiveyjyf ironfofiveyjyf) {
		return super.findPage(page, ironfofiveyjyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiveyjyf ironfofiveyjyf) {
		super.save(ironfofiveyjyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiveyjyf ironfofiveyjyf) {
		super.delete(ironfofiveyjyf);
	}
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiveyjyf> queryForList(Ironfofiveyjyf ironfofiveyjyf){
		
		return dao.queryForList(ironfofiveyjyf);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiveyjyf ironfofiveyjyf) {
		dao.updateIronfo(ironfofiveyjyf);
	}
	
	
	
	
	
}