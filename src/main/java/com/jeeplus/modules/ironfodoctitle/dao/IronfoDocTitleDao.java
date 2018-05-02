/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfodoctitle.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;

/**
 * 1.1乡镇卫生院基本概况DAO接口
 * @author mikesun
 * @version 2018-03-15
 */
@MyBatisDao
public interface IronfoDocTitleDao extends CrudDao<IronfoDocTitle> {
	
	

	
	public String insertid(IronfoDocTitle ironfoDocTitle);
	
	
	public IronfoDocTitle  getDocId(String remarks);
	
	public void  updateIronfo(IronfoDocTitle ironfoDocTitle);
	
	
	public List<IronfoDocTitle>  queryforList(IronfoDocTitle ironfoDocTitle);

	
}