/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzwkfck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfobzwkfck.entity.Ironfobzwkfck;
import com.jeeplus.modules.ironfobznkekbz.entity.Ironfobznkekbz;
import com.jeeplus.modules.ironfobzwkfck.dao.IronfobzwkfckDao;

/**
 * 2.6外科、妇（产）科病种	Service
 * @author mikesun
 * @version 2018-04-21
 */
@Service
@Transactional(readOnly = true)
public class IronfobzwkfckService extends CrudService<IronfobzwkfckDao, Ironfobzwkfck> {

	
	@Autowired
	private IronfobzwkfckDao dao;
	
	
	public Ironfobzwkfck get(String id) {
		return super.get(id);
	}
	
	public List<Ironfobzwkfck> findList(Ironfobzwkfck ironfobzwkfck) {
		return super.findList(ironfobzwkfck);
	}
	
	public Page<Ironfobzwkfck> findPage(Page<Ironfobzwkfck> page, Ironfobzwkfck ironfobzwkfck) {
		return super.findPage(page, ironfobzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfobzwkfck ironfobzwkfck) {
		super.save(ironfobzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfobzwkfck ironfobzwkfck) {
		super.delete(ironfobzwkfck);
	}
	
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfobzwkfck> queryForList(Ironfobzwkfck ironfobzwkfck){
		
		return dao.queryForList(ironfobzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfobzwkfck ironfobzwkfck) {
		dao.updateIronfo(ironfobzwkfck);
	}
	
	
	
	
	
}