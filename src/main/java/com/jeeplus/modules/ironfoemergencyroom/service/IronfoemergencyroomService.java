/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoemergencyroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfoemergencyroom.dao.IronfoemergencyroomDao;

/**
 * 急诊室Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoemergencyroomService extends CrudService<IronfoemergencyroomDao, Ironfoemergencyroom> {

	
	@Autowired
	private IronfoemergencyroomDao dao;
	
	public Ironfoemergencyroom get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoemergencyroom> findList(Ironfoemergencyroom ironfoemergencyroom) {
		return super.findList(ironfoemergencyroom);
	}
	
	public Page<Ironfoemergencyroom> findPage(Page<Ironfoemergencyroom> page, Ironfoemergencyroom ironfoemergencyroom) {
		return super.findPage(page, ironfoemergencyroom);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoemergencyroom ironfoemergencyroom) {
		super.save(ironfoemergencyroom);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoemergencyroom ironfoemergencyroom) {
		super.delete(ironfoemergencyroom);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoemergencyroom ironfoemergencyroom) {
		
		dao.updateIronfo(ironfoemergencyroom);
	}
	
	
	public List<Ironfoemergencyroom> queryForList(Ironfoemergencyroom ironfoemergencyroom){
		
		return dao.queryForList(ironfoemergencyroom);
	}
	
	
	
	
	
	
}