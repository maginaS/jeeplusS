/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveggwsyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;

/**
 * 5.5公共卫生用房DAO接口
 * @author mikesun
 * @version 2018-04-15
 */
@MyBatisDao
public interface IronfofiveggwsyfDao extends CrudDao<Ironfofiveggwsyf> {
	
	public List<Ironfofiveggwsyf> queryForList(Ironfofiveggwsyf ironfofiveggwsyf);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiveggwsyf ironfofiveggwsyf);

	
}