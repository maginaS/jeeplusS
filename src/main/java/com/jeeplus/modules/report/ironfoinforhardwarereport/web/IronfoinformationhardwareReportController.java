/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinforhardwarereport.web;

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
import com.jeeplus.modules.report.ironfoinforhardwarereport.entity.IronfoinformationhardwareReport;
import com.jeeplus.modules.report.ironfoinforhardwarereport.service.IronfoinformationhardwareReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 4.5信息化系统配套硬件Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinforhardwarereport/ironfoinformationhardware")
public class IronfoinformationhardwareReportController extends BaseController {

	@Autowired
	private IronfoinformationhardwareReportService ironfoinformationhardwareService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfoinformationhardwareReport get(@RequestParam(required=false) String id) {
		IronfoinformationhardwareReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationhardwareService.get(id);
		}
		if (entity == null){
			entity = new IronfoinformationhardwareReport();
		}
		return entity;
	}
	
	/**
	 * 4.5信息化系统配套硬件列表页面
	 */
	@RequiresPermissions("ironfoinforhardwarereport:ironfoinformationhardware:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoinformationhardwareReport ironfoinformationhardware, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoinformationhardware.getDuser() != null&&ironfoinformationhardware.getDuser().toString() != null && ironfoinformationhardware.getDuser().toString().trim() != null
					&& !"".equals(ironfoinformationhardware.getDuser().toString().trim())
					&& !"null".equals(ironfoinformationhardware.getDuser().toString().trim())) {
				userId = ironfoinformationhardware.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			//根据title表如果没字段,就默认查当前用户下的信息
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoinformationhardware.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoinformationhardwareReport> page = ironfoinformationhardwareService.findPage(new Page<IronfoinformationhardwareReport>(request, response), ironfoinformationhardware); 
		model.addAttribute("page", page);
		return "modules/report/ironfoinforhardwarereport/ironfoinformationhardwareList";
	}

	/**
	 * 查看，增加，编辑4.5信息化系统配套硬件表单页面
	 */
	@RequiresPermissions(value={"ironfoinforhardwarereport:ironfoinformationhardware:view","ironfoinforhardwarereport:ironfoinformationhardware:add","ironfoinforhardwarereport:ironfoinformationhardware:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoinformationhardwareReport ironfoinformationhardware, Model model) {
		model.addAttribute("ironfoinformationhardware", ironfoinformationhardware);
		return "report/ironfoinforhardwarereport/ironfoinformationhardwareForm";
	}

	/**
	 * 保存4.5信息化系统配套硬件
	 */
	@RequiresPermissions(value={"ironfoinforhardwarereport:ironfoinformationhardware:add","ironfoinforhardwarereport:ironfoinformationhardware:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoinformationhardwareReport ironfoinformationhardware, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoinformationhardware)){
			return form(ironfoinformationhardware, model);
		}
		if(!ironfoinformationhardware.getIsNewRecord()){//编辑表单保存
			IronfoinformationhardwareReport t = ironfoinformationhardwareService.get(ironfoinformationhardware.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoinformationhardware, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoinformationhardwareService.save(t);//保存
		}else{//新增表单保存
			ironfoinformationhardwareService.save(ironfoinformationhardware);//保存
		}
		addMessage(redirectAttributes, "保存4.5信息化系统配套硬件成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinforhardwarereport/ironfoinformationhardware/?repage";
	}
	
	/**
	 * 删除4.5信息化系统配套硬件
	 */
	@RequiresPermissions("ironfoinforhardwarereport:ironfoinformationhardware:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoinformationhardwareReport ironfoinformationhardware, RedirectAttributes redirectAttributes) {
		ironfoinformationhardwareService.delete(ironfoinformationhardware);
		addMessage(redirectAttributes, "删除4.5信息化系统配套硬件成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinforhardwarereport/ironfoinformationhardware/?repage";
	}
	
	/**
	 * 批量删除4.5信息化系统配套硬件
	 */
	@RequiresPermissions("ironfoinforhardwarereport:ironfoinformationhardware:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationhardwareService.delete(ironfoinformationhardwareService.get(id));
		}
		addMessage(redirectAttributes, "删除4.5信息化系统配套硬件成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinforhardwarereport/ironfoinformationhardware/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinforhardwarereport:ironfoinformationhardware:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoinformationhardwareReport ironfoinformationhardware, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoinformationhardware.getDuser() != null&&ironfoinformationhardware.getDuser().toString() != null && ironfoinformationhardware.getDuser().toString().trim() != null
					&& !"".equals(ironfoinformationhardware.getDuser().toString().trim())
					&& !"null".equals(ironfoinformationhardware.getDuser().toString().trim())) {
				userId = ironfoinformationhardware.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoinformationhardware.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "4.5信息化系统配套硬件"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoinformationhardwareReport> page = ironfoinformationhardwareService.findPage(new Page<IronfoinformationhardwareReport>(request, response, -1), ironfoinformationhardware);
    		new ExportExcel("4.5信息化系统配套硬件", IronfoinformationhardwareReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.5信息化系统配套硬件记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinforhardwarereport/ironfoinformationhardware/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinforhardwarereport:ironfoinformationhardware:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoinformationhardwareReport> list = ei.getDataList(IronfoinformationhardwareReport.class);
			for (IronfoinformationhardwareReport ironfoinformationhardware : list){
				try{
					ironfoinformationhardwareService.save(ironfoinformationhardware);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.5信息化系统配套硬件记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.5信息化系统配套硬件记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.5信息化系统配套硬件失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinforhardwarereport/ironfoinformationhardware/?repage";
    }
	
	/**
	 * 下载导入4.5信息化系统配套硬件数据模板
	 */
	@RequiresPermissions("ironfoinforhardwarereport:ironfoinformationhardware:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.5信息化系统配套硬件数据导入模板.xlsx";
    		List<IronfoinformationhardwareReport> list = Lists.newArrayList(); 
    		new ExportExcel("4.5信息化系统配套硬件数据", IronfoinformationhardwareReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinforhardwarereport/ironfoinformationhardware/?repage";
    }
	
	
	

}