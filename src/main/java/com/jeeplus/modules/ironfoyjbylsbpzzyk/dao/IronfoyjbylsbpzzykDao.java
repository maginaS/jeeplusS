/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzzyk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzykebyhk.entity.Ironfoyjbylsbpzykebyhk;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.entity.Ironfoyjbylsbpzzyk;

/**
 * 中医科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzzykDao extends CrudDao<Ironfoyjbylsbpzzyk> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzzyk ironfoyjbylsbpzykebyhk);
	
	
	public List<Ironfoyjbylsbpzzyk> queryForList(Ironfoyjbylsbpzzyk ironfoyjbylsbpzykebyhk);



	
}