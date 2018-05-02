/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzydjcn.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivegpszywwcl.entity.Ironfofivegpszywwcl;
import com.jeeplus.modules.ironfofiventzydjcn.entity.Ironfofiventzydjcn;

/**
 * 冬季采暖DAO接口
 * @author mikesun
 * @version 2018-04-16
 */
@MyBatisDao
public interface IronfofiventzydjcnDao extends CrudDao<Ironfofiventzydjcn> {
	
	public List<Ironfofiventzydjcn> queryForList(Ironfofiventzydjcn ironfofiventzydjcn);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiventzydjcn ironfofiventzydjcn);


	
}