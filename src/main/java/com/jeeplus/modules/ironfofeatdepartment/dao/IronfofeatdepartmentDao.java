/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofeatdepartment.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfofeatdepartment.entity.Ironfofeatdepartment;

/**
 * 2.4.1特色科室DAO接口
 * @author mikesun
 * @version 2018-03-16
 */
@MyBatisDao
public interface IronfofeatdepartmentDao extends CrudDao<Ironfofeatdepartment> {
	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofeatdepartment ironfofeatdepartment);
	
	
	public List<Ironfofeatdepartment> queryForList(Ironfofeatdepartment ironfofeatdepartment);
	

	
}