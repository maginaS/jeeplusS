/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzygylx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofiveqtzygylx.entity.Ironfofiveqtzygylx;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiveqtzygylx.dao.IronfofiveqtzygylxDao;

/**
 * 供应类型Service
 * @author mikesun
 * @version 2018-04-17
 */
@Service
@Transactional(readOnly = true)
public class IronfofiveqtzygylxService extends CrudService<IronfofiveqtzygylxDao, Ironfofiveqtzygylx> {
	
	@Autowired
	private IronfofiveqtzygylxDao dao;

	public Ironfofiveqtzygylx get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofiveqtzygylx> findList(Ironfofiveqtzygylx ironfofiveqtzygylx) {
		return super.findList(ironfofiveqtzygylx);
	}
	
	public Page<Ironfofiveqtzygylx> findPage(Page<Ironfofiveqtzygylx> page, Ironfofiveqtzygylx ironfofiveqtzygylx) {
		return super.findPage(page, ironfofiveqtzygylx);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofiveqtzygylx ironfofiveqtzygylx) {
		super.save(ironfofiveqtzygylx);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofiveqtzygylx ironfofiveqtzygylx) {
		super.delete(ironfofiveqtzygylx);
	}
	
	


	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofiveqtzygylx> queryForList(Ironfofiveqtzygylx ironfofiveqtzygylx){
		
		return dao.queryForList(ironfofiveqtzygylx);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofiveqtzygylx ironfofiveqtzygylx) {
		dao.updateIronfo(ironfofiveqtzygylx);
	}
	
	
	
	
	
	
}