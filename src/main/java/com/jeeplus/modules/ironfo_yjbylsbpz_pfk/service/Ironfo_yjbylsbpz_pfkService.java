/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_yjbylsbpz_pfk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.entity.Ironfoyjbylsbpzqkyxk;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.dao.Ironfo_yjbylsbpz_pfkDao;

/**
 * 皮肤科Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class Ironfo_yjbylsbpz_pfkService extends CrudService<Ironfo_yjbylsbpz_pfkDao, Ironfo_yjbylsbpz_pfk> {

	public Ironfo_yjbylsbpz_pfk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfo_yjbylsbpz_pfk> findList(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk) {
		return super.findList(ironfo_yjbylsbpz_pfk);
	}
	
	public Page<Ironfo_yjbylsbpz_pfk> findPage(Page<Ironfo_yjbylsbpz_pfk> page, Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk) {
		return super.findPage(page, ironfo_yjbylsbpz_pfk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk) {
		super.save(ironfo_yjbylsbpz_pfk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk) {
		super.delete(ironfo_yjbylsbpz_pfk);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk) {
		
		dao.updateIronfo(ironfo_yjbylsbpz_pfk);
	}
	
	
	public List<Ironfo_yjbylsbpz_pfk> queryForList(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk){
		
		return dao.queryForList(ironfo_yjbylsbpz_pfk);
	}
	
	
	
	
	
	
}