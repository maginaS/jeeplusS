/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopublichealth.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfopublichealth.entity.Ironfopublichealth;

/**
 * 2.3基本公共卫生服务DAO接口
 * @author mikesun
 * @version 2018-03-16
 */
@MyBatisDao
public interface IronfopublichealthDao extends CrudDao<Ironfopublichealth> {
	
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfopublichealth ironfopublichealth);
	
	
	public List<Ironfopublichealth> queryForList(Ironfopublichealth ironfopublichealth);

	
}