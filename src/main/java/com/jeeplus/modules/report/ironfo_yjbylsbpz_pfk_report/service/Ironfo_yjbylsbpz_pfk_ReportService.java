/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_yjbylsbpz_pfk_report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.report.ironfo_yjbylsbpz_pfk_report.entity.Ironfo_yjbylsbpz_pfk_Report;
import com.jeeplus.modules.report.ironfo_yjbylsbpz_pfk_report.dao.Ironfo_yjbylsbpz_pfk_ReportDao;

/**
 * 皮肤科Service
 * @author anti_magina
 * @version 2018-04-20
 */
@Service
@Transactional(readOnly = true)
public class Ironfo_yjbylsbpz_pfk_ReportService extends CrudService<Ironfo_yjbylsbpz_pfk_ReportDao, Ironfo_yjbylsbpz_pfk_Report> {

	public Ironfo_yjbylsbpz_pfk_Report get(String id) {
		return super.get(id);
	}
	
	public List<Ironfo_yjbylsbpz_pfk_Report> findList(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk) {
		return super.findList(ironfo_yjbylsbpz_pfk);
	}
	
	public Page<Ironfo_yjbylsbpz_pfk_Report> findPage(Page<Ironfo_yjbylsbpz_pfk_Report> page, Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk) {
		return super.findPage(page, ironfo_yjbylsbpz_pfk);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk) {
		super.save(ironfo_yjbylsbpz_pfk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk) {
		super.delete(ironfo_yjbylsbpz_pfk);
	}
	
	
	
	
}