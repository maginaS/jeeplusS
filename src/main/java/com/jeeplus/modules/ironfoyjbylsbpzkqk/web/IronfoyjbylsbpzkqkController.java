/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzkqk.web;

import java.lang.reflect.Method;
import java.util.ArrayList;
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
import com.jeeplus.common.config.Global;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.service.IronfoyjbylsbpzkqkService;
import com.jeeplus.modules.sys.dao.UserDao;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOKQK;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 * 口腔科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk")
public class IronfoyjbylsbpzkqkController extends BaseController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;


	@Autowired
	private IronfoyjbylsbpzkqkService ironfoyjbylsbpzkqkService;
	
	@ModelAttribute
	public Ironfoyjbylsbpzkqk get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzkqk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzkqkService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzkqk();
		}
		return entity;
	}
	
	/**
	 * 口腔科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk, HttpServletRequest request, HttpServletResponse response, Model model) {

		
		
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

			ironfoyjbylsbpzkqk.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzkqk> data = ironfoyjbylsbpzkqkService.queryForList(ironfoyjbylsbpzkqk);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzkqk room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOKQK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
		}else {
			for(IRONFOKQK jz :EnumUtils.IRONFOKQK.values()) {
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
		
		
		//		Page<Ironfoyjbylsbpzkqk> page = ironfoyjbylsbpzkqkService.findPage(new Page<Ironfoyjbylsbpzkqk>(request, response), ironfoyjbylsbpzkqk); 
//		model.addAttribute("page", page);
		return "modules/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqkList";
	}

	/**
	 * 查看，增加，编辑口腔科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:view","ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:add","ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk, Model model) {
		model.addAttribute("ironfoyjbylsbpzkqk", ironfoyjbylsbpzkqk);
		return "modules/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqkForm";
	}

	/**
	 * 保存口腔科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:add","ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
		 String[] SBMC = new String[] {"zxsct",
				 "ypcxxt","kqnkjxt","ykzhzlt","ntggybxt",
				 "ryjggxt","bjym","kqszymy","yksj","sjqxzyj",
				 "psjyj","kqymj","jgdmj","jgt","qtqzm"};
		 
		 
		 
			boolean isnull=false;
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			
			
			
			Subject subject = SecurityUtils.getSubject();  
			Principal obj = (Principal) subject.getPrincipal();
			
			System.out.println(obj.getId());
			
			Map<String,Object> map = new  TreeMap<String,Object>();
			String data = request.getParameter("datas");
			String[] ironfoyjbylsbpzkqks = data.split(";");
			
			
			String docId = "";
			for(int i=0;i<ironfoyjbylsbpzkqks.length;i++) {
//				if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//					map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//				}else {
					map.put(ironfoyjbylsbpzkqks[i].toString().split(":")[0].toString(),ironfoyjbylsbpzkqks[i].toString().split(":")[1].toString());
					if("docId" == ironfoyjbylsbpzkqks[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoyjbylsbpzkqks[i].toString().trim().split(":")[0].toString().trim())) {
						docId = ironfoyjbylsbpzkqks[i].toString().split(":")[1].toString();
					}
					
//				}
				
			}
			
			if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
	 			isnull = false;
	 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
	 			title.setRemarks(obj.getId());
	 			
	 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
	 			docId= docList.get(0).getId().toString();
	 			
			}else {
				
				ironfoyjbylsbpzkqk.setDoc_id(docId);
				List<Ironfoyjbylsbpzkqk> ironfoList = ironfoyjbylsbpzkqkService.queryForList(ironfoyjbylsbpzkqk);
				if(ironfoList.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}
			
		 
			Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk_data = null;
			if(isnull == false) {
				//更新
				int i=1;
				ironfoyjbylsbpzkqk_data = new Ironfoyjbylsbpzkqk();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzkqk.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzkqk_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzkqk_data.setDoc_id(docId); 
										ironfoyjbylsbpzkqkService.save(ironfoyjbylsbpzkqk_data);//保存
										i = 1;
										ironfoyjbylsbpzkqk_data = new Ironfoyjbylsbpzkqk();
								}	
							}	
						}	
					}	
				}	
				
				
			}else if(isnull == true){
				
				
				//更新
				int i=1;
				ironfoyjbylsbpzkqk_data = new Ironfoyjbylsbpzkqk();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								ironfoyjbylsbpzkqk_data.setId(entry.getValue().toString());
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzkqk.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzkqk_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzkqk_data.setDoc_id(docId); 
										ironfoyjbylsbpzkqkService.updateIronfo(ironfoyjbylsbpzkqk_data);//保存
										i = 1;
										ironfoyjbylsbpzkqk_data = new Ironfoyjbylsbpzkqk();
								}	
							}	
						}	
					}	
				}	
				
				
				
				
			}
		 
		
		
//		if (!beanValidator(model, ironfoyjbylsbpzkqk)){
//			return form(ironfoyjbylsbpzkqk, model);
//		}
//		if(!ironfoyjbylsbpzkqk.getIsNewRecord()){//编辑表单保存
//			Ironfoyjbylsbpzkqk t = ironfoyjbylsbpzkqkService.get(ironfoyjbylsbpzkqk.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzkqk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfoyjbylsbpzkqkService.save(t);//保存
//		}else{//新增表单保存
//			ironfoyjbylsbpzkqkService.save(ironfoyjbylsbpzkqk);//保存
//		}
//		addMessage(redirectAttributes, "保存口腔科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
	}
	
	/**
	 * 删除口腔科
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzkqkService.delete(ironfoyjbylsbpzkqk);
		addMessage(redirectAttributes, "删除口腔科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
	}
	
	/**
	 * 批量删除口腔科
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzkqkService.delete(ironfoyjbylsbpzkqkService.get(id));
		}
		addMessage(redirectAttributes, "删除口腔科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
	}
	
//	/**
//	 * 导出excel文件
//	 */
//	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:export")
//    @RequestMapping(value = "export", method=RequestMethod.POST)
//    public String exportFile(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = "口腔科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfoyjbylsbpzkqk> page = ironfoyjbylsbpzkqkService.findPage(new Page<Ironfoyjbylsbpzkqk>(request, response, -1), ironfoyjbylsbpzkqk);
//    		new ExportExcel("口腔科", Ironfoyjbylsbpzkqk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出口腔科记录失败！失败信息："+e.getMessage());
//		}
//		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
//    }
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		// 查找出所有用户
    	List<User> userList = userDao.findUserData(ironfoyjbylsbpzkqk.getDuser());
    	List<Ironfoyjbylsbpzkqk> pageList = new ArrayList<Ironfoyjbylsbpzkqk>();
    	String[] str = null;
    	String title_id = null;
    	List<Ironfoyjbylsbpzkqk> datas = null;
    	try {
    		for (User user : userList) {
    			String userId = user.getId();
    			IronfoDocTitle title = ironfoDoc_Title_Service.getDocId(userId);
    			Ironfoyjbylsbpzkqk ironfoyjbylsbpzzyk1 = new Ironfoyjbylsbpzkqk();
    			if (title != null) {
    				title_id = title.getId();
    				ironfoyjbylsbpzzyk1.setDoc_id(title_id);
    				//获取所有数据list
    				List<Ironfoyjbylsbpzkqk> list=ironfoyjbylsbpzkqkService.findList(ironfoyjbylsbpzzyk1);
    				if(list!=null && list.size()>0){
    					list.get(0).setDuser(user);
    					pageList.addAll(list);
    					//获取存在数据的用户下面的list
    					if(datas == null){
        					datas = list;
        				}
    				}
    			}
    		}
    		String fileName = "口腔科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
    		int strSize = 0;
    		if (datas.size() > 0 ) {
    			str = new String[datas.size()];
    			for (int i = 0; i < datas.size(); i++) {
    				str[i] = datas.get(i).getSbmc();
    			}
    		}else{
    			//用户此报表都不存在数据
    			return null;
    		}
//    		ExportExcel exl = new ExportExcel("口腔科", Ironfoyjbylsbpzkqk.class, str);
//    		strSize = exl.getAnnotationList().size() * str.length;
//    		exl.setDataList(pageList, strSize)
//    		.write(response, fileName).dispose();
    	} catch (Exception e) {
    		//System.out.println("eee---->" + e);
    		 addMessage(redirectAttributes, "导出口腔科记录失败！失败信息："+e.getMessage());
    	}
//		try {
//            String fileName = "口腔科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfoyjbylsbpzkqk> page = ironfoyjbylsbpzkqkService.findPage(new Page<Ironfoyjbylsbpzkqk>(request, response, -1), ironfoyjbylsbpzkqk);
//    		new ExportExcel("口腔科", Ironfoyjbylsbpzkqk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出口腔科记录失败！失败信息："+e.getMessage());
//		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzkqk> list = ei.getDataList(Ironfoyjbylsbpzkqk.class);
			for (Ironfoyjbylsbpzkqk ironfoyjbylsbpzkqk : list){
				try{
					ironfoyjbylsbpzkqkService.save(ironfoyjbylsbpzkqk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条口腔科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条口腔科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入口腔科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
    }
	
	/**
	 * 下载导入口腔科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqk:ironfoyjbylsbpzkqk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "口腔科数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzkqk> list = Lists.newArrayList(); 
    		new ExportExcel("口腔科数据", Ironfoyjbylsbpzkqk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/?repage";
    }
	
	
	

}