/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivegpszygssy.web;

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
import com.jeeplus.modules.ironfofivedqzygdfs.entity.Ironfofivedqzygdfs;
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;
import com.jeeplus.modules.ironfofivegpszygssy.service.IronfofivegpszygssyService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 给水水源Controller
 * @author mikesun
 * @version 2018-04-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivegpszygssy/ironfofivegpszygssy")
public class IronfofivegpszygssyController extends BaseController {

	@Autowired
	private IronfofivegpszygssyService ironfofivegpszygssyService;
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfofivegpszygssy get(@RequestParam(required=false) String id) {
		Ironfofivegpszygssy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivegpszygssyService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivegpszygssy();
		}
		return entity;
	}
	
	/**
	 * 给水水源列表页面
	 */
	@RequiresPermissions("ironfofivegpszygssy:ironfofivegpszygssy:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivegpszygssy ironfofivegpszygssy, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		
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
			Ironfofivegpszygssy ironfofivegpszygssy_data = null;
			try {
				ironfofivegpszygssy_data = Ironfofivegpszygssy.class.newInstance();
				ironfofivegpszygssy_data.setDoc_id(docList.get(0).getId().toString());
				List<Ironfofivegpszygssy> list_data = ironfofivegpszygssyService.queryForList(ironfofivegpszygssy_data);
				
				if(list_data.size()>0) {
					for(Ironfofivegpszygssy gssy : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("szgw",gssy.getSzgw());
						datas.put("sjzq",gssy.getSjzq());
						datas.put("id",gssy.getId());
						
					}
					
				}else {
//					private String doc_id;		// 主表id
//					private String szgw;		// 市政管网
//					private String sjzq;		// 水井自取
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", "");
					datas.put("szgw", "0");
					datas.put("sjzq", "0");
					datas.put("id", "");
					
				}
				
				
			} catch (Exception e) {
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofivegpszygssy/ironfofivegpszygssyList";
	}

	/**
	 * 查看，增加，编辑给水水源表单页面
	 */
	@RequiresPermissions(value={"ironfofivegpszygssy:ironfofivegpszygssy:view","ironfofivegpszygssy:ironfofivegpszygssy:add","ironfofivegpszygssy:ironfofivegpszygssy:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivegpszygssy ironfofivegpszygssy, Model model) {
		model.addAttribute("ironfofivegpszygssy", ironfofivegpszygssy);
		return "modules/ironfofivegpszygssy/ironfofivegpszygssyForm";
	}

	/**
	 * 保存给水水源
	 */
	@RequiresPermissions(value={"ironfofivegpszygssy:ironfofivegpszygssy:add","ironfofivegpszygssy:ironfofivegpszygssy:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivegpszygssy ironfofivegpszygssy, Model model, RedirectAttributes redirectAttributes) throws Exception{
	

		

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
			Ironfofivegpszygssy ironfofivegpszygssy_data = Ironfofivegpszygssy.class.newInstance();
			ironfofivegpszygssy_data.setDoc_id(docId);
			List<Ironfofivegpszygssy> fkjlx_data = ironfofivegpszygssyService.queryForList(ironfofivegpszygssy_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofivegpszygssy ironfofivegpszygssy_datas = Ironfofivegpszygssy.class.newInstance();
		ironfofivegpszygssy_datas.setDoc_id(docId);
		ironfofivegpszygssy_datas.setSzgw(map.get("szgw").toString());
		ironfofivegpszygssy_datas.setSjzq(map.get("sjzq").toString());
		
		
		
		
		if(isnull == true) {
			//更新
			ironfofivegpszygssy_datas.setId(id);
			ironfofivegpszygssyService.updateironfo(ironfofivegpszygssy_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivegpszygssyService.save(ironfofivegpszygssy_datas);
			
		}
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssy/ironfofivegpszygssy/?repage";
	}
	
	/**
	 * 删除给水水源
	 */
	@RequiresPermissions("ironfofivegpszygssy:ironfofivegpszygssy:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivegpszygssy ironfofivegpszygssy, RedirectAttributes redirectAttributes) {
		ironfofivegpszygssyService.delete(ironfofivegpszygssy);
		addMessage(redirectAttributes, "删除给水水源成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssy/ironfofivegpszygssy/?repage";
	}
	
	/**
	 * 批量删除给水水源
	 */
	@RequiresPermissions("ironfofivegpszygssy:ironfofivegpszygssy:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivegpszygssyService.delete(ironfofivegpszygssyService.get(id));
		}
		addMessage(redirectAttributes, "删除给水水源成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssy/ironfofivegpszygssy/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivegpszygssy:ironfofivegpszygssy:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivegpszygssy ironfofivegpszygssy, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "给水水源"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivegpszygssy> page = ironfofivegpszygssyService.findPage(new Page<Ironfofivegpszygssy>(request, response, -1), ironfofivegpszygssy);
    		new ExportExcel("给水水源", Ironfofivegpszygssy.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出给水水源记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssy/ironfofivegpszygssy/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivegpszygssy:ironfofivegpszygssy:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivegpszygssy> list = ei.getDataList(Ironfofivegpszygssy.class);
			for (Ironfofivegpszygssy ironfofivegpszygssy : list){
				try{
					ironfofivegpszygssyService.save(ironfofivegpszygssy);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条给水水源记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条给水水源记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入给水水源失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssy/ironfofivegpszygssy/?repage";
    }
	
	/**
	 * 下载导入给水水源数据模板
	 */
	@RequiresPermissions("ironfofivegpszygssy:ironfofivegpszygssy:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "给水水源数据导入模板.xlsx";
    		List<Ironfofivegpszygssy> list = Lists.newArrayList(); 
    		new ExportExcel("给水水源数据", Ironfofivegpszygssy.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssy/ironfofivegpszygssy/?repage";
    }
	
	
	

}