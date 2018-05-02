/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoconemp.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoconemp.entity.Ironfoconemp;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;

/**
 * 2.7.1职工构成DAO接口
 * @author mikesun
 * @version 2018-03-21
 */
@MyBatisDao
public interface IronfoconempDao extends CrudDao<Ironfoconemp> {
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoconemp ironfoconemp);
	
	
	public List<Ironfoconemp> queryForList(Ironfoconemp ironfoconemp);

	
}