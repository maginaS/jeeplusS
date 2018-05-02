/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzkqk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.dao.IronfoyjbylsbpzkqkDao;

/**
 * 口腔科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzkqkService extends CrudService<IronfoyjbylsbpzkqkDao, Ironfoyjbylsbpzkqk> {

	@Autowired
	private IronfoyjbylsbpzkqkDao dao;
	
	public Ironfoyjbylsbpzkqk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzkqk> findList(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk) {
		return super.findList(ironfoyjbylsbpzkqk);
	}
	
	public Page<Ironfoyjbylsbpzkqk> findPage(Page<Ironfoyjbylsbpzkqk> page, Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk) {
		return super.findPage(page, ironfoyjbylsbpzkqk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk) {
		super.save(ironfoyjbylsbpzkqk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk) {
		super.delete(ironfoyjbylsbpzkqk);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk) {
		
		dao.updateIronfo(ironfoyjbylsbpzkqk);
	}
	
	
	public List<Ironfoyjbylsbpzkqk> queryForList(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk){
		
		return dao.queryForList(ironfoyjbylsbpzkqk);
	}
	
	
	
	
	
	
}