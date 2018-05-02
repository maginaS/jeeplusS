/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofeatdepartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofeatdepartment.entity.Ironfofeatdepartment;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfofeatdepartment.dao.IronfofeatdepartmentDao;

/**
 * 2.4.1特色科室Service
 * @author mikesun
 * @version 2018-03-16
 */
@Service
@Transactional(readOnly = true)
public class IronfofeatdepartmentService extends CrudService<IronfofeatdepartmentDao, Ironfofeatdepartment> {

	
	@Autowired
	private IronfofeatdepartmentDao dao;
	
	
	public Ironfofeatdepartment get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofeatdepartment> findList(Ironfofeatdepartment ironfofeatdepartment) {
		return super.findList(ironfofeatdepartment);
	}
	
	public Page<Ironfofeatdepartment> findPage(Page<Ironfofeatdepartment> page, Ironfofeatdepartment ironfofeatdepartment) {
		return super.findPage(page, ironfofeatdepartment);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofeatdepartment ironfofeatdepartment) {
		super.save(ironfofeatdepartment);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofeatdepartment ironfofeatdepartment) {
		super.delete(ironfofeatdepartment);
	}
	
	

	@Transactional(readOnly = false)
	public void updateIronfo(Ironfofeatdepartment ironfofeatdepartment) {
		
		dao.updateIronfo(ironfofeatdepartment);
	}
	
	
	public List<Ironfofeatdepartment> queryForList(Ironfofeatdepartment ironfofeatdepartment){
		
		return dao.queryForList(ironfofeatdepartment);
	}
	
	
	
	
	
	
}