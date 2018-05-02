/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedqzygdfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfofivedqzygdfs.entity.Ironfofivedqzygdfs;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivedqzygdfs.dao.IronfofivedqzygdfsDao;

/**
 * 供电方式Service
 * @author mikesun
 * @version 2018-04-15
 */
@Service
@Transactional(readOnly = true)
public class IronfofivedqzygdfsService extends CrudService<IronfofivedqzygdfsDao, Ironfofivedqzygdfs> {

	
	@Autowired
	private IronfofivedqzygdfsDao dao;
	public Ironfofivedqzygdfs get(String id) {
		return super.get(id);
	}
	
	public List<Ironfofivedqzygdfs> findList(Ironfofivedqzygdfs ironfofivedqzygdfs) {
		return super.findList(ironfofivedqzygdfs);
	}
	
	public Page<Ironfofivedqzygdfs> findPage(Page<Ironfofivedqzygdfs> page, Ironfofivedqzygdfs ironfofivedqzygdfs) {
		return super.findPage(page, ironfofivedqzygdfs);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofivedqzygdfs ironfofivedqzygdfs) {
		super.save(ironfofivedqzygdfs);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofivedqzygdfs ironfofivedqzygdfs) {
		super.delete(ironfofivedqzygdfs);
	}
	
	

	/**
	 * 查询
	 * @param ironfofivemjzyfkjlx
	 * @return
	 */
	public List<Ironfofivedqzygdfs> queryForList(Ironfofivedqzygdfs ironfofivedqzygdfs){
		
		return dao.queryForList(ironfofivedqzygdfs);
	}
	
	@Transactional(readOnly = false)
	public void updateironfo(Ironfofivedqzygdfs ironfofivedqzygdfs) {
		dao.updateIronfo(ironfofivedqzygdfs);
	}
	
	
	
	
	
	
}