/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.sysrole.entity.SysRole;
import com.jeeplus.modules.sysrole.dao.SysRoleDao;

/**
 * 角色管理Service
 * @author mikesun
 * @version 2017-10-12
 */
@Service
@Transactional(readOnly = true)
public class SysRoleService extends CrudService<SysRoleDao, SysRole> {

	public SysRole get(String id) {
		return super.get(id);
	}
	
	public List<SysRole> findList(SysRole sysRole) {
		return super.findList(sysRole);
	}
	
	public Page<SysRole> findPage(Page<SysRole> page, SysRole sysRole) {
		return super.findPage(page, sysRole);
	}
	
	@Transactional(readOnly = false)
	public void save(SysRole sysRole) {
		super.save(sysRole);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysRole sysRole) {
		super.delete(sysRole);
	}
	
	
	
	
}