/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.sysrole.entity.Backup;
import com.jeeplus.modules.sysrole.dao.BackupDao;

/**
 * 数据库管理Service
 * @author 瞿高青
 * @version 2017-10-18
 */
@Service
@Transactional(readOnly = true)
public class BackupService extends CrudService<BackupDao, Backup> {

	public Backup get(String id) {
		return super.get(id);
	}
	
	public List<Backup> findList(Backup backup) {
		return super.findList(backup);
	}
	
	public Page<Backup> findPage(Page<Backup> page, Backup backup) {
		return super.findPage(page, backup);
	}
	
	@Transactional(readOnly = false)
	public void save(Backup backup) {
		super.save(backup);
	}
	
	@Transactional(readOnly = false)
	public void delete(Backup backup) {
		super.delete(backup);
	}
	
	
	
	
}