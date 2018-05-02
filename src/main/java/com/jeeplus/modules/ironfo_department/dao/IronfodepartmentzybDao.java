/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentjhsyb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;

/**
 * 2.4科室设置DAO接口
 * @author mikesun
 * @version 2018-03-16
 */
@MyBatisDao
public interface IronfodepartmentzybDao extends CrudDao<Ironfodepartmentzyb> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServicesi
	 */
	public void updateIronfo(Ironfodepartmentzyb ironfodepartmentzyb);
	
	
	public List<Ironfodepartmentzyb> queryForList(Ironfodepartmentzyb ironfodepartmentzyb);
	
	public void save(Ironfodepartmentzyb ironfodepartmentzyb);
	

	
}