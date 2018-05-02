/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzyxjzl.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiventzydjcn.entity.Ironfofiventzydjcn;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;

/**
 * 夏季制冷DAO接口
 * @author mikesun
 * @version 2018-04-17
 */
@MyBatisDao
public interface IronfofiventzyxjzlDao extends CrudDao<Ironfofiventzyxjzl> {
	
public List<Ironfofiventzyxjzl> queryForList(Ironfofiventzyxjzl ironfofiventzyxjzl);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiventzyxjzl ironfofiventzyxjzl);


	

	
}