/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofamilies.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeeplus.modules.tools.utils.JBZL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.ironfofamilies.entity.Ironfofamilies;
import com.jeeplus.modules.ironfofamilies.dao.IronfofamiliesDao;


import com.jeeplus.modules.ironfofamilies.entity.Ironfo_jbbz;
import com.jeeplus.modules.ironfobzlx.dao.IronfobzlxDao;
import com.jeeplus.modules.ironfobzlx.entity.Ironfobzlx;
import com.jeeplus.modules.ironfofamilies.dao.Ironfo_jbbzDao;
import com.jeeplus.modules.ironfofamilies.entity.Ironfotjbz;
import com.jeeplus.modules.ironfofamilies.dao.IronfotjbzDao;

/**
 * 2.5病种Service
 * @author mikesun
 * @version 2018-03-19
 */
@Service
@Transactional(readOnly = true)
public class IronfofamiliesService extends CrudService<IronfofamiliesDao, Ironfofamilies> {

//	private static String JBBZ ="JBBZ";
//	private static String TJBZ ="TJBZ";
	
	public static String TYPE[] = new String[] {"JBBZ","TJBZ"};
	
	
	@Autowired
	private Ironfo_jbbzDao ironfo_jbbzDao;
	@Autowired
	private IronfotjbzDao ironfotjbzDao;
	
	
	@Autowired
	private IronfobzlxDao ironfobzlxDao;
	
	public Ironfofamilies get(String id) {
		Ironfofamilies ironfofamilies = super.get(id);
		ironfofamilies.setIronfo_jbbzList(ironfo_jbbzDao.findList(new Ironfo_jbbz()));
		ironfofamilies.setIronfotjbzList(ironfotjbzDao.findList(new Ironfotjbz()));
		return ironfofamilies;
	}
	
	public List<Ironfofamilies> findList(Ironfofamilies ironfofamilies) {
		return super.findList(ironfofamilies);
	}
	
	public Page<Ironfofamilies> findPage(Page<Ironfofamilies> page, Ironfofamilies ironfofamilies) {
		return super.findPage(page, ironfofamilies);
	}
	
	@Transactional(readOnly = false)
	public void save(Ironfofamilies ironfofamilies) {
		super.save(ironfofamilies);
		for (Ironfo_jbbz ironfo_jbbz : ironfofamilies.getIronfo_jbbzList()){
			if (ironfo_jbbz.getId() == null){
				continue;
			}
			if (Ironfo_jbbz.DEL_FLAG_NORMAL.equals(ironfo_jbbz.getDelFlag())){
				if (StringUtils.isBlank(ironfo_jbbz.getId())){
					ironfo_jbbz.preInsert();
					ironfo_jbbzDao.insert(ironfo_jbbz);
				}else{
					ironfo_jbbz.preUpdate();
					ironfo_jbbzDao.update(ironfo_jbbz);
				}
			}else{
				ironfo_jbbzDao.delete(ironfo_jbbz);
			}
		}
		for (Ironfotjbz ironfotjbz : ironfofamilies.getIronfotjbzList()){
			if (ironfotjbz.getId() == null){
				continue;
			}
			if (Ironfotjbz.DEL_FLAG_NORMAL.equals(ironfotjbz.getDelFlag())){
				if (StringUtils.isBlank(ironfotjbz.getId())){
					ironfotjbz.preInsert();
					ironfotjbzDao.insert(ironfotjbz);
				}else{
					ironfotjbz.preUpdate();
					ironfotjbzDao.update(ironfotjbz);
				}
			}else{
				ironfotjbzDao.delete(ironfotjbz);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Ironfofamilies ironfofamilies) {
		super.delete(ironfofamilies);
		ironfo_jbbzDao.delete(new Ironfo_jbbz());
		ironfotjbzDao.delete(new Ironfotjbz());
	}
	
	
	public Map<String,Object> query(Ironfobzlx entity,String type,String bztype){
		String bztypes[] = null;
		Map<String,Object> datas = new HashMap<String,Object>();
		Map<String,Object> bzlx =null;
		
		if(bztype.indexOf(",")>0) {
			bztypes = bztype.split(",");
			
			for(int i=0;i<bztypes.length;i++) {
				try {
					entity = Ironfobzlx.class.newInstance();
					entity.setBztype(String.valueOf(JBZL.getjbzlEnumbyindex(Integer.parseInt(bztypes[i].toString()))));
					for(int j=0;j<TYPE.length;j++) {
						entity.setType(TYPE[j].toString());
						List<Ironfobzlx> data = ironfobzlxDao.findList(entity);
						bzlx = new HashMap<String,Object>();
						for(Ironfobzlx bz : data) {
							bzlx.put(bz.getNo(),bz.getName());
						}
						datas.put(String.valueOf(JBZL.getjbzlEnumbyindex(Integer.parseInt(bztypes[i].toString())))+"_"+TYPE[j].toString(), bzlx);
						
					}
					
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
				
			}
		}else {
			try {
				entity = Ironfobzlx.class.newInstance();
				entity.setBztype(String.valueOf(JBZL.getjbzlEnumbyindex(Integer.parseInt(bztype.toString()))));

				for(int j=0;j<TYPE.length;j++) {
					entity.setType(TYPE[j].toString());
					List<Ironfobzlx> data = ironfobzlxDao.findList(entity);
					bzlx = new HashMap<String,Object>();
					for(Ironfobzlx bz : data) {
						bzlx.put(bz.getNo(),bz.getName());
					}
					datas.put(String.valueOf(JBZL.getjbzlEnumbyindex(Integer.parseInt(bztype.toString())))+"_"+TYPE[j].toString(), bzlx);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		return datas;
		
	}
	
	
}