/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzqkyxk.web;

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
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.entity.Ironfoyjbylsbpzqkyxk;
import com.jeeplus.modules.ironfoyjbylsbpzqkyxk.service.IronfoyjbylsbpzqkyxkService;
import com.jeeplus.modules.sys.dao.UserDao;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 * 全科医学科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk")
public class IronfoyjbylsbpzqkyxkController extends BaseController {

	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private IronfoyjbylsbpzqkyxkService ironfoyjbylsbpzqkyxkService;
	
	@ModelAttribute
	public Ironfoyjbylsbpzqkyxk get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzqkyxk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzqkyxkService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzqkyxk();
		}
		return entity;
	}
	
	/**
	 * 全科医学科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk, HttpServletRequest request, HttpServletResponse response, Model model) {

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
		
		IronfoDocTitle title = null;;
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
			
			ironfoyjbylsbpzqkyxk.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzqkyxk> data = ironfoyjbylsbpzqkyxkService.queryForList(ironfoyjbylsbpzqkyxk);
		
			
			listData.put("doc_id", docList.get(0).getId().toString());
			
			for(Ironfoyjbylsbpzqkyxk k : data) {
				
				datas = new TreeMap<String,Object>();
				
				if("----".trim()==k.getId().trim()||"----".trim().equals(k.getId().trim())) {
					datas.put("qkyxk_id", "");
				}else{
					datas.put("qkyxk_id", k.getId());
				}
				
				if("----".trim()==k.getPp().trim()||"----".trim().equals(k.getPp().trim())) {
					datas.put("qkyxk_pp", "");
				}else {
					datas.put("qkyxk_pp", k.getPp());
				}
				
				if("----".trim()==k.getSbjg().trim()||"----".trim().equals(k.getSbjg().trim())) {
					datas.put("qkyxk_sbjg", "");
				}else {
					datas.put("qkyxk_sbjg", k.getSbjg());

				}
				
				if("----".trim() == k.getSl().trim()||"----".trim().equals(k.getSl().trim())) {
					datas.put("qkyxk_sl", "");
				}else {
					datas.put("qkyxk_sl", k.getSl());

				}
				
				if("----".trim()==k.getXh().trim()||"----".trim().equals(k.getXh().trim())) {
					datas.put("qkyxk_xh", "");
				}else {
					datas.put("qkyxk_xh",k.getXh());
				}
				
				if("----".trim()==k.getTrsynf().trim()||"----".trim().equals(k.getTrsynf().trim())) {
					datas.put("qkyxk_trsynf", "");
				}else {
					datas.put("qkyxk_trsynf", k.getTrsynf());
				}
				
				listData.put("qkyxk", datas);

			}
			
			
			
			
		}else {
			
//			for(IRONFOQKYXK jz :EnumUtils.IRONFOQKYXK.values()) {
				datas = new TreeMap<String,Object>();
				datas.put("qkyxk_id", "");
				datas.put("qkyxk_sbmc", "");
				datas.put("qkyxk_pp", "");
				datas.put("qkyxk_xh", "");
				datas.put("qkyxk_sl", "");
				datas.put("qkyxk_sbjg", "");
				datas.put("qkyxk_trsynf", "");
//				listData.add(datas);
				listData.put("qkyxk", datas);
			}
//		}
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		//		Page<Ironfoyjbylsbpzqkyxk> page = ironfoyjbylsbpzqkyxkService.findPage(new Page<Ironfoyjbylsbpzqkyxk>(request, response), ironfoyjbylsbpzqkyxk); 
//		model.addAttribute("page", page);
		return "modules/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxkList";
	}

	/**
	 * 查看，增加，编辑全科医学科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:view","ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:add","ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk, Model model) {
		model.addAttribute("ironfoyjbylsbpzqkyxk", ironfoyjbylsbpzqkyxk);
		return "modules/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxkForm";
	}

	/**
	 * 保存全科医学科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:add","ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk, Model model, RedirectAttributes redirectAttributes) throws Exception{

		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfoyjbylsbpzqkyxks = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<ironfoyjbylsbpzqkyxks.length;i++) {
				map.put(ironfoyjbylsbpzqkyxks[i].toString().split(":")[0].toString(),ironfoyjbylsbpzqkyxks[i].toString().split(":")[1].toString());
				if("docId" == ironfoyjbylsbpzqkyxks[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoyjbylsbpzqkyxks[i].toString().trim().split(":")[0].toString().trim())) {
					docId = ironfoyjbylsbpzqkyxks[i].toString().split(":")[1].toString();
				}
		}
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			ironfoyjbylsbpzqkyxk.setDoc_id(docId);
			List<Ironfoyjbylsbpzqkyxk> ironfoList = ironfoyjbylsbpzqkyxkService.queryForList(ironfoyjbylsbpzqkyxk);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
		}
		
		
		
		Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk_data = null;
		
		if(isnull == false) {
			int i=1;
			ironfoyjbylsbpzqkyxk_data = new Ironfoyjbylsbpzqkyxk();
			for(Map.Entry<String, Object> entry :map.entrySet()) {
				if("qkyxk".toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||"qkyxk".toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
				
					if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
						
					}else {
						Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzqkyxk.class,entry.getKey().toString().trim().split("_")[1].toString().trim());
						m.invoke(ironfoyjbylsbpzqkyxk_data, new Object[]{entry.getValue()} );
						i++;
						if(i==7) {
							ironfoyjbylsbpzqkyxk_data.setDoc_id(docId);
							ironfoyjbylsbpzqkyxkService.save(ironfoyjbylsbpzqkyxk_data);//保存
							i = 1;
							ironfoyjbylsbpzqkyxk_data = new Ironfoyjbylsbpzqkyxk();
						}
						
					}	
				}	
			}
			
		}else if(isnull == true) {
			

			int i=1;
			ironfoyjbylsbpzqkyxk_data = new Ironfoyjbylsbpzqkyxk();
			for(Map.Entry<String, Object> entry :map.entrySet()) {
				if("qkyxk".toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||"qkyxk".toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
				
					if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
						ironfoyjbylsbpzqkyxk_data.setId(entry.getValue().toString());
					}else {
						Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzqkyxk.class,entry.getKey().toString().trim().split("_")[1].toString().trim());
						m.invoke(ironfoyjbylsbpzqkyxk_data, new Object[]{entry.getValue()} );
						i++;
						if(i==7) {
							ironfoyjbylsbpzqkyxk_data.setDoc_id(docId);
							ironfoyjbylsbpzqkyxkService.updateIronfo(ironfoyjbylsbpzqkyxk_data);
							i = 1;
							ironfoyjbylsbpzqkyxk_data = new Ironfoyjbylsbpzqkyxk();
						}
						
					}	
				}	
			}	
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
	}
	
	/**
	 * 删除全科医学科
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzqkyxkService.delete(ironfoyjbylsbpzqkyxk);
		addMessage(redirectAttributes, "删除全科医学科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
	}
	
	/**
	 * 批量删除全科医学科
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzqkyxkService.delete(ironfoyjbylsbpzqkyxkService.get(id));
		}
		addMessage(redirectAttributes, "删除全科医学科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
	}
	
//	/**
//	 * 导出excel文件
//	 */
//	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:export")
//    @RequestMapping(value = "export", method=RequestMethod.POST)
//    public String exportFile(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = "全科医学科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfoyjbylsbpzqkyxk> page = ironfoyjbylsbpzqkyxkService.findPage(new Page<Ironfoyjbylsbpzqkyxk>(request, response, -1), ironfoyjbylsbpzqkyxk);
//    		new ExportExcel("全科医学科", Ironfoyjbylsbpzqkyxk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出全科医学科记录失败！失败信息："+e.getMessage());
//		}
//		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
//    }
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = "全科医学科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Ironfoyjbylsbpzqkyxk> page = ironfoyjbylsbpzqkyxkService.findPage(new Page<Ironfoyjbylsbpzqkyxk>(request, response, -1), ironfoyjbylsbpzqkyxk);
//    		new ExportExcel("全科医学科", Ironfoyjbylsbpzqkyxk.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出全科医学科记录失败！失败信息："+e.getMessage());
//		}
		// 查找出所有用户
    	List<User> userList = userDao.findUserData(ironfoyjbylsbpzqkyxk.getDuser());
    	List<Ironfoyjbylsbpzqkyxk> pageList = new ArrayList<Ironfoyjbylsbpzqkyxk>();
    	String[] str = null;
    	String title_id = null;
    	List<Ironfoyjbylsbpzqkyxk> datas = null;
    	try {
    		for (User user : userList) {
    			String userId = user.getId();
    			IronfoDocTitle title = ironfoDoc_Title_Service.getDocId(userId);
    			Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzzyk1 = new Ironfoyjbylsbpzqkyxk();
    			if (title != null) {
    				title_id = title.getId();
    				ironfoyjbylsbpzzyk1.setDoc_id(title_id);
    				//获取所有数据list
    				List<Ironfoyjbylsbpzqkyxk> list=ironfoyjbylsbpzqkyxkService.findList(ironfoyjbylsbpzzyk1);
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
    		String fileName = "全科医学科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
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
//    		ExportExcel exl = new ExportExcel("全科医学科", Ironfoyjbylsbpzqkyxk.class, str);
//    		strSize = exl.getAnnotationList().size() * str.length;
//    		exl.setDataList(pageList, strSize)
//    		.write(response, fileName).dispose();
    	} catch (Exception e) {
    		//System.out.println("eee---->" + e);
    		 addMessage(redirectAttributes, "导出全科医学科记录失败！失败信息："+e.getMessage());
    	}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzqkyxk> list = ei.getDataList(Ironfoyjbylsbpzqkyxk.class);
			for (Ironfoyjbylsbpzqkyxk ironfoyjbylsbpzqkyxk : list){
				try{
					ironfoyjbylsbpzqkyxkService.save(ironfoyjbylsbpzqkyxk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条全科医学科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条全科医学科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入全科医学科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
    }
	
	/**
	 * 下载导入全科医学科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxk:ironfoyjbylsbpzqkyxk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "全科医学科数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzqkyxk> list = Lists.newArrayList(); 
    		new ExportExcel("全科医学科数据", Ironfoyjbylsbpzqkyxk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/?repage";
    }
	
	
	

}