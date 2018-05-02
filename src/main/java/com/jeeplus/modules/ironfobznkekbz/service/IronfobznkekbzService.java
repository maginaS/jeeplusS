/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobznkekbz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfobznkekbz.entity.Ironfobznkekbz;
import com.jeeplus.modules.ironfofivedtzydtsb.entity.Ironfofivedtzydtsb;
import com.jeeplus.modules.ironfobznkekbz.dao.IronfobznkekbzDao;

/**
 * 2.5内科、儿科病种Service
 * @author mikesun
 * @version 2018-04-18
 */
@Service
@Transactional(readOnly = true)
public class IronfobznkekbzService extends CrudService<IronfobznkekbzDao, Ironfobznkekbz> {
	
	@Autowired
	private IronfobznkekbzDao dao;

	public Ironfobznkekbz get(String id) {
		return super.get(id);
	}
	
	public List<Ironfobznkekbz> findList(Ironfobznkekbz ironfobznkekbz) {
		return super.findList(ironfobznkekbz);
	}
	
	public Page<Ironfobznkekbz> findPage(Page<Ironfobznkekbz> page, Ironfobznkekbz ironfobznkekbz) {
		return super.findPage(page, ironfobznkekbz);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfobznkekbz ironfobznkekbz) {
		super.save(ironfobznkekbz);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfobznkekbz ironfobznkekbz) {
		super.delete(ironfobznkekbz);
	}
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfobznkekbz> queryForList(Ironfobznkekbz ironfobznkekbz){
		
		return dao.queryForList(ironfobznkekbz);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfobznkekbz ironfobznkekbz) {
		dao.updateIronfo(ironfobznkekbz);
	}
	
	
	
	
}