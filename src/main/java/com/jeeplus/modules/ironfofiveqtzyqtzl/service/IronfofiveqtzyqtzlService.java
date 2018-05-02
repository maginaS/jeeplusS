/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzyqtzl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiveqtzyqtzl.entity.Ironfofiveqtzyqtzl;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiveqtzyqtzl.dao.IronfofiveqtzyqtzlDao;

/**
 * 气体种类Service
 * @author mikesun
 * @version 2018-04-17
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveqtzyqtzlService extends CrudService<IronfofiveqtzyqtzlDao, Ironfofiveqtzyqtzl> {
	
	@Autowired
	private IronfofiveqtzyqtzlDao dao;

	public Ironfofiveqtzyqtzl get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiveqtzyqtzl> findList(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl) {
		return super.findList(ironfofiveqtzyqtzl);
	}
	
	public Page<Ironfofiveqtzyqtzl> findPage(Page<Ironfofiveqtzyqtzl> page, Ironfofiveqtzyqtzl ironfofiveqtzyqtzl) {
		return super.findPage(page, ironfofiveqtzyqtzl);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl) {
		super.save(ironfofiveqtzyqtzl);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl) {
		super.delete(ironfofiveqtzyqtzl);
	}
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiveqtzyqtzl> queryForList(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl){
		
		return dao.queryForList(ironfofiveqtzyqtzl);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl) {
		dao.updateIronfo(ironfofiveqtzyqtzl);
	}
	
	
	
	
}