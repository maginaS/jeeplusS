/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzxdgys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzxdgys.entity.Ironfoyjbylsbpzxdgys;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpzxdgys.dao.IronfoyjbylsbpzxdgysDao;

/**
 * 消毒供应室Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzxdgysService extends CrudService<IronfoyjbylsbpzxdgysDao, Ironfoyjbylsbpzxdgys> {

	@Autowired
	private  IronfoyjbylsbpzxdgysDao  dao;
	
	
	public Ironfoyjbylsbpzxdgys get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzxdgys> findList(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys) {
		return super.findList(ironfoyjbylsbpzxdgys);
	}
	
	public Page<Ironfoyjbylsbpzxdgys> findPage(Page<Ironfoyjbylsbpzxdgys> page, Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys) {
		return super.findPage(page, ironfoyjbylsbpzxdgys);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys) {
		super.save(ironfoyjbylsbpzxdgys);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys) {
		super.delete(ironfoyjbylsbpzxdgys);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys) {
		
		dao.updateIronfo(ironfoyjbylsbpzxdgys);
	}
	
	
	public List<Ironfoyjbylsbpzxdgys> queryForList(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys){
		
		return dao.queryForList(ironfoyjbylsbpzxdgys);
	}
	
	
	
	
	
	
}