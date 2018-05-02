/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveznglyf.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofiveznglyf.entity.Ironfofiveznglyf;

/**
 * 5.7职能管理用房DAO接口
 * @author mikesun
 * @version 2018-04-15
 */
@MyBatisDao
public interface IronfofiveznglyfDao extends CrudDao<Ironfofiveznglyf> {
	
	public List<Ironfofiveznglyf> queryForList(Ironfofiveznglyf ironfofiveznglyf);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiveznglyf ironfofiveznglyf);


	
}