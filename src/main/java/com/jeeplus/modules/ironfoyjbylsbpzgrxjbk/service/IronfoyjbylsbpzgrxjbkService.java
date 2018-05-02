/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.entity.Ironfoyjbylsbpzgrxjbk;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.dao.IronfoyjbylsbpzgrxjbkDao;

/**
 * 感染性疾病科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzgrxjbkService extends CrudService<IronfoyjbylsbpzgrxjbkDao, Ironfoyjbylsbpzgrxjbk> {
	
	
	@Autowired
	private IronfoyjbylsbpzgrxjbkDao dao;

	public Ironfoyjbylsbpzgrxjbk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzgrxjbk> findList(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk) {
		return super.findList(ironfoyjbylsbpzgrxjbk);
	}
	
	public Page<Ironfoyjbylsbpzgrxjbk> findPage(Page<Ironfoyjbylsbpzgrxjbk> page, Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk) {
		return super.findPage(page, ironfoyjbylsbpzgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk) {
		super.save(ironfoyjbylsbpzgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk) {
		super.delete(ironfoyjbylsbpzgrxjbk);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk) {
		
		dao.updateIronfo(ironfoyjbylsbpzgrxjbk);
	}
	
	
	public List<Ironfoyjbylsbpzgrxjbk> queryForList(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk){
		
		return dao.queryForList(ironfoyjbylsbpzgrxjbk);
	}
	
	
	
	
	
	
	
}