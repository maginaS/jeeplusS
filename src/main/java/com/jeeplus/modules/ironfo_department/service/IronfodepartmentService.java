/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartment;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentDao;


import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentggwsbDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentjhsyb;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentjhsybDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentremark;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentremarkDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentyjb;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentyjbDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentznglb;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentznglbDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentzybDao;

/**
 * 2.4科室设置Service
 * @author mikesun
 * @version 2018-03-16
 */
@Service
@Transactional(readOnly = true)
public class IronfodepartmentService extends CrudService<IronfodepartmentDao, Ironfodepartment> {

	@Autowired
	private IronfodepartmentggwsbDao ironfodepartmentggwsbDao;
	@Autowired
	private IronfodepartmentjhsybDao ironfodepartmentjhsybDao;
	@Autowired
	private IronfodepartmentremarkDao ironfodepartmentremarkDao;
	@Autowired
	private IronfodepartmentyjbDao ironfodepartmentyjbDao;
	@Autowired
	private IronfodepartmentznglbDao ironfodepartmentznglbDao;
	@Autowired
	private IronfodepartmentzybDao ironfodepartmentzybDao;
	
	
	
	
	/**
	 * save
	 */
	
	@Transactional(readOnly = false)
	public void savezyb(Ironfodepartmentzyb ironfodepartmentzyb) {
		ironfodepartmentzybDao.save(ironfodepartmentzyb);
	}
	
	@Transactional(readOnly = false)
	public void saveznglb(Ironfodepartmentznglb ironfodepartmentznglb) {
		ironfodepartmentznglbDao.save(ironfodepartmentznglb);
	}
	
	@Transactional(readOnly = false)
	public void saveyjb(Ironfodepartmentyjb ironfodepartmentyjb) {
		ironfodepartmentyjbDao.save(ironfodepartmentyjb);
	}
	@Transactional(readOnly = false)
	public void saveremark(Ironfodepartmentremark ironfodepartmentremark) {
		ironfodepartmentremarkDao.save(ironfodepartmentremark);
	}
	
	@Transactional(readOnly = false)
	public void savejhsyb(Ironfodepartmentjhsyb ironfodepartmentjhsyb) {
		ironfodepartmentjhsybDao.save(ironfodepartmentjhsyb);
	}
	
	@Transactional(readOnly = false)
	public void saveggwsb(Ironfodepartmentggwsb ggwsb) {
		ironfodepartmentggwsbDao.savegg(ggwsb);
	}
	
	/**
	 * queryforlist
	 */
	
//	@Transactional(readOnly = false)
	public List<Ironfodepartmentzyb> queryForZyb(Ironfodepartmentzyb ironfodepartmentzyb){
		
		return ironfodepartmentzybDao.queryForList(ironfodepartmentzyb);
	}
	
//	@Transactional(readOnly = false)
	public List<Ironfodepartmentznglb> queryForZnglb(Ironfodepartmentznglb ironfodepartmentznglb){
		
		return ironfodepartmentznglbDao.queryForList(ironfodepartmentznglb);
	}
//	@Transactional(readOnly = false)
	public List<Ironfodepartmentyjb> queryForYjb(Ironfodepartmentyjb ironfodepartmentyjb){
		
		return ironfodepartmentyjbDao.queryForList(ironfodepartmentyjb);
	}
//	@Transactional(readOnly = false)
	public List<Ironfodepartmentremark> queryForRemark(Ironfodepartmentremark ironfodepartmentremark){
		
		return ironfodepartmentremarkDao.queryForList(ironfodepartmentremark);
	}
	
//	@Transactional(readOnly = false)
	public List<Ironfodepartmentjhsyb> queryForJhsyb(Ironfodepartmentjhsyb ironfodepartmentjhsyb){
		List<Ironfodepartmentjhsyb> jhsyb=ironfodepartmentjhsybDao.queryForList(ironfodepartmentjhsyb); 
		
		return jhsyb;
	}
	
	
//	@Transactional(readOnly = false)
	public List<Ironfodepartmentggwsb> queryForGgwsb(Ironfodepartmentggwsb ironfodepartmentggwsb){
		
		return ironfodepartmentggwsbDao.queryForList(ironfodepartmentggwsb);
	}
	
	
	
