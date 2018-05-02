/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinforexperiencereport.web;

import java.util.List;

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
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.report.ironfoinforexperiencereport.entity.IronfoinformationexperienceReport;
import com.jeeplus.modules.report.ironfoinforexperiencereport.service.IronfoinformationexperienceReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 4.3信息化系统使用体验Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinforexperiencereport/ironfoinformationexperience")
public class IronfoinformationexperienceReportController extends BaseController {

	@Autowired
	private IronfoinformationexperienceReportService ironfoinformationexperienceService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfoinformationexperienceReport get(@RequestParam(required=false) String id) {
		IronfoinformationexperienceReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationexperienceService.get(id);
		}
		if (entity == null){
			entity = new IronfoinformationexperienceReport();
		}
		return entity;
	}
	
	/**
	 * 4.3信息化系统使用体验列表页面
	 */
	@RequiresPermissions("ironfoinforexperiencereport:ironfoinformationexperience:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoinformationexperienceReport ironfoinformationexperience, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoinformationexperience.getDuser() != null&&ironfoinformationexperience.getDuser().toString() != null && ironfoinformationexperience.getDuser().toString().trim() != null
					&& !"".equals(ironfoinformationexperience.getDuser().toString().trim())
					&& !"null".equals(ironfoinformationexperience.getDuser().toString().trim())) {
				userId = ironfoinformationexperience.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			//根据title表如果没字段,就默认查当前用户下的信息
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoinformationexperience.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoinformationexperienceReport> page = ironfoinformationexperienceService.findPage(new Page<IronfoinformationexperienceReport>(request, response), ironfoinformationexperience); 
		model.addAttribute("page", page);
		return "modules/report/ironfoinforexperiencereport/ironfoinformationexperienceList";
	}

	/**
	 * 查看，增加，编辑4.3信息化系统使用体验表单页面
	 */
	@RequiresPermissions(value={"ironfoinforexperiencereport:ironfoinformationexperience:view","ironfoinforexperiencereport:ironfoinformationexperience:add","ironfoinforexperiencereport:ironfoinformationexperience:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoinformationexperienceReport ironfoinformationexperience, Model model) {
		model.addAttribute("ironfoinformationexperience", ironfoinformationexperience);
		return "report/ironfoinforexperiencereport/ironfoinformationexperienceForm";
	}

	/**
	 * 保存4.3信息化系统使用体验
	 */
	@RequiresPermissions(value={"ironfoinforexperiencereport:ironfoinformationexperience:add","ironfoinforexperiencereport:ironfoinformationexperience:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoinformationexperienceReport ironfoinformationexperience, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoinformationexperience)){
			return form(ironfoinformationexperience, model);
		}
		if(!ironfoinformationexperience.getIsNewRecord()){//编辑表单保存
			IronfoinformationexperienceReport t = ironfoinformationexperienceService.get(ironfoinformationexperience.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoinformationexperience, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoinformationexperienceService.save(t);//保存
		}else{//新增表单保存
			ironfoinformationexperienceService.save(ironfoinformationexperience);//保存
		}
		addMessage(redirectAttributes, "保存4.3信息化系统使用体验成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinforexperiencereport/ironfoinformationexperience/?repage";
	}
	
	/**
	 * 删除4.3信息化系统使用体验
	 */
	@RequiresPermissions("ironfoinforexperiencereport:ironfoinformationexperience:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoinformationexperienceReport ironfoinformationexperience, RedirectAttributes redirectAttributes) {
		ironfoinformationexperienceService.delete(ironfoinformationexperience);
		addMessage(redirectAttributes, "删除4.3信息化系统使用体验成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinforexperiencereport/ironfoinformationexperience/?repage";
	}
	
	/**
	 * 批量删除4.3信息化系统使用体验
	 */
	@RequiresPermissions("ironfoinforexperiencereport:ironfoinformationexperience:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationexperienceService.delete(ironfoinformationexperienceService.get(id));
		}
		addMessage(redirectAttributes, "删除4.3信息化系统使用体验成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinforexperiencereport/ironfoinformationexperience/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinforexperiencereport:ironfoinformationexperience:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoinformationexperienceReport ironfoinformationexperience, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoinformationexperience.getDuser() != null&&ironfoinformationexperience.getDuser().toString() != null && ironfoinformationexperience.getDuser().toString().trim() != null
					&& !"".equals(ironfoinformationexperience.getDuser().toString().trim())
					&& !"null".equals(ironfoinformationexperience.getDuser().toString().trim())) {
				userId = ironfoinformationexperience.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			//根据title表如果没字段,就默认查当前用户下的信息
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoinformationexperience.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "4.3信息化系统使用体验"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoinformationexperienceReport> page = ironfoinformationexperienceService.findPage(new Page<IronfoinformationexperienceReport>(request, response, -1), ironfoinformationexperience);
    		new ExportExcel("4.3信息化系统使用体验", IronfoinformationexperienceReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.3信息化系统使用体验记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinforexperiencereport/ironfoinformationexperience/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinforexperiencereport:ironfoinformationexperience:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoinformationexperienceReport> list = ei.getDataList(IronfoinformationexperienceReport.class);
			for (IronfoinformationexperienceReport ironfoinformationexperience : list){
				try{
					ironfoinformationexperienceService.save(ironfoinformationexperience);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.3信息化系统使用体验记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.3信息化系统使用体验记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.3信息化系统使用体验失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinforexperiencereport/ironfoinformationexperience/?repage";
    }
	
	/**
	 * 下载导入4.3信息化系统使用体验数据模板
	 */
	@RequiresPermissions("ironfoinforexperiencereport:ironfoinformationexperience:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.3信息化系统使用体验数据导入模板.xlsx";
    		List<IronfoinformationexperienceReport> list = Lists.newArrayList(); 
    		new ExportExcel("4.3信息化系统使用体验数据", IronfoinformationexperienceReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinforexperiencereport/ironfoinformationexperience/?repage";
    }
	
	
	

}