/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.organization.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.organization.entity.Organization;

/**
 * 组织管理DAO接口
 * @author 瞿高青
 * @version 2017-10-30
 */
@MyBatisDao
public interface OrganizationDao extends CrudDao<Organization> {

	
}