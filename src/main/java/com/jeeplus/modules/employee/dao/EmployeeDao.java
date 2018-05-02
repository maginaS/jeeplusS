/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.employee.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.employee.entity.Employee;

/**
 * 员工管理DAO接口
 * @author mikesun
 * @version 2017-10-12
 */
@MyBatisDao
public interface EmployeeDao extends CrudDao<Employee> {

	
}