/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfomedicalservices.dao;

import java.util.List;
import java.util.Map;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;

/**
 * 2.1年度医疗服务量DAO接口
 * @author mikesun
 * @version 2018-03-13
 */
@MyBatisDao
public interface IronfoMedicalServicesDao extends CrudDao<IronfoMedicalServices> {
	
	
	public List<IronfoMedicalServices> queryForList(IronfoMedicalServices ironfoMedicalServices);
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(IronfoMedicalServices ironfoMedicalServices);
	
	
}