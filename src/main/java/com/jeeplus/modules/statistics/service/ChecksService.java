/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.statistics.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.statistics.entity.Checks;
import com.jeeplus.modules.statistics.dao.ChecksDao;

/**
 * 销售统计Service
 * @author 瞿高青
 * @version 2017-10-17
 */
@Service
@Transactional(readOnly = true)
public class ChecksService extends CrudService<ChecksDao, Checks> {

	public Checks get(String id) {
		return super.get(id);
	}
	
	public List<Checks> findList(Checks checks) {
		return super.findList(checks);
	}
	
	public Page<Checks> findPage(Page<Checks> page, Checks checks) {
		return super.findPage(page, checks);
	}
	
	@Transactional(readOnly = false)
	public void save(Checks checks) {
		super.save(checks);
	}
	
	@Transactional(readOnly = false)
	public void delete(Checks checks) {
		super.delete(checks);
	}
	
	
	
	
}