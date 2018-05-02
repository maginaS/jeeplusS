/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzxdgys.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpzxdgys.entity.Ironfoyjbylsbpzxdgys;

/**
 * 消毒供应室DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzxdgysDao extends CrudDao<Ironfoyjbylsbpzxdgys> {

	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys);
	
	
	public List<Ironfoyjbylsbpzxdgys> queryForList(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys);
	
	


	
}