/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationhardware.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;
import com.jeeplus.modules.ironfoinformationhardware.entity.Ironfoinformationhardware;

/**
 * 4.5信息化系统配套硬件DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoinformationhardwareDao extends CrudDao<Ironfoinformationhardware> {
	
	


	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoinformationhardware ironfoinformationexperience);
	
	
	public List<Ironfoinformationhardware> queryForList(Ironfoinformationhardware ironfoinformationexperience);


	
}