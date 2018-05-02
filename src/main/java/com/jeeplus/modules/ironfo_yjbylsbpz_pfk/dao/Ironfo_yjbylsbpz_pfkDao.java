/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_yjbylsbpz_pfk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.entity.Ironfoyjbylsbpzqkyxk;

/**
 * 皮肤科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface Ironfo_yjbylsbpz_pfkDao extends CrudDao<Ironfo_yjbylsbpz_pfk> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk);
	
	
	public List<Ironfo_yjbylsbpz_pfk> queryForList(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk);
	

	
}