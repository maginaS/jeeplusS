/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationbuild.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoinformationbuild.entity.Ironfoinformationbuild;
import com.jeeplus.modules.ironfoqtkspz.entity.Ironfoqtkspz;

/**
 * 4.1信息化系统建设情况DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoinformationbuildDao extends CrudDao<Ironfoinformationbuild> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoinformationbuild ironfoinformationbuild);
	
	
	public List<Ironfoinformationbuild> queryForList(Ironfoinformationbuild ironfoinformationbuild);



	
}