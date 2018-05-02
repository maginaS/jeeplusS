/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoemergencyroom.web;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
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
import com.jeeplus.modules.ironfoemergencyroom.service.IronfoemergencyroomService;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
//import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOEMERGENCYROOM;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 * 急诊室Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoemergencyroom/ironfoemergencyroom")
public class IronfoemergencyroomController extends BaseController {
	
	
	
	//xffsj
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfoemergencyroomService ironfoemergencyroomService;
	
	@ModelAttribute
	public Ironfoemergencyroom get(@RequestParam(required=false) String id) {
		Ironfoemergencyroom entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoemergencyroomService.get(id);
		}
		if (entity == null){
			entity = new Ironfoemergencyroom();
		}
		return entity;
	}
	
	/**
	 * 急诊室列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfoemergencyroom:ironfoemergencyroom:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoemergencyroom ironfoemergencyroom, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			
			ironfoemergencyroom.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoemergencyroom> data = ironfoemergencyroomService.queryForList(ironfoemergencyroom);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoemergencyroom room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOEMERGENCYROOM.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
//				listData.put("datas", datas);
//				listData.
//				listData.add(datas);
				
			}
			
		}else {
			
			for(IRONFOEMERGENCYROOM jz :EnumUtils.IRONFOEMERGENCYROOM.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_sbmc", "");
				datas.put(jz.toString().toLowerCase()+"_pp", "");
				datas.put(jz.toString().toLowerCase()+"_xh", "");
				datas.put(jz.toString().toLowerCase()+"_sl", "");
				datas.put(jz.toString().toLowerCase()+"_sbjg", "");
				datas.put(jz.toString().toLowerCase()+"_trsynf", "");
//				listData.add(datas);
				listData.put(jz.toString().toLowerCase(), datas);
			}
		}
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		return "modules/ironfoemergencyroom/ironfoemergencyroomList";
	}

	/**
	 * 查看，增加，编辑急诊室表单页面
	 */
	@RequiresPermissions(value={"ironfoemergencyroom:ironfoemergencyroom:view","ironfoemergencyroom:ironfoemergencyroom:add","ironfoemergencyroom:ironfoemergencyroom:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoemergencyroom ironfoemergencyroom, Model model) {
		model.addAttribute("ironfoemergencyroom", ironfoemergencyroom);
		return "modules/ironfoemergencyroom/ironfoemergencyroomForm";
	}

	/**
	 * 保存急诊室
	 */
	@RequiresPermissions(value={"ironfoemergencyroom:ironfoemergencyroom:add","ironfoemergencyroom:ironfoemergencyroom:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoemergencyroom ironfoemergencyroom, Model model, RedirectAttributes redirectAttributes) throws Exception{

		
		 String[] SBMC = new String[] {"dcsjhy",
				 "cpxly","ychxj","yzhxj","wchxj",
				 "zdptj","xdtj","xffsj","qcy","xwzqgj",
				 "czy","lsqbq","xwj","qjjhxjhc","kshj","qtqzm"};
		 
		 
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfoemergencyrooms = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<ironfoemergencyrooms.length;i++) {
//			if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//				map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//			}else {
				map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString(),ironfoemergencyrooms[i].toString().split(":")[1].toString());
				if("docId" == ironfoemergencyrooms[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoemergencyrooms[i].toString().trim().split(":")[0].toString().trim())) {
					docId = ironfoemergencyrooms[i].toString().split(":")[1].toString();
				}
				
//			}
			
		}
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfoemergencyroom.setDoc_id(docId);
			List<Ironfoemergencyroom> ironfoList = ironfoemergencyroomService.queryForList(ironfoemergencyroom);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoemergencyroom ironfoemergencyroom_data = null;
		
		if(isnull == false) {
			//更新
			int i=1;
			ironfoemergencyroom_data = new Ironfoemergencyroom();
			for(int j=0;j<SBMC.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoemergencyroom.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoemergencyroom_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoemergencyroom_data.setDoc_id(docId); 
									ironfoemergencyroomService.save(ironfoemergencyroom_data);//保存
									i = 1;
									ironfoemergencyroom_data = new Ironfoemergencyroom();
							}	
						}	
					}	
				}	
			}	
		}else if(isnull == true) {
			
			//更新
			

			int i=1;
			ironfoemergencyroom_data = new Ironfoemergencyroom();
			for(int j=0;j<SBMC.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfoemergencyroom_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoemergencyroom.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoemergencyroom_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoemergencyroom_data.setDoc_id(docId); 
//									ironfoemergencyroomService.save(ironfoemergencyroom_data);//保存
									ironfoemergencyroomService.updateIronfo(ironfoemergencyroom_data);
									i = 1;
									ironfoemergencyroom_data = new Ironfoemergencyroom();
							}	
						}	
					}	
				}	
			}	
			
		}
		
		
		
		
	
		
		
		
		
		
		
		
		
//		if (!beanValidator(model, ironfoemergencyroom)){
//			return form(ironfoemergencyroom, model);
//		}
//		if(!ironfoemergencyroom.getIsNewRecord()){//编辑表单保存
//			Ironfoemergencyroom t = ironfoemergencyroomService.get(ironfoemergencyroom.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfoemergencyroom, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfoemergencyroomService.save(t);//保存
//		}else{//新增表单保存
//			ironfoemergencyroomService.save(ironfoemergencyroom);//保存
//		}
		addMessage(redirectAttributes, "保存急诊室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoemergencyroom/ironfoemergencyroom/?repage";
	}
	
	/**
	 * 删除急诊室
	 */
	@RequiresPermissions("ironfoemergencyroom:ironfoemergencyroom:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoemergencyroom ironfoemergencyroom, RedirectAttributes redirectAttributes) {
		ironfoemergencyroomService.delete(ironfoemergencyroom);
		addMessage(redirectAttributes, "删除急诊室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoemergencyroom/ironfoemergencyroom/?repage";
	}
	
	/**
	 * 批量删除急诊室
	 */
	@RequiresPermissions("ironfoemergencyroom:ironfoemergencyroom:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoemergencyroomService.delete(ironfoemergencyroomService.get(id));
		}
		addMessage(redirectAttributes, "删除急诊室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoemergencyroom/ironfoemergencyroom/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoemergencyroom:ironfoemergencyroom:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoemergencyroom ironfoemergencyroom, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "急诊室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoemergencyroom> page = ironfoemergencyroomService.findPage(new Page<Ironfoemergencyroom>(request, response, -1), ironfoemergencyroom);
    		new ExportExcel("急诊室", Ironfoemergencyroom.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出急诊室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoemergencyroom/ironfoemergencyroom/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoemergencyroom:ironfoemergencyroom:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoemergencyroom> list = ei.getDataList(Ironfoemergencyroom.class);
			for (Ironfoemergencyroom ironfoemergencyroom : list){
				try{
					ironfoemergencyroomService.save(ironfoemergencyroom);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条急诊室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条急诊室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入急诊室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoemergencyroom/ironfoemergencyroom/?repage";
    }
	
	/**
	 * 下载导入急诊室数据模板
	 */
	@RequiresPermissions("ironfoemergencyroom:ironfoemergencyroom:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "急诊室数据导入模板.xlsx";
    		List<Ironfoemergencyroom> list = Lists.newArrayList(); 
    		new ExportExcel("急诊室数据", Ironfoemergencyroom.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoemergencyroom/ironfoemergencyroom/?repage";
    }
	
	
	
	
	
	
	
//
	
	
	
	
	

}