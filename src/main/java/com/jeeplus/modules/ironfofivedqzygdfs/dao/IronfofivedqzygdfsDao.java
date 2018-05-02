/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedqzygdfs.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ironfofivedqzygdfs.entity.Ironfofivedqzygdfs;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;

/**
 * 供电方式DAO接口
 * @author mikesun
 * @version 2018-04-15
 */
@MyBatisDao
public interface IronfofivedqzygdfsDao extends CrudDao<Ironfofivedqzygdfs> {
	
	
	public List<Ironfofivedqzygdfs> queryForList(Ironfofivedqzygdfs ironfofivedqzygdfs);
	
	
	/**
	 * 更新
	 * @param ironfoMedicalServices
	 */
	public void updateIronfo(Ironfofivedqzygdfs ironfofivedqzygdfs);

	
}