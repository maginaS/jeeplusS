/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszywwcl.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivegpszywscl.entity.Ironfofivegpszywscl;
import com.jeeplus.modules.ironfofivegpszywwcl.entity.Ironfofivegpszywwcl;

/**
 * 污物处理DAO接口
 * @author mikesun
 * @version 2018-04-16
 */
@MyBatisDao
public interface IronfofivegpszywwclDao extends CrudDao<Ironfofivegpszywwcl> {
	
	

	
	public List<Ironfofivegpszywwcl> queryForList(Ironfofivegpszywwcl ironfofivegpszywwcl);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivegpszywwcl ironfofivegpszywwcl);

	
	
	


	
}