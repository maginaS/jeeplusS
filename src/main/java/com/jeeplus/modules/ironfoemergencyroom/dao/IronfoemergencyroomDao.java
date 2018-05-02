/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoemergencyroom.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;

/**
 * 急诊室DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoemergencyroomDao extends CrudDao<Ironfoemergencyroom> {
	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoemergencyroom ironfoemergencyroom);
	
	
	public List<Ironfoemergencyroom> queryForList(Ironfoemergencyroom ironfoemergencyroom);

	
}