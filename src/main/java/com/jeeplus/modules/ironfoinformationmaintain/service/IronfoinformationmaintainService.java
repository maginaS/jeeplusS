/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationmaintain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoinformationmaintain.entity.Ironfoinformationmaintain;
import com.jeeplus.modules.ironfoinformationmaintain.dao.IronfoinformationmaintainDao;

/**
 * 4.4系统维护人员Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationmaintainService extends CrudService<IronfoinformationmaintainDao, Ironfoinformationmaintain> {

	public Ironfoinformationmaintain get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoinformationmaintain> findList(Ironfoinformationmaintain ironfoinformationmaintain) {
		return super.findList(ironfoinformationmaintain);
	}
	
	public Page<Ironfoinformationmaintain> findPage(Page<Ironfoinformationmaintain> page, Ironfoinformationmaintain ironfoinformationmaintain) {
		return super.findPage(page, ironfoinformationmaintain);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoinformationmaintain ironfoinformationmaintain) {
		super.save(ironfoinformationmaintain);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoinformationmaintain ironfoinformationmaintain) {
		super.delete(ironfoinformationmaintain);
	}
	
	
	
	
}