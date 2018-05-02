/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfowsjsrygc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfowsjsrygc.entity.Ironfowsjsrygc;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfowsjsrygc.dao.IronfowsjsrygcDao;

/**
 * 2.7.2卫生技术人员构成Service
 * @author mikesun
 * @version 2018-03-21
 */
@Service
@Transactional(readOnly = true)
public class IronfowsjsrygcService extends CrudService<IronfowsjsrygcDao, Ironfowsjsrygc> {

	
	@Autowired
	private IronfowsjsrygcDao dao;
	

	public Ironfowsjsrygc get(String id) {
		return super.get(id);
	}
	
	public List<Ironfowsjsrygc> findList(Ironfowsjsrygc ironfowsjsrygc) {
		return super.findList(ironfowsjsrygc);
	}
	
	public Page<Ironfowsjsrygc> findPage(Page<Ironfowsjsrygc> page, Ironfowsjsrygc ironfowsjsrygc) {
		return super.findPage(page, ironfowsjsrygc);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfowsjsrygc ironfowsjsrygc) {
		super.save(ironfowsjsrygc);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfowsjsrygc ironfowsjsrygc) {
		super.delete(ironfowsjsrygc);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfowsjsrygc ironfowsjsrygc) {
		
		dao.updateIronfo(ironfowsjsrygc);
	}
	
	
	public List<Ironfowsjsrygc> queryForList(Ironfowsjsrygc ironfowsjsrygc){
		
		return dao.queryForList(ironfowsjsrygc);
	}
	
	
	
	
}