/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.web;

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
import com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.entity.Ironfoyjbylsbpzgrxjbk;
import com.jeeplus.modules.ironfoyjbylsbpzgrxjbk.service.IronfoyjbylsbpzgrxjbkService;
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOGRXJBK;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOKFS;

/**
 * 感染性疾病科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk")
public class IronfoyjbylsbpzgrxjbkController extends BaseController {
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	

	@Autowired
	private IronfoyjbylsbpzgrxjbkService ironfoyjbylsbpzgrxjbkService;
	
	@ModelAttribute
	public Ironfoyjbylsbpzgrxjbk get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzgrxjbk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzgrxjbkService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzgrxjbk();
		}
		return entity;
	}
	
	/**
	 * 感染性疾病科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk, HttpServletRequest request, HttpServletResponse response, Model model) {

		
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
			
			


			ironfoyjbylsbpzgrxjbk.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzgrxjbk> data = ironfoyjbylsbpzgrxjbkService.queryForList(ironfoyjbylsbpzgrxjbk);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzgrxjbk room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOGRXJBK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
		}else {
			
			
			for(IRONFOGRXJBK jz :EnumUtils.IRONFOGRXJBK.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_sbmc", "");
				datas.put(jz.toString().toLowerCase()+"_pp", "");
				datas.put(jz.toString().toLowerCase()+"_xh", "");
				datas.put(jz.toString().toLowerCase()+"_sl", "");
				datas.put(jz.toString().toLowerCase()+"_sbjg", "");
				datas.put(jz.toString().toLowerCase()+"_trsynf", "");
				listData.put(jz.toString().toLowerCase(), datas);
			}
			
			
			
		}
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		return "modules/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbkList";
	}

	/**
	 * 查看，增加，编辑感染性疾病科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:view","ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:add","ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk, Model model) {
		model.addAttribute("ironfoyjbylsbpzgrxjbk", ironfoyjbylsbpzgrxjbk);
		return "modules/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbkForm";
	}

	/**
	 * 保存感染性疾病科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:add","ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
		
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
			
			ironfoyjbylsbpzgrxjbk.setDoc_id(docId);
			List<Ironfoyjbylsbpzgrxjbk> ironfoList = ironfoyjbylsbpzgrxjbkService.queryForList(ironfoyjbylsbpzgrxjbk);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk_data=null;
		
		
		
		if(isnull == false) {
			//更新
			int i=1;
			ironfoyjbylsbpzgrxjbk_data = new Ironfoyjbylsbpzgrxjbk();
			for(int j=0;j<EnumUtils.GRXJBK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.GRXJBK[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.GRXJBK[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzgrxjbk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoyjbylsbpzgrxjbk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoyjbylsbpzgrxjbk_data.setDoc_id(docId); 
									ironfoyjbylsbpzgrxjbkService.save(ironfoyjbylsbpzgrxjbk_data);//保存
									i = 1;
									ironfoyjbylsbpzgrxjbk_data = new Ironfoyjbylsbpzgrxjbk();
							}	
						}	
					}	
				}	
			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfoyjbylsbpzgrxjbk_data = new Ironfoyjbylsbpzgrxjbk();
			for(int j=0;j<EnumUtils.GRXJBK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.GRXJBK[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.GRXJBK[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfoyjbylsbpzgrxjbk_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzgrxjbk.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoyjbylsbpzgrxjbk_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoyjbylsbpzgrxjbk_data.setDoc_id(docId); 
									ironfoyjbylsbpzgrxjbkService.updateIronfo(ironfoyjbylsbpzgrxjbk_data);//保存
									i = 1;
									ironfoyjbylsbpzgrxjbk_data = new Ironfoyjbylsbpzgrxjbk();
							}	
						}	
					}	
				}	
			}	
				
			
		}
	
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/?repage";
	}
	
	/**
	 * 删除感染性疾病科
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzgrxjbkService.delete(ironfoyjbylsbpzgrxjbk);
		addMessage(redirectAttributes, "删除感染性疾病科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/?repage";
	}
	
	/**
	 * 批量删除感染性疾病科
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzgrxjbkService.delete(ironfoyjbylsbpzgrxjbkService.get(id));
		}
		addMessage(redirectAttributes, "删除感染性疾病科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "感染性疾病科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoyjbylsbpzgrxjbk> page = ironfoyjbylsbpzgrxjbkService.findPage(new Page<Ironfoyjbylsbpzgrxjbk>(request, response, -1), ironfoyjbylsbpzgrxjbk);
    		new ExportExcel("感染性疾病科", Ironfoyjbylsbpzgrxjbk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出感染性疾病科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzgrxjbk> list = ei.getDataList(Ironfoyjbylsbpzgrxjbk.class);
			for (Ironfoyjbylsbpzgrxjbk ironfoyjbylsbpzgrxjbk : list){
				try{
					ironfoyjbylsbpzgrxjbkService.save(ironfoyjbylsbpzgrxjbk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条感染性疾病科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条感染性疾病科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入感染性疾病科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/?repage";
    }
	
	/**
	 * 下载导入感染性疾病科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbk:ironfoyjbylsbpzgrxjbk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "感染性疾病科数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzgrxjbk> list = Lists.newArrayList(); 
    		new ExportExcel("感染性疾病科数据", Ironfoyjbylsbpzgrxjbk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/?repage";
    }
	
	
	

}