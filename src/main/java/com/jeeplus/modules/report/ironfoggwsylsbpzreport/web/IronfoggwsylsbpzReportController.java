/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoggwsylsbpzreport.web;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.jeeplus.modules.ironfoggwsylsbpz.entity.Ironfoggwsylsbpz;
import com.jeeplus.modules.ironfoggwsylsbpz.service.IronfoggwsylsbpzService;
import com.jeeplus.modules.report.ironfoggwsylsbpzreport.entity.IronfoggwsylsbpzReport;
import com.jeeplus.modules.report.ironfoggwsylsbpzreport.service.IronfoggwsylsbpzReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

import scala.collection.mutable.HashMap;

/**
 * 3.4公共卫生部医疗设备配置Controller
 * @author anti_magina
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoggwsylsbpzreport/ironfoggwsylsbpz")
public class IronfoggwsylsbpzReportController extends BaseController {

	@Autowired
	private IronfoggwsylsbpzReportService ironfoggwsylsbpzReportService;
	@Autowired
	private IronfoggwsylsbpzService ironfoggwsylsbpzService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoggwsylsbpzReport get(@RequestParam(required=false) String id) {
		IronfoggwsylsbpzReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoggwsylsbpzReportService.get(id);
		}
		if (entity == null){
			entity = new IronfoggwsylsbpzReport();
		}
		return entity;
	}
	
	/**
	 * 3.4公共卫生部医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoggwsylsbpzReport ironfoggwsylsbpz, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoggwsylsbpz.getDuser() != null&&ironfoggwsylsbpz.getDuser().toString() != null && ironfoggwsylsbpz.getDuser().toString().trim() != null
					&& !"".equals(ironfoggwsylsbpz.getDuser().toString().trim())
					&& !"null".equals(ironfoggwsylsbpz.getDuser().toString().trim())) {
				userId = ironfoggwsylsbpz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoggwsylsbpz.setDoc_id(title.getId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfoggwsylsbpzReport> page = ironfoggwsylsbpzReportService.findPage(new Page<IronfoggwsylsbpzReport>(request, response), ironfoggwsylsbpz); 
		model.addAttribute("page", page);
		return "modules/report/ironfoggwsylsbpzreport/ironfoggwsylsbpzList";
	}

	/**
	 * 查看，增加，编辑3.4公共卫生部医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfoggwsylsbpzreport:ironfoggwsylsbpz:view","ironfoggwsylsbpzreport:ironfoggwsylsbpz:add","ironfoggwsylsbpzreport:ironfoggwsylsbpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoggwsylsbpzReport ironfoggwsylsbpz, Model model) {
		model.addAttribute("ironfoggwsylsbpz", ironfoggwsylsbpz);
		return "report/ironfoggwsylsbpzreport/ironfoggwsylsbpzForm";
	}

	/**
	 * 保存3.4公共卫生部医疗设备配置
	 */
	@RequiresPermissions(value={"ironfoggwsylsbpzreport:ironfoggwsylsbpz:add","ironfoggwsylsbpzreport:ironfoggwsylsbpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoggwsylsbpzReport ironfoggwsylsbpz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoggwsylsbpz)){
			return form(ironfoggwsylsbpz, model);
		}
		if(!ironfoggwsylsbpz.getIsNewRecord()){//编辑表单保存
			IronfoggwsylsbpzReport t = ironfoggwsylsbpzReportService.get(ironfoggwsylsbpz.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoggwsylsbpz, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoggwsylsbpzReportService.save(t);//保存
		}else{//新增表单保存
			ironfoggwsylsbpzReportService.save(ironfoggwsylsbpz);//保存
		}
		addMessage(redirectAttributes, "保存3.4公共卫生部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
	}
	
	/**
	 * 删除3.4公共卫生部医疗设备配置
	 */
	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoggwsylsbpzReport ironfoggwsylsbpzReport, RedirectAttributes redirectAttributes) {
		Ironfoggwsylsbpz ironfoggwsylsbpz =  ironfoggwsylsbpzService.get(ironfoggwsylsbpzReport.getId());
		ironfoggwsylsbpzService.delete(ironfoggwsylsbpz);
		addMessage(redirectAttributes, "删除3.4公共卫生部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"report/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
	}
	
	/**
	 * 批量删除3.4公共卫生部医疗设备配置
	 */
	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoggwsylsbpzReportService.delete(ironfoggwsylsbpzReportService.get(id));
		}
		addMessage(redirectAttributes, "删除3.4公共卫生部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoggwsylsbpz ironfoggwsylsbpz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		String userId = null;
//		try {
//			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
//			if (ironfoggwsylsbpz.getDuser() != null&&ironfoggwsylsbpz.getDuser().toString() != null && ironfoggwsylsbpz.getDuser().toString().trim() != null
//					&& !"".equals(ironfoggwsylsbpz.getDuser().toString().trim())
//					&& !"null".equals(ironfoggwsylsbpz.getDuser().toString().trim())) {
//				userId = ironfoggwsylsbpz.getDuser().getId();
//				title.setRemarks(userId);
//			} else {
//				Subject subject = SecurityUtils.getSubject();
//				Principal obj = (Principal) subject.getPrincipal();
//				userId = (String) obj.getId();
//				
//			}
//			title = ironfoDoc_Title_Service.getDocId(userId);
//			if(title != null){
//			ironfoggwsylsbpz.setDoc_id(title.getId());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			//Ironfoggwsylsbpz ironfoggwsylsbpz2 = new Ironfoggwsylsbpz();
			//ironfoggwsylsbpz2.set
            String fileName = "3.4公共卫生部医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
			Page<Ironfoggwsylsbpz> page = ironfoggwsylsbpzService
					.findPage(new Page<Ironfoggwsylsbpz>(request, response, -1), new Ironfoggwsylsbpz());
			ExportExcel exls = new ExportExcel("3.4公共卫生部医疗设备配置", Ironfoggwsylsbpz.class);
			List<Ironfoggwsylsbpz> list1 = page.getList();
			Field[]  fs = Ironfoggwsylsbpz.class.getFields();
			//Map<String,String> list2 = (Map<String, String>) new HashMap<String,String>();
			List<String> list2 = new ArrayList<String>();
			//List<String> headerList = exls.getHeaderList();
//			for (String header : headerList) {
//				for (Ironfoggwsylsbpz iron : list1) {
//					String header1 = iron.getSbmc() + "-" +header;
//					list2.add(header1);
//				}
//			}
			//exls.setHeaderList(list2);
			//exls.setHeaderList(headerList);
			
			exls.setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出3.4公共卫生部医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
    }

//	/**
//	 * 导出excel文件
//	 */
//	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:export")
//    @RequestMapping(value = "export", method=RequestMethod.GET)
//    public String exportFile(Ironfoggwsylsbpz ironfoggwsylsbpz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		String userId = null;
//		/*try {
//			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
//			if (ironfoggwsylsbpz.getDuser() != null&&ironfoggwsylsbpz.getDuser().toString() != null && ironfoggwsylsbpz.getDuser().toString().trim() != null
//					&& !"".equals(ironfoggwsylsbpz.getDuser().toString().trim())
//					&& !"null".equals(ironfoggwsylsbpz.getDuser().toString().trim())) {
//				userId = ironfoggwsylsbpz.getDuser().getId();
//				title.setRemarks(userId);
//			} else {
//				Subject subject = SecurityUtils.getSubject();
//				Principal obj = (Principal) subject.getPrincipal();
//				userId = (String) obj.getId();
//				
//			}
//			title = ironfoDoc_Title_Service.getDocId(userId);
//			if(title != null){
//			ironfoggwsylsbpz.setDoc_id(title.getId());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//		try {
//			//Ironfoggwsylsbpz ironfoggwsylsbpz2 = new Ironfoggwsylsbpz();
//			//ironfoggwsylsbpz2.set
//            String fileName = "3.4公共卫生部医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//			Page<Ironfoggwsylsbpz> page = ironfoggwsylsbpzService
//					.findPage(new Page<Ironfoggwsylsbpz>(request, response, -1), ironfoggwsylsbpz);
//			ExportExcel exls = new ExportExcel("3.4公共卫生部医疗设备配置", Ironfoggwsylsbpz.class);
//			List<Ironfoggwsylsbpz> list1 = page.getList();
//			
//			List<String> headerList = exls.getHeaderList();
//			List<String> list2 = new ArrayList<String>();
//			for (String header : headerList) {
//				
//				for (Ironfoggwsylsbpz iron : list1) {
//					String header1 = iron.getSbmc() + "-" +header;
//					
//					list2.add(header1);
//				}
//			}
//			exls.setHeaderList(list2);
//			exls.setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出3.4公共卫生部医疗设备配置记录失败！失败信息："+e.getMessage());
//		}
//		return "redirect:"+Global.getAdminPath()+"/report/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
//    }
	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoggwsylsbpzReport> list = ei.getDataList(IronfoggwsylsbpzReport.class);
			for (IronfoggwsylsbpzReport ironfoggwsylsbpz : list){
				try{
					ironfoggwsylsbpzReportService.save(ironfoggwsylsbpz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条3.4公共卫生部医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条3.4公共卫生部医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入3.4公共卫生部医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
    }
	
	/**
	 * 下载导入3.4公共卫生部医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfoggwsylsbpzreport:ironfoggwsylsbpz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.4公共卫生部医疗设备配置数据导入模板.xlsx";
    		List<IronfoggwsylsbpzReport> list = Lists.newArrayList(); 
    		new ExportExcel("3.4公共卫生部医疗设备配置数据", IronfoggwsylsbpzReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoggwsylsbpzreport/ironfoggwsylsbpz/?repage";
    }
	
	
	

}