	/**
	 * 更新
	 * @param ironfodepartmentggwsb
	 */
	@Transactional(readOnly = false)
	public void updateggwsb(Ironfodepartmentggwsb ironfodepartmentggwsb) {
		ironfodepartmentggwsbDao.updateIronfo(ironfodepartmentggwsb);
	}
	
	@Transactional(readOnly = false)
	public void updatejhsyb(Ironfodepartmentjhsyb ironfodepartmentjhsyb) {
		ironfodepartmentjhsybDao.updateIronfo(ironfodepartmentjhsyb);
	}
	
	@Transactional(readOnly = false)
	public void updateyjb(Ironfodepartmentyjb ironfodepartmentyjb) {
		ironfodepartmentyjbDao.updateIronfo(ironfodepartmentyjb);
	}
	
	@Transactional(readOnly = false)
	public void updateznglb(Ironfodepartmentznglb ironfodepartmentznglb) {
		ironfodepartmentznglbDao.updateIronfo(ironfodepartmentznglb);
	}
	@Transactional(readOnly = false)
	public void updatezyb(Ironfodepartmentzyb ironfodepartmentzyb) {
		ironfodepartmentzybDao.updateIronfo(ironfodepartmentzyb);
	}
	@Transactional(readOnly = false)
	public void updateremark(Ironfodepartmentremark ironfodepartmentremark) {
		ironfodepartmentremarkDao.updateIronfo(ironfodepartmentremark);
	}
	
	public Ironfodepartment get(String id) {
		Ironfodepartment ironfodepartment = super.get(id);
//		ironfodepartment.setIronfodepartmentggwsbList(ironfodepartmentggwsbDao.findList(new Ironfodepartmentggwsb()));
//		ironfodepartment.setIronfodepartmentjhsybList(ironfodepartmentjhsybDao.findList(new Ironfodepartmentjhsyb()));
//		ironfodepartment.setIronfodepartmentremarkList(ironfodepartmentremarkDao.findList(new Ironfodepartmentremark()));
//		ironfodepartment.setIronfodepartmentyjbList(ironfodepartmentyjbDao.findList(new Ironfodepartmentyjb()));
//		ironfodepartment.setIronfodepartmentznglbList(ironfodepartmentznglbDao.findList(new Ironfodepartmentznglb()));
//		ironfodepartment.setIronfodepartmentzybList(ironfodepartmentzybDao.findList(new Ironfodepartmentzyb()));
		return ironfodepartment;
	}
	
	public List<Ironfodepartment> findList(Ironfodepartment ironfodepartment) {
		return super.findList(ironfodepartment);
	}
	
