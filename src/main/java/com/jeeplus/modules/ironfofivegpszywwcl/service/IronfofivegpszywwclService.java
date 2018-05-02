/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszywwcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivegpszywwcl.entity.Ironfofivegpszywwcl;
import com.jeeplus.modules.ironfofivegpszywscl.entity.Ironfofivegpszywscl;
import com.jeeplus.modules.ironfofivegpszywwcl.dao.IronfofivegpszywwclDao;

/**
 * 污物处理Service
 * @author mikesun
 * @version 2018-04-16
 */
@Service
@Transactional(readOnly = true)
public class IronfofivegpszywwclService extends CrudService<IronfofivegpszywwclDao, Ironfofivegpszywwcl> {

	
	@Autowired
	private IronfofivegpszywwclDao dao;
	
	
	public Ironfofivegpszywwcl get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivegpszywwcl> findList(Ironfofivegpszywwcl ironfofivegpszywwcl) {
		return super.findList(ironfofivegpszywwcl);
	}
	
	public Page<Ironfofivegpszywwcl> findPage(Page<Ironfofivegpszywwcl> page, Ironfofivegpszywwcl ironfofivegpszywwcl) {
		return super.findPage(page, ironfofivegpszywwcl);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivegpszywwcl ironfofivegpszywwcl) {
		super.save(ironfofivegpszywwcl);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivegpszywwcl ironfofivegpszywwcl) {
		super.delete(ironfofivegpszywwcl);
	}
	
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivegpszywwcl> queryForList(Ironfofivegpszywwcl ironfofivegpszywwcl){
		
		return dao.queryForList(ironfofivegpszywwcl);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivegpszywwcl ironfofivegpszywwcl) {
		dao.updateIronfo(ironfofivegpszywwcl);
	}
	
	
	
	
	
}