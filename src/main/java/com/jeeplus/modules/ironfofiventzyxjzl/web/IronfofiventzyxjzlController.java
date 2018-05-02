/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzyxjzl.web;

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
import com.jeeplus.modules.ironfofiventzydjcn.entity.Ironfofiventzydjcn;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiventzyxjzl.service.IronfofiventzyxjzlService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 夏季制冷Controller
 * @author mikesun
 * @version 2018-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiventzyxjzl/ironfofiventzyxjzl")
public class IronfofiventzyxjzlController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfofiventzyxjzlService ironfofiventzyxjzlService;
	
	@ModelAttribute
	public Ironfofiventzyxjzl get(@RequestParam(required=false) String id) {
		Ironfofiventzyxjzl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiventzyxjzlService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiventzyxjzl();
		}
		return entity;
	}
	
	/**
	 * 夏季制冷列表页面
	 */
	@RequiresPermissions("ironfofiventzyxjzl:ironfofiventzyxjzl:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiventzyxjzl ironfofiventzyxjzl, HttpServletRequest request, HttpServletResponse response, Model model) {
	

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
			Ironfofiventzyxjzl ironfofiventzyxjzl_data = null;
			try {
				ironfofiventzyxjzl_data = Ironfofiventzyxjzl.class.newInstance();
				ironfofiventzyxjzl_data.setDoc_id(docList.get(0).getId().toString());
				
				
				List<Ironfofiventzyxjzl> list_data = ironfofiventzyxjzlService.queryForList(ironfofiventzyxjzl_data);
				if(list_data.size()>0) {
					for(Ironfofiventzyxjzl xjzl :list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("zykt",xjzl.getZykt());
						datas.put("ftkt",xjzl.getFtkt());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("id",xjzl.getId());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("zykt", "0");
					datas.put("ftkt", "0");
					datas.put("doc_id", "");
					datas.put("id", "");
					
				}
				
			} catch (Exception e) {
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofiventzyxjzl/ironfofiventzyxjzlList";
	}

	/**
	 * 查看，增加，编辑夏季制冷表单页面
	 */
	@RequiresPermissions(value={"ironfofiventzyxjzl:ironfofiventzyxjzl:view","ironfofiventzyxjzl:ironfofiventzyxjzl:add","ironfofiventzyxjzl:ironfofiventzyxjzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiventzyxjzl ironfofiventzyxjzl, Model model) {
		model.addAttribute("ironfofiventzyxjzl", ironfofiventzyxjzl);
		return "modules/ironfofiventzyxjzl/ironfofiventzyxjzlForm";
	}

	/**
	 * 保存夏季制冷
	 */
	@RequiresPermissions(value={"ironfofiventzyxjzl:ironfofiventzyxjzl:add","ironfofiventzyxjzl:ironfofiventzyxjzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiventzyxjzl ironfofiventzyxjzl, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		


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
			Ironfofiventzyxjzl ironfofiventzyxjzl_data = Ironfofiventzyxjzl.class.newInstance();
			ironfofiventzyxjzl_data.setDoc_id(docId);
			List<Ironfofiventzyxjzl> fkjlx_data = ironfofiventzyxjzlService.queryForList(ironfofiventzyxjzl_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
//		private String doc_id;		// 主表id
//		private String zykt;		// 中央空调
//		private String ftkt;		// 分体空调
		
		Ironfofiventzyxjzl ironfofiventzyxjzl_datas = Ironfofiventzyxjzl.class.newInstance();
		ironfofiventzyxjzl_datas.setDoc_id(docId);
		ironfofiventzyxjzl_datas.setZykt(map.get("zykt").toString());
		ironfofiventzyxjzl_datas.setFtkt(map.get("ftkt").toString());
		

		if(isnull == true) {
			//更新
			ironfofiventzyxjzl_datas.setId(id);
			ironfofiventzyxjzlService.updateironfo(ironfofiventzyxjzl_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiventzyxjzlService.save(ironfofiventzyxjzl_datas);
			
		}
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzl/ironfofiventzyxjzl/?repage";
	}
	
	/**
	 * 删除夏季制冷
	 */
	@RequiresPermissions("ironfofiventzyxjzl:ironfofiventzyxjzl:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiventzyxjzl ironfofiventzyxjzl, RedirectAttributes redirectAttributes) {
		ironfofiventzyxjzlService.delete(ironfofiventzyxjzl);
		addMessage(redirectAttributes, "删除夏季制冷成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzl/ironfofiventzyxjzl/?repage";
	}
	
	/**
	 * 批量删除夏季制冷
	 */
	@RequiresPermissions("ironfofiventzyxjzl:ironfofiventzyxjzl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiventzyxjzlService.delete(ironfofiventzyxjzlService.get(id));
		}
		addMessage(redirectAttributes, "删除夏季制冷成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzl/ironfofiventzyxjzl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiventzyxjzl:ironfofiventzyxjzl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiventzyxjzl ironfofiventzyxjzl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "夏季制冷"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiventzyxjzl> page = ironfofiventzyxjzlService.findPage(new Page<Ironfofiventzyxjzl>(request, response, -1), ironfofiventzyxjzl);
    		new ExportExcel("夏季制冷", Ironfofiventzyxjzl.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出夏季制冷记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzl/ironfofiventzyxjzl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiventzyxjzl:ironfofiventzyxjzl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiventzyxjzl> list = ei.getDataList(Ironfofiventzyxjzl.class);
			for (Ironfofiventzyxjzl ironfofiventzyxjzl : list){
				try{
					ironfofiventzyxjzlService.save(ironfofiventzyxjzl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条夏季制冷记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条夏季制冷记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入夏季制冷失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzl/ironfofiventzyxjzl/?repage";
    }
	
	/**
	 * 下载导入夏季制冷数据模板
	 */
	@RequiresPermissions("ironfofiventzyxjzl:ironfofiventzyxjzl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "夏季制冷数据导入模板.xlsx";
    		List<Ironfofiventzyxjzl> list = Lists.newArrayList(); 
    		new ExportExcel("夏季制冷数据", Ironfofiventzyxjzl.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzl/ironfofiventzyxjzl/?repage";
    }
	
	
	

}