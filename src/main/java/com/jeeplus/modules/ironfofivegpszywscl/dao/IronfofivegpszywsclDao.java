/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszywscl.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;
import com.jeeplus.modules.ironfofivegpszywscl.entity.Ironfofivegpszywscl;

/**
 * 污水处理DAO接口
 * @author mikesun
 * @version 2018-04-16
 */
@MyBatisDao
public interface IronfofivegpszywsclDao extends CrudDao<Ironfofivegpszywscl> {
	
	
	
	
	public List<Ironfofivegpszywscl> queryForList(Ironfofivegpszywscl ironfofivegpszywscl);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivegpszywscl ironfofivegpszywscl);

	
}