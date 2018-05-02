/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzyjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.dao.Ironfo_yjbylsbpz_yjkDao;

/**
 *  药剂科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class Ironfo_yjbylsbpz_yjkService extends CrudService<Ironfo_yjbylsbpz_yjkDao, Ironfo_yjbylsbpz_yjk> {

	
	@Autowired
	private Ironfo_yjbylsbpz_yjkDao dao;
	
	
	public Ironfo_yjbylsbpz_yjk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfo_yjbylsbpz_yjk> findList(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk) {
		return super.findList(ironfo_yjbylsbpz_yjk);
	}
	
	public Page<Ironfo_yjbylsbpz_yjk> findPage(Page<Ironfo_yjbylsbpz_yjk> page, Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk) {
		return super.findPage(page, ironfo_yjbylsbpz_yjk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk) {
		super.save(ironfo_yjbylsbpz_yjk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk) {
		super.delete(ironfo_yjbylsbpz_yjk);
	}
	
	
	


	@Transactional(readOnly = false)
	public void updateIronfo(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk) {
		
		dao.updateIronfo(ironfo_yjbylsbpz_yjk);
	}
	
	
	public List<Ironfo_yjbylsbpz_yjk> queryForList(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk){
		
		return dao.queryForList(ironfo_yjbylsbpz_yjk);
	}
	
	
	
	
	
	
	
}