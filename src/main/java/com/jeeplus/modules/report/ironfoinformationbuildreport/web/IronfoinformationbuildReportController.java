/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationbuildreport.web;

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
import com.jeeplus.modules.report.ironfoinformationbuildreport.entity.IronfoinformationbuildReport;
import com.jeeplus.modules.report.ironfoinformationbuildreport.service.IronfoinformationbuildReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 4.1信息化系统建设情况Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationbuildreport/ironfoinformationbuild")
public class IronfoinformationbuildReportController extends BaseController {

	@Autowired
	private IronfoinformationbuildReportService ironfoinformationbuildService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoinformationbuildReport get(@RequestParam(required=false) String id) {
		IronfoinformationbuildReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationbuildService.get(id);
		}
		if (entity == null){
			entity = new IronfoinformationbuildReport();
		}
		return entity;
	}
	
	/**
	 * 4.1信息化系统建设情况列表页面
	 */
	@RequiresPermissions("ironfoinformationbuildreport:ironfoinformationbuild:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoinformationbuildReport ironfoinformationbuild, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoinformationbuild.getDuser() != null&&ironfoinformationbuild.getDuser().toString() != null && ironfoinformationbuild.getDuser().toString().trim() != null
					&& !"".equals(ironfoinformationbuild.getDuser().toString().trim())
					&& !"null".equals(ironfoinformationbuild.getDuser().toString().trim())) {
				userId = ironfoinformationbuild.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoinformationbuild.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoinformationbuildReport> page = ironfoinformationbuildService.findPage(new Page<IronfoinformationbuildReport>(request, response), ironfoinformationbuild); 
		model.addAttribute("page", page);
		return "modules/report/ironfoinformationbuildreport/ironfoinformationbuildList";
	}

	/**
	 * 查看，增加，编辑4.1信息化系统建设情况表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationbuildreport:ironfoinformationbuild:view","ironfoinformationbuildreport:ironfoinformationbuild:add","ironfoinformationbuildreport:ironfoinformationbuild:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoinformationbuildReport ironfoinformationbuild, Model model) {
		model.addAttribute("ironfoinformationbuild", ironfoinformationbuild);
		return "report/ironfoinformationbuildreport/ironfoinformationbuildForm";
	}

	/**
	 * 保存4.1信息化系统建设情况
	 */
	@RequiresPermissions(value={"ironfoinformationbuildreport:ironfoinformationbuild:add","ironfoinformationbuildreport:ironfoinformationbuild:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoinformationbuildReport ironfoinformationbuild, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoinformationbuild)){
			return form(ironfoinformationbuild, model);
		}
		if(!ironfoinformationbuild.getIsNewRecord()){//编辑表单保存
			IronfoinformationbuildReport t = ironfoinformationbuildService.get(ironfoinformationbuild.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoinformationbuild, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoinformationbuildService.save(t);//保存
		}else{//新增表单保存
			ironfoinformationbuildService.save(ironfoinformationbuild);//保存
		}
		addMessage(redirectAttributes, "保存4.1信息化系统建设情况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuildreport/ironfoinformationbuild/?repage";
	}
	
	/**
	 * 删除4.1信息化系统建设情况
	 */
	@RequiresPermissions("ironfoinformationbuildreport:ironfoinformationbuild:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoinformationbuildReport ironfoinformationbuild, RedirectAttributes redirectAttributes) {
		ironfoinformationbuildService.delete(ironfoinformationbuild);
		addMessage(redirectAttributes, "删除4.1信息化系统建设情况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuildreport/ironfoinformationbuild/?repage";
	}
	
	/**
	 * 批量删除4.1信息化系统建设情况
	 */
	@RequiresPermissions("ironfoinformationbuildreport:ironfoinformationbuild:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationbuildService.delete(ironfoinformationbuildService.get(id));
		}
		addMessage(redirectAttributes, "删除4.1信息化系统建设情况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuildreport/ironfoinformationbuild/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationbuildreport:ironfoinformationbuild:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoinformationbuildReport ironfoinformationbuild, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoinformationbuild.getDuser() != null&&ironfoinformationbuild.getDuser().toString() != null && ironfoinformationbuild.getDuser().toString().trim() != null
					&& !"".equals(ironfoinformationbuild.getDuser().toString().trim())
					&& !"null".equals(ironfoinformationbuild.getDuser().toString().trim())) {
				userId = ironfoinformationbuild.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoinformationbuild.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "4.1信息化系统建设情况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoinformationbuildReport> page = ironfoinformationbuildService.findPage(new Page<IronfoinformationbuildReport>(request, response, -1), ironfoinformationbuild);
    		new ExportExcel("4.1信息化系统建设情况", IronfoinformationbuildReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.1信息化系统建设情况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuildreport/ironfoinformationbuild/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationbuildreport:ironfoinformationbuild:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoinformationbuildReport> list = ei.getDataList(IronfoinformationbuildReport.class);
			for (IronfoinformationbuildReport ironfoinformationbuild : list){
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
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuildreport/ironfoinformationbuild/?repage";
    }
	
	/**
	 * 下载导入4.1信息化系统建设情况数据模板
	 */
	@RequiresPermissions("ironfoinformationbuildreport:ironfoinformationbuild:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.1信息化系统建设情况数据导入模板.xlsx";
    		List<IronfoinformationbuildReport> list = Lists.newArrayList(); 
    		new ExportExcel("4.1信息化系统建设情况数据", IronfoinformationbuildReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationbuildreport/ironfoinformationbuild/?repage";
    }
	
	
	

}