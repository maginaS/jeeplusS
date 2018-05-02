/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoggwsylsbpz.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoggwsylsbpz.entity.Ironfoggwsylsbpz;
import com.jeeplus.modules.ironfozyb.entity.Ironfozyb;

/**
 * 3.4公共卫生部医疗设备配置DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoggwsylsbpzDao extends CrudDao<Ironfoggwsylsbpz> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoggwsylsbpz ironfoyjbylsbpzkfk);
	
	
	public List<Ironfoggwsylsbpz> queryForList(Ironfoggwsylsbpz ironfoyjbylsbpzkfk);

	
}