/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzsss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzsss.entity.Ironfoyjbylsbpzsss;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;
import com.jeeplus.modules.ironfoyjbylsbpzsss.dao.IronfoyjbylsbpzsssDao;

/**
 * 手术室Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzsssService extends CrudService<IronfoyjbylsbpzsssDao, Ironfoyjbylsbpzsss> {

	
	
	@Autowired
	private IronfoyjbylsbpzsssDao dao;
	
	public Ironfoyjbylsbpzsss get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzsss> findList(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss) {
		return super.findList(ironfoyjbylsbpzsss);
	}
	
	public Page<Ironfoyjbylsbpzsss> findPage(Page<Ironfoyjbylsbpzsss> page, Ironfoyjbylsbpzsss ironfoyjbylsbpzsss) {
		return super.findPage(page, ironfoyjbylsbpzsss);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss) {
		super.save(ironfoyjbylsbpzsss);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss) {
		super.delete(ironfoyjbylsbpzsss);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss) {
		
		dao.updateIronfo(ironfoyjbylsbpzsss);
	}
	
	
	public List<Ironfoyjbylsbpzsss> queryForList(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss){
		
		return dao.queryForList(ironfoyjbylsbpzsss);
	}
	
	
	
	
}