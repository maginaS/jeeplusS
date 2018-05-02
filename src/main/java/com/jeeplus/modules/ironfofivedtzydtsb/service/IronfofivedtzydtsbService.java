/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedtzydtsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivedtzydtsb.entity.Ironfofivedtzydtsb;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofivedtzydtsb.dao.IronfofivedtzydtsbDao;

/**
 * 电梯设备Service
 * @author mikesun
 * @version 2018-04-17
 */
@Service
@Transactional(readOnly = true)
public class IronfofivedtzydtsbService extends CrudService<IronfofivedtzydtsbDao, Ironfofivedtzydtsb> {

	
	@Autowired
	private IronfofivedtzydtsbDao dao;
	
	
	public Ironfofivedtzydtsb get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivedtzydtsb> findList(Ironfofivedtzydtsb ironfofivedtzydtsb) {
		return super.findList(ironfofivedtzydtsb);
	}
	
	public Page<Ironfofivedtzydtsb> findPage(Page<Ironfofivedtzydtsb> page, Ironfofivedtzydtsb ironfofivedtzydtsb) {
		return super.findPage(page, ironfofivedtzydtsb);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivedtzydtsb ironfofivedtzydtsb) {
		super.save(ironfofivedtzydtsb);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivedtzydtsb ironfofivedtzydtsb) {
		super.delete(ironfofivedtzydtsb);
	}
	


	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivedtzydtsb> queryForList(Ironfofivedtzydtsb ironfofivedtzydtsb){
		
		return dao.queryForList(ironfofivedtzydtsb);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivedtzydtsb ironfofivedtzydtsb) {
		dao.updateIronfo(ironfofivedtzydtsb);
	}
	
	
	
	
	
}