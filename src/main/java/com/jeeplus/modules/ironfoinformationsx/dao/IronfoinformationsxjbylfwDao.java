/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbggwsfw;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbylfw;

/**
 * 4.2信息化系统功能实现DAO接口
 * @author mikesun
 * @version 2018-04-08
 */
@MyBatisDao
public interface IronfoinformationsxjbylfwDao extends CrudDao<Ironfoinformationsxjbylfw> {
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoinformationsxjbylfw ironfoinformationsxjbylfw);
	
	
	public List<Ironfoinformationsxjbylfw> queryForList(Ironfoinformationsxjbylfw ironfoinformationsxjbylfw);
	
	
	public void saveIronfo(Ironfoinformationsxjbylfw ironfoinformationsxjbylfw) ;
	

	
}