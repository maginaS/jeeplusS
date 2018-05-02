/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.web;

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
import com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.entity.IronfofiveqtzyqtzlReport;
import com.jeeplus.modules.report.ironfofiveqtzyqtzlreport.service.IronfofiveqtzyqtzlReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 气体种类Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl")
public class IronfofiveqtzyqtzlReportController extends BaseController {

	@Autowired
	private IronfofiveqtzyqtzlReportService ironfofiveqtzyqtzlService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofiveqtzyqtzlReport get(@RequestParam(required=false) String id) {
		IronfofiveqtzyqtzlReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveqtzyqtzlService.get(id);
		}
		if (entity == null){
			entity = new IronfofiveqtzyqtzlReport();
		}
		return entity;
	}
	
	/**
	 * 气体种类列表页面
	 */
	@RequiresPermissions("ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveqtzyqtzl.getDuser() != null&&ironfofiveqtzyqtzl.getDuser().toString() != null && ironfofiveqtzyqtzl.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveqtzyqtzl.getDuser().toString().trim())
					&& !"null".equals(ironfofiveqtzyqtzl.getDuser().toString().trim())) {
				userId = ironfofiveqtzyqtzl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveqtzyqtzl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiveqtzyqtzlReport> page = ironfofiveqtzyqtzlService.findPage(new Page<IronfofiveqtzyqtzlReport>(request, response), ironfofiveqtzyqtzl); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzlList";
	}

	/**
	 * 查看，增加，编辑气体种类表单页面
	 */
	@RequiresPermissions(value={"ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:view","ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:add","ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl, Model model) {
		model.addAttribute("ironfofiveqtzyqtzl", ironfofiveqtzyqtzl);
		return "report/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzlForm";
	}

	/**
	 * 保存气体种类
	 */
	@RequiresPermissions(value={"ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:add","ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiveqtzyqtzl)){
			return form(ironfofiveqtzyqtzl, model);
		}
		if(!ironfofiveqtzyqtzl.getIsNewRecord()){//编辑表单保存
			IronfofiveqtzyqtzlReport t = ironfofiveqtzyqtzlService.get(ironfofiveqtzyqtzl.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiveqtzyqtzl, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiveqtzyqtzlService.save(t);//保存
		}else{//新增表单保存
			ironfofiveqtzyqtzlService.save(ironfofiveqtzyqtzl);//保存
		}
		addMessage(redirectAttributes, "保存气体种类成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl/?repage";
	}
	
	/**
	 * 删除气体种类
	 */
	@RequiresPermissions("ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl, RedirectAttributes redirectAttributes) {
		ironfofiveqtzyqtzlService.delete(ironfofiveqtzyqtzl);
		addMessage(redirectAttributes, "删除气体种类成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl/?repage";
	}
	
	/**
	 * 批量删除气体种类
	 */
	@RequiresPermissions("ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveqtzyqtzlService.delete(ironfofiveqtzyqtzlService.get(id));
		}
		addMessage(redirectAttributes, "删除气体种类成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveqtzyqtzl.getDuser() != null&&ironfofiveqtzyqtzl.getDuser().toString() != null && ironfofiveqtzyqtzl.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveqtzyqtzl.getDuser().toString().trim())
					&& !"null".equals(ironfofiveqtzyqtzl.getDuser().toString().trim())) {
				userId = ironfofiveqtzyqtzl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveqtzyqtzl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "气体种类"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiveqtzyqtzlReport> page = ironfofiveqtzyqtzlService.findPage(new Page<IronfofiveqtzyqtzlReport>(request, response, -1), ironfofiveqtzyqtzl);
    		new ExportExcel("气体种类", IronfofiveqtzyqtzlReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出气体种类记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiveqtzyqtzlReport> list = ei.getDataList(IronfofiveqtzyqtzlReport.class);
			for (IronfofiveqtzyqtzlReport ironfofiveqtzyqtzl : list){
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
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl/?repage";
    }
	
	/**
	 * 下载导入气体种类数据模板
	 */
	@RequiresPermissions("ironfofiveqtzyqtzlreport:ironfofiveqtzyqtzl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "气体种类数据导入模板.xlsx";
    		List<IronfofiveqtzyqtzlReport> list = Lists.newArrayList(); 
    		new ExportExcel("气体种类数据", IronfofiveqtzyqtzlReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzyqtzlreport/ironfofiveqtzyqtzl/?repage";
    }
	
	
	

}