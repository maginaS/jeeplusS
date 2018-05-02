/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpznek.entity.Ironfoyjbylsbpznek;

/**
 * 放射科、超声科、心电图科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzfskcskxdtkDao extends CrudDao<Ironfoyjbylsbpzfskcskxdtk> {
	


	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpznek);
	
	
	public List<Ironfoyjbylsbpzfskcskxdtk> queryForList(Ironfoyjbylsbpzfskcskxdtk ironfoyjbylsbpznek);



	
}