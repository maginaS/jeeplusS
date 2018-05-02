/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoqtkspz.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfojhsybylsbpz.entity.Ironfojhsybylsbpz;
import com.jeeplus.modules.ironfoqtkspz.entity.Ironfoqtkspz;

/**
 * 3.6其他科室医疗设备配置DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoqtkspzDao extends CrudDao<Ironfoqtkspz> {
	

	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoqtkspz ironfoqtkspz);
	
	
	public List<Ironfoqtkspz> queryForList(Ironfoqtkspz ironfoqtkspz);


	
}