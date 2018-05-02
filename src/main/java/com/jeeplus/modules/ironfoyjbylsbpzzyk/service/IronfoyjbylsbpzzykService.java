/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzzyk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.entity.Ironfoyjbylsbpzzyk;
import com.jeeplus.modules.ironfoyjbylsbpzykebyhk.entity.Ironfoyjbylsbpzykebyhk;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.dao.IronfoyjbylsbpzzykDao;

/**
 * 中医科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzzykService extends CrudService<IronfoyjbylsbpzzykDao, Ironfoyjbylsbpzzyk> {
	
	
	@Autowired
	private IronfoyjbylsbpzzykDao dao;

	public Ironfoyjbylsbpzzyk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzzyk> findList(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk) {
		return super.findList(ironfoyjbylsbpzzyk);
	}
	
	public Page<Ironfoyjbylsbpzzyk> findPage(Page<Ironfoyjbylsbpzzyk> page, Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk) {
		return super.findPage(page, ironfoyjbylsbpzzyk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk) {
		super.save(ironfoyjbylsbpzzyk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk) {
		super.delete(ironfoyjbylsbpzzyk);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk) {
		
		dao.updateIronfo(ironfoyjbylsbpzzyk);
	}
	
	
	public List<Ironfoyjbylsbpzzyk> queryForList(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk){
		
		return dao.queryForList(ironfoyjbylsbpzzyk);
	}
	
	
	
	
	
}