/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoemergencyroomreport.web;

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
import com.jeeplus.modules.report.ironfoemergencyroomreport.entity.IronfoemergencyroomReport;
import com.jeeplus.modules.report.ironfoemergencyroomreport.service.IronfoemergencyroomReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 门急诊部医疗设备配置Controller
 * @author mikesun
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoemergencyroomreport/ironfoemergencyroom")
public class IronfoemergencyroomReportController extends BaseController {

	@Autowired
	private IronfoemergencyroomReportService ironfoemergencyroomService;
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoemergencyroomReport get(@RequestParam(required=false) String id) {
		IronfoemergencyroomReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoemergencyroomService.get(id);
		}
		if (entity == null){
			entity = new IronfoemergencyroomReport();
		}
		return entity;
	}
	
	
	/**
	 * 门急诊部医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfoemergencyroomreport:ironfoemergencyroom:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoemergencyroomReport ironfoemergencyroom, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoemergencyroom.getDuser() != null&&ironfoemergencyroom.getDuser().toString() != null && ironfoemergencyroom.getDuser().toString().trim() != null
					&& !"".equals(ironfoemergencyroom.getDuser().toString().trim())
					&& !"null".equals(ironfoemergencyroom.getDuser().toString().trim())) {
				userId = ironfoemergencyroom.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			//System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoemergencyroom.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoemergencyroomReport> page = ironfoemergencyroomService.findPage(new Page<IronfoemergencyroomReport>(request, response), ironfoemergencyroom); 
		model.addAttribute("page", page);
		return "modules/report/ironfoemergencyroomreport/ironfoemergencyroomList";
	}

	/**
	 * 查看，增加，编辑门急诊部医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfoemergencyroomreport:ironfoemergencyroom:view","ironfoemergencyroomreport:ironfoemergencyroom:add","ironfoemergencyroomreport:ironfoemergencyroom:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoemergencyroomReport ironfoemergencyroom, Model model) {
		model.addAttribute("ironfoemergencyroom", ironfoemergencyroom);
		return "modules/report/ironfoemergencyroomreport/ironfoemergencyroomForm";
	}

	/**
	 * 保存门急诊部医疗设备配置
	 */
	@RequiresPermissions(value={"ironfoemergencyroomreport:ironfoemergencyroom:add","ironfoemergencyroomreport:ironfoemergencyroom:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoemergencyroomReport ironfoemergencyroom, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoemergencyroom)){
			return form(ironfoemergencyroom, model);
		}
		if(!ironfoemergencyroom.getIsNewRecord()){//编辑表单保存
			IronfoemergencyroomReport t = ironfoemergencyroomService.get(ironfoemergencyroom.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoemergencyroom, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoemergencyroomService.save(t);//保存
		}else{//新增表单保存
			ironfoemergencyroomService.save(ironfoemergencyroom);//保存
		}
		addMessage(redirectAttributes, "保存门急诊部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/report/ironfoemergencyroomreport/ironfoemergencyroom/?repage";
	}
	
	/**
	 * 删除门急诊部医疗设备配置
	 */
	@RequiresPermissions("ironfoemergencyroomreport:ironfoemergencyroom:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoemergencyroomReport ironfoemergencyroom, RedirectAttributes redirectAttributes) {
		ironfoemergencyroomService.delete(ironfoemergencyroom);
		addMessage(redirectAttributes, "删除门急诊部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/report/ironfoemergencyroomreport/ironfoemergencyroom/?repage";
	}
	
	/**
	 * 批量删除门急诊部医疗设备配置
	 */
	@RequiresPermissions("ironfoemergencyroomreport:ironfoemergencyroom:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoemergencyroomService.delete(ironfoemergencyroomService.get(id));
		}
		addMessage(redirectAttributes, "删除门急诊部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/report/ironfoemergencyroomreport/ironfoemergencyroom/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoemergencyroomreport:ironfoemergencyroom:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoemergencyroomReport ironfoemergencyroom, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoemergencyroom.getDuser() != null && ironfoemergencyroom.getDuser().toString() != null
					&& ironfoemergencyroom.getDuser().toString().trim() != null
					&& !"".equals(ironfoemergencyroom.getDuser().toString().trim())
					&& !"null".equals(ironfoemergencyroom.getDuser().toString().trim())) {
				userId = ironfoemergencyroom.getDuser().getId();
				title.setRemarks(userId);
			} else{
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoemergencyroom.setDoc_id(title.getId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "门急诊部医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoemergencyroomReport> page = ironfoemergencyroomService.findPage(new Page<IronfoemergencyroomReport>(request, response, -1), ironfoemergencyroom);
    		new ExportExcel("门急诊部医疗设备配置", IronfoemergencyroomReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出门急诊部医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfoemergencyroomreport/ironfoemergencyroom/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoemergencyroomreport:ironfoemergencyroom:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoemergencyroomReport> list = ei.getDataList(IronfoemergencyroomReport.class);
			for (IronfoemergencyroomReport ironfoemergencyroom : list){
				try{
					ironfoemergencyroomService.save(ironfoemergencyroom);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条门急诊部医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条门急诊部医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入门急诊部医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfoemergencyroomreport/ironfoemergencyroom/?repage";
    }
	
	/**
	 * 下载导入门急诊部医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfoemergencyroomreport:ironfoemergencyroom:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "门急诊部医疗设备配置数据导入模板.xlsx";
    		List<IronfoemergencyroomReport> list = Lists.newArrayList(); 
    		new ExportExcel("门急诊部医疗设备配置数据", IronfoemergencyroomReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfoemergencyroomreport/ironfoemergencyroom/?repage";
    }
	
	
	

}