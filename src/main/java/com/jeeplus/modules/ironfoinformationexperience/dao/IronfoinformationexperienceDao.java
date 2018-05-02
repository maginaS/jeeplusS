/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationexperience.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;

/**
 * 4.3信息化系统使用体验DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoinformationexperienceDao extends CrudDao<Ironfoinformationexperience> {

	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoinformationexperience ironfoinformationexperience);
	
	
	public List<Ironfoinformationexperience> queryForList(Ironfoinformationexperience ironfoinformationexperience);

	
	
}