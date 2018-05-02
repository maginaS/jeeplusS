/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzyxjzl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiventzydjcn.entity.Ironfofiventzydjcn;
import com.jeeplus.modules.ironfofiventzyxjzl.dao.IronfofiventzyxjzlDao;

/**
 * 夏季制冷Service
 * @author mikesun
 * @version 2018-04-17
 */
@Service
@Transactional(readOnly = true)
public class IronfofiventzyxjzlService extends CrudService<IronfofiventzyxjzlDao, Ironfofiventzyxjzl> {
	
	@Autowired
	private IronfofiventzyxjzlDao dao;

	public Ironfofiventzyxjzl get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiventzyxjzl> findList(Ironfofiventzyxjzl ironfofiventzyxjzl) {
		return super.findList(ironfofiventzyxjzl);
	}
	
	public Page<Ironfofiventzyxjzl> findPage(Page<Ironfofiventzyxjzl> page, Ironfofiventzyxjzl ironfofiventzyxjzl) {
		return super.findPage(page, ironfofiventzyxjzl);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiventzyxjzl ironfofiventzyxjzl) {
		super.save(ironfofiventzyxjzl);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiventzyxjzl ironfofiventzyxjzl) {
		super.delete(ironfofiventzyxjzl);
	}
	
	


	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiventzyxjzl> queryForList(Ironfofiventzyxjzl ironfofiventzydjcn){
		
		return dao.queryForList(ironfofiventzydjcn);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiventzyxjzl ironfofiventzydjcn) {
		dao.updateIronfo(ironfofiventzydjcn);
	}
	
	
	
	
	
}