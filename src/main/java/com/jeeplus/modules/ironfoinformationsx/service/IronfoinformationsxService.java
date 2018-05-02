/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsx;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentjhsyb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentremark;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentyjb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentznglb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxDao;


import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbggwsfw;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjbggwsfwDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbylfw;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjbylfwDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjgjk;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjgjkDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjgyygl;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjgyyglDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjkdagl;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjkdaglDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjkxxfw;
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjkxxfwDao;

/**
 * 4.2信息化系统功能实现Service
 * @author mikesun
 * @version 2018-04-08
 */
@Service
@Transactional(readOnly = true)
public class IronfoinformationsxService extends CrudService<IronfoinformationsxDao, Ironfoinformationsx> {

	@Autowired
	private IronfoinformationsxjbggwsfwDao ironfoinformationsxjbggwsfwDao;
	@Autowired
	private IronfoinformationsxjbylfwDao ironfoinformationsxjbylfwDao;
	@Autowired
	private IronfoinformationsxjgjkDao ironfoinformationsxjgjkDao;
	@Autowired
	private IronfoinformationsxjgyyglDao ironfoinformationsxjgyyglDao;
	@Autowired
	private IronfoinformationsxjkdaglDao ironfoinformationsxjkdaglDao;
	@Autowired
	private IronfoinformationsxjkxxfwDao ironfoinformationsxjkxxfwDao;
	
	
	
	
	/**
	 * 更新
	 * @param ironfodepartmentggwsb
	 */
	@Transactional(readOnly = false)
	public void updatejbggwsfw(Ironfoinformationsxjbggwsfw ironfoinformationsxjbggwsfw) {
		ironfoinformationsxjbggwsfwDao.updateIronfo(ironfoinformationsxjbggwsfw);
	}
	
	@Transactional(readOnly = false)
	public void updatejbylfw(Ironfoinformationsxjbylfw ironfoinformationsxjbylfw) {
		ironfoinformationsxjbylfwDao.updateIronfo(ironfoinformationsxjbylfw);
	}
	
	@Transactional(readOnly = false)
	public void updatejgjk(Ironfoinformationsxjgjk ironfoinformationsxjgjk) {
		ironfoinformationsxjgjkDao.updateIronfo(ironfoinformationsxjgjk);
	}
	
	@Transactional(readOnly = false)
	public void updatejgyygl(Ironfoinformationsxjgyygl ironfoinformationsxjgyygl) {
		ironfoinformationsxjgyyglDao.updateIronfo(ironfoinformationsxjgyygl);
	}
	@Transactional(readOnly = false)
	public void updatejkdagl(Ironfoinformationsxjkdagl ironfoinformationsxjkdagl) {
		ironfoinformationsxjkdaglDao.updateIronfo(ironfoinformationsxjkdagl);
	}
	@Transactional(readOnly = false)
	public void updatejkxxfw(Ironfoinformationsxjkxxfw ironfoinformationsxjkxxfw) {
		ironfoinformationsxjkxxfwDao.updateIronfo(ironfoinformationsxjkxxfw);
	}
	
	
	/**
	 * queryforlist
	 */
	
	
//	@Transactional(readOnly = false)
	public List<Ironfoinformationsxjkxxfw> queryForGgwsb(Ironfoinformationsxjkxxfw ironfoinformationsxjkxxfw){
		
		return ironfoinformationsxjkxxfwDao.queryForList(ironfoinformationsxjkxxfw);
	}
	
	
//	@Transactional(readOnly = false)
	public List<Ironfoinformationsxjkdagl> queryForjkdagl(Ironfoinformationsxjkdagl ironfoinformationsxjkdagl){
		
		
		return ironfoinformationsxjkdaglDao.queryForList(ironfoinformationsxjkdagl);
		
		 
	}
	

//	@Transactional(readOnly = false)
	public List<Ironfoinformationsxjgyygl> queryForjgyygl(Ironfoinformationsxjgyygl ironfoinformationsxjgyygl){
		
		return ironfoinformationsxjgyyglDao.queryForList(ironfoinformationsxjgyygl);
	}
	

	

	public List<Ironfoinformationsxjbggwsfw> queryForjbggwsfw(Ironfoinformationsxjbggwsfw ironfoinformationsxjbggwsfw){
		
		return ironfoinformationsxjbggwsfwDao.queryForList(ironfoinformationsxjbggwsfw);
	}
	
//	@Transactional(readOnly = false)
	public List<Ironfoinformationsxjbylfw> queryForjbylfw(Ironfoinformationsxjbylfw ironfoinformationsxjbylfw){
		
		return ironfoinformationsxjbylfwDao.queryForList(ironfoinformationsxjbylfw);
	}
//	@Transactional(readOnly = false)
	public List<Ironfoinformationsxjgjk> queryForjgjk(Ironfoinformationsxjgjk ironfoinformationsxjgjk){
		
		return ironfoinformationsxjgjkDao.queryForList(ironfoinformationsxjgjk);
	}

	
	
	
	

