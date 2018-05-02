/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.entity.Ironfoyjbylsbpzgrxjbk;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;

/**
 * 感染性疾病科DAO接口
 * @author mikesun
 * @version 2018-03-22
 */
@MyBatisDao
public interface IronfoyjbylsbpzgrxjbkDao extends CrudDao<Ironfoyjbylsbpzgrxjbk> {
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk);
	
	
	public List<Ironfoyjbylsbpzgrxjbk> queryForList(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk);

	
}