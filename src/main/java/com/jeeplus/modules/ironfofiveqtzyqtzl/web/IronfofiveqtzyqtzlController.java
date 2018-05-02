/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzyqtzl.web;

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
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiveqtzyqtzl.entity.Ironfofiveqtzyqtzl;
import com.jeeplus.modules.ironfofiveqtzyqtzl.service.IronfofiveqtzyqtzlService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 气体种类Controller
 * @author mikesun
 * @version 2018-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl")
public class IronfofiveqtzyqtzlController extends BaseController {
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;


	@Autowired
	private IronfofiveqtzyqtzlService ironfofiveqtzyqtzlService;
	
	@ModelAttribute
	public Ironfofiveqtzyqtzl get(@RequestParam(required=false) String id) {
		Ironfofiveqtzyqtzl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveqtzyqtzlService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiveqtzyqtzl();
		}
		return entity;
	}
	
	/**
	 * 气体种类列表页面
	 */
	@RequiresPermissions("ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl, HttpServletRequest request, HttpServletResponse response, Model model) {
	

		Map<String,Object> listData = new HashMap<String,Object>();
		Map<String,Object> datas = null;
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		IronfoDocTitle title = null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			Ironfofiveqtzyqtzl ironfofiveqtzyqtzl_data = null;
			try {
				ironfofiveqtzyqtzl_data = Ironfofiveqtzyqtzl.class.newInstance();
				ironfofiveqtzyqtzl_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofiveqtzyqtzl> list_data = ironfofiveqtzyqtzlService.queryForList(ironfofiveqtzyqtzl_data);
				if(list_data.size()>0) {
					for(Ironfofiveqtzyqtzl qtzl :list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("yq",qtzl.getYq());
						datas.put("xq",qtzl.getXq());
						datas.put("dq",qtzl.getDq());
						datas.put("eyht",qtzl.getEyht());
						datas.put("yskq",qtzl.getYskq());
						datas.put("fyxy",qtzl.getFyxy());
						datas.put("id",qtzl.getId());
						datas.put("doc_id",docList.get(0).getId().toString());
						
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("yq", "0");
					datas.put("xq", "0");
					datas.put("dq", "0");
					datas.put("eyht", "0");
					datas.put("yskq", "0");
					datas.put("fyxy", "0");
					datas.put("id", "");
					datas.put("doc_id", "");
					
					
				}
				
			} catch (Exception e) {
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofiveqtzyqtzl/ironfofiveqtzyqtzlList";
	}

	/**
	 * 查看，增加，编辑气体种类表单页面
	 */
	@RequiresPermissions(value={"ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:view","ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:add","ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl, Model model) {
		model.addAttribute("ironfofiveqtzyqtzl", ironfofiveqtzyqtzl);
		return "modules/ironfofiveqtzyqtzl/ironfofiveqtzyqtzlForm";
	}

	/**
	 * 保存气体种类
	 */
	@RequiresPermissions(value={"ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:add","ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		


		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String docId = request.getParameter("docId");
		String checkbox = request.getParameter("checkval");
//		String type = request.getParameter("type");
		String checkout = request.getParameter("checkout");
//		String qtqzm = request.getParameter("qtqzm");
		String id = request.getParameter("id");
		
		
		
//		String[] datas = data.split(";");
		
//		System.out.println("------------->"+datas[datas.length-1]);
		/**
		 * 主表信息
		 */
//		String docId = "";
//		for(int i=0;i<datas.length;i++) {
//			map.put(datas[i].toString().split(":")[0].toString(), datas[i].toString().split(":")[1].toString());
//			if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
//				docId = datas[i].toString().split(":")[1].toString();
//			}
//		}
		
		
		if(checkbox.length()>0) {
			if(checkbox.indexOf(",")!=-1) {
				for(int j =0;j<checkbox.split(",").length;j++) {
					map.put(checkbox.split(",")[j], "1");
				}
			}else {
				 map.put(checkbox, "1");
			}
		}
		
		if(checkout.length()>0) {
			if(checkout.contains(",")) {
				for(int j =0;j<checkout.split(",").length;j++) {
					map.put(checkout.split(",")[j], "0");
				}	
			}else {
				map.put(checkout, "0");
			}
			
		}
		
		
		
		/**
		 * 附表信息
		 */
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||"----".trim()==docId.toString().trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
//			ironfofivemjzyf.setDoc_id(docId);
			Ironfofiveqtzyqtzl ironfofiveqtzyqtzl_data = Ironfofiveqtzyqtzl.class.newInstance();
			ironfofiveqtzyqtzl_data.setDoc_id(docId);
			List<Ironfofiveqtzyqtzl> fkjlx_data = ironfofiveqtzyqtzlService.queryForList(ironfofiveqtzyqtzl_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
//		private String yq;		// 氧气
//		private String xq;		// 笑气
//		private String dq;		// 氮气
//		private String eyht;		// 二氧化碳
//		private String yskq;		// 压缩空气
//		private String fyxy;		// 负压吸引
		
		Ironfofiveqtzyqtzl ironfofiveqtzyqtzl_datas = Ironfofiveqtzyqtzl.class.newInstance();
		ironfofiveqtzyqtzl_datas.setDoc_id(docId);
		ironfofiveqtzyqtzl_datas.setYq(map.get("yq").toString());
		ironfofiveqtzyqtzl_datas.setXq(map.get("xq").toString());
		ironfofiveqtzyqtzl_datas.setDq(map.get("dq").toString());
		ironfofiveqtzyqtzl_datas.setEyht(map.get("eyht").toString());
		ironfofiveqtzyqtzl_datas.setYskq(map.get("yskq").toString());
		ironfofiveqtzyqtzl_datas.setFyxy(map.get("fyxy").toString());
		
		

		if(isnull == true) {
			//更新
			ironfofiveqtzyqtzl_datas.setId(id);
			ironfofiveqtzyqtzlService.updateironfo(ironfofiveqtzyqtzl_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiveqtzyqtzlService.save(ironfofiveqtzyqtzl_datas);
			
		}
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/?repage";
	}
	
	/**
	 * 删除气体种类
	 */
	@RequiresPermissions("ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl, RedirectAttributes redirectAttributes) {
		ironfofiveqtzyqtzlService.delete(ironfofiveqtzyqtzl);
		addMessage(redirectAttributes, "删除气体种类成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/?repage";
	}
	
	/**
	 * 批量删除气体种类
	 */
	@RequiresPermissions("ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveqtzyqtzlService.delete(ironfofiveqtzyqtzlService.get(id));
		}
		addMessage(redirectAttributes, "删除气体种类成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiveqtzyqtzl ironfofiveqtzyqtzl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "气体种类"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiveqtzyqtzl> page = ironfofiveqtzyqtzlService.findPage(new Page<Ironfofiveqtzyqtzl>(request, response, -1), ironfofiveqtzyqtzl);
    		new ExportExcel("气体种类", Ironfofiveqtzyqtzl.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出气体种类记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiveqtzyqtzl> list = ei.getDataList(Ironfofiveqtzyqtzl.class);
			for (Ironfofiveqtzyqtzl ironfofiveqtzyqtzl : list){
				try{
					ironfofiveqtzyqtzlService.save(ironfofiveqtzyqtzl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条气体种类记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条气体种类记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入气体种类失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/?repage";
    }
	
	/**
	 * 下载导入气体种类数据模板
	 */
	@RequiresPermissions("ironfofiveqtzyqtzl:ironfofiveqtzyqtzl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "气体种类数据导入模板.xlsx";
    		List<Ironfofiveqtzyqtzl> list = Lists.newArrayList(); 
    		new ExportExcel("气体种类数据", Ironfofiveqtzyqtzl.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/?repage";
    }
	
	
	

}