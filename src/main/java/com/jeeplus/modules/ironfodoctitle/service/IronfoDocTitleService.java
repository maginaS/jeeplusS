/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfodoctitle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ironfodoctitle.dao.IronfoDocTitleDao;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
//import com.jeeplus.modules.ironfodoctitle.dao.IronfoDocTitleDao;

/**
 * 1.1乡镇卫生院基本概况Service
 * @author mikesun
 * @version 2018-03-15
 */
@Service
@Transactional(readOnly = true)
public class IronfoDocTitleService extends CrudService<IronfoDocTitleDao, IronfoDocTitle> {

	@Autowired
	private IronfoDocTitleDao ironfoDocTitleDao;
	
	
	public IronfoDocTitle get(String id) {
		return super.get(id);
	}
	
	
	public IronfoDocTitle getDocId(String remarks) {
		return ironfoDocTitleDao.getDocId(remarks);
	}
	
//	public List<IronfoDocTitle> queryForList(IronfoDocTitle ironfoDocTitle){
//		return null;
//		
//	}
	
	
	
	public List<IronfoDocTitle> findList(IronfoDocTitle ironfoDocTitle) {
		return super.findList(ironfoDocTitle);
	}
	
	
	public List<IronfoDocTitle> queryforList(IronfoDocTitle ironfoDocTitle) {
		return ironfoDocTitleDao.queryforList(ironfoDocTitle);
				//super.findList(ironfoDocTitle);
	}
	
	public Page<IronfoDocTitle> findPage(Page<IronfoDocTitle> page, IronfoDocTitle ironfoDocTitle) {
		return super.findPage(page, ironfoDocTitle);
	}
	
	@Transactional(readOnly = false)
	public void save(IronfoDocTitle ironfoDocTitle) {
		super.save(ironfoDocTitle);
	}
	
	@Transactional(readOnly = false)
	public void delete(IronfoDocTitle ironfoDocTitle) {
		super.delete(ironfoDocTitle);
	}
	
	


	@Transactional(readOnly = false)
	public void updateIronfo(IronfoDocTitle ironfoDocTitle) {
		//dao.update(ironfoDocTitle);
		ironfoDocTitleDao.updateIronfo(ironfoDocTitle);
	}
	
	
	public List<IronfoDocTitle> queryForList(IronfoDocTitle ironfoDocTitle){
		//return null;
		//return dao.queryforList(ironfoDocTitle);
//		return ironfoDocTitleDao.queryForList(ironfoDocTitle);
		return ironfoDocTitleDao.queryforList(ironfoDocTitle);
	}
	
	
	
		
}