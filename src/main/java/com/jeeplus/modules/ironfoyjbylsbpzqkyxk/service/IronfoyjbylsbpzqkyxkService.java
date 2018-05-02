/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzqkyxk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.entity.Ironfoyjbylsbpzqkyxk;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.dao.IronfoyjbylsbpzqkyxkDao;

/**
 * 全科医学科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzqkyxkService extends CrudService<IronfoyjbylsbpzqkyxkDao, Ironfoyjbylsbpzqkyxk> {

	
	@Autowired
	private IronfoyjbylsbpzqkyxkDao dao;
	
	
	public Ironfoyjbylsbpzqkyxk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzqkyxk> findList(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk) {
		return super.findList(ironfoyjbylsbpzqkyxk);
	}
	
	public Page<Ironfoyjbylsbpzqkyxk> findPage(Page<Ironfoyjbylsbpzqkyxk> page, Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk) {
		return super.findPage(page, ironfoyjbylsbpzqkyxk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk) {
		super.save(ironfoyjbylsbpzqkyxk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk) {
		super.delete(ironfoyjbylsbpzqkyxk);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk) {
		
		dao.updateIronfo(ironfoyjbylsbpzqkyxk);
	}
	
	
	public List<Ironfoyjbylsbpzqkyxk> queryForList(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk){
		
		return dao.queryForList(ironfoyjbylsbpzqkyxk);
	}
	
	
	
	
}