/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveswcdreport.web;

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
import com.jeeplus.modules.report.ironfofiveswcdreport.entity.IronfofiveswcdReport;
import com.jeeplus.modules.report.ironfofiveswcdreport.service.IronfofiveswcdReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.9室外场地Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveswcdreport/ironfofiveswcd")
public class IronfofiveswcdReportController extends BaseController {

	@Autowired
	private IronfofiveswcdReportService ironfofiveswcdService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofiveswcdReport get(@RequestParam(required=false) String id) {
		IronfofiveswcdReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveswcdService.get(id);
		}
		if (entity == null){
			entity = new IronfofiveswcdReport();
		}
		return entity;
	}
	
	/**
	 * 5.9室外场地列表页面
	 */
	@RequiresPermissions("ironfofiveswcdreport:ironfofiveswcd:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiveswcdReport ironfofiveswcd, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveswcd.getDuser() != null&&ironfofiveswcd.getDuser().toString() != null && ironfofiveswcd.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveswcd.getDuser().toString().trim())
					&& !"null".equals(ironfofiveswcd.getDuser().toString().trim())) {
				userId = ironfofiveswcd.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveswcd.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiveswcdReport> page = ironfofiveswcdService.findPage(new Page<IronfofiveswcdReport>(request, response), ironfofiveswcd); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiveswcdreport/ironfofiveswcdList";
	}

	/**
	 * 查看，增加，编辑5.9室外场地表单页面
	 */
	@RequiresPermissions(value={"ironfofiveswcdreport:ironfofiveswcd:view","ironfofiveswcdreport:ironfofiveswcd:add","ironfofiveswcdreport:ironfofiveswcd:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiveswcdReport ironfofiveswcd, Model model) {
		model.addAttribute("ironfofiveswcd", ironfofiveswcd);
		return "report/ironfofiveswcdreport/ironfofiveswcdForm";
	}

	/**
	 * 保存5.9室外场地
	 */
	@RequiresPermissions(value={"ironfofiveswcdreport:ironfofiveswcd:add","ironfofiveswcdreport:ironfofiveswcd:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiveswcdReport ironfofiveswcd, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiveswcd)){
			return form(ironfofiveswcd, model);
		}
		if(!ironfofiveswcd.getIsNewRecord()){//编辑表单保存
			IronfofiveswcdReport t = ironfofiveswcdService.get(ironfofiveswcd.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiveswcd, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiveswcdService.save(t);//保存
		}else{//新增表单保存
			ironfofiveswcdService.save(ironfofiveswcd);//保存
		}
		addMessage(redirectAttributes, "保存5.9室外场地成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcdreport/ironfofiveswcd/?repage";
	}
	
	/**
	 * 删除5.9室外场地
	 */
	@RequiresPermissions("ironfofiveswcdreport:ironfofiveswcd:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiveswcdReport ironfofiveswcd, RedirectAttributes redirectAttributes) {
		ironfofiveswcdService.delete(ironfofiveswcd);
		addMessage(redirectAttributes, "删除5.9室外场地成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcdreport/ironfofiveswcd/?repage";
	}
	
	/**
	 * 批量删除5.9室外场地
	 */
	@RequiresPermissions("ironfofiveswcdreport:ironfofiveswcd:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveswcdService.delete(ironfofiveswcdService.get(id));
		}
		addMessage(redirectAttributes, "删除5.9室外场地成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcdreport/ironfofiveswcd/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveswcdreport:ironfofiveswcd:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiveswcdReport ironfofiveswcd, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveswcd.getDuser() != null&&ironfofiveswcd.getDuser().toString() != null && ironfofiveswcd.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveswcd.getDuser().toString().trim())
					&& !"null".equals(ironfofiveswcd.getDuser().toString().trim())) {
				userId = ironfofiveswcd.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveswcd.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.9室外场地"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiveswcdReport> page = ironfofiveswcdService.findPage(new Page<IronfofiveswcdReport>(request, response, -1), ironfofiveswcd);
    		new ExportExcel("5.9室外场地", IronfofiveswcdReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.9室外场地记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofiveswcdreport/ironfofiveswcd/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveswcdreport:ironfofiveswcd:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiveswcdReport> list = ei.getDataList(IronfofiveswcdReport.class);
			for (IronfofiveswcdReport ironfofiveswcd : list){
				try{
					ironfofiveswcdService.save(ironfofiveswcd);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.9室外场地记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.9室外场地记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.9室外场地失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcdreport/ironfofiveswcd/?repage";
    }
	
	/**
	 * 下载导入5.9室外场地数据模板
	 */
	@RequiresPermissions("ironfofiveswcdreport:ironfofiveswcd:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.9室外场地数据导入模板.xlsx";
    		List<IronfofiveswcdReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.9室外场地数据", IronfofiveswcdReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcdreport/ironfofiveswcd/?repage";
    }
	
	
	

}