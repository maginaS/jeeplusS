/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveznglyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiveznglyf.entity.Ironfofiveznglyf;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofiveznglyf.dao.IronfofiveznglyfDao;

/**
 * 5.7职能管理用房Service
 * @author mikesun
 * @version 2018-04-15
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveznglyfService extends CrudService<IronfofiveznglyfDao, Ironfofiveznglyf> {
	
	
	@Autowired
	private IronfofiveznglyfDao dao;

	public Ironfofiveznglyf get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiveznglyf> findList(Ironfofiveznglyf ironfofiveznglyf) {
		return super.findList(ironfofiveznglyf);
	}
	
	public Page<Ironfofiveznglyf> findPage(Page<Ironfofiveznglyf> page, Ironfofiveznglyf ironfofiveznglyf) {
		return super.findPage(page, ironfofiveznglyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiveznglyf ironfofiveznglyf) {
		super.save(ironfofiveznglyf);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiveznglyf ironfofiveznglyf) {
		super.delete(ironfofiveznglyf);
	}
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiveznglyf> queryForList(Ironfofiveznglyf ironfofiveznglyf){
		
		return dao.queryForList(ironfofiveznglyf);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiveznglyf ironfofiveznglyf) {
		dao.updateIronfo(ironfofiveznglyf);
	}
	
	
	
	
	
}