/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.organization.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.organization.entity.Organization;
import com.jeeplus.modules.organization.dao.OrganizationDao;

/**
 * 组织管理Service
 * @author 瞿高青
 * @version 2017-10-30
 */
@Service
@Transactional(readOnly = true)
public class OrganizationService extends CrudService<OrganizationDao, Organization> {

	public Organization get(String id) {
		return super.get(id);
	}
	
	public List<Organization> findList(Organization organization) {
		return super.findList(organization);
	}
	
	public Page<Organization> findPage(Page<Organization> page, Organization organization) {
		return super.findPage(page, organization);
	}
	
	@Transactional(readOnly = false)
	public void save(Organization organization) {
		super.save(organization);
	}
	
	@Transactional(readOnly = false)
	public void delete(Organization organization) {
		super.delete(organization);
	}
	
	
	
	
}