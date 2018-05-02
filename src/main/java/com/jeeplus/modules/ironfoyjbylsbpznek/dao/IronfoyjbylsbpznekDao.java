/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpznek.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfoyjbylsbpznek.entity.Ironfoyjbylsbpznek;

/**
 * 内（儿）科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpznekDao extends CrudDao<Ironfoyjbylsbpznek> {
	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpznek ironfoyjbylsbpznek);
	
	
	public List<Ironfoyjbylsbpznek> queryForList(Ironfoyjbylsbpznek ironfoyjbylsbpznek);



	
}