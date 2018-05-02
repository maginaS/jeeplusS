/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivejhsyyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivejhsyyf.entity.Ironfofivejhsyyf;

/**
 * 5.6计划生育用房DAO接口
 * @author mikesun
 * @version 2018-04-15
 */
@MyBatisDao
public interface IronfofivejhsyyfDao extends CrudDao<Ironfofivejhsyyf> {
	
	public List<Ironfofivejhsyyf> queryForList(Ironfofivejhsyyf ironfofivejhsyyf);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivejhsyyf ironfofivejhsyyf);

	

	
}