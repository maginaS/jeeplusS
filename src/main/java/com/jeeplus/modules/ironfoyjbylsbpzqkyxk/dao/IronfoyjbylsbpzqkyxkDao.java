/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzqkyxk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.entity.Ironfoyjbylsbpzqkyxk;

/**
 * 全科医学科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzqkyxkDao extends CrudDao<Ironfoyjbylsbpzqkyxk> {
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk);
	
	
	public List<Ironfoyjbylsbpzqkyxk> queryForList(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk);
	
}