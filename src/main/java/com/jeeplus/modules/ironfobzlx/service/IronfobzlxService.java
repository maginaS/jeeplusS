/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzlx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfobzlx.entity.Ironfobzlx;
import com.jeeplus.modules.ironfobzlx.dao.IronfobzlxDao;

/**
 * ironfobzlxService
 * @author mikesun
 * @version 2018-03-19
 */
@Service
@Transactional(readOnly = true)
public class IronfobzlxService extends CrudService<IronfobzlxDao, Ironfobzlx> {

	public Ironfobzlx get(String id) {
		return super.get(id);
	}
	
	public List<Ironfobzlx> findList(Ironfobzlx ironfobzlx) {
		return super.findList(ironfobzlx);
	}
	
	public Page<Ironfobzlx> findPage(Page<Ironfobzlx> page, Ironfobzlx ironfobzlx) {
		return super.findPage(page, ironfobzlx);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfobzlx ironfobzlx) {
		super.save(ironfobzlx);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfobzlx ironfobzlx) {
		super.delete(ironfobzlx);
	}
	
	
	
	
}