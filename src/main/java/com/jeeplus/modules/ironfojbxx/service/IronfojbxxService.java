/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfojbxx.entity.Ironfojbxx;
import com.jeeplus.modules.ironfojbxx.dao.IronfojbxxDao;

/**
 * 基本信息Service
 * @author mikesun
 * @version 2018-04-17
 */
@Service
@Transactional(readOnly = true)
public class IronfojbxxService extends CrudService<IronfojbxxDao, Ironfojbxx> {

	public Ironfojbxx get(String id) {
		return super.get(id);
	}
	
	public List<Ironfojbxx> findList(Ironfojbxx ironfojbxx) {
		return super.findList(ironfojbxx);
	}
	
	public Page<Ironfojbxx> findPage(Page<Ironfojbxx> page, Ironfojbxx ironfojbxx) {
		return super.findPage(page, ironfojbxx);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfojbxx ironfojbxx) {
		super.save(ironfojbxx);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfojbxx ironfojbxx) {
		super.delete(ironfojbxx);
	}
	
	
	
	
}