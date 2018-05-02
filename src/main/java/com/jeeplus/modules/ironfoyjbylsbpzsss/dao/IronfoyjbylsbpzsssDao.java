/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzsss.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzsss.entity.Ironfoyjbylsbpzsss;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;

/**
 * 手术室DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzsssDao extends CrudDao<Ironfoyjbylsbpzsss> {
	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss);
	
	
	public List<Ironfoyjbylsbpzsss> queryForList(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss);

	


	
}