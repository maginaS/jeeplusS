/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszywsclreport.web;

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
import com.jeeplus.modules.report.ironfofivegpszywsclreport.entity.IronfofivegpszywsclReport;
import com.jeeplus.modules.report.ironfofivegpszywsclreport.service.IronfofivegpszywsclReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 污水处理Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivegpszywsclreport/ironfofivegpszywscl")
public class IronfofivegpszywsclReportController extends BaseController {

	@Autowired
	private IronfofivegpszywsclReportService ironfofivegpszywsclService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofivegpszywsclReport get(@RequestParam(required=false) String id) {
		IronfofivegpszywsclReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivegpszywsclService.get(id);
		}
		if (entity == null){
			entity = new IronfofivegpszywsclReport();
		}
		return entity;
	}
	
	/**
	 * 污水处理列表页面
	 */
	@RequiresPermissions("ironfofivegpszywsclreport:ironfofivegpszywscl:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivegpszywsclReport ironfofivegpszywscl, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivegpszywscl.getDuser() != null&&ironfofivegpszywscl.getDuser().toString() != null && ironfofivegpszywscl.getDuser().toString().trim() != null
					&& !"".equals(ironfofivegpszywscl.getDuser().toString().trim())
					&& !"null".equals(ironfofivegpszywscl.getDuser().toString().trim())) {
				userId = ironfofivegpszywscl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivegpszywscl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivegpszywsclReport> page = ironfofivegpszywsclService.findPage(new Page<IronfofivegpszywsclReport>(request, response), ironfofivegpszywscl); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivegpszywsclreport/ironfofivegpszywsclList";
	}

	/**
	 * 查看，增加，编辑污水处理表单页面
	 */
	@RequiresPermissions(value={"ironfofivegpszywsclreport:ironfofivegpszywscl:view","ironfofivegpszywsclreport:ironfofivegpszywscl:add","ironfofivegpszywsclreport:ironfofivegpszywscl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivegpszywsclReport ironfofivegpszywscl, Model model) {
		model.addAttribute("ironfofivegpszywscl", ironfofivegpszywscl);
		return "report/ironfofivegpszywsclreport/ironfofivegpszywsclForm";
	}

	/**
	 * 保存污水处理
	 */
	@RequiresPermissions(value={"ironfofivegpszywsclreport:ironfofivegpszywscl:add","ironfofivegpszywsclreport:ironfofivegpszywscl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivegpszywsclReport ironfofivegpszywscl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivegpszywscl)){
			return form(ironfofivegpszywscl, model);
		}
		if(!ironfofivegpszywscl.getIsNewRecord()){//编辑表单保存
			IronfofivegpszywsclReport t = ironfofivegpszywsclService.get(ironfofivegpszywscl.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivegpszywscl, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivegpszywsclService.save(t);//保存
		}else{//新增表单保存
			ironfofivegpszywsclService.save(ironfofivegpszywscl);//保存
		}
		addMessage(redirectAttributes, "保存污水处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywsclreport/ironfofivegpszywscl/?repage";
	}
	
	/**
	 * 删除污水处理
	 */
	@RequiresPermissions("ironfofivegpszywsclreport:ironfofivegpszywscl:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivegpszywsclReport ironfofivegpszywscl, RedirectAttributes redirectAttributes) {
		ironfofivegpszywsclService.delete(ironfofivegpszywscl);
		addMessage(redirectAttributes, "删除污水处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywsclreport/ironfofivegpszywscl/?repage";
	}
	
	/**
	 * 批量删除污水处理
	 */
	@RequiresPermissions("ironfofivegpszywsclreport:ironfofivegpszywscl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivegpszywsclService.delete(ironfofivegpszywsclService.get(id));
		}
		addMessage(redirectAttributes, "删除污水处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywsclreport/ironfofivegpszywscl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivegpszywsclreport:ironfofivegpszywscl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivegpszywsclReport ironfofivegpszywscl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivegpszywscl.getDuser() != null&&ironfofivegpszywscl.getDuser().toString() != null && ironfofivegpszywscl.getDuser().toString().trim() != null
					&& !"".equals(ironfofivegpszywscl.getDuser().toString().trim())
					&& !"null".equals(ironfofivegpszywscl.getDuser().toString().trim())) {
				userId = ironfofivegpszywscl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivegpszywscl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "污水处理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivegpszywsclReport> page = ironfofivegpszywsclService.findPage(new Page<IronfofivegpszywsclReport>(request, response, -1), ironfofivegpszywscl);
    		new ExportExcel("污水处理", IronfofivegpszywsclReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出污水处理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivegpszywsclreport/ironfofivegpszywscl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivegpszywsclreport:ironfofivegpszywscl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivegpszywsclReport> list = ei.getDataList(IronfofivegpszywsclReport.class);
			for (IronfofivegpszywsclReport ironfofivegpszywscl : list){
				try{
					ironfofivegpszywsclService.save(ironfofivegpszywscl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条污水处理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条污水处理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入污水处理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywsclreport/ironfofivegpszywscl/?repage";
    }
	
	/**
	 * 下载导入污水处理数据模板
	 */
	@RequiresPermissions("ironfofivegpszywsclreport:ironfofivegpszywscl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "污水处理数据导入模板.xlsx";
    		List<IronfofivegpszywsclReport> list = Lists.newArrayList(); 
    		new ExportExcel("污水处理数据", IronfofivegpszywsclReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywsclreport/ironfofivegpszywscl/?repage";
    }
	
	
	

}