/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivesssgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivesssgl.entity.Ironfofivesssgl;
import com.jeeplus.modules.ironfofivebfpz.entity.Ironfofivebfpz;
import com.jeeplus.modules.ironfofivesssgl.dao.IronfofivesssglDao;

/**
 * 5.4手术室Service
 * @author mikesun
 * @version 2018-04-08
 */
@Service
@Transactional(readOnly = true)
public class IronfofivesssglService extends CrudService<IronfofivesssglDao, Ironfofivesssgl> {

	@Autowired
	private IronfofivesssglDao dao;
	
	public Ironfofivesssgl get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivesssgl> findList(Ironfofivesssgl ironfofivesssgl) {
		return super.findList(ironfofivesssgl);
	}
	
	public Page<Ironfofivesssgl> findPage(Page<Ironfofivesssgl> page, Ironfofivesssgl ironfofivesssgl) {
		return super.findPage(page, ironfofivesssgl);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivesssgl ironfofivesssgl) {
		super.save(ironfofivesssgl);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivesssgl ironfofivesssgl) {
		super.delete(ironfofivesssgl);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfofivesssgl ironfofivesssgl) {
		
		dao.updateIronfo(ironfofivesssgl);
	}
	
	
	public List<Ironfofivesssgl> queryForList(Ironfofivesssgl ironfofivesssgl){
		
		return dao.queryForList(ironfofivesssgl);
	}
	
	
	
	
}