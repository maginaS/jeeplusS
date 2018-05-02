/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationexperience.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;
import com.jeeplus.modules.ironfoinformationexperience.service.IronfoinformationexperienceService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 * 4.3信息化系统使用体验Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationexperience/ironfoinformationexperience")
public class IronfoinformationexperienceController extends BaseController {

	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@Autowired
	private IronfoinformationexperienceService ironfoinformationexperienceService;
	
	@ModelAttribute
	public Ironfoinformationexperience get(@RequestParam(required=false) String id) {
		Ironfoinformationexperience entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationexperienceService.get(id);
		}
		if (entity == null){
			entity = new Ironfoinformationexperience();
		}
		return entity;
	}
	
	
/*	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:queryForListOrMap")*/
//	@RequestMapping(value = "queryForListOrMap")
//	@ResponseBody
//	public Map<String,Object> queryForListOrMap( HttpServletRequest request, HttpServletResponse response, Model model){
//		
//		
//		Ironfoinformationexperience ironfoinformationexperience = null;
//		try {
//			ironfoinformationexperience = Ironfoinformationexperience.class.newInstance();
//		} catch (InstantiationException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IllegalAccessException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		Subject subject = SecurityUtils.getSubject();  
//		Principal obj = (Principal) subject.getPrincipal();
//		System.out.println(obj.getId());
//		
//		
//		Map<String,Object> listData = new HashMap<String,Object>();
////		List<Object> listData = new ArrayList<Object>();
//		Map<String,Object> datas = null;
//		
//		IronfoDocTitle title = null;
//		try {
//			title = IronfoDocTitle.class.newInstance();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		title.setRemarks(obj.getId());
//		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
//		if(docList.size()>0) {
//			ironfoinformationexperience.setDoc_id(docList.get(0).getId().toString());
//			List<Ironfoinformationexperience> data = ironfoinformationexperienceService.queryForList(ironfoinformationexperience);
//			
//			
//			listData.put("doc_id", docList.get(0).getId().toString());
//			
//			for(Ironfoinformationexperience ce : data) {
//				datas = new TreeMap<String,Object>();
//				
//				
//				if("----".trim()==ce.getId().trim()||"----".trim().equals(ce.getId().trim())) {
//					datas.put("id", "");
//				}else{
//					datas.put("id", ce.getId());
//				}
//				
//				if("----".trim()==ce.getBjxty().trim()||"----".trim().equals(ce.getBjxty().trim())) {
//					datas.put("bjxty", "1");
//				}else {
//					datas.put("bjxty", ce.getBjxty());
//				}
//				
//				if("----".trim()==ce.getGgxty().trim()||"----".trim().equals(ce.getGgxty().trim())) {
//					datas.put("ggxty", "1");
//				}else {
//					datas.put("ggxty", ce.getGgxty());
//
//				}
//				
//				if("----".trim() == ce.getGnxty().trim()||"----".trim().equals(ce.getGnxty().trim())) {
//					datas.put("gnxty", "1");
//				}else {
//					datas.put("gnxty", ce.getGnxty());
//
//				}
//				
//				listData.put("datas", datas);
//
//				
//			}
//			
//		}else {
//			
//			datas = new TreeMap<String,Object>();
//			datas.put("id", "");
//			datas.put("bjxty", "1");
//			datas.put("ggxty", "1");
//			datas.put("gnxty", "1");
//			listData.put("datas", datas);
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		return listData;
//	}
	
	/**
	 * 4.3信息化系统使用体验列表页面
	 */
	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoinformationexperience ironfoinformationexperience, HttpServletRequest request, HttpServletResponse response, Model model) {

		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
		IronfoDocTitle title = null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			ironfoinformationexperience.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoinformationexperience> data = ironfoinformationexperienceService.queryForList(ironfoinformationexperience);
			
			
			listData.put("doc_id", docList.get(0).getId().toString());
			
			for(Ironfoinformationexperience ce : data) {
				datas = new TreeMap<String,Object>();
				
				
				if("----".trim()==ce.getId().trim()||"----".trim().equals(ce.getId().trim())) {
					datas.put("id", "");
				}else{
					datas.put("id", ce.getId());
				}
				
				if("----".trim()==ce.getBjxty().trim()||"----".trim().equals(ce.getBjxty().trim())) {
					datas.put("bjxty", "1");
				}else {
					datas.put("bjxty", ce.getBjxty());
				}
				
				if("----".trim()==ce.getGgxty().trim()||"----".trim().equals(ce.getGgxty().trim())) {
					datas.put("ggxty", "1");
				}else {
					datas.put("ggxty", ce.getGgxty());

				}
				
				if("----".trim() == ce.getGnxty().trim()||"----".trim().equals(ce.getGnxty().trim())) {
					datas.put("gnxty", "1");
				}else {
					datas.put("gnxty", ce.getGnxty());

				}
				
				listData.put("datas", datas);

				
			}
			
		}else {
			
			datas = new TreeMap<String,Object>();
			datas.put("id", "");
			datas.put("bjxty", "1");
			datas.put("ggxty", "1");
			datas.put("gnxty", "1");
			listData.put("datas", datas);
			
		}
		
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		return "modules/ironfoinformationexperience/ironfoinformationexperienceList";
	}

	/**
	 * 查看，增加，编辑4.3信息化系统使用体验表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationexperience:ironfoinformationexperience:view","ironfoinformationexperience:ironfoinformationexperience:add","ironfoinformationexperience:ironfoinformationexperience:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoinformationexperience ironfoinformationexperience, Model model) {
		model.addAttribute("ironfoinformationexperience", ironfoinformationexperience);
		return "modules/ironfoinformationexperience/ironfoinformationexperienceForm";
	}

	/**
	 * 保存4.3信息化系统使用体验
	 */
	@RequiresPermissions(value={"ironfoinformationexperience:ironfoinformationexperience:add","ironfoinformationexperience:ironfoinformationexperience:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoinformationexperience ironfoinformationexperience, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfoinformationexperiences = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<ironfoinformationexperiences.length;i++) {
//			if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//				map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//			}else {
				map.put(ironfoinformationexperiences[i].toString().split(":")[0].toString(),ironfoinformationexperiences[i].toString().split(":")[1].toString());
				if("docId" == ironfoinformationexperiences[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoinformationexperiences[i].toString().trim().split(":")[0].toString().trim())) {
					docId = ironfoinformationexperiences[i].toString().split(":")[1].toString();
				}
				
//			}
			
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||docId.toString().trim()=="----".trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfoinformationexperience.setDoc_id(docId);
			List<Ironfoinformationexperience> ironfoList = ironfoinformationexperienceService.queryForList(ironfoinformationexperience);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoinformationexperience ironfoinformationexperience_data = null;
		ironfoinformationexperience_data = new Ironfoinformationexperience();
		
		ironfoinformationexperience_data.setBjxty(map.get("bjxty").toString());
		ironfoinformationexperience_data.setGgxty(map.get("ggxty").toString());
		ironfoinformationexperience_data.setGnxty(map.get("gnxty").toString());
		ironfoinformationexperience_data.setDoc_id(docId);
		
		if(isnull == false) {
			
			//保存
			ironfoinformationexperienceService.save(ironfoinformationexperience_data);
		}else if(isnull == true) {
			
			//更新
			ironfoinformationexperience_data.setId(map.get("id").toString());
			ironfoinformationexperienceService.updateIronfo(ironfoinformationexperience_data);
			
		}
		
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationexperience/ironfoinformationexperience/?repage";
	}
	
	/**
	 * 删除4.3信息化系统使用体验
	 */
	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoinformationexperience ironfoinformationexperience, RedirectAttributes redirectAttributes) {
		ironfoinformationexperienceService.delete(ironfoinformationexperience);
		addMessage(redirectAttributes, "删除4.3信息化系统使用体验成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationexperience/ironfoinformationexperience/?repage";
	}
	
	/**
	 * 批量删除4.3信息化系统使用体验
	 */
	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationexperienceService.delete(ironfoinformationexperienceService.get(id));
		}
		addMessage(redirectAttributes, "删除4.3信息化系统使用体验成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationexperience/ironfoinformationexperience/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoinformationexperience ironfoinformationexperience, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.3信息化系统使用体验"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoinformationexperience> page = ironfoinformationexperienceService.findPage(new Page<Ironfoinformationexperience>(request, response, -1), ironfoinformationexperience);
    		new ExportExcel("4.3信息化系统使用体验", Ironfoinformationexperience.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.3信息化系统使用体验记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationexperience/ironfoinformationexperience/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoinformationexperience> list = ei.getDataList(Ironfoinformationexperience.class);
			for (Ironfoinformationexperience ironfoinformationexperience : list){
				try{
					ironfoinformationexperienceService.save(ironfoinformationexperience);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.3信息化系统使用体验记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.3信息化系统使用体验记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.3信息化系统使用体验失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationexperience/ironfoinformationexperience/?repage";
    }
	
	/**
	 * 下载导入4.3信息化系统使用体验数据模板
	 */
	@RequiresPermissions("ironfoinformationexperience:ironfoinformationexperience:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.3信息化系统使用体验数据导入模板.xlsx";
    		List<Ironfoinformationexperience> list = Lists.newArrayList(); 
    		new ExportExcel("4.3信息化系统使用体验数据", Ironfoinformationexperience.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationexperience/ironfoinformationexperience/?repage";
    }
	
	
	

}