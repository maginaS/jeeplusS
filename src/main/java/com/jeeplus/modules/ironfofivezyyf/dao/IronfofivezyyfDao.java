/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezyyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiveyjyf.entity.Ironfofiveyjyf;
import com.jeeplus.modules.ironfofivezyyf.entity.Ironfofivezyyf;

/**
 * 5.4住院用房DAO接口
 * @author mikesun
 * @version 2018-04-14
 */
@MyBatisDao
public interface IronfofivezyyfDao extends CrudDao<Ironfofivezyyf> {
	
public List<Ironfofivezyyf> queryForList(Ironfofivezyyf ironfofivezyyf);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivezyyf ironfofivezyyf);

	
}