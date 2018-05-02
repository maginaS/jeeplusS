/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzwkfck.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfobznkekbz.entity.Ironfobznkekbz;
import com.jeeplus.modules.ironfobzwkfck.entity.Ironfobzwkfck;

/**
 * 2.6外科、妇（产）科病种	DAO接口
 * @author mikesun
 * @version 2018-04-21
 */
@MyBatisDao
public interface IronfobzwkfckDao extends CrudDao<Ironfobzwkfck> {
	


	public List<Ironfobzwkfck> queryForList(Ironfobzwkfck ironfobzwkfck);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfobzwkfck ironfobzwkfck);



	

	
}