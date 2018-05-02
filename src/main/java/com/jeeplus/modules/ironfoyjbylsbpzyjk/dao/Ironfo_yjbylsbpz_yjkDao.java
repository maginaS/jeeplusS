/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzyjk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;

/**
 *  药剂科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface Ironfo_yjbylsbpz_yjkDao extends CrudDao<Ironfo_yjbylsbpz_yjk> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk);
	
	
	public List<Ironfo_yjbylsbpz_yjk> queryForList(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk);



	
}