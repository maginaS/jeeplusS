/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbyy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfojbyy.entity.Ironfojbyy;
import com.jeeplus.modules.ironfofinance.dao.IronfofinanceDao;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfojbyy.dao.IronfojbyyDao;

/**
 * 2.6基本用药Service
 * @author mikesun
 * @version 2018-03-21
 */
@Service
@Transactional(readOnly = true)
public class IronfojbyyService extends CrudService<IronfojbyyDao, Ironfojbyy> {

	
	
	@Autowired
	private IronfojbyyDao dao;
	
	public Ironfojbyy get(String id) {
		return super.get(id);
	}
	
	public List<Ironfojbyy> findList(Ironfojbyy ironfojbyy) {
		return super.findList(ironfojbyy);
	}
	
	public Page<Ironfojbyy> findPage(Page<Ironfojbyy> page, Ironfojbyy ironfojbyy) {
		return super.findPage(page, ironfojbyy);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfojbyy ironfojbyy) {
		super.save(ironfojbyy);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfojbyy ironfojbyy) {
		super.delete(ironfojbyy);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfojbyy ironfojbyy) {
		
		dao.updateIronfo(ironfojbyy);
	}
	
	
	public List<Ironfojbyy> queryForList(Ironfojbyy ironfojbyy){
		
		return dao.queryForList(ironfojbyy);
	}
	
	
	
	
}