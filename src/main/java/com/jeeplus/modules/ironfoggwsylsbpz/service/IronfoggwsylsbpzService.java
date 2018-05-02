/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoggwsylsbpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoggwsylsbpz.entity.Ironfoggwsylsbpz;
import com.jeeplus.modules.ironfozyb.entity.Ironfozyb;
import com.jeeplus.modules.ironfoggwsylsbpz.dao.IronfoggwsylsbpzDao;

/**
 * 3.4公共卫生部医疗设备配置Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoggwsylsbpzService extends CrudService<IronfoggwsylsbpzDao, Ironfoggwsylsbpz> {

	
	@Autowired
	private IronfoggwsylsbpzDao dao;
	
	public Ironfoggwsylsbpz get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoggwsylsbpz> findList(Ironfoggwsylsbpz ironfoggwsylsbpz) {
		return super.findList(ironfoggwsylsbpz);
	}
	
	public Page<Ironfoggwsylsbpz> findPage(Page<Ironfoggwsylsbpz> page, Ironfoggwsylsbpz ironfoggwsylsbpz) {
		return super.findPage(page, ironfoggwsylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoggwsylsbpz ironfoggwsylsbpz) {
		super.save(ironfoggwsylsbpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoggwsylsbpz ironfoggwsylsbpz) {
		super.delete(ironfoggwsylsbpz);
	}
	
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoggwsylsbpz ironfoggwsylsbpz) {
		
		dao.updateIronfo(ironfoggwsylsbpz);
	}
	
	
	public List<Ironfoggwsylsbpz> queryForList(Ironfoggwsylsbpz ironfoggwsylsbpz){
		
		return dao.queryForList(ironfoggwsylsbpz);
	}
	
	
	
	
}