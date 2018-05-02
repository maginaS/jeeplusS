/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.sysrole.entity.FeatureList;
import com.jeeplus.modules.sysrole.dao.FeatureListDao;

/**
 * 角色管理Service
 * @author 瞿高青
 * @version 2017-11-02
 */
@Service
@Transactional(readOnly = true)
public class FeatureListService extends CrudService<FeatureListDao, FeatureList> {

	public FeatureList get(String id) {
		return super.get(id);
	}
	
	public List<FeatureList> findList(FeatureList featureList) {
		return super.findList(featureList);
	}
	
	public Page<FeatureList> findPage(Page<FeatureList> page, FeatureList featureList) {
		return super.findPage(page, featureList);
	}
	
	@Transactional(readOnly = false)
	public void save(FeatureList featureList) {
		super.save(featureList);
	}
	
	@Transactional(readOnly = false)
	public void delete(FeatureList featureList) {
		super.delete(featureList);
	}
	
	
	
	
}