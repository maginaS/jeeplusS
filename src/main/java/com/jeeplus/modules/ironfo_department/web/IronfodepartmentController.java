/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_department.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.ironfo_department.dao.IronfodepartmentremarkDao;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartment;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentjhsyb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentremark;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentyjb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentznglb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;
import com.jeeplus.modules.ironfo_department.service.IronfodepartmentService;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.4科室设置Controller
 * @author mikesun
 * @version 2018-03-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfo_department/ironfodepartment")
public class IronfodepartmentController extends BaseController {

	
	  public static String JHSYB ="1";
	  public static String ZNGLB ="2";
	  public static String MJZB ="3";
	  public static String YJB ="4";
	  public static String GGWSB = "5";
	  public static String ZYB ="6";
	
	
	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	@Autowired
	private IronfodepartmentService ironfodepartmentService;
	
	@ModelAttribute
	public Ironfodepartment get(@RequestParam(required=false) String id) {
		Ironfodepartment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfodepartmentService.get(id);
		}
		if (entity == null){
			entity = new Ironfodepartment();
		}
		return entity;
	}
	
	/**
	 * 2.4科室设置列表页面
	 */
	@RequiresPermissions("ironfo_department:ironfodepartment:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfodepartment ironfodepartment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfodepartment> page = ironfodepartmentService.findPage(new Page<Ironfodepartment>(request, response), ironfodepartment); 
		model.addAttribute("page", page);
		return "modules/ironfo_department/ironfodepartmentList";
	}

	/**
	 * 查看，增加，编辑2.4科室设置表单页面
	 */
	@RequiresPermissions(value={"ironfo_department:ironfodepartment:view","ironfo_department:ironfodepartment:add","ironfo_department:ironfodepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfodepartment ironfodepartment, Model model) {

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		String type = request.getParameter("remark");
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
		Map<String,Object> datas = null;
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		IronfoDocTitle title = null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			
			
			Ironfodepartmentggwsb ggwsb = null;
			Ironfodepartmentjhsyb jhsyb = null;
			Ironfodepartmentremark mjzb = null;
			Ironfodepartmentyjb yjb = null;
			Ironfodepartmentznglb znglb = null;
			Ironfodepartmentzyb zyb = null;
			try {
				
				if(type.trim()==IronfodepartmentController.JHSYB||type.trim().equals(IronfodepartmentController.JHSYB)) {
					jhsyb =  Ironfodepartmentjhsyb.class.newInstance();
					jhsyb.setDoc_id(docList.get(0).getId().toString());
					List<Ironfodepartmentjhsyb> list_data = ironfodepartmentService.queryForJhsyb(jhsyb);
					if(list_data.size()>0) {
						for(Ironfodepartmentjhsyb m :list_data) {
							
							datas = new TreeMap<String,Object>();
							datas.put("doc_id",docList.get(0).getId().toString());
							datas.put("jhsyk", m.getJhsyk());
							datas.put("tjremark", m.getTjremark());
							datas.put("id", m.getId());
							datas.put("dep_id", m.getDep_id());
							
						}
						
					}else {
						
						datas = new TreeMap<String,Object>();
						datas.put("doc_id","");
						datas.put("jhsyk", "0");
						datas.put("tj_remark","");
						datas.put("id", "");
						datas.put("dep_id","");
						
					}
					
				}else if(type.trim()==IronfodepartmentController.GGWSB||type.trim().equals(IronfodepartmentController.GGWSB)){
					ggwsb =  Ironfodepartmentggwsb.class.newInstance();
					ggwsb.setDoc_id(docList.get(0).getId().toString());
					
					List<Ironfodepartmentggwsb> list_data = ironfodepartmentService.queryForGgwsb(ggwsb);
					if(list_data.size()>0) {
						for(Ironfodepartmentggwsb m : list_data) {
							
							datas = new TreeMap<String,Object>();
							datas.put("yfbjk", m.getYfbjk());
							datas.put("fnbjk", m.getFnbjk());
							datas.put("etbjk", m.getEtbjk());
							datas.put("tjzx", m.getTjzx());
							datas.put("tjremark", m.getTjremark());
							datas.put("dep_id", m.getDep_id());
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("id", m.getId());
						}
						
					}else {
						datas = new TreeMap<String,Object>();
						datas.put("yfbjk", "0");
						datas.put("fnbjk","0");
						datas.put("etbjk","0");
						datas.put("tjzx","0");
						datas.put("tj_remark","");
						datas.put("dep_id", "");
						datas.put("doc_id", "");
						datas.put("id","");
						
					}
					
					
				}else if(type.trim() == IronfodepartmentController.MJZB||type.trim().equals(IronfodepartmentController.MJZB)) {
					mjzb =  Ironfodepartmentremark.class.newInstance();
					mjzb.setDoc_id(docList.get(0).getId().toString());
					List<Ironfodepartmentremark> list_data = ironfodepartmentService.queryForRemark(mjzb);
					if(list_data.size()>0) {
						for(Ironfodepartmentremark m : list_data) {
							datas = new TreeMap<String,Object>();
							datas.put("dep_id", m.getDep_id());
							datas.put("jzs", m.getJzs());
							datas.put("nk", m.getNk());
							datas.put("ek", m.getEk());
							datas.put("wk", m.getWk());
							datas.put("fck", m.getFck());
							datas.put("qkyxk", m.getQkyxk());
							datas.put("zyk", m.getZyk());
							datas.put("yk", m.getYk());
							datas.put("ebhk", m.getEbhk());
							datas.put("kqk", m.getKqk());
							datas.put("kfk", m.getKfk());
							datas.put("pfk", m.getPfk());
							datas.put("grxjbk", m.getGrxjbk());
							datas.put("jsk", m.getJsk());
							datas.put("zjremark", m.getZjremark());
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("id", m.getId());
						
						}
						
					}else {
						datas = new TreeMap<String,Object>();
						datas.put("dep_id", "");
						datas.put("jzs", "0");
						datas.put("nk", "0");
						datas.put("ek","0");
						datas.put("wk", "0");
						datas.put("fck","0");
						datas.put("qkyxk","0");
						datas.put("zyk", "0");
						datas.put("yk", "0");
						datas.put("ebhk","0");
						datas.put("kqk","0");
						datas.put("kfk","0");
						datas.put("pfk","0");
						datas.put("grxjbk", "0");
						datas.put("jsk","0");
						datas.put("zjremark","");
						datas.put("doc_id","");
						datas.put("id","");
						
					}
					
					
					
				}else if(type.trim() == IronfodepartmentController.YJB||type.trim().equals(IronfodepartmentController.YJB)) {
					yjb = Ironfodepartmentyjb.class.newInstance();
					yjb.setDoc_id(docList.get(0).getId().toString());
					
					
					List<Ironfodepartmentyjb> list_data = ironfodepartmentService.queryForYjb(yjb);
					if(list_data.size()>0) {
						for(Ironfodepartmentyjb m: list_data) {
//							
							datas = new TreeMap<String,Object>();
							datas.put("dep_id", m.getDep_id());
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("yjk", m.getYjk());
							datas.put("jyk", m.getJyk());
							datas.put("fsk", m.getFsk());
							datas.put("csk", m.getCsk());
							datas.put("xdtk", m.getXdtk());
							datas.put("xdgys", m.getXdgys());
							datas.put("sss", m.getSss());
							datas.put("tjremark", m.getTjremark());
							datas.put("id", m.getId());
							
						}
						
					}else {
						datas = new TreeMap<String,Object>();
						datas.put("dep_id", "");
						datas.put("doc_id","");
						datas.put("yjk", "0");
						datas.put("jyk", "0");
						datas.put("fsk", "0");
						datas.put("csk","0");
						datas.put("xdtk", "0");
						datas.put("xdgys","0");
						datas.put("sss","0");
						datas.put("tjremark", "0");
						datas.put("id","");
						
					}
					
				}else if(type.trim() == IronfodepartmentController.ZNGLB||type.trim().equals(IronfodepartmentController.ZNGLB)) {
					znglb = Ironfodepartmentznglb.class.newInstance();
					znglb.setDoc_id(docList.get(0).getId().toString());
					
					
					List<Ironfodepartmentznglb> list_data = ironfodepartmentService.queryForZnglb(znglb);
					if(list_data.size()>0) {
						for(Ironfodepartmentznglb m:list_data) {
							
							datas = new TreeMap<String,Object>();
							datas.put("dep_id", m.getDep_id());
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("yzbgs", m.getYzbgs());
							datas.put("djbgs", m.getDjbgs());
							datas.put("ywk", m.getYwk());
							datas.put("hlk", m.getHlk());
							datas.put("cwk", m.getCwk());
							datas.put("daglk", m.getDaglk());
							datas.put("xxzx", m.getXxzx());
							datas.put("ygk", m.getYgk());
							datas.put("ybjsk", m.getYbjsk());
							datas.put("tj_remarks", m.getTjremarks());
							datas.put("id", m.getId());
							
						}
						
					}else {
						datas = new TreeMap<String,Object>();
						datas.put("dep_id", "");
						datas.put("doc_id", "");
						datas.put("yzbgs", "0");
						datas.put("djbgs","0");
						datas.put("ywk", "0");
						datas.put("hlk", "0");
						datas.put("cwk","0");
						datas.put("daglk","0");
						datas.put("xxzx", "0");
						datas.put("ygk","0");
						datas.put("ybjsk","0");
						datas.put("tj_remarks","");
						datas.put("id", "");
						
					}
					
					
				}else if(type.trim() == IronfodepartmentController.ZYB||type.trim().equals(IronfodepartmentController.ZYB)) {
					zyb = Ironfodepartmentzyb.class.newInstance();
					zyb.setDoc_id(docList.get(0).getId().toString());
					
					List<Ironfodepartmentzyb> list_data  = ironfodepartmentService.queryForZyb(zyb);
					if(list_data.size()>0) {
						for(Ironfodepartmentzyb m:list_data) {
							
							datas = new TreeMap<String,Object>();
							datas.put("ptbq", m.getPtbq());
							datas.put("kfbq", m.getKfbq());
							datas.put("lzghk", m.getLzghk());
							datas.put("tjremarks", m.getTjremarks());
							datas.put("dep_id", m.getDep_id());
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("id", m.getId());
						}
						
					}else {
						
						datas = new TreeMap<String,Object>();
						datas.put("ptbq", "0");
						datas.put("kfbq", "0");
						datas.put("lzghk", "0");
						datas.put("tjremarks", "");
						datas.put("dep_id","");
						datas.put("doc_id", "");
						datas.put("id", "");
						
					}
				}
				
				
			} catch (InstantiationException e) {
				
				e.printStackTrace();
				
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
				
			}
			
			
			
			
			
		}
		
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
//		model.addAttribute("ironfodepartment", ironfodepartment);
		return "modules/ironfo_department/ironfodepartmentForm";
	}

	/**
	 * 保存2.4科室设置
	 */
	@RequiresPermissions(value={"ironfo_department:ironfodepartment:add","ironfo_department:ironfodepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfodepartment ironfodepartment, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("titles");
		String checkbox = request.getParameter("checkbox");
		String type = request.getParameter("type");
		String checkout = request.getParameter("checkout");
		String remarks = request.getParameter("remarks");
		String id = request.getParameter("id");
		
		String[] datas = data.split(";");

		
		System.out.println("------------->"+datas[datas.length-1]);
		/**
		 * 主表信息
		 */
		String docId = "";
		for(int i=0;i<datas.length;i++) {
			map.put(datas[i].toString().split(":")[0].toString(), datas[i].toString().split(":")[1].toString());
			if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
				docId = datas[i].toString().split(":")[1].toString();
			}
		}
		
//		  if(){
		if(checkbox.length()>0) {
			if(checkbox.indexOf(",")!=-1) {
				for(int j =0;j<checkbox.split(",").length;j++) {
					map.put(checkbox.split(",")[j], "1");
				}
			}else {
				 map.put(checkbox, "1");
			}
		}
		
		if(checkout.length()>0) {
			if(checkout.contains(",")) {
				for(int j =0;j<checkout.split(",").length;j++) {
					map.put(checkout.split(",")[j], "0");
				}	
			}else {
				map.put(checkout, "0");
			}
			
		}
		
		
		/**
		 * 附表信息
		 */
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||"----".trim()==docId.toString().trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			
			
			/**
			 * 获取type值
			 */
			if(type.trim()==IronfodepartmentController.GGWSB||type.trim().equals(IronfodepartmentController.GGWSB)) {
				
				Ironfodepartmentggwsb b = Ironfodepartmentggwsb.class.newInstance();
				b.setDoc_id(docId);
				List<Ironfodepartmentggwsb> gg_data  = ironfodepartmentService.queryForGgwsb(b);
					
				if(gg_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}else if(type.trim()==IronfodepartmentController.JHSYB||type.trim().equals(IronfodepartmentController.JHSYB)) {
				/**
				 * 
				 */
				Ironfodepartmentjhsyb b = Ironfodepartmentjhsyb.class.newInstance();
				b.setDoc_id(docId);
				List<Ironfodepartmentjhsyb> jh_data = ironfodepartmentService.queryForJhsyb(b);
				if(jh_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}else if(type.trim()==IronfodepartmentController.MJZB||type.trim().equals(IronfodepartmentController.MJZB)) {
				/**
				 * 
				 */
				Ironfodepartmentremark mjzb = Ironfodepartmentremark.class.newInstance();
				mjzb.setDoc_id(docId);
				List<Ironfodepartmentremark> mjzb_data = ironfodepartmentService.queryForRemark(mjzb);
				if(mjzb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}else if(type.trim()==IronfodepartmentController.YJB||type.trim().equals(IronfodepartmentController.YJB)){
				/**
				 * 
				 */
				Ironfodepartmentyjb yjb = Ironfodepartmentyjb.class.newInstance();
				yjb.setDoc_id(docId);
				List<Ironfodepartmentyjb> yjb_data= ironfodepartmentService.queryForYjb(yjb);
				if(yjb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}else if(type.trim()==IronfodepartmentController.ZNGLB||type.trim().equals(IronfodepartmentController.ZNGLB)) {
				/**
				 * 
				 */
				Ironfodepartmentznglb znglb = Ironfodepartmentznglb.class.newInstance();
				znglb.setDoc_id(docId);
				List<Ironfodepartmentznglb> znglb_data=ironfodepartmentService.queryForZnglb(znglb);
				if(znglb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}else if(type.trim()==IronfodepartmentController.ZYB||type.trim().equals(IronfodepartmentController.ZYB)) {
				/**
				 * 
				 */
				Ironfodepartmentzyb zyb = Ironfodepartmentzyb.class.newInstance();
				zyb.setDoc_id(docId);
				List<Ironfodepartmentzyb> zyb_data = ironfodepartmentService.queryForZyb(zyb);
				if(zyb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}	
		}
		
		
//		 UUID.randomUUID().toString().replaceAll("-", "");
		
		/**
		 * 获取type值
		 */
		if(type.trim()==IronfodepartmentController.GGWSB||type.trim().equals(IronfodepartmentController.GGWSB)) {
			/**
			 * 
			 */
			Ironfodepartmentggwsb b = null;
				b = Ironfodepartmentggwsb.class.newInstance();
				b.setEtbjk(map.get("etbjk").toString());
				b.setFnbjk(map.get("fnbjk").toString());
				b.setYfbjk(map.get("yfbjk").toString());
				b.setTjzx(map.get("tjzx").toString());
//				b.setTj_remark(map.get("tj_remark").toString());
				b.setDep_id(map.get("dep_id").toString());
				b.setTjremark(remarks);
				b.setDoc_id(docId);
			if(isnull==true) {
				b.setId(id);
				ironfodepartmentService.updateggwsb(b);
			}else if(isnull==false){
				b.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfodepartmentService.saveggwsb(b);
			}
			
		}else if(type.trim()==IronfodepartmentController.JHSYB||type.trim().equals(IronfodepartmentController.JHSYB)) {
			/**
			 * private String jhsyk;		// 计划生育科
				private String tj_remark;		// 添加
				private String dep_id;		// 主表id
				private String doc_id;
			 */
			Ironfodepartmentjhsyb jhsyb = Ironfodepartmentjhsyb.class.newInstance();
			jhsyb.setJhsyk(map.get("jhsyk").toString());
			jhsyb.setTjremark(remarks);
			jhsyb.setDep_id(map.get("dep_id").toString());
			jhsyb.setDoc_id(docId);
			if(isnull==true) {
				jhsyb.setId(id);
				ironfodepartmentService.updatejhsyb(jhsyb);
			}else if(isnull==false){
				jhsyb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfodepartmentService.savejhsyb(jhsyb);
			}
			
			
		}else if(type.trim()==IronfodepartmentController.MJZB||type.trim().equals(IronfodepartmentController.MJZB)) {
	
			Ironfodepartmentremark mjzb = Ironfodepartmentremark.class.newInstance();
			mjzb.setDep_id(map.get("dep_id").toString());
			mjzb.setNk(map.get("nk").toString());
			mjzb.setEk(map.get("ek").toString());
			mjzb.setWk(map.get("wk").toString());
			mjzb.setFck(map.get("fck").toString());
			mjzb.setQkyxk(map.get("qkyxk").toString());
			mjzb.setZyk(map.get("zyk").toString());
			mjzb.setYk(map.get("yk").toString());
			mjzb.setEbhk(map.get("ebhk").toString());
			mjzb.setKqk(map.get("kqk").toString());
			mjzb.setKfk(map.get("kfk").toString());
			mjzb.setPfk(map.get("pfk").toString());
			mjzb.setGrxjbk(map.get("grxjbk").toString());
			mjzb.setJsk(map.get("jsk").toString());
			mjzb.setZjremark(remarks);
			mjzb.setDoc_id(docId);
			
			if(isnull==true) {
				mjzb.setId(id);
				ironfodepartmentService.updateremark(mjzb);
			}else if(isnull==false){
				mjzb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfodepartmentService.saveremark(mjzb);
			}

			
		}else if(type.trim()==IronfodepartmentController.YJB||type.trim().equals(IronfodepartmentController.YJB)){
			/**
			 * 
			 */
			Ironfodepartmentyjb yjb = Ironfodepartmentyjb.class.newInstance();
			yjb.setDep_id(map.get("dep_id").toString());
			yjb.setDoc_id(docId);
			yjb.setTjremark(remarks);
			yjb.setYjk(map.get("yjk").toString());
			yjb.setJyk(map.get("jyk").toString());
			yjb.setFsk(map.get("fsk").toString());
			yjb.setCsk(map.get("csk").toString());
			yjb.setXdtk(map.get("xdtk").toString());
			yjb.setXdgys(map.get("xdgys").toString());
			yjb.setSss(map.get("sss").toString());
			if(isnull==true) {
				yjb.setId(id);
				ironfodepartmentService.updateyjb(yjb);
			}else if(isnull==false){
				yjb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfodepartmentService.saveyjb(yjb);
			}

			
		}else if(type.trim()==IronfodepartmentController.ZNGLB||type.trim().equals(IronfodepartmentController.ZNGLB)) {
		
			Ironfodepartmentznglb znglb = Ironfodepartmentznglb.class.newInstance();
			znglb.setYzbgs(map.get("yzbgs").toString());
			znglb.setDjbgs(map.get("djbgs").toString());
			znglb.setYwk(map.get("ywk").toString());
			znglb.setHlk(map.get("hlk").toString());
			znglb.setCwk(map.get("cwk").toString());
			znglb.setDaglk(map.get("daglk").toString());
			znglb.setXxzx(map.get("xxzx").toString());
			znglb.setYgk(map.get("ygk").toString());
			znglb.setYbjsk(map.get("ybjsk").toString());
		/*	znglb.setHqglk(map.get("hqglk").toString());*/
			znglb.setTjremarks(remarks);
			znglb.setDoc_id(docId);
			znglb.setDep_id(map.get("dep_id").toString());
			
			if(isnull==true) {
				znglb.setId(id);
				ironfodepartmentService.updateznglb(znglb);
			}else if(isnull==false){
				znglb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfodepartmentService.saveznglb(znglb);
			}
			
		}else if(type.trim()==IronfodepartmentController.ZYB||type.trim().equals(IronfodepartmentController.ZYB)) {
			/**
			 * 
			 */
			Ironfodepartmentzyb zyb = Ironfodepartmentzyb.class.newInstance();
			zyb.setDoc_id(docId);
			zyb.setTjremarks(remarks);
			zyb.setDep_id(map.get("dep_id").toString());
			zyb.setPtbq(map.get("ptbq").toString());
			zyb.setKfbq(map.get("kfbq").toString());
			zyb.setLzghk(map.get("lzghk").toString());
			
			if(isnull==true) {
				zyb.setId(id);
				ironfodepartmentService.updatezyb(zyb);
			}else if(isnull==false){
				zyb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfodepartmentService.savezyb(zyb);
			}
			
			
			
			
			
		}
		
		
		
		
		

		return "redirect:"+Global.getAdminPath()+"/ironfo_department/ironfodepartment/?repage";
	}
	
	/**
	 * 删除2.4科室设置
	 */
	@RequiresPermissions("ironfo_department:ironfodepartment:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfodepartment ironfodepartment, RedirectAttributes redirectAttributes) {
		ironfodepartmentService.delete(ironfodepartment);
		addMessage(redirectAttributes, "删除2.4科室设置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_department/ironfodepartment/?repage";
	}
	
	/**
	 * 批量删除2.4科室设置
	 */
	@RequiresPermissions("ironfo_department:ironfodepartment:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfodepartmentService.delete(ironfodepartmentService.get(id));
		}
		addMessage(redirectAttributes, "删除2.4科室设置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_department/ironfodepartment/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfo_department:ironfodepartment:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfodepartment ironfodepartment, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.4科室设置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfodepartment> page = ironfodepartmentService.findPage(new Page<Ironfodepartment>(request, response, -1), ironfodepartment);
    		new ExportExcel("2.4科室设置", Ironfodepartment.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.4科室设置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_department/ironfodepartment/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfo_department:ironfodepartment:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfodepartment> list = ei.getDataList(Ironfodepartment.class);
			for (Ironfodepartment ironfodepartment : list){
				try{
					ironfodepartmentService.save(ironfodepartment);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.4科室设置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.4科室设置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.4科室设置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_department/ironfodepartment/?repage";
    }
	
	/**
	 * 下载导入2.4科室设置数据模板
	 */
	@RequiresPermissions("ironfo_department:ironfodepartment:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.4科室设置数据导入模板.xlsx";
    		List<Ironfodepartment> list = Lists.newArrayList(); 
    		new ExportExcel("2.4科室设置数据", Ironfodepartment.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_department/ironfodepartment/?repage";
    }
	
	
	

}