/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivesssgl.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivebfpz.entity.Ironfofivebfpz;
import com.jeeplus.modules.ironfofivesssgl.entity.Ironfofivesssgl;

/**
 * 5.4手术室DAO接口
 * @author mikesun
 * @version 2018-04-08
 */
@MyBatisDao
public interface IronfofivesssglDao extends CrudDao<Ironfofivesssgl> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivesssgl ironfofivesssgl);
	
	
	public List<Ironfofivesssgl> queryForList(Ironfofivesssgl ironfofivesssgl);


	
}