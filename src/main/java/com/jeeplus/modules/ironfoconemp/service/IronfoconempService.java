/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoconemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoconemp.entity.Ironfoconemp;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfoconemp.dao.IronfoconempDao;

/**
 * 2.7.1职工构成Service
 * @author mikesun
 * @version 2018-03-21
 */
@Service
@Transactional(readOnly = true)
public class IronfoconempService extends CrudService<IronfoconempDao, Ironfoconemp> {
	
	@Autowired
	private IronfoconempDao dao;

	public Ironfoconemp get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoconemp> findList(Ironfoconemp ironfoconemp) {
		return super.findList(ironfoconemp);
	}
	
	public Page<Ironfoconemp> findPage(Page<Ironfoconemp> page, Ironfoconemp ironfoconemp) {
		return super.findPage(page, ironfoconemp);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoconemp ironfoconemp) {
		super.save(ironfoconemp);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoconemp ironfoconemp) {
		super.delete(ironfoconemp);
	}
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoconemp ironfoconemp) {
		
		dao.updateIronfo(ironfoconemp);
	}
	
	
	public List<Ironfoconemp> queryForList(Ironfoconemp ironfoconemp){
		
		return dao.queryForList(ironfoconemp);
	}
	
	
	
	
	
}