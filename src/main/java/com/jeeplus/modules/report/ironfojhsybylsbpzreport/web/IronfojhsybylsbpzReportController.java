/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfojhsybylsbpzreport.web;

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
import com.jeeplus.modules.report.ironfojhsybylsbpzreport.entity.IronfojhsybylsbpzReport;
import com.jeeplus.modules.report.ironfojhsybylsbpzreport.service.IronfojhsybylsbpzReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 3.5计划生育部医疗设备配置Controller
 * @author anti_magina
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfojhsybylsbpzreport/ironfojhsybylsbpz")
public class IronfojhsybylsbpzReportController extends BaseController {

	@Autowired
	private IronfojhsybylsbpzReportService ironfojhsybylsbpzService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfojhsybylsbpzReport get(@RequestParam(required=false) String id) {
		IronfojhsybylsbpzReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfojhsybylsbpzService.get(id);
		}
		if (entity == null){
			entity = new IronfojhsybylsbpzReport();
		}
		return entity;
	}
	
	/**
	 * 3.5计划生育部医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfojhsybylsbpzreport:ironfojhsybylsbpz:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfojhsybylsbpzReport ironfojhsybylsbpz, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfojhsybylsbpz.getDuser() != null&&ironfojhsybylsbpz.getDuser().toString() != null && ironfojhsybylsbpz.getDuser().toString().trim() != null
					&& !"".equals(ironfojhsybylsbpz.getDuser().toString().trim())
					&& !"null".equals(ironfojhsybylsbpz.getDuser().toString().trim())) {
				userId = ironfojhsybylsbpz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfojhsybylsbpz.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfojhsybylsbpzReport> page = ironfojhsybylsbpzService.findPage(new Page<IronfojhsybylsbpzReport>(request, response), ironfojhsybylsbpz); 
		model.addAttribute("page", page);
		return "modules/report/ironfojhsybylsbpzreport/ironfojhsybylsbpzList";
	}

	/**
	 * 查看，增加，编辑3.5计划生育部医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfojhsybylsbpzreport:ironfojhsybylsbpz:view","ironfojhsybylsbpzreport:ironfojhsybylsbpz:add","ironfojhsybylsbpzreport:ironfojhsybylsbpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfojhsybylsbpzReport ironfojhsybylsbpz, Model model) {
		model.addAttribute("ironfojhsybylsbpz", ironfojhsybylsbpz);
		return "report/ironfojhsybylsbpzreport/ironfojhsybylsbpzForm";
	}

	/**
	 * 保存3.5计划生育部医疗设备配置
	 */
	@RequiresPermissions(value={"ironfojhsybylsbpzreport:ironfojhsybylsbpz:add","ironfojhsybylsbpzreport:ironfojhsybylsbpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfojhsybylsbpzReport ironfojhsybylsbpz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfojhsybylsbpz)){
			return form(ironfojhsybylsbpz, model);
		}
		if(!ironfojhsybylsbpz.getIsNewRecord()){//编辑表单保存
			IronfojhsybylsbpzReport t = ironfojhsybylsbpzService.get(ironfojhsybylsbpz.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfojhsybylsbpz, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfojhsybylsbpzService.save(t);//保存
		}else{//新增表单保存
			ironfojhsybylsbpzService.save(ironfojhsybylsbpz);//保存
		}
		addMessage(redirectAttributes, "保存3.5计划生育部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojhsybylsbpzreport/ironfojhsybylsbpz/?repage";
	}
	
	/**
	 * 删除3.5计划生育部医疗设备配置
	 */
	@RequiresPermissions("ironfojhsybylsbpzreport:ironfojhsybylsbpz:del")
	@RequestMapping(value = "delete")
	public String delete(IronfojhsybylsbpzReport ironfojhsybylsbpz, RedirectAttributes redirectAttributes) {
		
		ironfojhsybylsbpzService.delete(ironfojhsybylsbpz);
		addMessage(redirectAttributes, "删除3.5计划生育部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojhsybylsbpzreport/ironfojhsybylsbpz/?repage";
	}
	
	/**
	 * 批量删除3.5计划生育部医疗设备配置
	 */
	@RequiresPermissions("ironfojhsybylsbpzreport:ironfojhsybylsbpz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfojhsybylsbpzService.delete(ironfojhsybylsbpzService.get(id));
		}
		addMessage(redirectAttributes, "删除3.5计划生育部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojhsybylsbpzreport/ironfojhsybylsbpz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfojhsybylsbpzreport:ironfojhsybylsbpz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfojhsybylsbpzReport ironfojhsybylsbpz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfojhsybylsbpz.getDuser() != null&&ironfojhsybylsbpz.getDuser().toString() != null && ironfojhsybylsbpz.getDuser().toString().trim() != null
					&& !"".equals(ironfojhsybylsbpz.getDuser().toString().trim())
					&& !"null".equals(ironfojhsybylsbpz.getDuser().toString().trim())) {
				userId = ironfojhsybylsbpz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			if(title != null){
			title = ironfoDoc_Title_Service.getDocId(userId);
			}
			ironfojhsybylsbpz.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "3.5计划生育部医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfojhsybylsbpzReport> page = ironfojhsybylsbpzService.findPage(new Page<IronfojhsybylsbpzReport>(request, response, -1), ironfojhsybylsbpz);
    		new ExportExcel("3.5计划生育部医疗设备配置", IronfojhsybylsbpzReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出3.5计划生育部医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfojhsybylsbpzreport/ironfojhsybylsbpz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfojhsybylsbpzreport:ironfojhsybylsbpz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfojhsybylsbpzReport> list = ei.getDataList(IronfojhsybylsbpzReport.class);
			for (IronfojhsybylsbpzReport ironfojhsybylsbpz : list){
				try{
					ironfojhsybylsbpzService.save(ironfojhsybylsbpz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条3.5计划生育部医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条3.5计划生育部医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入3.5计划生育部医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojhsybylsbpzreport/ironfojhsybylsbpz/?repage";
    }
	
	/**
	 * 下载导入3.5计划生育部医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfojhsybylsbpzreport:ironfojhsybylsbpz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.5计划生育部医疗设备配置数据导入模板.xlsx";
    		List<IronfojhsybylsbpzReport> list = Lists.newArrayList(); 
    		new ExportExcel("3.5计划生育部医疗设备配置数据", IronfojhsybylsbpzReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojhsybylsbpzreport/ironfojhsybylsbpz/?repage";
    }
	
	
	

}