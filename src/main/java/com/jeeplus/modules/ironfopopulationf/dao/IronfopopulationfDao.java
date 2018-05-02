/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulationf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfopopulation.entity.Ironfopopulation;
import com.jeeplus.modules.ironfopopulationf.entity.Ironfopopulationf;

/**
 * 5.1.2建筑分布概况DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfopopulationfDao extends CrudDao<Ironfopopulationf> {
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfopopulationf ironfopopulationf);
	
	
	public List<Ironfopopulationf> queryForList(Ironfopopulationf ironfopopulationf);


	
}