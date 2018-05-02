/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszywwclreport.web;

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
import com.jeeplus.modules.report.ironfofivegpszywwclreport.entity.IronfofivegpszywwclReport;
import com.jeeplus.modules.report.ironfofivegpszywwclreport.service.IronfofivegpszywwclReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 污物处理Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivegpszywwclreport/ironfofivegpszywwcl")
public class IronfofivegpszywwclReportController extends BaseController {

	@Autowired
	private IronfofivegpszywwclReportService ironfofivegpszywwclService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivegpszywwclReport get(@RequestParam(required=false) String id) {
		IronfofivegpszywwclReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivegpszywwclService.get(id);
		}
		if (entity == null){
			entity = new IronfofivegpszywwclReport();
		}
		return entity;
	}
	
	/**
	 * 污物处理列表页面
	 */
	@RequiresPermissions("ironfofivegpszywwclreport:ironfofivegpszywwcl:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivegpszywwclReport ironfofivegpszywwcl, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivegpszywwcl.getDuser() != null&&ironfofivegpszywwcl.getDuser().toString() != null && ironfofivegpszywwcl.getDuser().toString().trim() != null
					&& !"".equals(ironfofivegpszywwcl.getDuser().toString().trim())
					&& !"null".equals(ironfofivegpszywwcl.getDuser().toString().trim())) {
				userId = ironfofivegpszywwcl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivegpszywwcl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivegpszywwclReport> page = ironfofivegpszywwclService.findPage(new Page<IronfofivegpszywwclReport>(request, response), ironfofivegpszywwcl); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivegpszywwclreport/ironfofivegpszywwclList";
	}

	/**
	 * 查看，增加，编辑污物处理表单页面
	 */
	@RequiresPermissions(value={"ironfofivegpszywwclreport:ironfofivegpszywwcl:view","ironfofivegpszywwclreport:ironfofivegpszywwcl:add","ironfofivegpszywwclreport:ironfofivegpszywwcl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivegpszywwclReport ironfofivegpszywwcl, Model model) {
		model.addAttribute("ironfofivegpszywwcl", ironfofivegpszywwcl);
		return "report/ironfofivegpszywwclreport/ironfofivegpszywwclForm";
	}

	/**
	 * 保存污物处理
	 */
	@RequiresPermissions(value={"ironfofivegpszywwclreport:ironfofivegpszywwcl:add","ironfofivegpszywwclreport:ironfofivegpszywwcl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivegpszywwclReport ironfofivegpszywwcl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivegpszywwcl)){
			return form(ironfofivegpszywwcl, model);
		}
		if(!ironfofivegpszywwcl.getIsNewRecord()){//编辑表单保存
			IronfofivegpszywwclReport t = ironfofivegpszywwclService.get(ironfofivegpszywwcl.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivegpszywwcl, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivegpszywwclService.save(t);//保存
		}else{//新增表单保存
			ironfofivegpszywwclService.save(ironfofivegpszywwcl);//保存
		}
		addMessage(redirectAttributes, "保存污物处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywwclreport/ironfofivegpszywwcl/?repage";
	}
	
	/**
	 * 删除污物处理
	 */
	@RequiresPermissions("ironfofivegpszywwclreport:ironfofivegpszywwcl:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivegpszywwclReport ironfofivegpszywwcl, RedirectAttributes redirectAttributes) {
		ironfofivegpszywwclService.delete(ironfofivegpszywwcl);
		addMessage(redirectAttributes, "删除污物处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywwclreport/ironfofivegpszywwcl/?repage";
	}
	
	/**
	 * 批量删除污物处理
	 */
	@RequiresPermissions("ironfofivegpszywwclreport:ironfofivegpszywwcl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivegpszywwclService.delete(ironfofivegpszywwclService.get(id));
		}
		addMessage(redirectAttributes, "删除污物处理成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywwclreport/ironfofivegpszywwcl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivegpszywwclreport:ironfofivegpszywwcl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivegpszywwclReport ironfofivegpszywwcl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivegpszywwcl.getDuser() != null&&ironfofivegpszywwcl.getDuser().toString() != null && ironfofivegpszywwcl.getDuser().toString().trim() != null
					&& !"".equals(ironfofivegpszywwcl.getDuser().toString().trim())
					&& !"null".equals(ironfofivegpszywwcl.getDuser().toString().trim())) {
				userId = ironfofivegpszywwcl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivegpszywwcl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "污物处理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivegpszywwclReport> page = ironfofivegpszywwclService.findPage(new Page<IronfofivegpszywwclReport>(request, response, -1), ironfofivegpszywwcl);
    		new ExportExcel("污物处理", IronfofivegpszywwclReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出污物处理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivegpszywwclreport/ironfofivegpszywwcl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivegpszywwclreport:ironfofivegpszywwcl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivegpszywwclReport> list = ei.getDataList(IronfofivegpszywwclReport.class);
			for (IronfofivegpszywwclReport ironfofivegpszywwcl : list){
				try{
					ironfofivegpszywwclService.save(ironfofivegpszywwcl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条污物处理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条污物处理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入污物处理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywwclreport/ironfofivegpszywwcl/?repage";
    }
	
	/**
	 * 下载导入污物处理数据模板
	 */
	@RequiresPermissions("ironfofivegpszywwclreport:ironfofivegpszywwcl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "污物处理数据导入模板.xlsx";
    		List<IronfofivegpszywwclReport> list = Lists.newArrayList(); 
    		new ExportExcel("污物处理数据", IronfofivegpszywwclReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszywwclreport/ironfofivegpszywwcl/?repage";
    }
	
	
	

}