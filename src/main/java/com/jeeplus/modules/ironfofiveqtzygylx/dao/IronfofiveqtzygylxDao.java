/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzygylx.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiveqtzygylx.entity.Ironfofiveqtzygylx;

/**
 * 供应类型DAO接口
 * @author mikesun
 * @version 2018-04-17
 */
@MyBatisDao
public interface IronfofiveqtzygylxDao extends CrudDao<Ironfofiveqtzygylx> {
	
	

	public List<Ironfofiveqtzygylx> queryForList(Ironfofiveqtzygylx ironfofiveqtzygylx);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofiveqtzygylx ironfofiveqtzygylx);



	
}