/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpznek.entity.Ironfoyjbylsbpznek;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.dao.IronfoyjbylsbpzfskcskxdtkDao;

/**
 * 放射科、超声科、心电图科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoyjbylsbpzfskcskxdtkService extends CrudService<IronfoyjbylsbpzfskcskxdtkDao, Ironfoyjbylsbpzfskcskxdtk> {
	
	@Autowired
	private IronfoyjbylsbpzfskcskxdtkDao dao;

	public Ironfoyjbylsbpzfskcskxdtk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoyjbylsbpzfskcskxdtk> findList(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpzfskcskxdtk) {
		return super.findList(ironfoyjbylsbpzfskcskxdtk);
	}
	
	public Page<Ironfoyjbylsbpzfskcskxdtk> findPage(Page<Ironfoyjbylsbpzfskcskxdtk> page, Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpzfskcskxdtk) {
		return super.findPage(page, ironfoyjbylsbpzfskcskxdtk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpzfskcskxdtk) {
		super.save(ironfoyjbylsbpzfskcskxdtk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpzfskcskxdtk) {
		super.delete(ironfoyjbylsbpzfskcskxdtk);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpzfskcskxdtk) {
		
		dao.updateIronfo(ironfoyjbylsbpzfskcskxdtk);
	}
	
	
	public List<Ironfoyjbylsbpzfskcskxdtk> queryForList(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpzfskcskxdtk){
		
		return dao.queryForList(ironfoyjbylsbpzfskcskxdtk);
	}
	
	
	
	
	
	
}