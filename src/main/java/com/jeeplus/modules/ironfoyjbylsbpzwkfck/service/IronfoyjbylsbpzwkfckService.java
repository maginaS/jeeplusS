/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzwkfck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.dao.IronfoyjbylsbpzwkfckDao;

/**
 * 外科、妇（产）科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzwkfckService extends CrudService<IronfoyjbylsbpzwkfckDao, Ironfoyjbylsbpzwkfck> {

	
	
	@Autowired
	private IronfoyjbylsbpzwkfckDao dao;
	
	public Ironfoyjbylsbpzwkfck get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzwkfck> findList(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck) {
		return super.findList(ironfoyjbylsbpzwkfck);
	}
	
	public Page<Ironfoyjbylsbpzwkfck> findPage(Page<Ironfoyjbylsbpzwkfck> page, Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck) {
		return super.findPage(page, ironfoyjbylsbpzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck) {
		super.save(ironfoyjbylsbpzwkfck);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck) {
		super.delete(ironfoyjbylsbpzwkfck);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck) {
		
		dao.updateIronfo(ironfoyjbylsbpzwkfck);
	}
	
	
	public List<Ironfoyjbylsbpzwkfck> queryForList(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck){
		
		return dao.queryForList(ironfoyjbylsbpzwkfck);
	}
	
	
	
	
	
}