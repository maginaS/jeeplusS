/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbyy.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfojbyy.entity.Ironfojbyy;

/**
 * 2.6基本用药DAO接口
 * @author mikesun
 * @version 2018-03-21
 */
@MyBatisDao
public interface IronfojbyyDao extends CrudDao<Ironfojbyy> {
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfojbyy ironfojbyy);
	
	
	public List<Ironfojbyy> queryForList(Ironfojbyy ironfojbyy);

	
}