/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;

/**
 * 2.4科室设置DAO接口
 * @author mikesun
 * @version 2018-03-16
 */
@MyBatisDao
public interface IronfodepartmentggwsbDao extends CrudDao<Ironfodepartmentggwsb> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfodepartmentggwsb ironfodepartmentggwsb);
	
	
	public List<Ironfodepartmentggwsb> queryForList(Ironfodepartmentggwsb ironfodepartmentggwsb);
	
	
	public void savegg(Ironfodepartmentggwsb ironfodepartmentggwsb) ;
	

	
}