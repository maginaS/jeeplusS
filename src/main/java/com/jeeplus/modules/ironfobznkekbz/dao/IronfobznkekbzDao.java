/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobznkekbz.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfobznkekbz.entity.Ironfobznkekbz;
import com.jeeplus.modules.ironfofivedtzydtsb.entity.Ironfofivedtzydtsb;

/**
 * 2.5内科、儿科病种DAO接口
 * @author mikesun
 * @version 2018-04-18
 */
@MyBatisDao
public interface IronfobznkekbzDao extends CrudDao<Ironfobznkekbz> {
	
	
	

	public List<Ironfobznkekbz> queryForList(Ironfobznkekbz ironfobznkekbz);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfobznkekbz ironfobznkekbz);



	
}