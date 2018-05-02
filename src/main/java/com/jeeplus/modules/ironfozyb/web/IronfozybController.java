/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfozyb.web;

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
import com.jeeplus.modules.ironfoyjbylsbpzkfk.entity.Ironfoyjbylsbpzkfk;
import com.jeeplus.modules.ironfozyb.entity.Ironfozyb;
import com.jeeplus.modules.ironfozyb.service.IronfozybService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOKFS;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOZYBGL;

/**
 * 3.3住院部医疗设备配置Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfozyb/ironfozyb")
public class IronfozybController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfozybService ironfozybService;
	
	@ModelAttribute
	public Ironfozyb get(@RequestParam(required=false) String id) {
		Ironfozyb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfozybService.get(id);
		}
		if (entity == null){
			entity = new Ironfozyb();
		}
		return entity;
	}
	
	/**
	 * 3.3住院部医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfozyb:ironfozyb:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfozyb ironfozyb, HttpServletRequest request, HttpServletResponse response, Model model) {


		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
//		String type = request.getParameter("type");
		

		
		
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
			

			ironfozyb.setDoc_id(docList.get(0).getId().toString());
			List<Ironfozyb> data = ironfozybService.queryForList(ironfozyb);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfozyb room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
//				if("----".trim()==room.getIsnull().trim()||"----".trim().equals(room.getIsnull().trim())) {
//					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_isnull", "");
//				}else {
//					datas.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_isnull", room.getIsnull());
//				}
				
				listData.put(EnumUtils.IRONFOZYBGL.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
		}else {
			
			

			for(IRONFOZYBGL jz :EnumUtils.IRONFOZYBGL.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_sbmc", "");
				datas.put(jz.toString().toLowerCase()+"_pp", "");
				datas.put(jz.toString().toLowerCase()+"_xh", "");
				datas.put(jz.toString().toLowerCase()+"_sl", "");
				datas.put(jz.toString().toLowerCase()+"_sbjg", "");
				datas.put(jz.toString().toLowerCase()+"_trsynf", "");
//				datas.put(jz.toString().toLowerCase()+"_isnull", "");
//				listData.add(datas);
				listData.put(jz.toString().toLowerCase(), datas);
			}
			
			
			
		}
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		
		
		
		
		return "modules/ironfozyb/ironfozybList";
	}

	/**
	 * 查看，增加，编辑3.3住院部医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfozyb:ironfozyb:view","ironfozyb:ironfozyb:add","ironfozyb:ironfozyb:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfozyb ironfozyb, Model model) {
		model.addAttribute("ironfozyb", ironfozyb);
		return "modules/ironfozyb/ironfozybForm";
	}

	/**
	 * 保存3.3住院部医疗设备配置
	 */
	@RequiresPermissions(value={"ironfozyb:ironfozyb:add","ironfozyb:ironfozyb:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfozyb ironfozyb, Model model, RedirectAttributes redirectAttributes) throws Exception{

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
			
			ironfozyb.setDoc_id(docId);
			List<Ironfozyb> ironfoList = ironfozybService.queryForList(ironfozyb);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfozyb ironfozyb_data=null;
		
		
		if(isnull == false) {
			//更新
			int i=1;
			ironfozyb_data = new Ironfozyb();
			for(int j=0;j<EnumUtils.ZYB.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.ZYB[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.ZYB[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfozyb.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfozyb_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfozyb_data.setDoc_id(docId); 
									ironfozybService.save(ironfozyb_data);//保存
									i = 1;
									ironfozyb_data = new Ironfozyb();
							}	
						}	
					}	
				}	
			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfozyb_data = new Ironfozyb();
			for(int j=0;j<EnumUtils.ZYB.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.ZYB[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.ZYB[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfozyb_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfozyb.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfozyb_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfozyb_data.setDoc_id(docId); 
									ironfozybService.updateIronfo(ironfozyb_data);//保存
									i = 1;
									ironfozyb_data = new Ironfozyb();
							}	
						}	
					}	
				}	
			}	
				
			
		}
	
		
	 
	
	
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfozyb/ironfozyb/?repage";
	}
	
	/**
	 * 删除3.3住院部医疗设备配置
	 */
	@RequiresPermissions("ironfozyb:ironfozyb:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfozyb ironfozyb, RedirectAttributes redirectAttributes) {
		ironfozybService.delete(ironfozyb);
		addMessage(redirectAttributes, "删除3.3住院部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfozyb/ironfozyb/?repage";
	}
	
	/**
	 * 批量删除3.3住院部医疗设备配置
	 */
	@RequiresPermissions("ironfozyb:ironfozyb:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfozybService.delete(ironfozybService.get(id));
		}
		addMessage(redirectAttributes, "删除3.3住院部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfozyb/ironfozyb/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfozyb:ironfozyb:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfozyb ironfozyb, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.3住院部医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfozyb> page = ironfozybService.findPage(new Page<Ironfozyb>(request, response, -1), ironfozyb);
    		new ExportExcel("3.3住院部医疗设备配置", Ironfozyb.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出3.3住院部医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfozyb/ironfozyb/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfozyb:ironfozyb:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfozyb> list = ei.getDataList(Ironfozyb.class);
			for (Ironfozyb ironfozyb : list){
				try{
					ironfozybService.save(ironfozyb);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条3.3住院部医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条3.3住院部医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入3.3住院部医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfozyb/ironfozyb/?repage";
    }
	
	/**
	 * 下载导入3.3住院部医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfozyb:ironfozyb:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.3住院部医疗设备配置数据导入模板.xlsx";
    		List<Ironfozyb> list = Lists.newArrayList(); 
    		new ExportExcel("3.3住院部医疗设备配置数据", Ironfozyb.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfozyb/ironfozyb/?repage";
    }
	
	
	

}