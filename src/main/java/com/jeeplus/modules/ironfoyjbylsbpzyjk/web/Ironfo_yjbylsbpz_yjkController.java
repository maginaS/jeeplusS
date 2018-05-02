/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzyjk.web;

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
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.service.Ironfo_yjbylsbpz_yjkService;
import com.jeeplus.modules.sys.dao.UserDao;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOYJK;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 *  药剂科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk")
public class Ironfo_yjbylsbpz_yjkController extends BaseController {

	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@Autowired
	private Ironfo_yjbylsbpz_yjkService ironfo_yjbylsbpz_yjkService;
	@Autowired
	private UserDao userDao;
	
	@ModelAttribute
	public Ironfo_yjbylsbpz_yjk get(@RequestParam(required=false) String id) {
		Ironfo_yjbylsbpz_yjk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfo_yjbylsbpz_yjkService.get(id);
		}
		if (entity == null){
			entity = new Ironfo_yjbylsbpz_yjk();
		}
		return entity;
	}
	
	/**
	 *  药剂科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk, HttpServletRequest request, HttpServletResponse response, Model model) {
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
			

			ironfo_yjbylsbpz_yjk.setDoc_id(docList.get(0).getId().toString());
			List<Ironfo_yjbylsbpz_yjk> data = ironfo_yjbylsbpz_yjkService.queryForList(ironfo_yjbylsbpz_yjk);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfo_yjbylsbpz_yjk room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOYJK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
			
			
		}else {
			


			for(IRONFOYJK jz :EnumUtils.IRONFOYJK.values()) {
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
		
		return "modules/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjkList";
	}

	/**
	 * 查看，增加，编辑 药剂科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:view","ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:add","ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk, Model model) {
		model.addAttribute("ironfo_yjbylsbpz_yjk", ironfo_yjbylsbpz_yjk);
		return "modules/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjkForm";
	}

	/**
	 * 保存 药剂科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:add","ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		

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
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfo_yjbylsbpz_yjk.setDoc_id(docId);
			List<Ironfo_yjbylsbpz_yjk> ironfoList = ironfo_yjbylsbpz_yjkService.queryForList(ironfo_yjbylsbpz_yjk);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk_data = null;
		
		


		if(isnull == false) {
			//更新
			int i=1;
			ironfo_yjbylsbpz_yjk_data = new Ironfo_yjbylsbpz_yjk();
			for(int j=0;j<EnumUtils.YJK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.YJK[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.YJK[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfo_yjbylsbpz_yjk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfo_yjbylsbpz_yjk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfo_yjbylsbpz_yjk_data.setDoc_id(docId); 
									ironfo_yjbylsbpz_yjkService.save(ironfo_yjbylsbpz_yjk_data);//保存
									i = 1;
									ironfo_yjbylsbpz_yjk_data = new Ironfo_yjbylsbpz_yjk();
							}	
						}	
					}	
				}	
			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfo_yjbylsbpz_yjk_data = new Ironfo_yjbylsbpz_yjk();
			for(int j=0;j<EnumUtils.YJK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.YJK[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.YJK[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfo_yjbylsbpz_yjk_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfo_yjbylsbpz_yjk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfo_yjbylsbpz_yjk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfo_yjbylsbpz_yjk_data.setDoc_id(docId); 
									ironfo_yjbylsbpz_yjkService.updateIronfo(ironfo_yjbylsbpz_yjk_data);//保存
									i = 1;
									ironfo_yjbylsbpz_yjk_data = new Ironfo_yjbylsbpz_yjk();
							}	
						}	
					}	
				}	
			}	
		}
	
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
	}
	
	/**
	 * 删除 药剂科
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk, RedirectAttributes redirectAttributes) {
		ironfo_yjbylsbpz_yjkService.delete(ironfo_yjbylsbpz_yjk);
		addMessage(redirectAttributes, "删除 药剂科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
	}
	
	/**
	 * 批量删除 药剂科
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfo_yjbylsbpz_yjkService.delete(ironfo_yjbylsbpz_yjkService.get(id));
		}
		addMessage(redirectAttributes, "删除 药剂科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
	}
	
//	/**
//	 * 导出excel文件
//	 */
//	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:export")
//    @RequestMapping(value = "export", method=RequestMethod.POST)
//    public String exportFile(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = " 药剂科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfo_yjbylsbpz_yjk> page = ironfo_yjbylsbpz_yjkService.findPage(new Page<Ironfo_yjbylsbpz_yjk>(request, response, -1), ironfo_yjbylsbpz_yjk);
//    		new ExportExcel(" 药剂科", Ironfo_yjbylsbpz_yjk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出 药剂科记录失败！失败信息："+e.getMessage());
//		}
//		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
//    }
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = " 药剂科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfo_yjbylsbpz_yjk> page = ironfo_yjbylsbpz_yjkService.findPage(new Page<Ironfo_yjbylsbpz_yjk>(request, response, -1), ironfo_yjbylsbpz_yjk);
//    		new ExportExcel(" 药剂科", Ironfo_yjbylsbpz_yjk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出 药剂科记录失败！失败信息："+e.getMessage());
//		}
		// 查找出所有用户
    	List<User> userList = userDao.findUserData(ironfo_yjbylsbpz_yjk.getDuser());
    	List<Ironfo_yjbylsbpz_yjk> pageList = new ArrayList<Ironfo_yjbylsbpz_yjk>();
    	List<String> str = null;
    	String title_id = null;
    	List<Ironfo_yjbylsbpz_yjk> datas = null;
    	try {
    		for (User user : userList) {
    			String userId = user.getId();
    			IronfoDocTitle title = ironfoDoc_Title_Service.getDocId(userId);
    			Ironfo_yjbylsbpz_yjk ironfoyjbylsbpzzyk1 = new Ironfo_yjbylsbpz_yjk();
    			if (title != null) {
    				title_id = title.getId();
    				ironfoyjbylsbpzzyk1.setDoc_id(title_id);
    				//获取所有数据list
    				List<Ironfo_yjbylsbpz_yjk> list=ironfo_yjbylsbpz_yjkService.findList(ironfoyjbylsbpzzyk1);
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
    		String fileName = "中医科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
    		int strSize = 0;
    		if (datas.size() > 0) {
    			str = new ArrayList<String>();
    			for (int i = 0; i < datas.size(); i++) {
    				str.add(datas.get(i).getSbmc());
    			}
    			strSize = 6 * str.size();
    			//strSize=5;
    		}else{
    			//用户此报表都不存在数据
    			return null;
    		}
    		new ExportExcel("中医科", Ironfo_yjbylsbpz_yjk.class, str).setDataList(pageList, strSize)
    		.write(response, fileName).dispose();
    	} catch (Exception e) {
    		//System.out.println("eee---->" + e);
    		 addMessage(redirectAttributes, "导出中医科记录失败！失败信息："+e.getMessage());
    	}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfo_yjbylsbpz_yjk> list = ei.getDataList(Ironfo_yjbylsbpz_yjk.class);
			for (Ironfo_yjbylsbpz_yjk ironfo_yjbylsbpz_yjk : list){
				try{
					ironfo_yjbylsbpz_yjkService.save(ironfo_yjbylsbpz_yjk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条 药剂科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条 药剂科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入 药剂科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
    }
	
	/**
	 * 下载导入 药剂科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjk:ironfo_yjbylsbpz_yjk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = " 药剂科数据导入模板.xlsx";
    		List<Ironfo_yjbylsbpz_yjk> list = Lists.newArrayList(); 
    		new ExportExcel(" 药剂科数据", Ironfo_yjbylsbpz_yjk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/?repage";
    }
	
	
	

}