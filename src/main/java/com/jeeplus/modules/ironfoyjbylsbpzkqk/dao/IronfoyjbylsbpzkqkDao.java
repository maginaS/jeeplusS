/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzkqk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;

/**
 * 口腔科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzkqkDao extends CrudDao<Ironfoyjbylsbpzkqk> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk);
	
	
	public List<Ironfoyjbylsbpzkqk> queryForList(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk);

	

	
}