/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzkfk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;

/**
 * 康复科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzkfkDao extends CrudDao<Ironfoyjbylsbpzkfk> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk);
	
	
	public List<Ironfoyjbylsbpzkfk> queryForList(Ironfoyjbylsbpzkfk ironfoyjbylsbpzkfk);


	
}