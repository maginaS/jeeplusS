/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopublichealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfopublichealth.entity.Ironfopublichealth;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfopublichealth.dao.IronfopublichealthDao;

/**
 * 2.3基本公共卫生服务Service
 * @author mikesun
 * @version 2018-03-16
 */
@Service
@Transactional(readOnly = true)
public class IronfopublichealthService extends CrudService<IronfopublichealthDao, Ironfopublichealth> {
	
	@Autowired
	private IronfopublichealthDao dao;

	public Ironfopublichealth get(String id) {
		return super.get(id);
	}
	
	public List<Ironfopublichealth> findList(Ironfopublichealth ironfopublichealth) {
		return super.findList(ironfopublichealth);
	}
	
	public Page<Ironfopublichealth> findPage(Page<Ironfopublichealth> page, Ironfopublichealth ironfopublichealth) {
		return super.findPage(page, ironfopublichealth);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfopublichealth ironfopublichealth) {
		super.save(ironfopublichealth);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfopublichealth ironfopublichealth) {
		super.delete(ironfopublichealth);
	}
	
	
	@Transactional(readOnly = false)
	public void updateIronfo(Ironfopublichealth ironfopublichealth) {
		
		dao.updateIronfo(ironfopublichealth);
	}
	
	
	public List<Ironfopublichealth> queryForList(Ironfopublichealth ironfopublichealth){
		
		return dao.queryForList(ironfopublichealth);
	}
	
	
	
	
	
}