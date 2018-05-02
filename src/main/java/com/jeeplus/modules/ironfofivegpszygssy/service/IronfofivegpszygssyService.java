/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszygssy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;
import com.jeeplus.modules.ironfofivedqzygdfs.entity.Ironfofivedqzygdfs;
import com.jeeplus.modules.ironfofivegpszygssy.dao.IronfofivegpszygssyDao;

/**
 * 给水水源Service
 * @author mikesun
 * @version 2018-04-16
 */
@Service
@Transactional(readOnly = true)
public class IronfofivegpszygssyService extends CrudService<IronfofivegpszygssyDao, Ironfofivegpszygssy> {

	
	
	@Autowired
	private IronfofivegpszygssyDao dao;
	
	
	public Ironfofivegpszygssy get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivegpszygssy> findList(Ironfofivegpszygssy ironfofivegpszygssy) {
		return super.findList(ironfofivegpszygssy);
	}
	
	public Page<Ironfofivegpszygssy> findPage(Page<Ironfofivegpszygssy> page, Ironfofivegpszygssy ironfofivegpszygssy) {
		return super.findPage(page, ironfofivegpszygssy);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivegpszygssy ironfofivegpszygssy) {
		super.save(ironfofivegpszygssy);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivegpszygssy ironfofivegpszygssy) {
		super.delete(ironfofivegpszygssy);
	}
	
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivegpszygssy> queryForList(Ironfofivegpszygssy ironfofivegpszygssy){
		
		return dao.queryForList(ironfofivegpszygssy);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivegpszygssy ironfofivegpszygssy) {
		dao.updateIronfo(ironfofivegpszygssy);
	}
	
	
	
	
	
}