	/**
	 * save
	 */
	
	@Transactional(readOnly = false)
	public void savejbggwsfw(Ironfoinformationsxjbggwsfw ironfoinformationsxjbggwsfw) {
		ironfoinformationsxjbggwsfwDao.savesxjbggwsfw(ironfoinformationsxjbggwsfw);
	}
	
	@Transactional(readOnly = false)
	public void savejbylfw(Ironfoinformationsxjbylfw ironfoinformationsxjbylfw) {
		ironfoinformationsxjbylfwDao.saveIronfo(ironfoinformationsxjbylfw);
	}
	
	@Transactional(readOnly = false)
	public void savejgjk(Ironfoinformationsxjgjk ironfoinformationsxjgjk) {
		ironfoinformationsxjgjkDao.saveIronfo(ironfoinformationsxjgjk);
	}
	@Transactional(readOnly = false)
	public void savejgyygl(Ironfoinformationsxjgyygl ironfoinformationsxjgyygl) {
		ironfoinformationsxjgyyglDao.saveIronfo(ironfoinformationsxjgyygl);
	}
	
	@Transactional(readOnly = false)
	public void savejkdagl(Ironfoinformationsxjkdagl ironfoinformationsxjkdagl) {
		ironfoinformationsxjkdaglDao.saveIronfo(ironfoinformationsxjkdagl);
	}
	
	@Transactional(readOnly = false)
	public void savejkxxfw(Ironfoinformationsxjkxxfw ironfoinformationsxjkxxfw) {
		ironfoinformationsxjkxxfwDao.saveIronfo(ironfoinformationsxjkxxfw);
	}
	
	
	
	
	
	
	
	
	public Ironfoinformationsx get(String id) {
		Ironfoinformationsx ironfoinformationsx = super.get(id);
//		ironfoinformationsx.setIronfoinformationsxjbggwsfwList(ironfoinformationsxjbggwsfwDao.findList(new Ironfoinformationsxjbggwsfw()));
//		ironfoinformationsx.setIronfoinformationsxjbylfwList(ironfoinformationsxjbylfwDao.findList(new Ironfoinformationsxjbylfw()));
//		ironfoinformationsx.setIronfoinformationsxjgjkList(ironfoinformationsxjgjkDao.findList(new Ironfoinformationsxjgjk()));
//		ironfoinformationsx.setIronfoinformationsxjgyyglList(ironfoinformationsxjgyyglDao.findList(new Ironfoinformationsxjgyygl()));
//		ironfoinformationsx.setIronfoinformationsxjkdaglList(ironfoinformationsxjkdaglDao.findList(new Ironfoinformationsxjkdagl()));
//		ironfoinformationsx.setIronfoinformationsxjkxxfwList(ironfoinformationsxjkxxfwDao.findList(new Ironfoinformationsxjkxxfw()));
		return ironfoinformationsx;
	}
	
	public List<Ironfoinformationsx> findList(Ironfoinformationsx ironfoinformationsx) {
		return super.findList(ironfoinformationsx);
	}
	