	public Page<Ironfodepartment> findPage(Page<Ironfodepartment> page, Ironfodepartment ironfodepartment) {
		return super.findPage(page, ironfodepartment);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfodepartment ironfodepartment) {
		super.save(ironfodepartment);
		for (Ironfodepartmentggwsb ironfodepartmentggwsb : ironfodepartment.getIronfodepartmentggwsbList()){
			if (ironfodepartmentggwsb.getId() == null){
				continue;
			}
			if (Ironfodepartmentggwsb.DEL_FLAG_NORMAL.equals(ironfodepartmentggwsb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentggwsb.getId())){
					ironfodepartmentggwsb.preInsert();
					ironfodepartmentggwsbDao.insert(ironfodepartmentggwsb);
				}else{
					ironfodepartmentggwsb.preUpdate();
					ironfodepartmentggwsbDao.update(ironfodepartmentggwsb);
				}
			}else{
				ironfodepartmentggwsbDao.delete(ironfodepartmentggwsb);
			}
		}
		for (Ironfodepartmentjhsyb ironfodepartmentjhsyb : ironfodepartment.getIronfodepartmentjhsybList()){
			if (ironfodepartmentjhsyb.getId() == null){
				continue;
			}
			if (Ironfodepartmentjhsyb.DEL_FLAG_NORMAL.equals(ironfodepartmentjhsyb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentjhsyb.getId())){
					ironfodepartmentjhsyb.preInsert();
					ironfodepartmentjhsybDao.insert(ironfodepartmentjhsyb);
				}else{
					ironfodepartmentjhsyb.preUpdate();
					ironfodepartmentjhsybDao.update(ironfodepartmentjhsyb);
				}
			}else{
				ironfodepartmentjhsybDao.delete(ironfodepartmentjhsyb);
			}
		}
		for (Ironfodepartmentremark ironfodepartmentremark : ironfodepartment.getIronfodepartmentremarkList()){
			if (ironfodepartmentremark.getId() == null){
				continue;
			}
			if (Ironfodepartmentremark.DEL_FLAG_NORMAL.equals(ironfodepartmentremark.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentremark.getId())){
					ironfodepartmentremark.preInsert();
					ironfodepartmentremarkDao.insert(ironfodepartmentremark);
				}else{
					ironfodepartmentremark.preUpdate();
					ironfodepartmentremarkDao.update(ironfodepartmentremark);
				}
			}else{
				ironfodepartmentremarkDao.delete(ironfodepartmentremark);
			}
		}
		for (Ironfodepartmentyjb ironfodepartmentyjb : ironfodepartment.getIronfodepartmentyjbList()){
			if (ironfodepartmentyjb.getId() == null){
				continue;
			}
			if (Ironfodepartmentyjb.DEL_FLAG_NORMAL.equals(ironfodepartmentyjb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentyjb.getId())){
					ironfodepartmentyjb.preInsert();
					ironfodepartmentyjbDao.insert(ironfodepartmentyjb);
				}else{
					ironfodepartmentyjb.preUpdate();
					ironfodepartmentyjbDao.update(ironfodepartmentyjb);
				}
			}else{
				ironfodepartmentyjbDao.delete(ironfodepartmentyjb);
			}
		}
		for (Ironfodepartmentznglb ironfodepartmentznglb : ironfodepartment.getIronfodepartmentznglbList()){
			if (ironfodepartmentznglb.getId() == null){
				continue;
			}
			if (Ironfodepartmentznglb.DEL_FLAG_NORMAL.equals(ironfodepartmentznglb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentznglb.getId())){
					ironfodepartmentznglb.preInsert();
					ironfodepartmentznglbDao.insert(ironfodepartmentznglb);
				}else{
					ironfodepartmentznglb.preUpdate();
					ironfodepartmentznglbDao.update(ironfodepartmentznglb);
				}
			}else{
				ironfodepartmentznglbDao.delete(ironfodepartmentznglb);
			}
		}
		for (Ironfodepartmentzyb ironfodepartmentzyb : ironfodepartment.getIronfodepartmentzybList()){
			if (ironfodepartmentzyb.getId() == null){
				continue;
			}
			if (Ironfodepartmentzyb.DEL_FLAG_NORMAL.equals(ironfodepartmentzyb.getDelFlag())){
				if (StringUtils.isBlank(ironfodepartmentzyb.getId())){
					ironfodepartmentzyb.preInsert();
					ironfodepartmentzybDao.insert(ironfodepartmentzyb);
				}else{
					ironfodepartmentzyb.preUpdate();
					ironfodepartmentzybDao.update(ironfodepartmentzyb);
				}
			}else{
				ironfodepartmentzybDao.delete(ironfodepartmentzyb);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfodepartment ironfodepartment) {
		super.delete(ironfodepartment);
		ironfodepartmentggwsbDao.delete(new Ironfodepartmentggwsb());
		ironfodepartmentjhsybDao.delete(new Ironfodepartmentjhsyb());
		ironfodepartmentremarkDao.delete(new Ironfodepartmentremark());
		ironfodepartmentyjbDao.delete(new Ironfodepartmentyjb());
		ironfodepartmentznglbDao.delete(new Ironfodepartmentznglb());
		ironfodepartmentzybDao.delete(new Ironfodepartmentzyb());
	}
	
	
}