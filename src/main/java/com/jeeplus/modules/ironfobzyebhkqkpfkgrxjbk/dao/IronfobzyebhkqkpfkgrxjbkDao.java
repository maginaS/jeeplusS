/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfobzwkfck.entity.Ironfobzwkfck;
import com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.entity.Ironfobzyebhkqkpfkgrxjbk;

/**
 * 2.7其它临床科室病种DAO接口
 * @author mikesun
 * @version 2018-04-21
 */
@MyBatisDao
public interface IronfobzyebhkqkpfkgrxjbkDao extends CrudDao<Ironfobzyebhkqkpfkgrxjbk> {
	
	

	public List<Ironfobzyebhkqkpfkgrxjbk> queryForList(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk);




	
}