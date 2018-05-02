/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoqtkspz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoqtkspz.entity.Ironfoqtkspz;
import com.jeeplus.modules.ironfojhsybylsbpz.entity.Ironfojhsybylsbpz;
import com.jeeplus.modules.ironfoqtkspz.dao.IronfoqtkspzDao;

/**
 * 3.6其他科室医疗设备配置Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoqtkspzService extends CrudService<IronfoqtkspzDao, Ironfoqtkspz> {

	@Autowired
	private IronfoqtkspzDao dao;
	
	public Ironfoqtkspz get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoqtkspz> findList(Ironfoqtkspz ironfoqtkspz) {
		return super.findList(ironfoqtkspz);
	}
	
	public Page<Ironfoqtkspz> findPage(Page<Ironfoqtkspz> page, Ironfoqtkspz ironfoqtkspz) {
		return super.findPage(page, ironfoqtkspz);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoqtkspz ironfoqtkspz) {
		super.save(ironfoqtkspz);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoqtkspz ironfoqtkspz) {
		super.delete(ironfoqtkspz);
	}
	
	



	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoqtkspz ironfoqtkspz) {
		
		dao.updateIronfo(ironfoqtkspz);
	}
	
	
	public List<Ironfoqtkspz> queryForList(Ironfoqtkspz ironfoqtkspz){
		
		return dao.queryForList(ironfoqtkspz);
	}
	
	
	
	
	
	
}