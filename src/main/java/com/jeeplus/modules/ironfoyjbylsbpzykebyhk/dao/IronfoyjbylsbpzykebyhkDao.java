/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzykebyhk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpzykebyhk.entity.Ironfoyjbylsbpzykebyhk;

/**
 * 眼科、耳鼻咽喉科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzykebyhkDao extends CrudDao<Ironfoyjbylsbpzykebyhk> {
	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk);
	
	
	public List<Ironfoyjbylsbpzykebyhk> queryForList(Ironfoyjbylsbpzykebyhk ironfoyjbylsbpzykebyhk);



	
}