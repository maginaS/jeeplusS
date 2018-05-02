/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfo_yjbylsbpz_pfk.web;

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
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.service.Ironfo_yjbylsbpz_pfkService;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.sys.dao.UserDao;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOPFK;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 * 皮肤科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk")
public class Ironfo_yjbylsbpz_pfkController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private Ironfo_yjbylsbpz_pfkService ironfo_yjbylsbpz_pfkService;
	
	@ModelAttribute
	public Ironfo_yjbylsbpz_pfk get(@RequestParam(required=false) String id) {
		Ironfo_yjbylsbpz_pfk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfo_yjbylsbpz_pfkService.get(id);
		}
		if (entity == null){
			entity = new Ironfo_yjbylsbpz_pfk();
		}
		return entity;
	}
	
	/**
	 * 皮肤科列表页面
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk, HttpServletRequest request, HttpServletResponse response, Model model) {

		
		
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
			ironfo_yjbylsbpz_pfk.setDoc_id(docList.get(0).getId().toString());
			
			List<Ironfo_yjbylsbpz_pfk> data = ironfo_yjbylsbpz_pfkService.queryForList(ironfo_yjbylsbpz_pfk);

			
			listData.put("doc_id", docList.get(0).getId().toString());
			
			
			for(Ironfo_yjbylsbpz_pfk room :data) {
				datas = new TreeMap<String,Object>();
				
				
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOPFK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);

				
				
				
			}
			
			
			
			
		}else {
			
			
			for(IRONFOPFK jz :EnumUtils.IRONFOPFK.values()) {
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
		//		Page<Ironfo_yjbylsbpz_pfk> page = ironfo_yjbylsbpz_pfkService.findPage(new Page<Ironfo_yjbylsbpz_pfk>(request, response), ironfo_yjbylsbpz_pfk); 
//		model.addAttribute("page", page);
		return "modules/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfkList";
	}

	/**
	 * 查看，增加，编辑皮肤科表单页面
	 */
	@RequiresPermissions(value={"ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:view","ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:add","ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk, Model model) {
		model.addAttribute("ironfo_yjbylsbpz_pfk", ironfo_yjbylsbpz_pfk);
		return "modules/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfkForm";
	}

	/**
	 * 保存皮肤科
	 */
	@RequiresPermissions(value={"ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:add","ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk, Model model, RedirectAttributes redirectAttributes) throws Exception{

		 String[] SBMC = new String[] {"jgzly",
				 "hgzly","lgzly","zwzly","ytzlq",
				 "qtqzm"};
		 
		
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfo_yjbylsbpz_pfks = data.split(";");
		
		
		
		String docId = "";
		for(int i=0;i<ironfo_yjbylsbpz_pfks.length;i++) {
				map.put(ironfo_yjbylsbpz_pfks[i].toString().split(":")[0].toString(),ironfo_yjbylsbpz_pfks[i].toString().split(":")[1].toString());
				if("docId" == ironfo_yjbylsbpz_pfks[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfo_yjbylsbpz_pfks[i].toString().trim().split(":")[0].toString().trim())) {
					docId = ironfo_yjbylsbpz_pfks[i].toString().split(":")[1].toString();
				}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			ironfo_yjbylsbpz_pfk.setDoc_id(docId);
			List<Ironfo_yjbylsbpz_pfk> ironfoList = ironfo_yjbylsbpz_pfkService.queryForList(ironfo_yjbylsbpz_pfk);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
		}
		
		
		Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk_data =null;
		
		if(isnull == false) {
			//更新
			int i=1;
			ironfo_yjbylsbpz_pfk_data = new Ironfo_yjbylsbpz_pfk();
			for(int j=0;j<SBMC.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
								Method m = GetSetMethod.getSetMethod(Ironfo_yjbylsbpz_pfk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfo_yjbylsbpz_pfk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfo_yjbylsbpz_pfk_data.setDoc_id(docId); 
									ironfo_yjbylsbpz_pfkService.save(ironfo_yjbylsbpz_pfk_data);//保存
									i = 1;
									ironfo_yjbylsbpz_pfk_data = new Ironfo_yjbylsbpz_pfk();
							}	
						}	
					}	
				}	
			}	
		}else if(isnull == true) {
			
			
			//更新
			int i=1;
			ironfo_yjbylsbpz_pfk_data = new Ironfo_yjbylsbpz_pfk();
			for(int j=0;j<SBMC.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfo_yjbylsbpz_pfk_data.setId(entry.getValue().toString());
						}else {
								Method m = GetSetMethod.getSetMethod(Ironfo_yjbylsbpz_pfk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfo_yjbylsbpz_pfk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfo_yjbylsbpz_pfk_data.setDoc_id(docId); 
									ironfo_yjbylsbpz_pfkService.updateIronfo(ironfo_yjbylsbpz_pfk_data);//保存
									i = 1;
									ironfo_yjbylsbpz_pfk_data = new Ironfo_yjbylsbpz_pfk();
							}	
						}	
					}	
				}	
			}	
			
			
		}
		
		
		
		
		//		if (!beanValidator(model, ironfo_yjbylsbpz_pfk)){
