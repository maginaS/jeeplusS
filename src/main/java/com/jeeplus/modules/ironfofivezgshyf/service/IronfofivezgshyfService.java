/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezgshyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivezgshyf.entity.Ironfofivezgshyf;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivezgshyf.dao.IronfofivezgshyfDao;

/**
 * 5.8职工生活用房Service
 * @author mikesun
 * @version 2018-04-15
 */
@Service
@Transactional(readOnly = true)
public class IronfofivezgshyfService extends CrudService<IronfofivezgshyfDao, Ironfofivezgshyf> {

	
	
	@Autowired
	private IronfofivezgshyfDao dao;
	
	public Ironfofivezgshyf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivezgshyf> findList(Ironfofivezgshyf ironfofivezgshyf) {
		return super.findList(ironfofivezgshyf);
	}
	
	public Page<Ironfofivezgshyf> findPage(Page<Ironfofivezgshyf> page, Ironfofivezgshyf ironfofivezgshyf) {
		return super.findPage(page, ironfofivezgshyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivezgshyf ironfofivezgshyf) {
		super.save(ironfofivezgshyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivezgshyf ironfofivezgshyf) {
		super.delete(ironfofivezgshyf);
	}
	
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivezgshyf> queryForList(Ironfofivezgshyf ironfofivezgshyf){
		
		return dao.queryForList(ironfofivezgshyf);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivezgshyf ironfofivezgshyf) {
		dao.updateIronfo(ironfofivezgshyf);
	}
	
	
	
	
}