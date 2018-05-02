/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzxdgys.web;

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
import com.jeeplus.modules.ironfoyjbylsbpzxdgys.entity.Ironfoyjbylsbpzxdgys;
import com.jeeplus.modules.ironfoyjbylsbpzxdgys.service.IronfoyjbylsbpzxdgysService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOKFS;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOXDGYS;

/**
 * 消毒供应室Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys")
public class IronfoyjbylsbpzxdgysController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzxdgysService ironfoyjbylsbpzxdgysService;
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfoyjbylsbpzxdgys get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzxdgys entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzxdgysService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzxdgys();
		}
		return entity;
	}
	
	/**
	 * 消毒供应室列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys, HttpServletRequest request, HttpServletResponse response, Model model) {
		

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
			
			


			ironfoyjbylsbpzxdgys.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzxdgys> data = ironfoyjbylsbpzxdgysService.queryForList(ironfoyjbylsbpzxdgys);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzxdgys room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOXDGYS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
			
		}else {
			
			for(IRONFOXDGYS jz :EnumUtils.IRONFOXDGYS.values()) {
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
		return "modules/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgysList";
	}

	/**
	 * 查看，增加，编辑消毒供应室表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:view","ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:add","ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys, Model model) {
		model.addAttribute("ironfoyjbylsbpzxdgys", ironfoyjbylsbpzxdgys);
		return "modules/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgysForm";
	}

	/**
	 * 保存消毒供应室
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:add","ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		String[] SBMC = new String[] {"hyywmjq",
				 "dwdlzmjq","ylzqmjq","qzdqxxdj","csqxj",
				 "sclzz","fkj","ksydq","qtqzm"};
		
		
		
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
				map.put(datas[i].toString().split(":")[0].toString(),datas[i].toString().split(":")[1].toString());
				if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
					docId = datas[i].toString().split(":")[1].toString();
				}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfoyjbylsbpzxdgys.setDoc_id(docId);
			List<Ironfoyjbylsbpzxdgys> ironfoList = ironfoyjbylsbpzxdgysService.queryForList(ironfoyjbylsbpzxdgys);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		
		Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys_data = null;
		
		
		if(isnull == false) {
			//更新
			int i=1;
			ironfoyjbylsbpzxdgys_data = new Ironfoyjbylsbpzxdgys();
			for(int j=0;j<SBMC.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzxdgys.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoyjbylsbpzxdgys_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoyjbylsbpzxdgys_data.setDoc_id(docId); 
									ironfoyjbylsbpzxdgysService.save(ironfoyjbylsbpzxdgys_data);//保存
									i = 1;
									ironfoyjbylsbpzxdgys_data = new Ironfoyjbylsbpzxdgys();
							}	
						}	
					}	
				}	
			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfoyjbylsbpzxdgys_data = new Ironfoyjbylsbpzxdgys();
			for(int j=0;j<SBMC.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfoyjbylsbpzxdgys_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzxdgys.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoyjbylsbpzxdgys_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoyjbylsbpzxdgys_data.setDoc_id(docId); 
									ironfoyjbylsbpzxdgysService.updateIronfo(ironfoyjbylsbpzxdgys_data);//保存
									i = 1;
									ironfoyjbylsbpzxdgys_data = new Ironfoyjbylsbpzxdgys();
							}	
						}	
					}	
				}	
			}	
				
			
		}
	
		
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/?repage";
	}
	
	/**
	 * 删除消毒供应室
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzxdgysService.delete(ironfoyjbylsbpzxdgys);
		addMessage(redirectAttributes, "删除消毒供应室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/?repage";
	}
	
	/**
	 * 批量删除消毒供应室
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzxdgysService.delete(ironfoyjbylsbpzxdgysService.get(id));
		}
		addMessage(redirectAttributes, "删除消毒供应室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "消毒供应室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoyjbylsbpzxdgys> page = ironfoyjbylsbpzxdgysService.findPage(new Page<Ironfoyjbylsbpzxdgys>(request, response, -1), ironfoyjbylsbpzxdgys);
    		new ExportExcel("消毒供应室", Ironfoyjbylsbpzxdgys.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出消毒供应室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzxdgys> list = ei.getDataList(Ironfoyjbylsbpzxdgys.class);
			for (Ironfoyjbylsbpzxdgys ironfoyjbylsbpzxdgys : list){
				try{
					ironfoyjbylsbpzxdgysService.save(ironfoyjbylsbpzxdgys);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条消毒供应室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条消毒供应室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入消毒供应室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/?repage";
    }
	
	/**
	 * 下载导入消毒供应室数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgys:ironfoyjbylsbpzxdgys:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "消毒供应室数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzxdgys> list = Lists.newArrayList(); 
    		new ExportExcel("消毒供应室数据", Ironfoyjbylsbpzxdgys.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/?repage";
    }
	
	
	

}