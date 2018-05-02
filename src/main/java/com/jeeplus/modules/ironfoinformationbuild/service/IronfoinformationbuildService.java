/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationbuild.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfoinformationbuild.entity.Ironfoinformationbuild;
import com.jeeplus.modules.ironfoqtkspz.entity.Ironfoqtkspz;
import com.jeeplus.modules.ironfoinformationbuild.dao.IronfoinformationbuildDao;

/**
 * 4.1信息化系统建设情况Service
 * @author mikesun
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationbuildService extends CrudService<IronfoinformationbuildDao, Ironfoinformationbuild> {

	
	@Autowired
	private IronfoinformationbuildDao dao;
	
	public Ironfoinformationbuild get(String id) {
		return super.get(id);
	}
	
	public List<Ironfoinformationbuild> findList(Ironfoinformationbuild ironfoinformationbuild) {
		return super.findList(ironfoinformationbuild);
	}
	
	public Page<Ironfoinformationbuild> findPage(Page<Ironfoinformationbuild> page, Ironfoinformationbuild ironfoinformationbuild) {
		return super.findPage(page, ironfoinformationbuild);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoinformationbuild ironfoinformationbuild) {
		super.save(ironfoinformationbuild);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoinformationbuild ironfoinformationbuild) {
		super.delete(ironfoinformationbuild);
	}
	


	@Transactional(readOnly = false)
	public void updateIronfo(Ironfoinformationbuild ironfoinformationbuild) {
		
		dao.updateIronfo(ironfoinformationbuild);
	}
	
	
	public List<Ironfoinformationbuild> queryForList(Ironfoinformationbuild ironfoinformationbuild){
		
		return dao.queryForList(ironfoinformationbuild);
	}
	
	
	
	
	
	
	
	
}