//			return form(ironfo_yjbylsbpz_pfk, model);
//		}
//		if(!ironfo_yjbylsbpz_pfk.getIsNewRecord()){//编辑表单保存
//			Ironfo_yjbylsbpz_pfk t = ironfo_yjbylsbpz_pfkService.get(ironfo_yjbylsbpz_pfk.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfo_yjbylsbpz_pfk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfo_yjbylsbpz_pfkService.save(t);//保存
//		}else{//新增表单保存
//			ironfo_yjbylsbpz_pfkService.save(ironfo_yjbylsbpz_pfk);//保存
//		}
//		addMessage(redirectAttributes, "保存皮肤科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
	}
	
	/**
	 * 删除皮肤科
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk, RedirectAttributes redirectAttributes) {
		ironfo_yjbylsbpz_pfkService.delete(ironfo_yjbylsbpz_pfk);
		addMessage(redirectAttributes, "删除皮肤科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
	}
	
	/**
	 * 批量删除皮肤科
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfo_yjbylsbpz_pfkService.delete(ironfo_yjbylsbpz_pfkService.get(id));
		}
		addMessage(redirectAttributes, "删除皮肤科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
	}
	
//	/**
//	 * 导出excel文件
//	 */
//	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:export")
//    @RequestMapping(value = "export", method=RequestMethod.POST)
//    public String exportFile(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = "皮肤科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfo_yjbylsbpz_pfk> page = ironfo_yjbylsbpz_pfkService.findPage(new Page<Ironfo_yjbylsbpz_pfk>(request, response, -1), ironfo_yjbylsbpz_pfk);
//    		new ExportExcel("皮肤科", Ironfo_yjbylsbpz_pfk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出皮肤科记录失败！失败信息："+e.getMessage());
//		}
//		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
//    }
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		// 查找出所有用户
    	List<User> userList = userDao.findUserData(ironfo_yjbylsbpz_pfk.getDuser());
    	List<Ironfo_yjbylsbpz_pfk> pageList = new ArrayList<Ironfo_yjbylsbpz_pfk>();
    	String[] str = null;
    	String title_id = null;
    	List<Ironfo_yjbylsbpz_pfk> datas = null;
    	try {
    		for (User user : userList) {
    			String userId = user.getId();
    			IronfoDocTitle title = ironfoDoc_Title_Service.getDocId(userId);
    			Ironfo_yjbylsbpz_pfk ironfoyjbylsbpzzyk1 = new Ironfo_yjbylsbpz_pfk();
    			if (title != null) {
    				title_id = title.getId();
    				ironfoyjbylsbpzzyk1.setDoc_id(title_id);
    				//获取所有数据list
    				List<Ironfo_yjbylsbpz_pfk> list=ironfo_yjbylsbpz_pfkService.findList(ironfoyjbylsbpzzyk1);
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
    		String fileName = "皮肤科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
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
    		//ExportExcel exl = new ExportExcel("皮肤科", Ironfo_yjbylsbpz_pfk.class, str);
    		//strSize = exl.getAnnotationList().size() * str.length;
    		//exl.setDataList(pageList, strSize)
    		//.write(response, fileName).dispose();
    	} catch (Exception e) {
    		//System.out.println("eee---->" + e);
    		 addMessage(redirectAttributes, "导出皮肤科记录失败！失败信息："+e.getMessage());
    	}
//		try {
//            String fileName = "皮肤科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfo_yjbylsbpz_pfk> page = ironfo_yjbylsbpz_pfkService.findPage(new Page<Ironfo_yjbylsbpz_pfk>(request, response, -1), ironfo_yjbylsbpz_pfk);
//    		new ExportExcel("皮肤科", Ironfo_yjbylsbpz_pfk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出皮肤科记录失败！失败信息："+e.getMessage());
//		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfo_yjbylsbpz_pfk> list = ei.getDataList(Ironfo_yjbylsbpz_pfk.class);
			for (Ironfo_yjbylsbpz_pfk ironfo_yjbylsbpz_pfk : list){
				try{
					ironfo_yjbylsbpz_pfkService.save(ironfo_yjbylsbpz_pfk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条皮肤科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条皮肤科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入皮肤科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
    }
	
	/**
	 * 下载导入皮肤科数据模板
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk:ironfo_yjbylsbpz_pfk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "皮肤科数据导入模板.xlsx";
    		List<Ironfo_yjbylsbpz_pfk> list = Lists.newArrayList(); 
    		new ExportExcel("皮肤科数据", Ironfo_yjbylsbpz_pfk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/?repage";
    }
	
	
	

}