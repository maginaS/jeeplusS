/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveswcd.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofiveswcd.entity.Ironfofiveswcd;

/**
 * 5.9室外场地DAO接口
 * @author mikesun
 * @version 2018-04-15
 */
@MyBatisDao
public interface IronfofiveswcdDao extends CrudDao<Ironfofiveswcd> {
	
	
	
	public List<Ironfofiveswcd> queryForList(Ironfofiveswcd ironfofiveswcd);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiveswcd ironfofiveswcd);


	
}