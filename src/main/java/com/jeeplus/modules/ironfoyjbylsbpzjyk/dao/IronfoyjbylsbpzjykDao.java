/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzjyk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzjyk.entity.Ironfoyjbylsbpzjyk;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;

/**
 * 检验科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzjykDao extends CrudDao<Ironfoyjbylsbpzjyk> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk);
	
	
	public List<Ironfoyjbylsbpzjyk> queryForList(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk);


	
}