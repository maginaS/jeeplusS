/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzjyk.web;

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
import com.jeeplus.modules.ironfoyjbylsbpzjyk.entity.Ironfoyjbylsbpzjyk;
import com.jeeplus.modules.ironfoyjbylsbpzjyk.service.IronfoyjbylsbpzjykService;
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOJYK;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOKQK;

/**
 * 检验科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk")
public class IronfoyjbylsbpzjykController extends BaseController {
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;


	@Autowired
	private IronfoyjbylsbpzjykService ironfoyjbylsbpzjykService;
	
	@ModelAttribute
	public Ironfoyjbylsbpzjyk get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzjyk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzjykService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzjyk();
		}
		return entity;
	}
	
	/**
	 * 检验科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk, HttpServletRequest request, HttpServletResponse response, Model model) {
		
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
			
			

			ironfoyjbylsbpzjyk.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzjyk> data = ironfoyjbylsbpzjykService.queryForList(ironfoyjbylsbpzjyk);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzjyk room : data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOJYK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
		}else {
			
			for(IRONFOJYK jz :EnumUtils.IRONFOJYK.values()) {
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
		
		return "modules/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjykList";
	}

	/**
	 * 查看，增加，编辑检验科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:view","ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:add","ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk, Model model) {
		model.addAttribute("ironfoyjbylsbpzjyk", ironfoyjbylsbpzjyk);
		return "modules/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjykForm";
	}

	/**
	 * 保存检验科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:add","ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		 String[] SBMC = new String[] {"qzdshfxy",
				 "hxfgmyfxy","lsxby","xxbfxy","xyfxy",
				 "xqfxy","xxjdy","gsldlxj","ymjdxpyy","nczfxy",
				 "pcry","eyhtpyx","mbfxy","xbj","cmcfydbfxy","thxhdbfxy",
				 "dwbx","nyfxy","swxwj","swaqg","styz","lxj",
				 "xkbx","ztxyhsxt","xyfzy","bdmhsb","xyrhx","qtqzm"};
		
		 
		 
		 
		 boolean isnull=false;
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			
			
			
			Subject subject = SecurityUtils.getSubject();  
			Principal obj = (Principal) subject.getPrincipal();
			
			System.out.println(obj.getId());
			
			Map<String,Object> map = new  TreeMap<String,Object>();
			String data = request.getParameter("datas");
			String[] ironfoyjbylsbpzjyks = data.split(";");
			
			
			String docId = "";
			for(int i=0;i<ironfoyjbylsbpzjyks.length;i++) {
//				if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//					map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//				}else {
					map.put(ironfoyjbylsbpzjyks[i].toString().split(":")[0].toString(),ironfoyjbylsbpzjyks[i].toString().split(":")[1].toString());
					if("docId" == ironfoyjbylsbpzjyks[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoyjbylsbpzjyks[i].toString().trim().split(":")[0].toString().trim())) {
						docId = ironfoyjbylsbpzjyks[i].toString().split(":")[1].toString();
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
				
				ironfoyjbylsbpzjyk.setDoc_id(docId);
				List<Ironfoyjbylsbpzjyk> ironfoList = ironfoyjbylsbpzjykService.queryForList(ironfoyjbylsbpzjyk);
				if(ironfoList.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}
			
			
			Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk_data = null;
			
			
			
			if(isnull == false) {
				//更新
				int i=1;
				ironfoyjbylsbpzjyk_data = new Ironfoyjbylsbpzjyk();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzjyk.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzjyk_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzjyk_data.setDoc_id(docId); 
										ironfoyjbylsbpzjykService.save(ironfoyjbylsbpzjyk_data);//保存
										i = 1;
										ironfoyjbylsbpzjyk_data = new Ironfoyjbylsbpzjyk();
								}	
							}	
						}	
					}	
				}	
				
				
			}else if(isnull == true){
				
				
				//更新
				int i=1;
				ironfoyjbylsbpzjyk_data = new Ironfoyjbylsbpzjyk();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								ironfoyjbylsbpzjyk_data.setId(entry.getValue().toString());
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzjyk.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzjyk_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzjyk_data.setDoc_id(docId); 
										ironfoyjbylsbpzjykService.save(ironfoyjbylsbpzjyk_data);//保存
										i = 1;
										ironfoyjbylsbpzjyk_data = new Ironfoyjbylsbpzjyk();
								}	
							}	
						}	
					}	
				}	
			}
		 
		 
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/?repage";
	}
	
	/**
	 * 删除检验科
	 */
	@RequiresPermissions("ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzjykService.delete(ironfoyjbylsbpzjyk);
		addMessage(redirectAttributes, "删除检验科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/?repage";
	}
	
	/**
	 * 批量删除检验科
	 */
	@RequiresPermissions("ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzjykService.delete(ironfoyjbylsbpzjykService.get(id));
		}
		addMessage(redirectAttributes, "删除检验科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "检验科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoyjbylsbpzjyk> page = ironfoyjbylsbpzjykService.findPage(new Page<Ironfoyjbylsbpzjyk>(request, response, -1), ironfoyjbylsbpzjyk);
    		new ExportExcel("检验科", Ironfoyjbylsbpzjyk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出检验科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzjyk> list = ei.getDataList(Ironfoyjbylsbpzjyk.class);
			for (Ironfoyjbylsbpzjyk ironfoyjbylsbpzjyk : list){
				try{
					ironfoyjbylsbpzjykService.save(ironfoyjbylsbpzjyk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条检验科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条检验科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入检验科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/?repage";
    }
	
	/**
	 * 下载导入检验科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzjyk:ironfoyjbylsbpzjyk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "检验科数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzjyk> list = Lists.newArrayList(); 
    		new ExportExcel("检验科数据", Ironfoyjbylsbpzjyk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/?repage";
    }
	
	
	

}