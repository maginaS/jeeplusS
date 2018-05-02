/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopopulationreport.web;

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
import com.jeeplus.modules.report.ironfopopulationreport.entity.IronfopopulationReport;
import com.jeeplus.modules.report.ironfopopulationreport.service.IronfopopulationReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.1.1建筑总体概况Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfopopulationreport/ironfopopulation")
public class IronfopopulationReportController extends BaseController {

	@Autowired
	private IronfopopulationReportService ironfopopulationService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfopopulationReport get(@RequestParam(required=false) String id) {
		IronfopopulationReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfopopulationService.get(id);
		}
		if (entity == null){
			entity = new IronfopopulationReport();
		}
		return entity;
	}
	
	/**
	 * 5.1.1建筑总体概况列表页面
	 */
	@RequiresPermissions("ironfopopulationreport:ironfopopulation:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfopopulationReport ironfopopulation, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfopopulation.getDuser() != null&&ironfopopulation.getDuser().toString() != null && ironfopopulation.getDuser().toString().trim() != null
					&& !"".equals(ironfopopulation.getDuser().toString().trim())
					&& !"null".equals(ironfopopulation.getDuser().toString().trim())) {
				userId = ironfopopulation.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfopopulation.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfopopulationReport> page = ironfopopulationService.findPage(new Page<IronfopopulationReport>(request, response), ironfopopulation); 
		model.addAttribute("page", page);
		return "modules/report/ironfopopulationreport/ironfopopulationList";
	}

	/**
	 * 查看，增加，编辑5.1.1建筑总体概况表单页面
	 */
	@RequiresPermissions(value={"ironfopopulationreport:ironfopopulation:view","ironfopopulationreport:ironfopopulation:add","ironfopopulationreport:ironfopopulation:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfopopulationReport ironfopopulation, Model model) {
		model.addAttribute("ironfopopulation", ironfopopulation);
		return "report/ironfopopulationreport/ironfopopulationForm";
	}

	/**
	 * 保存5.1.1建筑总体概况
	 */
	@RequiresPermissions(value={"ironfopopulationreport:ironfopopulation:add","ironfopopulationreport:ironfopopulation:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfopopulationReport ironfopopulation, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfopopulation)){
			return form(ironfopopulation, model);
		}
		if(!ironfopopulation.getIsNewRecord()){//编辑表单保存
			IronfopopulationReport t = ironfopopulationService.get(ironfopopulation.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfopopulation, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfopopulationService.save(t);//保存
		}else{//新增表单保存
			ironfopopulationService.save(ironfopopulation);//保存
		}
		addMessage(redirectAttributes, "保存5.1.1建筑总体概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationreport/ironfopopulation/?repage";
	}
	
	/**
	 * 删除5.1.1建筑总体概况
	 */
	@RequiresPermissions("ironfopopulationreport:ironfopopulation:del")
	@RequestMapping(value = "delete")
	public String delete(IronfopopulationReport ironfopopulation, RedirectAttributes redirectAttributes) {
		ironfopopulationService.delete(ironfopopulation);
		addMessage(redirectAttributes, "删除5.1.1建筑总体概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationreport/ironfopopulation/?repage";
	}
	
	/**
	 * 批量删除5.1.1建筑总体概况
	 */
	@RequiresPermissions("ironfopopulationreport:ironfopopulation:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfopopulationService.delete(ironfopopulationService.get(id));
		}
		addMessage(redirectAttributes, "删除5.1.1建筑总体概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationreport/ironfopopulation/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfopopulationreport:ironfopopulation:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfopopulationReport ironfopopulation, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfopopulation.getDuser() != null&&ironfopopulation.getDuser().toString() != null && ironfopopulation.getDuser().toString().trim() != null
					&& !"".equals(ironfopopulation.getDuser().toString().trim())
					&& !"null".equals(ironfopopulation.getDuser().toString().trim())) {
				userId = ironfopopulation.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfopopulation.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.1.1建筑总体概况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfopopulationReport> page = ironfopopulationService.findPage(new Page<IronfopopulationReport>(request, response, -1), ironfopopulation);
    		new ExportExcel("5.1.1建筑总体概况", IronfopopulationReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.1.1建筑总体概况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfopopulationreport/ironfopopulation/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfopopulationreport:ironfopopulation:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfopopulationReport> list = ei.getDataList(IronfopopulationReport.class);
			for (IronfopopulationReport ironfopopulation : list){
				try{
					ironfopopulationService.save(ironfopopulation);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.1.1建筑总体概况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.1.1建筑总体概况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.1.1建筑总体概况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationreport/ironfopopulation/?repage";
    }
	
	/**
	 * 下载导入5.1.1建筑总体概况数据模板
	 */
	@RequiresPermissions("ironfopopulationreport:ironfopopulation:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.1.1建筑总体概况数据导入模板.xlsx";
    		List<IronfopopulationReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.1.1建筑总体概况数据", IronfopopulationReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationreport/ironfopopulation/?repage";
    }
	
	
	

}