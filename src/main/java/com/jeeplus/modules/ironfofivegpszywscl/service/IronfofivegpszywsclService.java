/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszywscl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivegpszywscl.entity.Ironfofivegpszywscl;
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;
import com.jeeplus.modules.ironfofivegpszywscl.dao.IronfofivegpszywsclDao;

/**
 * 污水处理Service
 * @author mikesun
 * @version 2018-04-16
 */
@Service
@Transactional(readOnly = true)
public class IronfofivegpszywsclService extends CrudService<IronfofivegpszywsclDao, Ironfofivegpszywscl> {

	@Autowired
	private IronfofivegpszywsclDao dao;
	
	
	public Ironfofivegpszywscl get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivegpszywscl> findList(Ironfofivegpszywscl ironfofivegpszywscl) {
		return super.findList(ironfofivegpszywscl);
	}
	
	public Page<Ironfofivegpszywscl> findPage(Page<Ironfofivegpszywscl> page, Ironfofivegpszywscl ironfofivegpszywscl) {
		return super.findPage(page, ironfofivegpszywscl);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivegpszywscl ironfofivegpszywscl) {
		super.save(ironfofivegpszywscl);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivegpszywscl ironfofivegpszywscl) {
		super.delete(ironfofivegpszywscl);
	}
	
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivegpszywscl> queryForList(Ironfofivegpszywscl ironfofivegpszywscl){
		
		return dao.queryForList(ironfofivegpszywscl);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivegpszywscl ironfofivegpszywscl) {
		dao.updateIronfo(ironfofivegpszywscl);
	}
	
	
	
	
}