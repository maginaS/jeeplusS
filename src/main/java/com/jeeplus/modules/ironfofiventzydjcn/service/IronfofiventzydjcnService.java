/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzydjcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiventzydjcn.entity.Ironfofiventzydjcn;
import com.jeeplus.modules.ironfofivegpszywwcl.entity.Ironfofivegpszywwcl;
import com.jeeplus.modules.ironfofiventzydjcn.dao.IronfofiventzydjcnDao;

/**
 * 冬季采暖Service
 * @author mikesun
 * @version 2018-04-16
 */
@Service
@Transactional(readOnly = true)
public class IronfofiventzydjcnService extends CrudService<IronfofiventzydjcnDao, Ironfofiventzydjcn> {

	
	@Autowired
	private IronfofiventzydjcnDao dao;
	public Ironfofiventzydjcn get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiventzydjcn> findList(Ironfofiventzydjcn ironfofiventzydjcn) {
		return super.findList(ironfofiventzydjcn);
	}
	
	public Page<Ironfofiventzydjcn> findPage(Page<Ironfofiventzydjcn> page, Ironfofiventzydjcn ironfofiventzydjcn) {
		return super.findPage(page, ironfofiventzydjcn);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiventzydjcn ironfofiventzydjcn) {
		super.save(ironfofiventzydjcn);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiventzydjcn ironfofiventzydjcn) {
		super.delete(ironfofiventzydjcn);
	}
	
	


	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiventzydjcn> queryForList(Ironfofiventzydjcn ironfofiventzydjcn){
		
		return dao.queryForList(ironfofiventzydjcn);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiventzydjcn ironfofiventzydjcn) {
		dao.updateIronfo(ironfofiventzydjcn);
	}
	
	
	
	
	
}