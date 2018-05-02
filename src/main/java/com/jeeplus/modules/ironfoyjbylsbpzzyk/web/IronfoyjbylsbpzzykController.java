/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzzyk.web;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import com.jeeplus.modules.ironfoyjbylsbpzykebyhk.entity.Ironfoyjbylsbpzykebyhk;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.entity.Ironfoyjbylsbpzzyk;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.service.IronfoyjbylsbpzzykService;
import com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.entity.IronfoyjbylsbpzzykReport;
import com.jeeplus.modules.report.utils.AnnotationForClass;
import com.jeeplus.modules.sys.dao.UserDao;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOYKEBHK;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOZYK;

/**
 * 中医科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk")
public class IronfoyjbylsbpzzykController extends BaseController {
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfoyjbylsbpzzykService ironfoyjbylsbpzzykService;
	
	@Autowired
	private UserDao userDao;
	@ModelAttribute
	public Ironfoyjbylsbpzzyk get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzzyk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzzykService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzzyk();
		}
		return entity;
	}
	
	/**
	 * 中医科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk, HttpServletRequest request, HttpServletResponse response, Model model) {

		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
		IronfoDocTitle title =null;
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


			ironfoyjbylsbpzzyk.setDocId(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzzyk> data = ironfoyjbylsbpzzykService.queryForList(ironfoyjbylsbpzzyk);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzzyk room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getRusynf().trim()||"----".trim().equals(room.getRusynf().trim())) {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_rusynf", "");
				}else {
					datas.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_rusynf", room.getRusynf());
				}
				
				listData.put(EnumUtils.IRONFOZYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
			
			
		}else {
			

			for(IRONFOZYK jz :EnumUtils.IRONFOZYK.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_sbmc", "");
				datas.put(jz.toString().toLowerCase()+"_pp", "");
				datas.put(jz.toString().toLowerCase()+"_xh", "");
				datas.put(jz.toString().toLowerCase()+"_sl", "");
				datas.put(jz.toString().toLowerCase()+"_sbjg", "");
				datas.put(jz.toString().toLowerCase()+"_rusynf", "");
//				listData.add(datas);
				listData.put(jz.toString().toLowerCase(), datas);
			}
			
			
			
			
			
			
		}
		
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
	
		return "modules/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzykList";
	}

	/**
	 * 查看，增加，编辑中医科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:view","ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:add","ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk, Model model) {
		model.addAttribute("ironfoyjbylsbpzzyk", ironfoyjbylsbpzzyk);
		return "modules/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzykForm";
	}

	/**
	 * 保存中医科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:add","ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		


		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] datas = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<datas.length;i++) {
//			if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//				map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//			}else {
				map.put(datas[i].toString().split(":")[0].toString(),datas[i].toString().split(":")[1].toString());
				if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
					docId = datas[i].toString().split(":")[1].toString();
				}
				
//			}
			
		}
		
		
		if(docId.toString().trim() == null ||docId.toString().trim() == "----".trim()|| "".equals(docId.toString().trim())||"----".trim().toString().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfoyjbylsbpzzyk.setDocId(docId);
			List<Ironfoyjbylsbpzzyk> ironfoList = ironfoyjbylsbpzzykService.queryForList(ironfoyjbylsbpzzyk);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk_data = null;
		
		


		if(isnull == false) {
			//更新
			int i=1;
			ironfoyjbylsbpzzyk_data = new Ironfoyjbylsbpzzyk();
			for(int j=0;j<EnumUtils.ZYK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.ZYK[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.ZYK[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzzyk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoyjbylsbpzzyk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoyjbylsbpzzyk_data.setDocId(docId); 
									ironfoyjbylsbpzzykService.save(ironfoyjbylsbpzzyk_data);//保存
									i = 1;
									ironfoyjbylsbpzzyk_data = new Ironfoyjbylsbpzzyk();
							}	
						}	
					}	
				}	
			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfoyjbylsbpzzyk_data = new Ironfoyjbylsbpzzyk();
			for(int j=0;j<EnumUtils.ZYK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.ZYK[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.ZYK[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfoyjbylsbpzzyk_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzzyk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoyjbylsbpzzyk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoyjbylsbpzzyk_data.setDocId(docId); 
									ironfoyjbylsbpzzykService.updateIronfo(ironfoyjbylsbpzzyk_data);//保存
									i = 1;
									ironfoyjbylsbpzzyk_data = new Ironfoyjbylsbpzzyk();
							}	
						}	
					}	
				}	
			}	
		}
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/?repage";
	}
	
	/**
	 * 删除中医科
	 */
	@RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzzykService.delete(ironfoyjbylsbpzzyk);
		addMessage(redirectAttributes, "删除中医科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/?repage";
	}
	
	/**
	 * 批量删除中医科
	 */
	@RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzzykService.delete(ironfoyjbylsbpzzykService.get(id));
		}
		addMessage(redirectAttributes, "删除中医科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
//	@RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:export")
//    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile1(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "中医科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoyjbylsbpzzyk> page = ironfoyjbylsbpzzykService.findPage(new Page<Ironfoyjbylsbpzzyk>(request, response, -1), ironfoyjbylsbpzzyk);
    		new ExportExcel("中医科", Ironfoyjbylsbpzzyk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出中医科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/?repage";
    }
	/**
	 * 导出excel文件
	 */
    @RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
    	// 查找出所有用户
    	List<User> userList = userDao.findUserData(ironfoyjbylsbpzzyk.getDuser());
    	List<Ironfoyjbylsbpzzyk> pageList = new ArrayList<Ironfoyjbylsbpzzyk>();
    	List<String> str = null;
    	String title_id = null;
    	List<Ironfoyjbylsbpzzyk> datas = null;
    	try {
    		for (User user : userList) {
    			String userId = user.getId();
    			IronfoDocTitle title = ironfoDoc_Title_Service.getDocId(userId);
    			Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk1 = new Ironfoyjbylsbpzzyk();
    			if (title != null) {
    				title_id = title.getId();
    				ironfoyjbylsbpzzyk1.setDocId(title_id);
    				//获取所有数据list
    				List<Ironfoyjbylsbpzzyk> list=ironfoyjbylsbpzzykService.findList(ironfoyjbylsbpzzyk1);
    				if(list!=null && list.size()>0){
    					Collections.sort(list,new Comparator<Ironfoyjbylsbpzzyk>(){
    			            public int compare(Ironfoyjbylsbpzzyk arg0, Ironfoyjbylsbpzzyk arg1) {
    			                return arg0.getSbmc().compareTo(arg1.getSbmc());
    			            }
    			        });
    					list.get(0).setDuser(user);
    					pageList.addAll(list);
    					//获取存在数据的用户下面的list
    					if(datas == null){
        					datas = list;
        				}
    				}
    			}
    		}
    		String fileName = "中医科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
    		int strSize = 0;
    		//List<Object[]> clsList = AnnotationForClass.class.newInstance().getAnnotationList(ironfoyjbylsbpzzyk.getClass());
    		List<Ironfoyjbylsbpzzyk> pageList1 = new ArrayList<Ironfoyjbylsbpzzyk>();
    		Ironfoyjbylsbpzzyk test = null;
    		if (datas.size() > 0 ) {
    			str = new ArrayList<String>();
    			for (int i = 0; i < datas.size(); i++) {
    				test = new  Ironfoyjbylsbpzzyk();
    				str.add(datas.get(i).getSbmc());
    			}
    		}
//    			else{
//    			//用户此报表都不存在数据
//    			return null;
//    		}
    		ExportExcel exl = new ExportExcel("中医科", Ironfoyjbylsbpzzyk.class, str);
    		strSize = exl.getAnnotationList().size() * str.size();
    		exl.setDataList(pageList, strSize)
    		.write(response, fileName).dispose();
    	} catch (Exception e) {
    		//System.out.println("eee---->" + e);
    		 addMessage(redirectAttributes, "导出中医科记录失败！失败信息："+e.getMessage());
    	}
    	return "redirect:" + Global.getAdminPath() + "/report/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
    }


	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzzyk> list = ei.getDataList(Ironfoyjbylsbpzzyk.class);
			for (Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk : list){
				try{
					ironfoyjbylsbpzzykService.save(ironfoyjbylsbpzzyk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条中医科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条中医科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入中医科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/?repage";
    }
	
	/**
	 * 下载导入中医科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzzyk:ironfoyjbylsbpzzyk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "中医科数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzzyk> list = Lists.newArrayList(); 
    		new ExportExcel("中医科数据", Ironfoyjbylsbpzzyk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/?repage";
    }
	
	
	

}