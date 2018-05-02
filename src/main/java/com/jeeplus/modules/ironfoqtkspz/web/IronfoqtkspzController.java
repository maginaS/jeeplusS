/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoqtkspz.web;

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
import com.jeeplus.modules.ironfoqtkspz.entity.Ironfoqtkspz;
import com.jeeplus.modules.ironfoqtkspz.service.IronfoqtkspzService;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;

/**
 * 3.6其他科室医疗设备配置Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoqtkspz/ironfoqtkspz")
public class IronfoqtkspzController extends BaseController {

	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@Autowired
	private IronfoqtkspzService ironfoqtkspzService;
	
	@ModelAttribute
	public Ironfoqtkspz get(@RequestParam(required=false) String id) {
		Ironfoqtkspz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoqtkspzService.get(id);
		}
		if (entity == null){
			entity = new Ironfoqtkspz();
		}
		return entity;
	}
	
	/**
	 * 3.6其他科室医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfoqtkspz:ironfoqtkspz:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoqtkspz ironfoqtkspz, HttpServletRequest request, HttpServletResponse response, Model model) {
			
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
			
			ironfoqtkspz.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoqtkspz> data = ironfoqtkspzService.queryForList(ironfoqtkspz);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoqtkspz room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put("qtqzm_id", "");
				}else{
					datas.put("qtqzm_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put("qtqzm_pp", "");
				}else {
					datas.put("qtqzm_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put("qtqzm_sbjg", "");
				}else {
					datas.put("qtqzm_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put("qtqzm_sl", "");
				}else {
					datas.put("qtqzm_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put("qtqzm_xh", "");
				}else {
					datas.put("qtqzm_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put("qtqzm_trsynf", "");
				}else {
					datas.put("qtqzm_trsynf", room.getTrsynf());
				}
				
				listData.put("qtqzm", datas);
				
			}
		}else {
			datas = new TreeMap<String,Object>();
			datas.put("qtqzm_id", "");
			datas.put("qtqzm_sbmc", "");
			datas.put("qtqzm_pp", "");
			datas.put("qtqzm_xh", "");
			datas.put("qtqzm_sl", "");
			datas.put("qtqzm_sbjg", "");
			datas.put("qtqzm_trsynf", "");
//			listData.add(datas);
			listData.put("qtqzm", datas);
			
		}
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		return "modules/ironfoqtkspz/ironfoqtkspzList";
	}

	/**
	 * 查看，增加，编辑3.6其他科室医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfoqtkspz:ironfoqtkspz:view","ironfoqtkspz:ironfoqtkspz:add","ironfoqtkspz:ironfoqtkspz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoqtkspz ironfoqtkspz, Model model) {
		model.addAttribute("ironfoqtkspz", ironfoqtkspz);
		return "modules/ironfoqtkspz/ironfoqtkspzForm";
	}

	/**
	 * 保存3.6其他科室医疗设备配置
	 */
	@RequiresPermissions(value={"ironfoqtkspz:ironfoqtkspz:add","ironfoqtkspz:ironfoqtkspz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoqtkspz ironfoqtkspz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
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
			
			ironfoqtkspz.setDoc_id(docId);
			List<Ironfoqtkspz> ironfoList = ironfoqtkspzService.queryForList(ironfoqtkspz);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfoqtkspz ironfoqtkspz_data = null;
		


		if(isnull == false) {
			//更新
			int i=1;
			ironfoqtkspz_data = new Ironfoqtkspz();
//			for(int j=0;j<EnumUtils.YJK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if("qtqzm".toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||"qtqzm".toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoqtkspz.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoqtkspz_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoqtkspz_data.setDoc_id(docId); 
									ironfoqtkspzService.save(ironfoqtkspz_data);//保存
									i = 1;
									ironfoqtkspz_data = new Ironfoqtkspz();
							}	
						}	
					}	
				}	
//			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfoqtkspz_data = new Ironfoqtkspz();
//			for(int j=0;j<EnumUtils.YJK.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if("qtqzm".toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||"qtqzm".toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfoqtkspz_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoqtkspz.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoqtkspz_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoqtkspz_data.setDoc_id(docId); 
									ironfoqtkspzService.updateIronfo(ironfoqtkspz_data);//保存
									i = 1;
									ironfoqtkspz_data = new Ironfoqtkspz();
							}	
						}	
					}	
				}	
			}	
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspz/ironfoqtkspz/?repage";
	}
	
	/**
	 * 删除3.6其他科室医疗设备配置
	 */
	@RequiresPermissions("ironfoqtkspz:ironfoqtkspz:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoqtkspz ironfoqtkspz, RedirectAttributes redirectAttributes) {
		ironfoqtkspzService.delete(ironfoqtkspz);
		addMessage(redirectAttributes, "删除3.6其他科室医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspz/ironfoqtkspz/?repage";
	}
	
	/**
	 * 批量删除3.6其他科室医疗设备配置
	 */
	@RequiresPermissions("ironfoqtkspz:ironfoqtkspz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoqtkspzService.delete(ironfoqtkspzService.get(id));
		}
		addMessage(redirectAttributes, "删除3.6其他科室医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspz/ironfoqtkspz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoqtkspz:ironfoqtkspz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoqtkspz ironfoqtkspz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.6其他科室医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoqtkspz> page = ironfoqtkspzService.findPage(new Page<Ironfoqtkspz>(request, response, -1), ironfoqtkspz);
    		new ExportExcel("3.6其他科室医疗设备配置", Ironfoqtkspz.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出3.6其他科室医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspz/ironfoqtkspz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoqtkspz:ironfoqtkspz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoqtkspz> list = ei.getDataList(Ironfoqtkspz.class);
			for (Ironfoqtkspz ironfoqtkspz : list){
				try{
					ironfoqtkspzService.save(ironfoqtkspz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条3.6其他科室医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条3.6其他科室医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入3.6其他科室医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspz/ironfoqtkspz/?repage";
    }
	
	/**
	 * 下载导入3.6其他科室医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfoqtkspz:ironfoqtkspz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.6其他科室医疗设备配置数据导入模板.xlsx";
    		List<Ironfoqtkspz> list = Lists.newArrayList(); 
    		new ExportExcel("3.6其他科室医疗设备配置数据", Ironfoqtkspz.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspz/ironfoqtkspz/?repage";
    }
	
	
	

}