/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivebfpz.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfofivebfpz.entity.Ironfofivebfpz;

/**
 * 5.3病房DAO接口
 * @author mikesun
 * @version 2018-04-08
 */
@MyBatisDao
public interface IronfofivebfpzDao extends CrudDao<Ironfofivebfpz> {

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivebfpz ironfofinance);
	
	
	public List<Ironfofivebfpz> queryForList(Ironfofivebfpz ironfofinance);


	
}