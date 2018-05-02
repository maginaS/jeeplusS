/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzjyk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzjyk.entity.Ironfoyjbylsbpzjyk;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;
import com.jeeplus.modules.ironfoyjbylsbpzjyk.dao.IronfoyjbylsbpzjykDao;

/**
 * 检验科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzjykService extends CrudService<IronfoyjbylsbpzjykDao, Ironfoyjbylsbpzjyk> {

	@Autowired
	private IronfoyjbylsbpzjykDao dao;
	
	
	
	public Ironfoyjbylsbpzjyk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzjyk> findList(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk) {
		return super.findList(ironfoyjbylsbpzjyk);
	}
	
	public Page<Ironfoyjbylsbpzjyk> findPage(Page<Ironfoyjbylsbpzjyk> page, Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk) {
		return super.findPage(page, ironfoyjbylsbpzjyk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk) {
		super.save(ironfoyjbylsbpzjyk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk) {
		super.delete(ironfoyjbylsbpzjyk);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk) {
		
		dao.updateIronfo(ironfoyjbylsbpzjyk);
	}
	
	
	public List<Ironfoyjbylsbpzjyk> queryForList(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk){
		
		return dao.queryForList(ironfoyjbylsbpzjyk);
	}
	
	
	
	
	
}