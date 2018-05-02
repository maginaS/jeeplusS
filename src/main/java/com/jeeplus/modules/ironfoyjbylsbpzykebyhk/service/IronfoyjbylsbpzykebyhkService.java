/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzykebyhk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzykebyhk.entity.Ironfoyjbylsbpzykebyhk;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpzykebyhk.dao.IronfoyjbylsbpzykebyhkDao;

/**
 * 眼科、耳鼻咽喉科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzykebyhkService extends CrudService<IronfoyjbylsbpzykebyhkDao, Ironfoyjbylsbpzykebyhk> {

	
	@Autowired
	private IronfoyjbylsbpzykebyhkDao dao;
	
	
	public Ironfoyjbylsbpzykebyhk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzykebyhk> findList(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk) {
		return super.findList(ironfoyjbylsbpzykebyhk);
	}
	
	public Page<Ironfoyjbylsbpzykebyhk> findPage(Page<Ironfoyjbylsbpzykebyhk> page, Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk) {
		return super.findPage(page, ironfoyjbylsbpzykebyhk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk) {
		super.save(ironfoyjbylsbpzykebyhk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk) {
		super.delete(ironfoyjbylsbpzykebyhk);
	}
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk) {
		
		dao.updateIronfo(ironfoyjbylsbpzykebyhk);
	}
	
	
	public List<Ironfoyjbylsbpzykebyhk> queryForList(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk){
		
		return dao.queryForList(ironfoyjbylsbpzykebyhk);
	}
	
	
	
	
	
	
}