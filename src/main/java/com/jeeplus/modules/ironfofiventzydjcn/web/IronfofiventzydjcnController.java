/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiventzydjcn.web;

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
import com.jeeplus.modules.ironfofivegpszywwcl.entity.Ironfofivegpszywwcl;
import com.jeeplus.modules.ironfofiventzydjcn.entity.Ironfofiventzydjcn;
import com.jeeplus.modules.ironfofiventzydjcn.service.IronfofiventzydjcnService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 冬季采暖Controller
 * @author mikesun
 * @version 2018-04-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiventzydjcn/ironfofiventzydjcn")
public class IronfofiventzydjcnController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@Autowired
	private IronfofiventzydjcnService ironfofiventzydjcnService;
	
	@ModelAttribute
	public Ironfofiventzydjcn get(@RequestParam(required=false) String id) {
		Ironfofiventzydjcn entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiventzydjcnService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiventzydjcn();
		}
		return entity;
	}
	
	/**
	 * 冬季采暖列表页面
	 */
	@RequiresPermissions("ironfofiventzydjcn:ironfofiventzydjcn:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiventzydjcn ironfofiventzydjcn, HttpServletRequest request, HttpServletResponse response, Model model) {


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
			Ironfofiventzydjcn ironfofiventzydjcn_data = null;
			try {
				
				ironfofiventzydjcn_data = Ironfofiventzydjcn.class.newInstance();
				ironfofiventzydjcn_data.setDoc_id(docList.get(0).getId().toString());
				
			List<Ironfofiventzydjcn> list_data = ironfofiventzydjcnService.queryForList(ironfofiventzydjcn_data);
			if(list_data.size()>0) {
				for(Ironfofiventzydjcn djcn : list_data) {
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", docList.get(0).getId().toString());
					datas.put("zykt",djcn.getZykt());
					datas.put("ftkt",djcn.getFtkt());
					datas.put("glcn",djcn.getGlcn());
					datas.put("dzq",djcn.getDzq());
					datas.put("szrl",djcn.getSzrl());
					datas.put("id",djcn.getId());
					
				}
				
			}else {
				datas = new TreeMap<String,Object>();
				datas.put("doc_id", "");
				datas.put("zykt", "0");
				datas.put("ftkt", "0");
				datas.put("glcn", "0");
				datas.put("dzq", "0");
				datas.put("szrl", "0");
				datas.put("id", "");
				
			}

				
			} catch (Exception e) {
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		return "modules/ironfofiventzydjcn/ironfofiventzydjcnList";
	}

	/**
	 * 查看，增加，编辑冬季采暖表单页面
	 */
	@RequiresPermissions(value={"ironfofiventzydjcn:ironfofiventzydjcn:view","ironfofiventzydjcn:ironfofiventzydjcn:add","ironfofiventzydjcn:ironfofiventzydjcn:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiventzydjcn ironfofiventzydjcn, Model model) {
		model.addAttribute("ironfofiventzydjcn", ironfofiventzydjcn);
		return "modules/ironfofiventzydjcn/ironfofiventzydjcnForm";
	}

	/**
	 * 保存冬季采暖
	 */
	@RequiresPermissions(value={"ironfofiventzydjcn:ironfofiventzydjcn:add","ironfofiventzydjcn:ironfofiventzydjcn:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiventzydjcn ironfofiventzydjcn, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		

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
			Ironfofiventzydjcn ironfofiventzydjcn_data = Ironfofiventzydjcn.class.newInstance();
			ironfofiventzydjcn_data.setDoc_id(docId);
			List<Ironfofiventzydjcn> fkjlx_data = ironfofiventzydjcnService.queryForList(ironfofiventzydjcn_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofiventzydjcn ironfofiventzydjcn_datas = Ironfofiventzydjcn.class.newInstance();
		ironfofiventzydjcn_datas.setDoc_id(docId);
		ironfofiventzydjcn_datas.setZykt(map.get("zykt").toString());
		ironfofiventzydjcn_datas.setFtkt(map.get("ftkt").toString());
		ironfofiventzydjcn_datas.setGlcn(map.get("glcn").toString());
		ironfofiventzydjcn_datas.setDzq(map.get("dzq").toString());
		ironfofiventzydjcn_datas.setSzrl(map.get("szrl").toString());
		
		

		if(isnull == true) {
			//更新
			ironfofiventzydjcn_datas.setId(id);
			ironfofiventzydjcnService.updateironfo(ironfofiventzydjcn_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiventzydjcnService.save(ironfofiventzydjcn_datas);
			
		}
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcn/ironfofiventzydjcn/?repage";
	}
	
	/**
	 * 删除冬季采暖
	 */
	@RequiresPermissions("ironfofiventzydjcn:ironfofiventzydjcn:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiventzydjcn ironfofiventzydjcn, RedirectAttributes redirectAttributes) {
		ironfofiventzydjcnService.delete(ironfofiventzydjcn);
		addMessage(redirectAttributes, "删除冬季采暖成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcn/ironfofiventzydjcn/?repage";
	}
	
	/**
	 * 批量删除冬季采暖
	 */
	@RequiresPermissions("ironfofiventzydjcn:ironfofiventzydjcn:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiventzydjcnService.delete(ironfofiventzydjcnService.get(id));
		}
		addMessage(redirectAttributes, "删除冬季采暖成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcn/ironfofiventzydjcn/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiventzydjcn:ironfofiventzydjcn:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiventzydjcn ironfofiventzydjcn, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "冬季采暖"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiventzydjcn> page = ironfofiventzydjcnService.findPage(new Page<Ironfofiventzydjcn>(request, response, -1), ironfofiventzydjcn);
    		new ExportExcel("冬季采暖", Ironfofiventzydjcn.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出冬季采暖记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcn/ironfofiventzydjcn/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiventzydjcn:ironfofiventzydjcn:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiventzydjcn> list = ei.getDataList(Ironfofiventzydjcn.class);
			for (Ironfofiventzydjcn ironfofiventzydjcn : list){
				try{
					ironfofiventzydjcnService.save(ironfofiventzydjcn);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条冬季采暖记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条冬季采暖记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入冬季采暖失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcn/ironfofiventzydjcn/?repage";
    }
	
	/**
	 * 下载导入冬季采暖数据模板
	 */
	@RequiresPermissions("ironfofiventzydjcn:ironfofiventzydjcn:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "冬季采暖数据导入模板.xlsx";
    		List<Ironfofiventzydjcn> list = Lists.newArrayList(); 
    		new ExportExcel("冬季采暖数据", Ironfofiventzydjcn.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcn/ironfofiventzydjcn/?repage";
    }
	
	
	

}