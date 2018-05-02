/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszygssy.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivedqzygdfs.entity.Ironfofivedqzygdfs;
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;

/**
 * 给水水源DAO接口
 * @author mikesun
 * @version 2018-04-16
 */
@MyBatisDao
public interface IronfofivegpszygssyDao extends CrudDao<Ironfofivegpszygssy> {
	

	public List<Ironfofivegpszygssy> queryForList(Ironfofivegpszygssy ironfofivegpszygssy);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivegpszygssy ironfofivegpszygssy);


	
}