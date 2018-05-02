/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivemjzyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyf;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;
import com.jeeplus.modules.ironfofivemjzyf.dao.IronfofivemjzyfDao;


import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyfkjlx;
import com.jeeplus.modules.ironfofivemjzyf.dao.IronfofivemjzyfkjlxDao;

/**
 * 5.2门急诊用房Service
 * @author mikesun
 * @version 2018-04-13
 */
@Service
@Transactional(readOnly = true)
public class IronfofivemjzyfService extends CrudService<IronfofivemjzyfDao, Ironfofivemjzyf> {

	@Autowired
	private IronfofivemjzyfkjlxDao ironfofivemjzyfkjlxDao;
	
	public Ironfofivemjzyf get(String id) {
		Ironfofivemjzyf ironfofivemjzyf = super.get(id);
//		ironfofivemjzyf.setIronfofivemjzyfkjlxList(ironfofivemjzyfkjlxDao.findList(new Ironfofivemjzyfkjlx()));
		return ironfofivemjzyf;
	}
	
	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivemjzyfkjlx> queryForList(Ironfofivemjzyfkjlx ironfofivemjzyfkjlx){
		
		return ironfofivemjzyfkjlxDao.queryForList(ironfofivemjzyfkjlx);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivemjzyfkjlx ironfofivemjzyfkjlx) {
		ironfofivemjzyfkjlxDao.updateIronfo(ironfofivemjzyfkjlx);
	}
	
	
	@Transactional(readOnly = false)
	public void saveironfo(Ironfofivemjzyfkjlx ironfofivemjzyfkjlx) {
		ironfofivemjzyfkjlxDao.saveIronfo(ironfofivemjzyfkjlx);
	}
	
	public List<Ironfofivemjzyf> findList(Ironfofivemjzyf ironfofivemjzyf) {
		return super.findList(ironfofivemjzyf);
	}
	
	public Page<Ironfofivemjzyf> findPage(Page<Ironfofivemjzyf> page, Ironfofivemjzyf ironfofivemjzyf) {
		return super.findPage(page, ironfofivemjzyf);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivemjzyf ironfofivemjzyf) {
		super.save(ironfofivemjzyf);
		for (Ironfofivemjzyfkjlx ironfofivemjzyfkjlx : ironfofivemjzyf.getIronfofivemjzyfkjlxList()){
			if (ironfofivemjzyfkjlx.getId() == null){
				continue;
			}
			if (Ironfofivemjzyfkjlx.DEL_FLAG_NORMAL.equals(ironfofivemjzyfkjlx.getDelFlag())){
				if (StringUtils.isBlank(ironfofivemjzyfkjlx.getId())){
					ironfofivemjzyfkjlx.preInsert();
					ironfofivemjzyfkjlxDao.insert(ironfofivemjzyfkjlx);
				}else{
					ironfofivemjzyfkjlx.preUpdate();
					ironfofivemjzyfkjlxDao.update(ironfofivemjzyfkjlx);
				}
			}else{
				ironfofivemjzyfkjlxDao.delete(ironfofivemjzyfkjlx);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivemjzyf ironfofivemjzyf) {
		super.delete(ironfofivemjzyf);
		ironfofivemjzyfkjlxDao.delete(new Ironfofivemjzyfkjlx());
	}
	
	
}