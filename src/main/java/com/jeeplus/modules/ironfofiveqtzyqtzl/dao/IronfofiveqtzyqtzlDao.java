/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzyqtzl.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiveqtzyqtzl.entity.Ironfofiveqtzyqtzl;

/**
 * 气体种类DAO接口
 * @author mikesun
 * @version 2018-04-17
 */
@MyBatisDao
public interface IronfofiveqtzyqtzlDao extends CrudDao<Ironfofiveqtzyqtzl> {
	
	
	
	public List<Ironfofiveqtzyqtzl> queryForList(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl);


	

	
}