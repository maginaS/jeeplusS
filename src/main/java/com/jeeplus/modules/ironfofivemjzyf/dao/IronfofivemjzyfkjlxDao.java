/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivemjzyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyfkjlx;

/**
 * 5.2门急诊用房DAO接口
 * @author mikesun
 * @version 2018-04-13
 */
@MyBatisDao
public interface IronfofivemjzyfkjlxDao extends CrudDao<Ironfofivemjzyfkjlx> {
	
	public List<Ironfofivemjzyfkjlx> queryForList(Ironfofivemjzyfkjlx ironfofivemjzyfkjlx);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivemjzyfkjlx ironfofivemjzyfkjlx);
	
	public void saveIronfo(Ironfofivemjzyfkjlx ironfofivemjzyfkjlx);

	
}