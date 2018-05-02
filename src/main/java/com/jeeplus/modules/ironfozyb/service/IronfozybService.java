/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfozyb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfozyb.entity.Ironfozyb;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfozyb.dao.IronfozybDao;

/**
 * 3.3住院部医疗设备配置Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfozybService extends CrudService<IronfozybDao, Ironfozyb> {
	
	
	@Autowired
	private IronfozybDao dao;

	public Ironfozyb get(String id) {
		return super.get(id);
	}
	
	public List<Ironfozyb> findList(Ironfozyb ironfozyb) {
		return super.findList(ironfozyb);
	}
	
	public Page<Ironfozyb> findPage(Page<Ironfozyb> page, Ironfozyb ironfozyb) {
		return super.findPage(page, ironfozyb);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfozyb ironfozyb) {
		super.save(ironfozyb);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfozyb ironfozyb) {
		super.delete(ironfozyb);
	}
	
	


	@Transactional(readOnly = false)
	public void updateIronfo(Ironfozyb ironfozyb) {
		
		dao.updateIronfo(ironfozyb);
	}
	
	
	public List<Ironfozyb> queryForList(Ironfozyb ironfozyb){
		
		return dao.queryForList(ironfozyb);
	}
	
	
	
	
	
}