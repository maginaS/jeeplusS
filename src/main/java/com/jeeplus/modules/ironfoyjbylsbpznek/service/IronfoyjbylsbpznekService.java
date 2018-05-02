/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpznek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpznek.entity.Ironfoyjbylsbpznek;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpznek.dao.IronfoyjbylsbpznekDao;

/**
 * 内（儿）科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpznekService extends CrudService<IronfoyjbylsbpznekDao, Ironfoyjbylsbpznek> {
	
	@Autowired
	private IronfoyjbylsbpznekDao dao;

	public Ironfoyjbylsbpznek get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpznek> findList(Ironfoyjbylsbpznek ironfoyjbylsbpznek) {
		return super.findList(ironfoyjbylsbpznek);
	}
	
	public Page<Ironfoyjbylsbpznek> findPage(Page<Ironfoyjbylsbpznek> page, Ironfoyjbylsbpznek ironfoyjbylsbpznek) {
		return super.findPage(page, ironfoyjbylsbpznek);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpznek ironfoyjbylsbpznek) {
		super.save(ironfoyjbylsbpznek);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpznek ironfoyjbylsbpznek) {
		super.delete(ironfoyjbylsbpznek);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpznek ironfoyjbylsbpznek) {
		
		dao.updateIronfo(ironfoyjbylsbpznek);
	}
	
	
	public List<Ironfoyjbylsbpznek> queryForList(Ironfoyjbylsbpznek ironfoyjbylsbpznek){
		
		return dao.queryForList(ironfoyjbylsbpznek);
	}
	
	
	
	
	
	
}