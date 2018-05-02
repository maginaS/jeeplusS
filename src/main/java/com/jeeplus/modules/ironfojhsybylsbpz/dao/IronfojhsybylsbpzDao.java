/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojhsybylsbpz.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfojhsybylsbpz.entity.Ironfojhsybylsbpz;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;

/**
 * 3.5计划生育部医疗设备配置DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfojhsybylsbpzDao extends CrudDao<Ironfojhsybylsbpz> {

	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfojhsybylsbpz ironfojhsybylsbpz);
	
	
	public List<Ironfojhsybylsbpz> queryForList(Ironfojhsybylsbpz ironfojhsybylsbpz);


	
}