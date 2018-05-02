/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationbuild.web;

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
import com.jeeplus.modules.ironfoinformationbuild.entity.Ironfoinformationbuild;
import com.jeeplus.modules.ironfoinformationbuild.service.IronfoinformationbuildService;
import com.jeeplus.modules.ironfoyjbylsbpzyjk.entity.Ironfo_yjbylsbpz_yjk;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOXXHJS;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOYJK;

/**
 * 4.1信息化系统建设情况Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationbuild/ironfoinformationbuild")
public class IronfoinformationbuildController extends BaseController {

	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	@Autowired
	private IronfoinformationbuildService ironfoinformationbuildService;
	
	@ModelAttribute
	public Ironfoinformationbuild get(@RequestParam(required=false) String id) {
		Ironfoinformationbuild entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationbuildService.get(id);
		}
		if (entity == null){
			entity = new Ironfoinformationbuild();
		}
		return entity;
	}
	
	/**
	 * 4.1信息化系统建设情况列表页面
	 */
	@RequiresPermissions("ironfoinformationbuild:ironfoinformationbuild:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoinformationbuild ironfoinformationbuild, HttpServletRequest request, HttpServletResponse response, Model model) {

		
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
			

			ironfoinformationbuild.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoinformationbuild> data = ironfoinformationbuildService.queryForList(ironfoinformationbuild);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoinformationbuild room :data) {
				
				datas = new TreeMap<String,Object>();
//				
				
				
				

				
				
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getCsmc().trim()||"----".trim().equals(room.getCsmc().trim())) {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_csmc", "");
				}else {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_csmc", room.getCsmc());
				}
				
				if("----".trim()==room.getRjzj().trim()||"----".trim().equals(room.getRjzj().trim())) {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_rjzj", "");
				}else {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_rjzj", room.getRjzj());

				}
				
				if("----".trim() == room.getTrsysj().trim()||"----".trim().equals(room.getTrsysj().trim())) {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_trsysj", "");
				}else {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_trsysj", room.getTrsysj());

				}
				
				if("----".trim()==room.getXtbsfs().trim()||"----".trim().equals(room.getXtbsfs().trim())) {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_xtbsfs", "");
				}else {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_xtbsfs", room.getXtbsfs());
				}
				
				if("----".trim()==room.getXtgnsx().trim()||"----".trim().equals(room.getXtgnsx().trim())) {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_xtgnsx", "");
				}else {
					datas.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase()+"_xtgnsx", room.getXtgnsx());
				}
				
				listData.put(EnumUtils.IRONFOXXHJS.getEnumbyname(room.getRjmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
			
			
		}else {
			
			

//			private String csmc;		// 厂商名称
//			private String rjzj;		// 软件造价（元）
//			private String trsysj;		// 投入使用时间
//			private String xtbsfs;		// 系统部署方式
//			private String xtgnsx;		// 系统功能实现
			
			

			for(IRONFOXXHJS jz :EnumUtils.IRONFOXXHJS.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_csmc", "");
				datas.put(jz.toString().toLowerCase()+"_rjzj", "");
				datas.put(jz.toString().toLowerCase()+"_trsysj", "");
				datas.put(jz.toString().toLowerCase()+"_xtbsfs", "");
				datas.put(jz.toString().toLowerCase()+"_xtgnsx", "");
//				listData.add(datas);
				listData.put(jz.toString().toLowerCase(), datas);
			}
			
			
			
			
		}
		
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		
		return "modules/ironfoinformationbuild/ironfoinformationbuildList";
	}

	/**
	 * 查看，增加，编辑4.1信息化系统建设情况表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationbuild:ironfoinformationbuild:view","ironfoinformationbuild:ironfoinformationbuild:add","ironfoinformationbuild:ironfoinformationbuild:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoinformationbuild ironfoinformationbuild, Model model) {
		model.addAttribute("ironfoinformationbuild", ironfoinformationbuild);
		return "modules/ironfoinformationbuild/ironfoinformationbuildForm";
	}

	/**
	 * 保存4.1信息化系统建设情况
	 */
	@RequiresPermissions(value={"ironfoinformationbuild:ironfoinformationbuild:add","ironfoinformationbuild:ironfoinformationbuild:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoinformationbuild ironfoinformationbuild, Model model, RedirectAttributes redirectAttributes) throws Exception{

		
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
			
			ironfoinformationbuild.setDoc_id(docId);
			List<Ironfoinformationbuild> ironfoList = ironfoinformationbuildService.queryForList(ironfoinformationbuild);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoinformationbuild ironfoinformationbuild_data = null;
		
		
		


		if(isnull == false) {
			//更新
			int i=1;
			ironfoinformationbuild_data = new Ironfoinformationbuild();
			for(int j=0;j<EnumUtils.XXHJS.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.XXHJS[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.XXHJS[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoinformationbuild.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoinformationbuild_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoinformationbuild_data.setDoc_id(docId); 
									ironfoinformationbuildService.save(ironfoinformationbuild_data);//保存
									i = 1;
									ironfoinformationbuild_data = new Ironfoinformationbuild();
							}	
						}	
					}	
				}	
			}	
			
			
		}else if(isnull == true){
			
			
			//更新
			int i=1;
			ironfoinformationbuild_data = new Ironfoinformationbuild();
			for(int j=0;j<EnumUtils.XXHJS.length;j++) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()) {
					if(EnumUtils.XXHJS[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||EnumUtils.XXHJS[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
						if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
							ironfoinformationbuild_data.setId(entry.getValue().toString());
						}else {
							
								Method m = GetSetMethod.getSetMethod(Ironfoinformationbuild.class,entry.getKey().toString().trim().split("_")[1].toString());
								m.invoke(ironfoinformationbuild_data, new Object[]{entry.getValue()} );
								i++;
								if(i==7) {
									ironfoinformationbuild_data.setDoc_id(docId); 
									ironfoinformationbuildService.updateIronfo(ironfoinformationbuild_data);//保存
									i = 1;
									ironfoinformationbuild_data = new Ironfoinformationbuild();
							}	
						}	
					}	
				}	
			}	
		}
	
		
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuild/ironfoinformationbuild/?repage";
	}
	
	/**
	 * 删除4.1信息化系统建设情况
	 */
	@RequiresPermissions("ironfoinformationbuild:ironfoinformationbuild:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoinformationbuild ironfoinformationbuild, RedirectAttributes redirectAttributes) {
		ironfoinformationbuildService.delete(ironfoinformationbuild);
		addMessage(redirectAttributes, "删除4.1信息化系统建设情况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuild/ironfoinformationbuild/?repage";
	}
	
	/**
	 * 批量删除4.1信息化系统建设情况
	 */
	@RequiresPermissions("ironfoinformationbuild:ironfoinformationbuild:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationbuildService.delete(ironfoinformationbuildService.get(id));
		}
		addMessage(redirectAttributes, "删除4.1信息化系统建设情况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuild/ironfoinformationbuild/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationbuild:ironfoinformationbuild:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoinformationbuild ironfoinformationbuild, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.1信息化系统建设情况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoinformationbuild> page = ironfoinformationbuildService.findPage(new Page<Ironfoinformationbuild>(request, response, -1), ironfoinformationbuild);
    		new ExportExcel("4.1信息化系统建设情况", Ironfoinformationbuild.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.1信息化系统建设情况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuild/ironfoinformationbuild/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationbuild:ironfoinformationbuild:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoinformationbuild> list = ei.getDataList(Ironfoinformationbuild.class);
			for (Ironfoinformationbuild ironfoinformationbuild : list){
				try{
					ironfoinformationbuildService.save(ironfoinformationbuild);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.1信息化系统建设情况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.1信息化系统建设情况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.1信息化系统建设情况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuild/ironfoinformationbuild/?repage";
    }
	
	/**
	 * 下载导入4.1信息化系统建设情况数据模板
	 */
	@RequiresPermissions("ironfoinformationbuild:ironfoinformationbuild:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.1信息化系统建设情况数据导入模板.xlsx";
    		List<Ironfoinformationbuild> list = Lists.newArrayList(); 
    		new ExportExcel("4.1信息化系统建设情况数据", Ironfoinformationbuild.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuild/ironfoinformationbuild/?repage";
    }
	
	
	

}