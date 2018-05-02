/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzyjkreport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfoyjbylsbpzyjkreport.entity.Ironfo_yjbylsbpz_yjkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzyjkreport.dao.Ironfo_yjbylsbpz_yjkReportDao;

/**
 *  药剂科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class Ironfo_yjbylsbpz_yjkReportService extends CrudService<Ironfo_yjbylsbpz_yjkReportDao, Ironfo_yjbylsbpz_yjkReport> {

	public Ironfo_yjbylsbpz_yjkReport get(String id) {
		return super.get(id);
	}
	
	public List<Ironfo_yjbylsbpz_yjkReport> findList(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk) {
		return super.findList(ironfo_yjbylsbpz_yjk);
	}
	
	public Page<Ironfo_yjbylsbpz_yjkReport> findPage(Page<Ironfo_yjbylsbpz_yjkReport> page, Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk) {
		return super.findPage(page, ironfo_yjbylsbpz_yjk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk) {
		super.save(ironfo_yjbylsbpz_yjk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk) {
		super.delete(ironfo_yjbylsbpz_yjk);
	}
	
	
	
	
}