	public Page<Ironfoinformationsx> findPage(Page<Ironfoinformationsx> page, Ironfoinformationsx ironfoinformationsx) {
		return super.findPage(page, ironfoinformationsx);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfoinformationsx ironfoinformationsx) {
		super.save(ironfoinformationsx);
		for (Ironfoinformationsxjbggwsfw ironfoinformationsxjbggwsfw : ironfoinformationsx.getIronfoinformationsxjbggwsfwList()){
			if (ironfoinformationsxjbggwsfw.getId() == null){
				continue;
			}
			if (Ironfoinformationsxjbggwsfw.DEL_FLAG_NORMAL.equals(ironfoinformationsxjbggwsfw.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjbggwsfw.getId())){
					ironfoinformationsxjbggwsfw.preInsert();
					ironfoinformationsxjbggwsfwDao.insert(ironfoinformationsxjbggwsfw);
				}else{
					ironfoinformationsxjbggwsfw.preUpdate();
					ironfoinformationsxjbggwsfwDao.update(ironfoinformationsxjbggwsfw);
				}
			}else{
				ironfoinformationsxjbggwsfwDao.delete(ironfoinformationsxjbggwsfw);
			}
		}
		for (Ironfoinformationsxjbylfw ironfoinformationsxjbylfw : ironfoinformationsx.getIronfoinformationsxjbylfwList()){
			if (ironfoinformationsxjbylfw.getId() == null){
				continue;
			}
			if (Ironfoinformationsxjbylfw.DEL_FLAG_NORMAL.equals(ironfoinformationsxjbylfw.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjbylfw.getId())){
					ironfoinformationsxjbylfw.preInsert();
					ironfoinformationsxjbylfwDao.insert(ironfoinformationsxjbylfw);
				}else{
					ironfoinformationsxjbylfw.preUpdate();
					ironfoinformationsxjbylfwDao.update(ironfoinformationsxjbylfw);
				}
			}else{
				ironfoinformationsxjbylfwDao.delete(ironfoinformationsxjbylfw);
			}
		}
		for (Ironfoinformationsxjgjk ironfoinformationsxjgjk : ironfoinformationsx.getIronfoinformationsxjgjkList()){
			if (ironfoinformationsxjgjk.getId() == null){
				continue;
			}
			if (Ironfoinformationsxjgjk.DEL_FLAG_NORMAL.equals(ironfoinformationsxjgjk.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjgjk.getId())){
					ironfoinformationsxjgjk.preInsert();
					ironfoinformationsxjgjkDao.insert(ironfoinformationsxjgjk);
				}else{
					ironfoinformationsxjgjk.preUpdate();
					ironfoinformationsxjgjkDao.update(ironfoinformationsxjgjk);
				}
			}else{
				ironfoinformationsxjgjkDao.delete(ironfoinformationsxjgjk);
			}
		}
		for (Ironfoinformationsxjgyygl ironfoinformationsxjgyygl : ironfoinformationsx.getIronfoinformationsxjgyyglList()){
			if (ironfoinformationsxjgyygl.getId() == null){
				continue;
			}
			if (Ironfoinformationsxjgyygl.DEL_FLAG_NORMAL.equals(ironfoinformationsxjgyygl.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjgyygl.getId())){
					ironfoinformationsxjgyygl.preInsert();
					ironfoinformationsxjgyyglDao.insert(ironfoinformationsxjgyygl);
				}else{
					ironfoinformationsxjgyygl.preUpdate();
					ironfoinformationsxjgyyglDao.update(ironfoinformationsxjgyygl);
				}
			}else{
				ironfoinformationsxjgyyglDao.delete(ironfoinformationsxjgyygl);
			}
		}
		for (Ironfoinformationsxjkdagl ironfoinformationsxjkdagl : ironfoinformationsx.getIronfoinformationsxjkdaglList()){
			if (ironfoinformationsxjkdagl.getId() == null){
				continue;
			}
			if (Ironfoinformationsxjkdagl.DEL_FLAG_NORMAL.equals(ironfoinformationsxjkdagl.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjkdagl.getId())){
					ironfoinformationsxjkdagl.preInsert();
					ironfoinformationsxjkdaglDao.insert(ironfoinformationsxjkdagl);
				}else{
					ironfoinformationsxjkdagl.preUpdate();
					ironfoinformationsxjkdaglDao.update(ironfoinformationsxjkdagl);
				}
			}else{
				ironfoinformationsxjkdaglDao.delete(ironfoinformationsxjkdagl);
			}
		}
		for (Ironfoinformationsxjkxxfw ironfoinformationsxjkxxfw : ironfoinformationsx.getIronfoinformationsxjkxxfwList()){
			if (ironfoinformationsxjkxxfw.getId() == null){
				continue;
			}
			if (Ironfoinformationsxjkxxfw.DEL_FLAG_NORMAL.equals(ironfoinformationsxjkxxfw.getDelFlag())){
				if (StringUtils.isBlank(ironfoinformationsxjkxxfw.getId())){
					ironfoinformationsxjkxxfw.preInsert();
					ironfoinformationsxjkxxfwDao.insert(ironfoinformationsxjkxxfw);
				}else{
					ironfoinformationsxjkxxfw.preUpdate();
					ironfoinformationsxjkxxfwDao.update(ironfoinformationsxjkxxfw);
				}
			}else{
				ironfoinformationsxjkxxfwDao.delete(ironfoinformationsxjkxxfw);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfoinformationsx ironfoinformationsx) {
		super.delete(ironfoinformationsx);
		ironfoinformationsxjbggwsfwDao.delete(new Ironfoinformationsxjbggwsfw());
		ironfoinformationsxjbylfwDao.delete(new Ironfoinformationsxjbylfw());
		ironfoinformationsxjgjkDao.delete(new Ironfoinformationsxjgjk());
		ironfoinformationsxjgyyglDao.delete(new Ironfoinformationsxjgyygl());
		ironfoinformationsxjkdaglDao.delete(new Ironfoinformationsxjkdagl());
		ironfoinformationsxjkxxfwDao.delete(new Ironfoinformationsxjkxxfw());
	}
	
	
}