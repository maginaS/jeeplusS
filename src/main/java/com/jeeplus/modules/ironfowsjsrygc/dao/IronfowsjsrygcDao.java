/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfowsjsrygc.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfowsjsrygc.entity.Ironfowsjsrygc;

/**
 * 2.7.2卫生技术人员构成DAO接口
 * @author mikesun
 * @version 2018-03-21
 */
@MyBatisDao
public interface IronfowsjsrygcDao extends CrudDao<Ironfowsjsrygc> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfowsjsrygc ironfowsjsrygc);
	
	
	public List<Ironfowsjsrygc> queryForList(Ironfowsjsrygc ironfowsjsrygc);

	
}