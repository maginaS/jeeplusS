/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfozyb.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfozyb.entity.Ironfozyb;

/**
 * 3.3住院部医疗设备配置DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfozybDao extends CrudDao<Ironfozyb> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfozyb ironfoyjbylsbpzkfk);
	
	
	public List<Ironfozyb> queryForList(Ironfozyb ironfoyjbylsbpzkfk);


	
}