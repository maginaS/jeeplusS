/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzkfk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.dao.IronfoyjbylsbpzkfkDao;

/**
 * 康复科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzkfkService extends CrudService<IronfoyjbylsbpzkfkDao, Ironfoyjbylsbpzkfk> {

	@Autowired
	private IronfoyjbylsbpzkfkDao dao;
	
	
	public Ironfoyjbylsbpzkfk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzkfk> findList(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk) {
		return super.findList(ironfoyjbylsbpzkfk);
	}
	
	public Page<Ironfoyjbylsbpzkfk> findPage(Page<Ironfoyjbylsbpzkfk> page, Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk) {
		return super.findPage(page, ironfoyjbylsbpzkfk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk) {
		super.save(ironfoyjbylsbpzkfk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk) {
		super.delete(ironfoyjbylsbpzkfk);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk) {
		
		dao.updateIronfo(ironfoyjbylsbpzkfk);
	}
	
	
	public List<Ironfoyjbylsbpzkfk> queryForList(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk){
		
		return dao.queryForList(ironfoyjbylsbpzkfk);
	}
	
	
	
	
	
	
	
}