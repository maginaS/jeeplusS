/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveyjyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyfkjlx;
import com.jeeplus.modules.ironfofiveyjyf.entity.Ironfofiveyjyf;

/**
 * 5.3医技用房DAO接口
 * @author mikesun
 * @version 2018-04-14
 */
@MyBatisDao
public interface IronfofiveyjyfDao extends CrudDao<Ironfofiveyjyf> {
	
	public List<Ironfofiveyjyf> queryForList(Ironfofiveyjyf ironfofiveyjyf);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiveyjyf ironfofiveyjyf);

	
}