/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivefjpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.ironfofivefjpz.entity.Ironfofivefjpz;
import com.jeeplus.modules.ironfofivefjpz.dao.IronfofivefjpzDao;


import com.jeeplus.modules.ironfofivefjpz.entity.Ironfofivefjlx;
import com.jeeplus.modules.ironfofivefjpz.dao.IronfofivefjlxDao;

/**
 * 5.2房间配置Service
 * @author mikesun
 * @version 2018-03-23
 */
@Service
@Transactional(readOnly = true)
public class IronfofivefjpzService extends CrudService<IronfofivefjpzDao, Ironfofivefjpz> {

	@Autowired
	private IronfofivefjlxDao ironfofivefjlxDao;
	
	public Ironfofivefjpz get(String id) {
		Ironfofivefjpz ironfofivefjpz = super.get(id);
		ironfofivefjpz.setIronfofivefjlxList(ironfofivefjlxDao.findList(new Ironfofivefjlx()));
		return ironfofivefjpz;
	}
	
	public List<Ironfofivefjpz> findList(Ironfofivefjpz ironfofivefjpz) {
		return super.findList(ironfofivefjpz);
	}
	
	public Page<Ironfofivefjpz> findPage(Page<Ironfofivefjpz> page, Ironfofivefjpz ironfofivefjpz) {
		return super.findPage(page, ironfofivefjpz);
	}
	
//	public static void main(String[] args) {
//		Ironfofivefjpz z = new Ironfofivefjpz();
//		z.setDelFlag("0");
//		IronfofivefjpzService s = new IronfofivefjpzService();
//		List<Ironfofivefjpz> sz  = s.findList(z);
////		List<Ironfofivefjpz> sz = (List<Ironfofivefjpz>) s.findPage(new Page<Ironfofivefjpz>(request, response), z);
//		System.out.println("sz--------->"+sz.size());
//		
//		
//	}
	
	
	
	@Transactional(readOnly = false)
	public void save(Ironfofivefjpz ironfofivefjpz) {
		super.save(ironfofivefjpz);
		for (Ironfofivefjlx ironfofivefjlx : ironfofivefjpz.getIronfofivefjlxList()){
			if (ironfofivefjlx.getId() == null){
				continue;
			}
			if (Ironfofivefjlx.DEL_FLAG_NORMAL.equals(ironfofivefjlx.getDelFlag())){
				if (StringUtils.isBlank(ironfofivefjlx.getId())){
					ironfofivefjlx.preInsert();
					ironfofivefjlxDao.insert(ironfofivefjlx);
				}else{
					ironfofivefjlx.preUpdate();
					ironfofivefjlxDao.update(ironfofivefjlx);
				}
			}else{
				ironfofivefjlxDao.delete(ironfofivefjlx);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivefjpz ironfofivefjpz) {
		super.delete(ironfofivefjpz);
		ironfofivefjlxDao.delete(new Ironfofivefjlx());
	}
	
	
}