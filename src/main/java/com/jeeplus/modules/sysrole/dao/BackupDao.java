/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.sysrole.entity.Backup;

/**
 * 数据库管理DAO接口
 * @author 瞿高青
 * @version 2017-10-18
 */
@MyBatisDao
public interface BackupDao extends CrudDao<Backup> {

	
}