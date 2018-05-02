/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjgjk;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjgyygl;

/**
 * 4.2信息化系统功能实现DAO接口
 * @author mikesun
 * @version 2018-04-08
 */
@MyBatisDao
public interface IronfoinformationsxjgyyglDao extends CrudDao<Ironfoinformationsxjgyygl> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoinformationsxjgyygl ironfoinformationsxjgyygl);
	
	
	public List<Ironfoinformationsxjgyygl> queryForList(Ironfoinformationsxjgyygl ironfoinformationsxjgyygl);
	
	
	public void saveIronfo(Ironfoinformationsxjgyygl ironfoinformationsxjgyygl);

	
}