/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;
import com.jeeplus.modules.ironfofinance.dao.IronfofinanceDao;

/**
 * 2.2财务收支Service
 * @author mikesun
 * @version 2018-03-16
 */
@Service
@Transactional(readOnly = true)
public class IronfofinanceService extends CrudService<IronfofinanceDao, Ironfofinance> {
	
	@Autowired
	private IronfofinanceDao dao;

	public Ironfofinance get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofinance> findList(Ironfofinance ironfofinance) {
		return super.findList(ironfofinance);
	}
	
	public Page<Ironfofinance> findPage(Page<Ironfofinance> page, Ironfofinance ironfofinance) {
		return super.findPage(page, ironfofinance);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofinance ironfofinance) {
		super.save(ironfofinance);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofinance ironfofinance) {
		super.delete(ironfofinance);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfofinance ironfofinance) {
		
		dao.updateIronfo(ironfofinance);
	}
	
	
	public List<Ironfofinance> queryForList(Ironfofinance ironfofinance){
		
		return dao.queryForList(ironfofinance);
	}
	
	
	
	
	
	
}