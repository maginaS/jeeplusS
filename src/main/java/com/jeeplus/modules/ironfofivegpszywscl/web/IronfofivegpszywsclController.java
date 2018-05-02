/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszywscl.web;

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
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;
import com.jeeplus.modules.ironfofivegpszywscl.entity.Ironfofivegpszywscl;
import com.jeeplus.modules.ironfofivegpszywscl.service.IronfofivegpszywsclService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 污水处理Controller
 * @author mikesun
 * @version 2018-04-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivegpszywscl/ironfofivegpszywscl")
public class IronfofivegpszywsclController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	
	@Autowired
	private IronfofivegpszywsclService ironfofivegpszywsclService;
	
	@ModelAttribute
	public Ironfofivegpszywscl get(@RequestParam(required=false) String id) {
		Ironfofivegpszywscl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivegpszywsclService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivegpszywscl();
		}
		return entity;
	}
	
	/**
	 * 污水处理列表页面
	 */
	@RequiresPermissions("ironfofivegpszywscl:ironfofivegpszywscl:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivegpszywscl ironfofivegpszywscl, HttpServletRequest request, HttpServletResponse response, Model model) {
		

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
			Ironfofivegpszywscl ironfofivegpszywscl_data = null;
			try {
				ironfofivegpszywscl_data = Ironfofivegpszywscl.class.newInstance();
				ironfofivegpszywscl_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofivegpszywscl> list_data = ironfofivegpszywsclService.queryForList(ironfofivegpszywscl_data);
				if(list_data.size()>0) {
					
					for(Ironfofivegpszywscl wscl : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("wffl",wscl.getWffl());
						datas.put("hfc",wscl.getHfc());
						datas.put("clz",wscl.getClz());
						datas.put("szjc",wscl.getSzjc());
						datas.put("id",wscl.getId());
						
					}
					
				}else {
					
					
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", "");
					datas.put("wffl", "0");
					datas.put("hfc", "0");
					datas.put("clz", "0");
					datas.put("szjc", "0");
					datas.put("id", "");
					
				}
				
				
				
			} catch (Exception e) {
			}
			
		}
		
		
		
		

		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofivegpszywscl/ironfofivegpszywsclList";
	}

	/**
	 * 查看，增加，编辑污水处理表单页面
	 */
	@RequiresPermissions(value={"ironfofivegpszywscl:ironfofivegpszywscl:view","ironfofivegpszywscl:ironfofivegpszywscl:add","ironfofivegpszywscl:ironfofivegpszywscl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivegpszywscl ironfofivegpszywscl, Model model) {
		model.addAttribute("ironfofivegpszywscl", ironfofivegpszywscl);
		return "modules/ironfofivegpszywscl/ironfofivegpszywsclForm";
	}

	/**
	 * 保存污水处理
	 */
	@RequiresPermissions(value={"ironfofivegpszywscl:ironfofivegpszywscl:add","ironfofivegpszywscl:ironfofivegpszywscl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivegpszywscl ironfofivegpszywscl, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		

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
		String qtqzm = request.getParameter("qtqzm");
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
			Ironfofivegpszywscl ironfofivegpszywscl_data = Ironfofivegpszywscl.class.newInstance();
			ironfofivegpszywscl_data.setDoc_id(docId);
			List<Ironfofivegpszywscl> fkjlx_data = ironfofivegpszywsclService.queryForList(ironfofivegpszywscl_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofivegpszywscl ironfofivegpszywscl_datas = Ironfofivegpszywscl.class.newInstance();
		ironfofivegpszywscl_datas.setWffl(map.get("wffl").toString());
		ironfofivegpszywscl_datas.setHfc(map.get("hfc").toString());
		ironfofivegpszywscl_datas.setClz(map.get("clz").toString());
		ironfofivegpszywscl_datas.setSzjc(map.get("szjc").toString());
		ironfofivegpszywscl_datas.setDoc_id(docId);
		
		
		

		if(isnull == true) {
			//更新
			ironfofivegpszywscl_datas.setId(id);
			ironfofivegpszywsclService.updateironfo(ironfofivegpszywscl_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivegpszywsclService.save(ironfofivegpszywscl_datas);
			
		}
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywscl/ironfofivegpszywscl/?repage";
	}
	
	/**
	 * 删除污水处理
	 */
	@RequiresPermissions("ironfofivegpszywscl:ironfofivegpszywscl:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivegpszywscl ironfofivegpszywscl, RedirectAttributes redirectAttributes) {
		ironfofivegpszywsclService.delete(ironfofivegpszywscl);
		addMessage(redirectAttributes, "删除污水处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywscl/ironfofivegpszywscl/?repage";
	}
	
	/**
	 * 批量删除污水处理
	 */
	@RequiresPermissions("ironfofivegpszywscl:ironfofivegpszywscl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivegpszywsclService.delete(ironfofivegpszywsclService.get(id));
		}
		addMessage(redirectAttributes, "删除污水处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywscl/ironfofivegpszywscl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivegpszywscl:ironfofivegpszywscl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivegpszywscl ironfofivegpszywscl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "污水处理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivegpszywscl> page = ironfofivegpszywsclService.findPage(new Page<Ironfofivegpszywscl>(request, response, -1), ironfofivegpszywscl);
    		new ExportExcel("污水处理", Ironfofivegpszywscl.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出污水处理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywscl/ironfofivegpszywscl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivegpszywscl:ironfofivegpszywscl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivegpszywscl> list = ei.getDataList(Ironfofivegpszywscl.class);
			for (Ironfofivegpszywscl ironfofivegpszywscl : list){
				try{
					ironfofivegpszywsclService.save(ironfofivegpszywscl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条污水处理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条污水处理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入污水处理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywscl/ironfofivegpszywscl/?repage";
    }
	
	/**
	 * 下载导入污水处理数据模板
	 */
	@RequiresPermissions("ironfofivegpszywscl:ironfofivegpszywscl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "污水处理数据导入模板.xlsx";
    		List<Ironfofivegpszywscl> list = Lists.newArrayList(); 
    		new ExportExcel("污水处理数据", Ironfofivegpszywscl.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywscl/ironfofivegpszywscl/?repage";
    }
	
	
	

}