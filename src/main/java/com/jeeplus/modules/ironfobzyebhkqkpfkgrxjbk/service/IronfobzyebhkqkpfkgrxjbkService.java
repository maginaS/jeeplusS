/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.entity.Ironfobzyebhkqkpfkgrxjbk;
import com.jeeplus.modules.ironfobzwkfck.entity.Ironfobzwkfck;
import com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.dao.IronfobzyebhkqkpfkgrxjbkDao;

/**
 * 2.7其它临床科室病种Service
 * @author mikesun
 * @version 2018-04-21
 */
@Service
@Transactional(readOnly = true)
public class IronfobzyebhkqkpfkgrxjbkService extends CrudService<IronfobzyebhkqkpfkgrxjbkDao, Ironfobzyebhkqkpfkgrxjbk> {

	
	@Autowired
	private IronfobzyebhkqkpfkgrxjbkDao dao;
	
	public Ironfobzyebhkqkpfkgrxjbk get(String id) {
		return super.get(id);
	}
	
	public List<Ironfobzyebhkqkpfkgrxjbk> findList(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk) {
		return super.findList(ironfobzyebhkqkpfkgrxjbk);
	}
	
	public Page<Ironfobzyebhkqkpfkgrxjbk> findPage(Page<Ironfobzyebhkqkpfkgrxjbk> page, Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk) {
		return super.findPage(page, ironfobzyebhkqkpfkgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk) {
		super.save(ironfobzyebhkqkpfkgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk) {
		super.delete(ironfobzyebhkqkpfkgrxjbk);
	}
	
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfobzyebhkqkpfkgrxjbk> queryForList(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk){
		
		return dao.queryForList(ironfobzyebhkqkpfkgrxjbk);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk) {
		dao.updateIronfo(ironfobzyebhkqkpfkgrxjbk);
	}
	
	
	
	
	
	
}