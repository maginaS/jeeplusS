/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezgshyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivezgshyf.entity.Ironfofivezgshyf;

/**
 * 5.8职工生活用房DAO接口
 * @author mikesun
 * @version 2018-04-15
 */
@MyBatisDao
public interface IronfofivezgshyfDao extends CrudDao<Ironfofivezgshyf> {
	
	public List<Ironfofivezgshyf> queryForList(Ironfofivezgshyf ironfofivezgshyf);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivezgshyf ironfofivezgshyf);


	
}