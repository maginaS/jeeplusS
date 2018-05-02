/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedtzydtsb.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivedtzydtsb.entity.Ironfofivedtzydtsb;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;

/**
 * 电梯设备DAO接口
 * @author mikesun
 * @version 2018-04-17
 */
@MyBatisDao
public interface IronfofivedtzydtsbDao extends CrudDao<Ironfofivedtzydtsb> {
	
	public List<Ironfofivedtzydtsb> queryForList(Ironfofivedtzydtsb ironfofivedtzydtsb);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivedtzydtsb ironfofivedtzydtsb);



	
}