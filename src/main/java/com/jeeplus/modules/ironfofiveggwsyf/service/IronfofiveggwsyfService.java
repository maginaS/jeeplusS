/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveggwsyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivezyyf.entity.Ironfofivezyyf;
import com.jeeplus.modules.ironfofiveggwsyf.dao.IronfofiveggwsyfDao;

/**
 * 5.5公共卫生用房Service
 * @author mikesun
 * @version 2018-04-15
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveggwsyfService extends CrudService<IronfofiveggwsyfDao, Ironfofiveggwsyf> {
	
	
	@Autowired
	private IronfofiveggwsyfDao dao;

	public Ironfofiveggwsyf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiveggwsyf> findList(Ironfofiveggwsyf ironfofiveggwsyf) {
		return super.findList(ironfofiveggwsyf);
	}
	
	public Page<Ironfofiveggwsyf> findPage(Page<Ironfofiveggwsyf> page, Ironfofiveggwsyf ironfofiveggwsyf) {
		return super.findPage(page, ironfofiveggwsyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiveggwsyf ironfofiveggwsyf) {
		super.save(ironfofiveggwsyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiveggwsyf ironfofiveggwsyf) {
		super.delete(ironfofiveggwsyf);
	}
	
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiveggwsyf> queryForList(Ironfofiveggwsyf ironfofiveggwsyf){
		
		return dao.queryForList(ironfofiveggwsyf);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiveggwsyf ironfofiveggwsyf) {
		dao.updateIronfo(ironfofiveggwsyf);
	}
	
	
	
	
	
}