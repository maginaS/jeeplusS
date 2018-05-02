/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulation.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoinformationhardware.entity.Ironfoinformationhardware;
import com.jeeplus.modules.ironfopopulation.entity.Ironfopopulation;

/**
 * 5.1.1建筑总体概况DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfopopulationDao extends CrudDao<Ironfopopulation> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfopopulation ironfopopulation);
	
	
	public List<Ironfopopulation> queryForList(Ironfopopulation ironfopopulation);

	
}